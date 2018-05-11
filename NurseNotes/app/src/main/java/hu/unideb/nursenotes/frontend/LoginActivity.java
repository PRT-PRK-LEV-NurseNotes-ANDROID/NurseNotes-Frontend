package hu.unideb.nursenotes.frontend;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import javax.net.ssl.HttpsURLConnection;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hu.unideb.nursenotes.frontend.pojo.LoginResponsePojo;
import hu.unideb.nursenotes.frontend.task.AuthTask;
import hu.unideb.nursenotes.frontend.task.LoginTask;
import hu.unideb.nursenotes.frontend.task.RegistrationTask;
import hu.unideb.nursenotes.frontend.task.Unsafe;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static hu.unideb.nursenotes.frontend.task.LoginTask.getBase64;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = RegistrationTask.class.getSimpleName();

    @BindView(R.id.username_edittext)
    EditText userEditText;

    @BindView(R.id.password_edittext)
    EditText passwordEditText;

    @BindView(R.id.error_textView)
    TextView errorTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.login_button)
    public void login(View view) {
        if (userEditText.getText().toString().isEmpty() && passwordEditText.getText().toString().isEmpty()) {
            Log.d(TAG, "activity_login: login_error_username_and_password");
            errorTextView.setText("Username and password are empty!");
            errorTextView.setVisibility(View.VISIBLE);
        } else if (userEditText.getText().toString().isEmpty()) {
            Log.d(TAG, "activity_login: login_error_username");
            errorTextView.setText("Username is empty!");
            errorTextView.setVisibility(View.VISIBLE);
        } else if (passwordEditText.getText().toString().isEmpty()) {
            Log.d(TAG, "activity_login: login_error_password");
            errorTextView.setText("Password is empty!");
            errorTextView.setVisibility(View.VISIBLE);
        } else {
            new LoginTask(this).execute(userEditText.getText().toString(), passwordEditText.getText().toString());
            Toast.makeText(getApplicationContext(), "Login successful!", Toast.LENGTH_LONG).show();
            startActivity(new Intent(this, ClientList.class));
//
//        }
//        try {
//            OkHttpClient okHttpClient = Unsafe.getUnsafeOkHttpClient();
//
//            Request request = new Request.Builder()
//                    .url("http://localhost/login")// + LoginPath.LOGIN_PATH)
//                    .addHeader("Authentication", "Basic " + getBase64(userEditText.getText().toString(), passwordEditText.getText().toString()))
//                    .build();
//
//            //     try {
//            Response execute = okHttpClient.newCall(request).execute();
//            int responseCode = execute.code();
////            Log.e("ASD", String.valueOf(responseCode));
//        } catch (IOException e) {
//            e.printStackTrace();
//                  }
//             }
//
//            @OnClick(R.id.register_button)
//            public void register (View view){
 //       }

//    private ide visza kell andi amit vár a link azt az objektumot create(){
//        itt meg kell írni a builder
//                és ha itt mega builder akkor utána ennek jónak kell leniemert uyge a task excetuteal fut le oda beadjuk neki a lebuildelt obejktumot
        }
    }
}