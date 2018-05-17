package hu.unideb.nursenotes.task.client;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.IOException;
import java.net.SocketTimeoutException;

import hu.unideb.nursenotes.container.StoredUserInfo;
import hu.unideb.nursenotes.pojo.client.ClientListReturnPojo;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static hu.unideb.nursenotes.container.PathContainer.CLIENT_ADD_URL;
import static hu.unideb.nursenotes.container.PathContainer.MEDIA_TYPE_JSON;
import static hu.unideb.nursenotes.container.PathContainer.UNKNOW_ERROR;
import static hu.unideb.nursenotes.container.Unsafe.getUnsafeOkHttpClient;
import static java.net.HttpURLConnection.HTTP_ACCEPTED;
import static java.net.HttpURLConnection.HTTP_BAD_REQUEST;
import static java.net.HttpURLConnection.HTTP_CLIENT_TIMEOUT;
import static java.net.HttpURLConnection.HTTP_GATEWAY_TIMEOUT;
import static java.net.HttpURLConnection.HTTP_INTERNAL_ERROR;
import static java.net.HttpURLConnection.HTTP_UNAUTHORIZED;

public class ClientAddTask extends AsyncTask<String, Void, ClientListReturnPojo> {

    private Activity actualActivity;

    public ClientAddTask(Activity actualActivity) {
        this.actualActivity = actualActivity;
    }

    @Override
    protected ClientListReturnPojo doInBackground(String... strings) {
        try {
            OkHttpClient client = getUnsafeOkHttpClient();
            RequestBody body = RequestBody.create(MEDIA_TYPE_JSON, strings[0]);
            Request request = new Request.Builder()
                    .url(CLIENT_ADD_URL)
                    .header("Authorization", "Basic " + StoredUserInfo.getInstance().getInternalToken())
                    .post(body)
                    .build();

            Response response = client.newCall(request).execute();
            int responseCode = response.code();

            switch (responseCode) {

                case HTTP_ACCEPTED:

                    return new ClientListReturnPojo(responseCode, null);
                case HTTP_BAD_REQUEST:

                    return new ClientListReturnPojo(responseCode, null);
                case HTTP_UNAUTHORIZED:
                    return new ClientListReturnPojo(responseCode, null);
                case HTTP_GATEWAY_TIMEOUT:
                    return new ClientListReturnPojo(responseCode, null);
                case HTTP_INTERNAL_ERROR:
                    return new ClientListReturnPojo(responseCode, null);
            }
        } catch (IOException e) {
            e.printStackTrace();
            if (e instanceof SocketTimeoutException) {
                return new ClientListReturnPojo(HTTP_CLIENT_TIMEOUT, null);
            }
        }
        return new ClientListReturnPojo(UNKNOW_ERROR, null);

    }

    @Override
    protected void onPostExecute(ClientListReturnPojo registrationReturnPojo) {
        super.onPostExecute(registrationReturnPojo);

        switch (registrationReturnPojo.getHttpCode()) {
            case HTTP_ACCEPTED:
//                Intent intent = new Intent(actualActivity, MainActivity.class);
//                actualActivity.startActivity(intent);
                Toast.makeText(actualActivity, "Success", Toast.LENGTH_SHORT).show();
                break;
            case HTTP_BAD_REQUEST:
//                for (Violation violation : registrationReturnPojo.getViolationList()) {
//                    String fieldName = violation.getField();
//
//                }
                Toast.makeText(actualActivity, "Unsuccessful client add!", Toast.LENGTH_SHORT).show();
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
