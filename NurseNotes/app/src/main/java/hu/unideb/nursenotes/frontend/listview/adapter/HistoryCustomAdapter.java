package hu.unideb.nursenotes.frontend.listview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import hu.unideb.nursenotes.frontend.History;
import hu.unideb.nursenotes.frontend.R;
import hu.unideb.nursenotes.frontend.listview.model.HistoryDataModel;

public class HistoryCustomAdapter extends BaseAdapter {

    private Context context;
    private List<HistoryDataModel> historyDataModels;

    public HistoryCustomAdapter(Context context, List<HistoryDataModel> historyDataModels) {
        this.context = context;
        this.historyDataModels = historyDataModels;
    }

    @Override
    public int getCount() {
        return historyDataModels.size();
    }

    @Override
    public Object getItem(int position) {
        return historyDataModels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.history_row_item, parent, false);
        }

        HistoryDataModel historyDataModel = (HistoryDataModel) getItem(position);

        TextView textView = convertView.findViewById(R.id.history_firstname);
        TextView textView1 = convertView.findViewById(R.id.history_lastname);
        TextView textView2 = convertView.findViewById(R.id.history_date);

        textView.setText(historyDataModel.getFirstName());
        textView1.setText(historyDataModel.getLastName());
        textView2.setText(historyDataModel.getDate().toString());

        return convertView;
    }
}