package hu.unideb.nursenotes.listview.adapter.client;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import hu.unideb.nursenotes.R;
import hu.unideb.nursenotes.commons.pojo.response.ClientResponse;

public class ClientListCustomAdapter extends BaseAdapter {

    private Context context;
    private List<ClientResponse> clientResponses;

    public ClientListCustomAdapter(Context context, List<ClientResponse> clientResponses) {
        this.context = context;
        this.clientResponses = clientResponses;
    }

    @Override
    public int getCount() {
        return clientResponses.size();
    }

    @Override
    public Object getItem(int position) {
        return clientResponses.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.client_row_item, parent, false);
        }

        ClientResponse clientResponse = (ClientResponse) getItem(position);

        TextView clientNameTextView = convertView.findViewById(R.id.client_name);
        TextView clientAdressTextView = convertView.findViewById(R.id.client_address);

        clientNameTextView.setText(clientResponse.getFirstName() + " " +clientResponse.getLastName());
        clientAdressTextView.setText(clientResponse.getAddress());

        return convertView;
    }
}
