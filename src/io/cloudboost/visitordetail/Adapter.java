package io.cloudboost.visitordetail;

import io.cloudboost.CloudObject;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class Adapter  extends ArrayAdapter<CloudObject> {
    private List<CloudObject> objectList = new ArrayList<>();

    public Adapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    @Override
    public void add(CloudObject object) {
    	objectList.add(object);
        super.add(object);
    }

    @Override
    public int getCount() {
        return this.objectList.size();
    }

    @Override
    public CloudObject getItem(int index) {
        return this.objectList.get(index);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.row, parent, false);
        } 
        TextView region=(TextView) row.findViewById(R.id.region);
        TextView country=(TextView) row.findViewById(R.id.country);
        TextView city=(TextView) row.findViewById(R.id.city);
        TextView ip=(TextView) row.findViewById(R.id.ip);
        CloudObject object = getItem(position);
        region.setText(object.getString("region"));
        country.setText(object.getString("country"));    
        city.setText(object.getString("city"));   
        ip.setText(object.getString("ip"));   
        return row;
    }
}