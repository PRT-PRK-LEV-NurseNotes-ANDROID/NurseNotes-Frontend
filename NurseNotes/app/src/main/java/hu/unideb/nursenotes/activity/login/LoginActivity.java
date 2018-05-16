package hu.unideb.nursenotes.activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.commons.codec.binary.Base64;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hu.unideb.nursenotes.R;
import hu.unideb.nursenotes.activity.main.MainActivity;
import hu.unideb.nursenotes.activity.registration.RegistrationActivity;
import hu.unideb.nursenotes.task.login.LoginTask;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = LoginActivity.class.getSimpleName();

    @BindView(R.id.username_edittext)
    EditText usernameEditText;

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
    public void loginButton(View view){
        if (usernameEditText.getText().toString().isEmpty() && passwordEditText.getText().toString().isEmpty()) {
            Log.d(TAG, "activity_login: login_error_username_and_password");
            errorTextView.setText("Username and password are empty!");
            errorTextView.setVisibility(View.VISIBLE);
        } else if (usernameEditText.getText().toString().isEmpty()) {
            Log.d(TAG, "activity_login: login_error_username");
            errorTextView.setText("Username is empty!");
            errorTextView.setVisibility(View.VISIBLE);
        } else if (passwordEditText.getText().toString().isEmpty()) {
            Log.d(TAG, "activity_login: login_error_password");
            errorTextView.setText("Password is empty!");
            errorTextView.setVisibility(View.VISIBLE);
        } else {
            new LoginTask(this).execute(getBase64(usernameEditText.getText().toString(),passwordEditText.getText().toString()));
        }
    }

    @OnClick(R.id.register_button)
    public void registerButton(View view){
        startActivity(new Intent(this, RegistrationActivity.class));
    }

    private static String getBase64(String username, String password) {
        String toBase64 = username + ":" + password;
        byte[] encodedUsernameAndPassword = Base64.encodeBase64(toBase64.getBytes());
        return new String(encodedUsernameAndPassword);
    }

}
