package hu.unideb.nursenotes.listview.adapter.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.List;

import hu.unideb.nursenotes.R;
import hu.unideb.nursenotes.commons.pojo.response.ActivityResponse;
import hu.unideb.nursenotes.commons.pojo.response.ClientResponse;

public class ActivitytListCustomAdapter extends BaseAdapter {

    private Context context;
    private List<ActivityResponse> activityResponses;

    public ActivitytListCustomAdapter(Context context, List<ActivityResponse> activityResponses) {
        this.context = context;
        this.activityResponses = activityResponses;
    }

    @Override
    public int getCount() {
        return activityResponses.size();
    }

    @Override
    public Object getItem(int position) {
        return activityResponses.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_row_item, parent, false);
        }

        ActivityResponse activityResponse = (ActivityResponse) getItem(position);


        TextView activityTravelTimeTextView = convertView.findViewById(R.id.activity_travel_time_textview);
        TextView activityTimeSpentTextView = convertView.findViewById(R.id.activity_time_spent_textview);
        TextView activityTypeTextView = convertView.findViewById(R.id.activity_type_textview);
        TextView activityDateTextView = convertView.findViewById(R.id.activity_date_textview);

        activityTravelTimeTextView.setText(activityResponse.getTravelTime().toString());
        activityTimeSpentTextView.setText(activityResponse.getTimeSpent());
        activityTypeTextView.setText(activityResponse.getType().toString());

        String date = DateFormat.getDateInstance(DateFormat.MEDIUM).format(activityResponse.getDate());

        activityDateTextView.setText(date);

        return convertView;
    }
}
