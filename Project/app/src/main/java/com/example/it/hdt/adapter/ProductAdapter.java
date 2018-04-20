package com.example.it.hdt.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.it.hdt.R;
import com.example.it.hdt.RowItem;

import java.util.List;

/**
 * Created by DELL on 4/20/2018.
 */

public class ProductAdapter extends BaseAdapter {
    Context context;
    List<RowItem> rowItems;


    public ProductAdapter(Context context, List<RowItem> rowItems) {
        this.context = context;
        this.rowItems = rowItems;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder{
        ImageView produ_pic;
        TextView produ_mane;
        TextView status;
        TextView contactCart;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        LayoutInflater mInfalater= (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        if (convertView == null){
            convertView= mInfalater.inflate(R.layout.list_item, null);
            holder = new ViewHolder();

            holder.produ_mane = (TextView) convertView.findViewById(R.id.pro_name);
            holder.produ_pic = (ImageView) convertView.findViewById(R.id.pro_pic);
            holder.status= (TextView) convertView.findViewById(R.id.status);
            holder.contactCart= (TextView) convertView.findViewById(R.id.contect) ;

            RowItem row_pos= rowItems.get(position);

            holder.produ_pic.setImageResource(row_pos.getPic_id());
            holder.produ_mane.setText(row_pos.getProName());
            holder.status.setText(row_pos.getStatus());
            holder.contactCart.setText((row_pos.getContact()));
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        return convertView;
    }



}

