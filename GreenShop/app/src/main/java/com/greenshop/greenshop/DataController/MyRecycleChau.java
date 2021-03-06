package com.greenshop.greenshop.DataController;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.greenshop.greenshop.Models.Product;
import com.greenshop.greenshop.R;
import com.greenshop.greenshop.ViewControllers.DetailProductActivity;

import java.util.ArrayList;

/**
 * Created by IT on 3/19/2018.
 */

public class MyRecycleChau extends RecyclerView.Adapter <MyRecycleChau.myViewHolder>        {
    private ArrayList<Product> data;
    private AppCompatActivity context;
    private Intent intent;

    public MyRecycleChau(ArrayList<Product> data){
        this.data = data;
    }

    public MyRecycleChau(ArrayList<Product> data, AppCompatActivity context) {
        this.data = data;
        this.context = context;
        intent = new Intent(context, DetailProductActivity.class);
    }

    public static class myViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private ImageView imageView;
        private TextView gia;

        public myViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.carTextViewchau);
            imageView =(ImageView) itemView.findViewById(R.id.imageViewchau);
            gia = (TextView) itemView.findViewById(R.id.gia);
        }
    }

    @Override
    public MyRecycleChau.myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        CardView cardView= (CardView) inflater.inflate(R.layout.card_view_chaukieng,parent,false);

        return new myViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(MyRecycleChau.myViewHolder holder, int position) {
        //Log.d("testSize", data.size()+" ");
        final Product aCard= data.get(position);
        int img = context.getResources().getIdentifier(aCard.getImages()[0], "drawable", context.getPackageName());
        Log.d("TestIMG", aCard.getImages()[0] + aCard.getName());

        Drawable drawable= holder.imageView.getResources().getDrawable(img);
        holder.textView.setText(aCard.getName());
        holder.imageView.setImageDrawable(drawable);
        holder.gia.setText(aCard.getStringPrice());

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("data", aCard);
                intent.putExtra("bundle", bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 8;
    }
}
