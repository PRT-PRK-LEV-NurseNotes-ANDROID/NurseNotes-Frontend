package hu.unideb.nursenotes.activity.client;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import hu.unideb.nursenotes.R;

public class ClientModificationActivity extends AppCompatActivity {

    @BindView(R.id.client_fname_editText)
    EditText clientFirstNameEdit;

    @BindView(R.id.client_lname_editText)
    EditText clientLastNameEdit;

    @BindView(R.id.client_age_editText)
    EditText clientAgeEdit;

    @BindView(R.id.client_phone_editText)
    EditText clientPhoneEdit;

    @BindView(R.id.client_address_editText)
    EditText clientAddressEdit;

    @BindView(R.id.client_wage_editText)
    EditText clintWageEdit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_client);
        ButterKnife.bind(this);
    }
}
