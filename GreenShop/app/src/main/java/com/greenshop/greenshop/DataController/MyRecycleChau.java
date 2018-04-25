package com.greenshop.greenshop.DataController;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.greenshop.greenshop.Models.Product;
import com.greenshop.greenshop.R;

import java.util.Vector;

/**
 * Created by IT on 3/19/2018.
 */

public class MyRecycleChau extends RecyclerView.Adapter <MyRecycleChau.myViewHolder>{
    private Vector<Product> data;

    public MyRecycleChau(Vector<Product> data){
        this.data = data;
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
        Product aCard= data.get(position);


        Drawable drawable=holder.imageView.getResources().getDrawable(R.drawable.ic_launcher_background);
        holder.textView.setText(aCard.getName());
        holder.imageView.setImageDrawable(drawable);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
