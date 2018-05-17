package hu.unideb.nursenotes.activity.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hu.unideb.nursenotes.R;
import hu.unideb.nursenotes.activity.activity.ActivityAddActivity;
import hu.unideb.nursenotes.activity.client.ClientAddActivity;
import hu.unideb.nursenotes.commons.pojo.response.ClientResponse;
import hu.unideb.nursenotes.listview.adapter.client.ClientListCustomAdapter;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.client_history_list_view)
    ListView clientHistoryListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Bundle bundle = getIntent().getExtras();

        List<ClientResponse> clientResponses = (List<ClientResponse>) bundle.get("LIST");

        if(clientResponses != null){
            ClientListCustomAdapter clientListCustomAdapter = new ClientListCustomAdapter(getApplicationContext(), clientResponses);
            clientHistoryListView.setAdapter(clientListCustomAdapter);
        }

    }

    @OnClick(R.id.add_client_button)
    public void addClientButton(View view) {
        startActivity(new Intent(this, ClientAddActivity.class));
    }

    @OnClick(R.id.activity_add_button)
    public void addActivityButton(View view) {
        startActivity(new Intent(this, ActivityAddActivity.class));
    }

    @OnClick(R.id.see_history_button)
    public void seeHistoryButton(View view) {

    }

}
