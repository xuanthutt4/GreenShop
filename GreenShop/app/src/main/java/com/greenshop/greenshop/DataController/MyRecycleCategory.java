package com.greenshop.greenshop.DataController;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.greenshop.greenshop.Models.Product;
import com.greenshop.greenshop.R;
import com.greenshop.greenshop.ViewControllers.SplashActivity;

import java.util.ArrayList;

/**
 * Created by dell on 20-Apr-18.
 */

public class MyRecycleCategory extends RecyclerView.Adapter <MyRecycleCategory.myViewHolder> {
    private ArrayList<Product> data;
    private int idCategory;
    private MySubCategory mySubCategoryLeft, mySubCategoryRight;
    private AppCompatActivity context = null;
    private Intent intent;

    public MyRecycleCategory(AppCompatActivity context, ArrayList<Product> data, int idCategory){
        this.data = data;
        this.idCategory = idCategory;
        this.context = context;
        intent = new Intent(context, SplashActivity.class);
    }
    public static class myViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private ListView lstLeft, lstRight;
        private Button btnXemThem;

        public myViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.txt_category);
            lstLeft = (ListView) itemView.findViewById(R.id.list_left);
            lstRight = (ListView) itemView.findViewById(R.id.list_right);
            btnXemThem = (Button) itemView.findViewById(R.id.btn_xem_them);
        }
    }

    @Override
    public MyRecycleCategory.myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        CardView cardView= (CardView) inflater.inflate(R.layout.list_category,parent,false);

        return new myViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(MyRecycleCategory.myViewHolder holder, final int position) {
        ArrayList<Product> dataType = new ArrayList<>();
        for (Product modelchau : data) {
            if (modelchau.getIdCategory() == position + 1) {
                holder.textView.setText(String.valueOf(modelchau.getIdCategory()));
                dataType.add(modelchau);
            }
            if (dataType.size() == 4)
                break;
        }
        mySubCategoryLeft = new MySubCategory(context, R.layout.sub_list_category, dataType, position+1, 1);
        mySubCategoryRight = new MySubCategory(context, R.layout.sub_list_category, dataType, position+1, 2);
        holder.lstLeft.setAdapter(mySubCategoryLeft);
        holder.lstRight.setAdapter(mySubCategoryRight);

        holder.btnXemThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("data", data);
                intent.putExtra("bundle", bundle);
                intent.putExtra("type", position + 1);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return idCategory;
    }
}
