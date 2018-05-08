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

public class ClientEditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.client_edit);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.save_client_button)
    public void saveClient(View view){
        Toast.makeText(getApplicationContext(), "Client saved!", Toast.LENGTH_LONG).show();
    }

}
