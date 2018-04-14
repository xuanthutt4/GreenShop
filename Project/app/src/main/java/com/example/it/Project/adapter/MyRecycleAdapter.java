package com.example.it.Project.adapter;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.it.Project.data_models.CardViewModel;

import java.util.Vector;
import com.example.it.hdt.R;
/**
 * Created by IT on 3/19/2018.
 */

public class MyRecycleAdapter extends RecyclerView.Adapter <MyRecycleAdapter.myViewHolder>{
    private Vector<CardViewModel> data;

    public MyRecycleAdapter(Vector<CardViewModel> data){
        this.data = data;
    }


    public static class myViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private ImageView imageView;
        public myViewHolder(View itemView) {
            super(itemView);
            textView= (TextView) itemView.findViewById(R.id.carTextView);
            imageView=(ImageView) itemView.findViewById(R.id.imageView);
        }
    }

    @Override
    public MyRecycleAdapter.myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        CardView cardView= (CardView) inflater.inflate(R.layout.card_view_layout,parent,false);

        return new myViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(MyRecycleAdapter.myViewHolder holder, int position) {
        CardViewModel aCard= data.get(position);


        Drawable drawable=holder.imageView.getResources().getDrawable(aCard.getImage());
        holder.textView.setText(aCard.getCardName());
        holder.imageView.setImageDrawable(drawable);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
