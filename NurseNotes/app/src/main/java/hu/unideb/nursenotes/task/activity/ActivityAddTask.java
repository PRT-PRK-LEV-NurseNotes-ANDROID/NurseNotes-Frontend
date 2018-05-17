package hu.unideb.nursenotes.task.activity;

import android.app.Activity;
import android.os.AsyncTask;

import java.io.IOException;
import java.net.SocketTimeoutException;

import hu.unideb.nursenotes.container.StoredUserInfo;
import hu.unideb.nursenotes.pojo.activity.ActivityReturnPojo;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static hu.unideb.nursenotes.container.PathContainer.ACTIVITY_ADD_URL;
import static hu.unideb.nursenotes.container.PathContainer.MEDIA_TYPE_JSON;
import static hu.unideb.nursenotes.container.PathContainer.UNKNOW_ERROR;
import static hu.unideb.nursenotes.container.Unsafe.getUnsafeOkHttpClient;
import static java.net.HttpURLConnection.HTTP_ACCEPTED;
import static java.net.HttpURLConnection.HTTP_BAD_REQUEST;
import static java.net.HttpURLConnection.HTTP_CLIENT_TIMEOUT;
import static java.net.HttpURLConnection.HTTP_GATEWAY_TIMEOUT;
import static java.net.HttpURLConnection.HTTP_INTERNAL_ERROR;
import static java.net.HttpURLConnection.HTTP_UNAUTHORIZED;

public class ActivityAddTask extends AsyncTask<String, Void, ActivityReturnPojo> {

    private Activity actualActivity;

    @Override
    protected ActivityReturnPojo doInBackground(String... strings) {
        try {
            OkHttpClient client = getUnsafeOkHttpClient();
            RequestBody body = RequestBody.create(MEDIA_TYPE_JSON, strings[0]);
            Request request = new Request.Builder()
                    .url(ACTIVITY_ADD_URL)
                    .header("Authorization", "Basic " + StoredUserInfo.getInstance().getInternalToken())
                    .post(body)
                    .build();

            Response response = client.newCall(request).execute();
            int responseCode = response.code();

            switch (responseCode) {

                case HTTP_ACCEPTED:

                    return new ActivityReturnPojo(responseCode, null);
                case HTTP_BAD_REQUEST:

                    return new ActivityReturnPojo(responseCode, null);
                case HTTP_UNAUTHORIZED:
                    return new ActivityReturnPojo(responseCode, null);
                case HTTP_GATEWAY_TIMEOUT:
                    return new ActivityReturnPojo(responseCode, null);
                case HTTP_INTERNAL_ERROR:
                    return new ActivityReturnPojo(responseCode, null);
            }
        } catch (IOException e) {
            e.printStackTrace();
            if (e instanceof SocketTimeoutException) {
                return new ActivityReturnPojo(HTTP_CLIENT_TIMEOUT, null);
            }
        }
        return new ActivityReturnPojo(UNKNOW_ERROR, null);
    }
}
