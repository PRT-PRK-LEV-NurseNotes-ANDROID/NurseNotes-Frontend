package hu.unideb.nursenotes.task.login;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.Serializable;
import java.net.SocketTimeoutException;
import java.util.List;

import hu.unideb.nursenotes.activity.main.MainActivity;
import hu.unideb.nursenotes.commons.pojo.response.ClientResponse;
import hu.unideb.nursenotes.container.StoredUserInfo;
import hu.unideb.nursenotes.pojo.login.LoginReturnPojo;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static hu.unideb.nursenotes.container.PathContainer.GET_ALL_CLEINT;
import static hu.unideb.nursenotes.container.PathContainer.LOGIN_URL;
import static hu.unideb.nursenotes.container.PathContainer.UNKNOW_ERROR;
import static hu.unideb.nursenotes.container.Unsafe.getUnsafeOkHttpClient;
import static java.net.HttpURLConnection.HTTP_CLIENT_TIMEOUT;
import static java.net.HttpURLConnection.HTTP_GATEWAY_TIMEOUT;
import static java.net.HttpURLConnection.HTTP_INTERNAL_ERROR;
import static java.net.HttpURLConnection.HTTP_OK;
import static java.net.HttpURLConnection.HTTP_UNAUTHORIZED;

public class LoginTask extends AsyncTask<String, Void, LoginReturnPojo> {

    private static final String TAG = LoginTask.class.getSimpleName();

    private Activity actualActivity;

    public LoginTask(Activity actualActivity) {
        this.actualActivity = actualActivity;
    }
    @Override
    protected LoginReturnPojo doInBackground(String... strings) {
        Log.d(TAG, "doInBackground: Start");
            try {
                OkHttpClient client = getUnsafeOkHttpClient();
                ObjectMapper objectMapper = new ObjectMapper();
                Request request = new Request.Builder()
                        .url(LOGIN_URL)
                        .header("Authorization", "Basic " + strings[0])
                        .build();
                StoredUserInfo.getInstance().setInternalToken(strings[0]);
                Response response = client.newCall(request).execute();
                int responseCode = response.code();

                switch (responseCode) {

                    case HTTP_OK:

                        Response allClient = getAllClient(strings[0]);
                        List<ClientResponse> clientResponses = objectMapper.readValue(allClient.body().string(),new TypeReference<List<ClientResponse>>(){});

                        return new LoginReturnPojo(responseCode,clientResponses );
                    case HTTP_UNAUTHORIZED:
                        return new LoginReturnPojo(responseCode, null);
                    case HTTP_GATEWAY_TIMEOUT:
                        return new LoginReturnPojo(responseCode, null);
                    case HTTP_INTERNAL_ERROR:
                        return new LoginReturnPojo(responseCode, null);
                }
            } catch (IOException e) {
                e.printStackTrace();
                if (e instanceof SocketTimeoutException) {
                    return new LoginReturnPojo(HTTP_CLIENT_TIMEOUT, null);
                }
            }
            return new LoginReturnPojo(UNKNOW_ERROR, null);

    }

    private static Response getAllClient(String user) throws IOException {
        OkHttpClient client = new OkHttpClient();

        final Request request = new Request.Builder()
                .url(GET_ALL_CLEINT)
                .header("Authorization", "Basic " + user)
                .build();

        return client.newCall(request).execute();
    }

    @Override
    protected void onPostExecute(LoginReturnPojo loginReturnPojo) {
        super.onPostExecute(loginReturnPojo);
        switch (loginReturnPojo.getHttpCode()) {
            case HTTP_OK:
                Intent intent = new Intent(actualActivity, MainActivity.class);
                intent.putExtra("LIST", (Serializable) loginReturnPojo.getClientResponseList() );

                actualActivity.startActivity(intent);
                Toast.makeText(actualActivity, "Successful login", Toast.LENGTH_SHORT).show();
                break;
            case UNKNOW_ERROR:
//                errorTextViewAtRegistration.setVisibility(View.VISIBLE);
//                errorTextViewAtRegistration.setText(R.string.login_unknown_error);
                break;
            case HTTP_GATEWAY_TIMEOUT:
//                Log.d(TAG, ON_POST_EXECUTE_END + HTTP_GATEWAY_TIMEOUT);
//                scrollViewAutoScroll(ScrollView.FOCUS_DOWN);
//                errorTextViewAtRegistration.setVisibility(View.VISIBLE);
//                errorTextViewAtRegistration.setText(R.string.login_server_timeout_msg);
                break;
            case HTTP_CLIENT_TIMEOUT:
//                Log.d(TAG, ON_POST_EXECUTE_END + HTTP_CLIENT_TIMEOUT);
//                scrollViewAutoScroll(ScrollView.FOCUS_DOWN);
//                errorTextViewAtRegistration.setVisibility(View.VISIBLE);
//                errorTextViewAtRegistration.setText(R.string.login_server_timeout_msg);
                break;
            case HTTP_INTERNAL_ERROR:
//                Log.d(TAG, ON_POST_EXECUTE_END + HTTP_INTERNAL_ERROR);
//                scrollViewAutoScroll(ScrollView.FOCUS_DOWN);
//                errorTextViewAtRegistration.setVisibility(View.VISIBLE);
//                errorTextViewAtRegistration.setText(R.string.login_server_timeout_msg);
                break;
        }
    }
}
