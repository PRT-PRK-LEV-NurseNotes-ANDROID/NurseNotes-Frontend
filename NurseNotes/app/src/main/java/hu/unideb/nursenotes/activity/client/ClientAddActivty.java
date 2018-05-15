package hu.unideb.nursenotes.activity.client;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import hu.unideb.nursenotes.R;

public class ClientAddActivty extends AppCompatActivity {

    @BindView(R.id.client_fname)
    TextView clientFirstName;

    @BindView(R.id.client_fname_editText)
    EditText clientFirstNameEdit;

    @BindView(R.id.client_lname_textView)
    TextView clientLastName;

    @BindView(R.id.client_lname_editText)
    EditText clientLastNameEdit;

    @BindView(R.id.client_age_textView)
    TextView clientAge;

    @BindView(R.id.client_age_editText)
    EditText clientAgeEdit;

    @BindView(R.id.client_phone_textView)
    TextView clientPhone;

    @BindView(R.id.client_phone_editText)
    EditText clientPhoneEdit;

    @BindView(R.id.client_address_textView)
    TextView clientAddress;

    @BindView(R.id.client_address_editText)
    EditText clientAddressEdit;

    @BindView(R.id.client_wage_textView)
    TextView clientWage;

    @BindView(R.id.client_wage_editText)
    EditText clintWageEdit;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
