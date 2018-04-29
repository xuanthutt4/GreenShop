package com.greenshop.greenshop.DataController;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.greenshop.greenshop.Models.Product;
import com.greenshop.greenshop.R;
import com.greenshop.greenshop.ViewControllers.DetailProductActivity;

import java.util.ArrayList;

public class MyRecycleProByCat extends RecyclerView.Adapter <MyRecycleProByCat.myViewHolder> {
    private ArrayList<Product> products;
    private static AppCompatActivity c;
    private static Intent intent;

    public MyRecycleProByCat(ArrayList<Product> products, AppCompatActivity c) {
        this.products = products;
        this.c = c;
        intent = new Intent(c, DetailProductActivity.class);
    }

    public static class myViewHolder extends RecyclerView.ViewHolder {
        private TextView txtName, txtPrice, txtStatus;
        private ImageView img;
        public View view;
        public Product currentItem;

        public myViewHolder(View itemView) {
            super(itemView);
            txtName = (TextView) itemView.findViewById(R.id.pro_name);
            txtPrice = (TextView) itemView.findViewById(R.id.pro_price);
            txtStatus = (TextView) itemView.findViewById(R.id.status);
            img = (ImageView) itemView.findViewById(R.id.pro_pic);

            view = itemView;
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("data", currentItem);
                    intent.putExtra("bundle", bundle);
                    c.startActivity(intent);
                }
            });
        }
    }
    @NonNull
    @Override
    public MyRecycleProByCat.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        CardView cardView= (CardView) inflater.inflate(R.layout.list_item,parent,false);

        return new myViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecycleProByCat.myViewHolder holder, int position) {
        Product product = holder.currentItem = products.get(position);

        int idImg = c.getResources().getIdentifier(product.getImages()[0], "drawable", c.getPackageName());
        Drawable drawable = holder.img.getResources().getDrawable(idImg);
        holder.img.setImageDrawable(drawable);
        holder.txtName.setText(product.getName());
        holder.txtPrice.setText(String.valueOf(product.getPrice()));
        holder.txtStatus.setText("Còn hàng");
    }



    @Override
    public int getItemCount() {
        return products.size();
    }
}
