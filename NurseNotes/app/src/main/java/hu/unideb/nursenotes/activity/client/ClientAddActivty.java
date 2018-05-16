package hu.unideb.nursenotes.activity.client;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import hu.unideb.nursenotes.R;
import hu.unideb.nursenotes.commons.pojo.request.ClientRequest;
import hu.unideb.nursenotes.commons.pojo.response.ClientResponse;

public class ClientAddActivty extends AppCompatActivity {


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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_client);
        ButterKnife.bind(this);
    }

    private ClientRequest createClient(){
        return ClientRequest.builder()
                            .firstName(clientFirstNameEdit.getText().toString())
                            .lastName(clientLastNameEdit.getText().toString())
                            .age(Integer.parseInt(clientAgeEdit.getText().toString()))
                            .phoneNumber(clientPhoneEdit.getText().toString())
                            .address(clientAddressEdit.getText().toString())
                            .wage(Integer.parseInt(clintWageEdit.getText().toString()))
                            .build();
    }
}
