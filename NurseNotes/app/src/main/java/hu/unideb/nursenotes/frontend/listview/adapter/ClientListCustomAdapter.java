package hu.unideb.nursenotes.frontend.listview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import hu.unideb.nursenotes.frontend.R;
import hu.unideb.nursenotes.frontend.listview.model.ClientDataModel;

import static hu.unideb.nursenotes.frontend.R.id.wage;

public class ClientListCustomAdapter extends BaseAdapter{

    private Context context;
    private List<ClientDataModel> clientDataModels;

    public ClientListCustomAdapter(Context context, List<ClientDataModel> clientDataModels) {
        this.context = context;
        this.clientDataModels = clientDataModels;
    }
    @Override
    public int getCount() {
        return clientDataModels.size();
    }

    @Override
    public Object getItem(int position) {
        return clientDataModels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.client_row_item, parent, false);
        }
        ClientDataModel clientDataModel = (ClientDataModel) getItem(position);

        TextView textView = convertView.findViewById(R.id.firstname);
        TextView textView1 = convertView.findViewById(R.id.lastname);
     //   TextView textView2 = convertView.findViewById(R.id.wage);

        textView.setText(clientDataModel.getFirstName());
        textView1.setText(clientDataModel.getLastName());
     //   textView2.setText(clientDataModel.getWage());

        return convertView;
    }
}