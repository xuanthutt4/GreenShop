package com.example.it.Project.adapter;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.it.Project.data_models.CardViewModelchau;
import com.example.it.hdt.R;

import java.util.Vector;

/**
 * Created by dell on 20-Apr-18.
 */

public class MyRecycleCategory extends RecyclerView.Adapter <MyRecycleCategory.myViewHolder> {
    private Vector<CardViewModelchau> data;
    private int type;
    private MySubCategory mySubCategoryLeft, mySubCategoryRight;
    private AppCompatActivity context = null;

    public MyRecycleCategory(AppCompatActivity context, Vector<CardViewModelchau> data, int type){
        this.data = data;
        this.type = type;
        this.context = context;
    }
    public static class myViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private ListView lstLeft, lstRight;

        public myViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.txt_category);
            lstLeft = (ListView) itemView.findViewById(R.id.list_left);
            lstRight = (ListView) itemView.findViewById(R.id.list_right);
        }
    }

    @Override
    public MyRecycleCategory.myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        CardView cardView= (CardView) inflater.inflate(R.layout.list_category,parent,false);

        return new myViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(MyRecycleCategory.myViewHolder holder, int position) {
        Vector<CardViewModelchau> dataType = new Vector<>();
        for (CardViewModelchau modelchau : data) {
            if (modelchau.getType() == position + 1) {
                holder.textView.setText(String.valueOf(modelchau.getType()));
                dataType.add(modelchau);
            }
            if (dataType.size() == 4)
                break;
        }
        mySubCategoryLeft = new MySubCategory(context, R.layout.sub_list_category, dataType, position+1, 1);
        mySubCategoryRight = new MySubCategory(context, R.layout.sub_list_category, dataType, position+1, 2);
        holder.lstLeft.setAdapter(mySubCategoryLeft);
        holder.lstRight.setAdapter(mySubCategoryRight);
    }

    @Override
    public int getItemCount() {
        return type;
    }
}
