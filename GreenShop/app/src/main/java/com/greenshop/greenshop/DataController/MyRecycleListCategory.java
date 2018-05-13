package com.greenshop.greenshop.DataController;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.greenshop.greenshop.Models.Category;
import com.greenshop.greenshop.R;

import java.util.ArrayList;

public class MyRecycleListCategory extends RecyclerView.Adapter <MyRecycleListCategory.myViewHolder>{
    private ArrayList<Category> categories;

    public MyRecycleListCategory(ArrayList<Category> categories) {
        this.categories = categories;
    }

    public static class myViewHolder extends RecyclerView.ViewHolder{
        private TextView txtNameCategory;
        public myViewHolder(View itemView) {
            super(itemView);
            txtNameCategory = (TextView) itemView.findViewById(R.id.name_cat);
        }
    }

    @NonNull
    @Override
    public MyRecycleListCategory.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        CardView cardView= (CardView) inflater.inflate(R.layout.card_view_list_category,parent,false);

        return new myViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecycleListCategory.myViewHolder holder, int position) {
        Category category = categories.get(position);

        holder.txtNameCategory.setText(category.getName());
    }

    @Override
    public int getItemCount() {
        return 1;
    }

}
