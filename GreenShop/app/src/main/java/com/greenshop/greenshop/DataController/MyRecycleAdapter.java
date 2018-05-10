package com.greenshop.greenshop.DataController;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.greenshop.greenshop.R;

/**
 * Created by IT on 3/19/2018.
 */

public class MyRecycleAdapter extends RecyclerView.Adapter <MyRecycleAdapter.myViewHolder>{
    private String[] data;
    private AppCompatActivity c;
    public MyRecycleAdapter(String[] data, AppCompatActivity c){
        this.data = data;
        this.c = c;
    }


    public static class myViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private ImageView imageView;
        public myViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.carTextView);
            imageView =(ImageView) itemView.findViewById(R.id.imageView);
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

        int img = c.getResources().getIdentifier(data[position], "drawable", c.getPackageName());
        Log.d("testImg", data[0]);
        Drawable drawable = holder.imageView.getResources().getDrawable(img);
        holder.imageView.setImageDrawable(drawable);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }
}
