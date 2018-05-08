package hu.unideb.nursenotes.frontend;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import hu.unideb.nursenotes.frontend.listview.adapter.HistoryCustomAdapter;
import hu.unideb.nursenotes.frontend.listview.model.HistoryDataModel;

public class History extends AppCompatActivity {

    @BindView(R.id.history)
    ListView history;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history);
        ButterKnife.bind(this);

        HistoryDataModel historyDataModel = new HistoryDataModel("first1", "last1", LocalDate.of(2018, 5,8));
        HistoryDataModel historyDataModel2 = new HistoryDataModel("first2", "last2", LocalDate.of(2018, 4,8));
        HistoryDataModel historyDataModel3 = new HistoryDataModel("first3", "last3", LocalDate.of(2018, 3,8));
        HistoryDataModel historyDataModel4 = new HistoryDataModel("first4", "last4", LocalDate.of(2018, 2,8));
        HistoryDataModel historyDataModel5 = new HistoryDataModel("first5", "last5", LocalDate.of(2018, 1,8));

        List<HistoryDataModel> historyDataModels = Arrays.asList(historyDataModel, historyDataModel2, historyDataModel3, historyDataModel4, historyDataModel5);

        HistoryCustomAdapter historyCustomAdapter = new HistoryCustomAdapter(getApplicationContext(), historyDataModels);

        history.setAdapter(historyCustomAdapter);

    }
}
