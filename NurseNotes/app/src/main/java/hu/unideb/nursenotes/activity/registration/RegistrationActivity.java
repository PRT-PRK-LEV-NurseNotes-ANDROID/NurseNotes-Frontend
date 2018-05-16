package hu.unideb.nursenotes.activity.registration;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hu.unideb.nursenotes.R;
import hu.unideb.nursenotes.commons.pojo.request.RegistrationRequest;
import hu.unideb.nursenotes.task.registration.RegistrationTask;

public class RegistrationActivity extends AppCompatActivity {

    @BindView(R.id.registration_username_edittext)
    EditText usernameEditText;

    @BindView(R.id.registration_password_edittext)
    EditText passwordEditText;

    @BindView(R.id.registration_fitst_name_edittext)
    EditText firstNameEditText;

    @BindView(R.id.registration_last_name_edittext)
    EditText lastNameEditText;

    @BindView(R.id.registration_email_edittext)
    EditText emailEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.registration_button)
    public void register(View view){
        ObjectMapper mapper = new ObjectMapper();
        try {
            String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(createUser());
            new RegistrationTask(this).execute(jsonInString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }

    private RegistrationRequest createUser(){
        return RegistrationRequest.builder()
                                  .username(usernameEditText.getText().toString())
                                  .password(passwordEditText.getText().toString())
                                  .firstName(firstNameEditText.getText().toString())
                                  .lastName(lastNameEditText.getText().toString())
                                  .email(emailEditText.getText().toString())
                                  .build();
    }
}
