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

import com.greenshop.greenshop.Models.Category;
import com.greenshop.greenshop.Models.Product;
import com.greenshop.greenshop.R;
import com.greenshop.greenshop.ViewControllers.ProductByCategoryActivity;

import java.util.ArrayList;

/**
 * Created by dell on 20-Apr-18.
 */

public class MyRecycleCategory extends RecyclerView.Adapter <MyRecycleCategory.myViewHolder> {
    private ArrayList<Product> data;
    private ArrayList<Category> categories;
    private MySubCategory mySubCategoryLeft, mySubCategoryRight;
    private AppCompatActivity context = null;
    private Intent intent;

    public MyRecycleCategory(AppCompatActivity context, ArrayList<Product> data, ArrayList<Category> categories){
        this.data = data;
        this.categories = categories;
        this.context = context;
        intent = new Intent(context, ProductByCategoryActivity.class);
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
        final ArrayList<Product> dataType = new ArrayList<>();
        final String[] catName = new String[1];
        //Lấy 4 sản phẩm trong cùng 1 loại
        for (Product modelchau : data) {
            if (modelchau.getIdCategory() == position + 1) {
                for (Category category:categories) {//Lấy tên loại
                    if (modelchau.getIdCategory() == category.getId())
                        catName[0] = category.getName();
                        holder.textView.setText(catName[0]);
                }

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
                bundle.putString("nameCat", catName[0]);
                bundle.putInt("idCat", position + 1);
                intent.putExtra("bundle", bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }
}
