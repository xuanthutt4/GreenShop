package com.example.it.Project.adapter;

import android.graphics.drawable.Drawable;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.it.Project.data_models.CardViewModelchau;
import com.example.it.hdt.R;

import java.util.Vector;

/**
 * Created by dell on 20-Apr-18.
 */

public class MySubCategory extends ArrayAdapter<CardViewModelchau>{
    private AppCompatActivity context = null;
    private Vector<CardViewModelchau> myArray = null, data = new Vector<>();
    private int idLayout, type, side;

    public MySubCategory(@NonNull AppCompatActivity context, @LayoutRes int resource, Vector<CardViewModelchau> myArray, int type, int side) {
        super(context, resource, myArray);
        this.context = context;
        this.myArray = myArray;
        this.idLayout = resource;
        this.type = type;
        this.side = side;

        if (side == 1) {
            data.add(myArray.get(0));
            data.add(myArray.get(2));
        }
        else if (side == 2) {
            data.add(myArray.get(1));
            data.add(myArray.get(3));
        }
    }

    private static class ViewHolder {
        TextView name, price;
        ImageView img;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final ViewHolder viewHolder;
        LayoutInflater inflater = context.getLayoutInflater();

        if (convertView == null) {
            convertView = inflater.inflate(idLayout, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.name = (TextView) convertView.findViewById(R.id.txtTen);
            viewHolder.price = (TextView) convertView.findViewById(R.id.txtGia);
            viewHolder.img = (ImageView) convertView.findViewById(R.id.imgcdb);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        CardViewModelchau product = data.get(position);

        viewHolder.name.setText(product.getCardName());
        viewHolder.price.setText(String.valueOf(product.getGia()));
        Drawable drawable = viewHolder.img.getResources().getDrawable(product.getImage());
        viewHolder.img.setImageDrawable(drawable);

        return convertView;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
