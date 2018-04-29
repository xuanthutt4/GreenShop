package com.greenshop.greenshop.DataController;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
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
import com.greenshop.greenshop.ViewControllers.DetailProductActivity;

import java.util.ArrayList;

/**
 * Created by dell on 20-Apr-18.
 */

public class MySubCategory extends ArrayAdapter<Product>{
    private AppCompatActivity context = null;
    private ArrayList<Product> myArray = null, data = new ArrayList<>();
    private int idLayout, type, side;
    private Intent intent;

    public MySubCategory(@NonNull AppCompatActivity context, @LayoutRes int resource, ArrayList<Product> myArray, int type, int side) {
        super(context, resource, myArray);
        this.context = context;
        this.myArray = myArray;
        this.idLayout = resource;
        this.type = type;
        this.side = side;
        intent = new Intent(context, DetailProductActivity.class);
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

        final Product product = data.get(position);

        viewHolder.name.setText(product.getName());
        viewHolder.price.setText(String.valueOf(product.getPrice()));
        int img = context.getResources().getIdentifier(product.getImages()[0], "drawable", context.getPackageName());
        Drawable drawable = viewHolder.img.getResources().getDrawable(img);
        viewHolder.img.setImageDrawable(drawable);

        viewHolder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("data", product);
                intent.putExtra("bundle", bundle);
                context.startActivity(intent);
            }
        });

        return convertView;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
