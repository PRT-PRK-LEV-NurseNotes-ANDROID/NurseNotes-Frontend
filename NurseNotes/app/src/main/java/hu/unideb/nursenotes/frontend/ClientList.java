package hu.unideb.nursenotes.frontend;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hu.unideb.nursenotes.frontend.listview.adapter.ClientListCustomAdapter;
import hu.unideb.nursenotes.frontend.listview.model.ClientDataModel;

public class ClientList extends AppCompatActivity {

    @BindView(R.id.client_list)
    ListView clientList;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_client_list);
        ButterKnife.bind(this);

        ClientDataModel clientDataModel = new ClientDataModel("first1","last1","address","phonenumbver", LocalDate.now(),LocalDate.now(),10,12);
        ClientDataModel clientDataMode2 = new ClientDataModel("first2","last2","address","phonenumbver", LocalDate.now(),LocalDate.now(),10,12);
        ClientDataModel clientDataMode3 = new ClientDataModel("first3","last3","address","phonenumbver", LocalDate.now(),LocalDate.now(),10,12);
        ClientDataModel clientDataMode4 = new ClientDataModel("first4","last4","address","phonenumbver", LocalDate.now(),LocalDate.now(),10,12);
        ClientDataModel clientDataMode5 = new ClientDataModel("first5","last5","address","phonenumbver", LocalDate.now(),LocalDate.now(),10,12);
        ClientDataModel clientDataMode6 = new ClientDataModel("first6","last6","address","phonenumbver", LocalDate.now(),LocalDate.now(),10,12);


       List<ClientDataModel> clientDataModels = Arrays.asList(clientDataModel,clientDataMode2,clientDataMode3,clientDataMode4,clientDataMode5,clientDataMode6);

        ClientListCustomAdapter clientListCustomAdapter = new ClientListCustomAdapter(getApplicationContext(),clientDataModels);

        clientList.setAdapter(clientListCustomAdapter);

    }

//    @OnClick(R.id.save_client_button)
//    public void login(View view) {
//        startActivity(new Intent(this, ClientEditActivity.class));
//    }

    @OnClick(R.id.add_client_button)
    public void clients_button(View view) {
        startActivity(new Intent(this, ClientEditActivity.class));
    }


    @OnClick(R.id.historybutton)
    public void historybutton(View view) {
        startActivity(new Intent(this, History.class));
    }
}


