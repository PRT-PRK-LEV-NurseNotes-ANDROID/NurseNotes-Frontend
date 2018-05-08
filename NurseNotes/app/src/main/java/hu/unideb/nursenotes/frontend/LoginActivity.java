package hu.unideb.nursenotes.frontend;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.username_edittext)
    EditText userEditText;

    @BindView(R.id.password_edittext)
    EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.login_button)
    public void login(View view) {
        startActivity(new Intent(this, ClientActivity.class));
    }

    @OnClick(R.id.register_button)
    public void register(View view) {
        Toast.makeText(getApplicationContext(), "Register", Toast.LENGTH_LONG).show();
    }
}

