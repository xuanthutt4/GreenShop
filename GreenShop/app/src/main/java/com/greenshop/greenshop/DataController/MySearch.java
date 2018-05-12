package com.greenshop.greenshop.DataController;

import android.content.Intent;
import android.os.Bundle;
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

public class MySearch extends ArrayAdapter<Product> {
    private AppCompatActivity context;
    private ArrayList<Product> products;
    private int idLayout;
    private Intent intent;

    public MySearch(@NonNull AppCompatActivity context, int resource, ArrayList<Product> products) {
        super(context, resource, products);
        this.context = context;
        this.products = products;
        this.idLayout = resource;
        intent = new Intent(context, DetailProductActivity.class);
    }

    private static class viewHolder {
        TextView name, price;
        ImageView img;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        viewHolder viewHolder;
        LayoutInflater inflater = context.getLayoutInflater();

        if (convertView == null) {
            convertView = inflater.inflate(idLayout, parent, false);
            viewHolder = new viewHolder();
            viewHolder.name = (TextView) convertView.findViewById(R.id.pro_name);
            viewHolder.img = (ImageView) convertView.findViewById(R.id.pro_pic);
            viewHolder.price = (TextView) convertView.findViewById(R.id.pro_price);
            convertView.setTag(viewHolder);
        }
        else
            viewHolder = (viewHolder) convertView.getTag();
        final Product product = products.get(position);

        viewHolder.name.setText(product.getName());
        viewHolder.price.setText(String.valueOf(product.getPrice()));
        int img = context.getResources().getIdentifier(product.getImages()[0], "drawable", context.getPackageName());
        //Drawable drawable = viewHolder.img.getResources().getDrawable(img);
        //viewHolder.img.setImageDrawable(drawable);
        convertView.setOnClickListener(new View.OnClickListener() {
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

}
