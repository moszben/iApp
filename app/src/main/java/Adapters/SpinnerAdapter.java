package Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.moszben.iapp.R;

import java.util.List;

import Models.Client;

/**
 * Created by moszben on 11/05/2017.
 */
public class SpinnerAdapter extends ArrayAdapter<Client> {
    Context myContext;
    int layoutResourceId;
    List<Client> clients;

    public SpinnerAdapter(Context context, int resource, List<Client> objects) {
        super(context, resource, objects);
        myContext=context;
        layoutResourceId=resource;
        clients=objects;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getView(position,convertView,parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            LayoutInflater inflater = ((Activity) myContext).getLayoutInflater();
            convertView = inflater.inflate(layoutResourceId, parent, false);
        }

        Client current=clients.get(position);
        TextView type = (TextView) convertView.findViewById(R.id.type);

        type.setText(current.getType());
        return convertView;
    }
}
