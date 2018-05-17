package hu.unideb.nursenotes.task.registration;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.SocketTimeoutException;

import hu.unideb.nursenotes.activity.login.LoginActivity;
import hu.unideb.nursenotes.commons.pojo.response.UserDetailsResponse;
import hu.unideb.nursenotes.commons.pojo.validator.Violation;
import hu.unideb.nursenotes.container.PathContainer;
import hu.unideb.nursenotes.pojo.login.LoginReturnPojo;
import hu.unideb.nursenotes.pojo.registration.RegistrationReturnPojo;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static hu.unideb.nursenotes.container.PathContainer.MEDIA_TYPE_JSON;
import static hu.unideb.nursenotes.container.PathContainer.REGISTRATION_URL;
import static hu.unideb.nursenotes.container.PathContainer.UNKNOW_ERROR;
import static hu.unideb.nursenotes.container.Unsafe.getUnsafeOkHttpClient;
import static java.net.HttpURLConnection.HTTP_ACCEPTED;
import static java.net.HttpURLConnection.HTTP_BAD_REQUEST;
import static java.net.HttpURLConnection.HTTP_CLIENT_TIMEOUT;
import static java.net.HttpURLConnection.HTTP_GATEWAY_TIMEOUT;
import static java.net.HttpURLConnection.HTTP_INTERNAL_ERROR;
import static java.net.HttpURLConnection.HTTP_OK;
import static java.net.HttpURLConnection.HTTP_UNAUTHORIZED;

public class RegistrationTask extends AsyncTask<String, Void, RegistrationReturnPojo> {

    private static final String TAG = RegistrationTask.class.getSimpleName();

    private Activity actualActivity;

    public RegistrationTask(Activity actualActivity) {
        this.actualActivity = actualActivity;
    }

    @Override
    protected RegistrationReturnPojo doInBackground(String... strings) {
        try {
            OkHttpClient client = getUnsafeOkHttpClient();
            RequestBody body = RequestBody.create(MEDIA_TYPE_JSON, strings[0]);
            Request request = new Request.Builder()
                    .url(REGISTRATION_URL)
                    .post(body)
                    .build();

            Response response = client.newCall(request).execute();
            int responseCode = response.code();

            switch (responseCode) {

                case HTTP_ACCEPTED:

                    return new RegistrationReturnPojo(responseCode, null);
                case HTTP_BAD_REQUEST:

                    return new RegistrationReturnPojo(responseCode, null);
                case HTTP_UNAUTHORIZED:
                    return new RegistrationReturnPojo(responseCode, null);
                case HTTP_GATEWAY_TIMEOUT:
                    return new RegistrationReturnPojo(responseCode, null);
                case HTTP_INTERNAL_ERROR:
                    return new RegistrationReturnPojo(responseCode, null);
            }
        } catch (IOException e) {
            e.printStackTrace();
            if (e instanceof SocketTimeoutException) {
                return new RegistrationReturnPojo(HTTP_CLIENT_TIMEOUT, null);
            }
        }
        return new RegistrationReturnPojo(UNKNOW_ERROR, null);

    }

    @Override
    protected void onPostExecute(RegistrationReturnPojo registrationReturnPojo) {
        super.onPostExecute(registrationReturnPojo);

        switch (registrationReturnPojo.getHttpCode()) {
            case HTTP_ACCEPTED:
                Intent intent = new Intent(actualActivity, LoginActivity.class);
                actualActivity.startActivity(intent);
                Toast.makeText(actualActivity, "Successful registration!", Toast.LENGTH_SHORT).show();
                break;
            case HTTP_BAD_REQUEST:
//                for (Violation violation : registrationReturnPojo.getViolationList()) {
//                    String fieldName = violation.getField();
//
//                }
                Toast.makeText(actualActivity, "Unsuccessful registration.", Toast.LENGTH_SHORT).show();
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
