package com.example.taweesoft.leftmenu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by TAWEESOFT on 4/2/16 AD.
 */
public class ListViewAdapter extends ArrayAdapter<Item> {

    public ListViewAdapter(Context context, int resource, List<Item> items) {
        super(context, resource,items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_layout,null,false);
            ImageView img = (ImageView)convertView.findViewById(R.id.img);
            TextView txt = (TextView)convertView.findViewById(R.id.text);
            img.setImageResource(getItem(position).getImg());
            txt.setText(getItem(position).getTxt());
        }
        return convertView;
    }
}
