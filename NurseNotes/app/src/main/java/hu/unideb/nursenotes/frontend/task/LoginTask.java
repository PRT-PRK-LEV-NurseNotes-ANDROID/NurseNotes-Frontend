package hu.unideb.nursenotes.frontend.task;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.apache.commons.codec.binary.Base64;

import java.io.IOException;

import hu.unideb.nursenotes.frontend.ClientActivity;
import hu.unideb.nursenotes.frontend.pojo.LoginResponsePojo;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static java.net.HttpURLConnection.HTTP_BAD_REQUEST;
import static java.net.HttpURLConnection.HTTP_OK;

public class LoginTask extends AsyncTask<String, Void, LoginResponsePojo> {

    private Activity activity;

    public LoginTask(Activity activity) {
        this.activity = activity;
    }

    @Override
    protected LoginResponsePojo doInBackground(String... strings) {
        OkHttpClient okHttpClient = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://localhost:8080/login")
                .addHeader("Authentication", "Basic " + getBase64(strings[0], strings[1]))
                .build();

        try {
            Response execute = okHttpClient.newCall(request).execute();

            int responseCode = execute.code();

            return new LoginResponsePojo(responseCode);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getBase64(String username, String password) {
        String toBase64 = username + ":" + password;
        byte[] encodedUsernameAndPassword = Base64.encodeBase64(toBase64.getBytes());
        return new String(encodedUsernameAndPassword);
    }

    @Override
    protected void onPostExecute(LoginResponsePojo loginResponsePojo) {
        super.onPostExecute(loginResponsePojo);

        switch (loginResponsePojo.getHttpCode()) {
            case HTTP_OK:
                Log.e("Tesz", "ez jó");
                activity.startActivity(new Intent(activity, ClientActivity.class));
            case HTTP_BAD_REQUEST:
                Log.e("Tesz", "Nem jó");
        }


    }
}
