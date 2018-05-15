package hu.unideb.nursenotes.activity.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hu.unideb.nursenotes.R;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.client_history_list_view)
    ListView clientHistoryListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.add_client_button)
    public void addClientButton(View view) {

    }

    @OnClick(R.id.activity_add_button)
    public void addActivityButton(View view) {

    }

    @OnClick(R.id.see_history_button)
    public void seeHistoryButton(View view) {

    }

}
