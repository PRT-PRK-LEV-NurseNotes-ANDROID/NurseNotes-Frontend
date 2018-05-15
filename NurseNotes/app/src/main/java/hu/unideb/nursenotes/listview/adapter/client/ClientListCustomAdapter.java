package hu.unideb.nursenotes.listview.adapter.client;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import hu.unideb.nursenotes.R;

public class ClientListCustomAdapter extends BaseAdapter {

    private Context context;
//    private List<ClientDataModel> clientDataModels;

//    public ClientListCustomAdapter(Context context, List<ClientDataModel> clientDataModels) {
//        this.context = context;
//        this.clientDataModels = clientDataModels;
//    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    //    @Override
//    public int getCount() {
//        return clientDataModels.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return clientDataModels.get(position);
//    }
//
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.client_row_item, parent, false);
        }
//        ClientDataModel clientDataMoCdel = (ClientDataModel) getItem(position);

        TextView clientNameTextView = convertView.findViewById(R.id.client_name);
        TextView clientAdressTextView = convertView.findViewById(R.id.client_address);

//        textView.setText(clientDataModel.getFirstName());
//        textView1.setText(clientDataModel.getLastName());
//        textView2.setText(String.valueOf(clientDataModel.getWage()));

        return convertView;
    }
}
