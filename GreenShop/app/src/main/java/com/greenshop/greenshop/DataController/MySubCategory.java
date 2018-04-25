package com.greenshop.greenshop.DataController;

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

import com.greenshop.greenshop.Models.Product;
import com.greenshop.greenshop.R;

import java.util.ArrayList;

/**
 * Created by dell on 20-Apr-18.
 */

public class MySubCategory extends ArrayAdapter<Product>{
    private AppCompatActivity context = null;
    private ArrayList<Product> myArray = null, data = new ArrayList<>();
    private int idLayout, type, side;

    public MySubCategory(@NonNull AppCompatActivity context, @LayoutRes int resource, ArrayList<Product> myArray, int type, int side) {
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

        Product product = data.get(position);

        viewHolder.name.setText(product.getName());
        viewHolder.price.setText(String.valueOf(product.getPrice()));
        Drawable drawable = viewHolder.img.getResources().getDrawable(R.drawable.ic_launcher_background);
        viewHolder.img.setImageDrawable(drawable);

        return convertView;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
