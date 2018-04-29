package com.greenshop.greenshop.ViewControllers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.greenshop.greenshop.DataController.DataController;
import com.greenshop.greenshop.DataController.MyRecycleListCategory;
import com.greenshop.greenshop.Models.Category;
import com.greenshop.greenshop.R;

import java.util.ArrayList;

public class ListCategoryActivity extends AppCompatActivity {
    private ArrayList<Category> categories;
    private DataController controller = new DataController();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_list_catetogy);
        categories = controller.getAllCategory();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycle_list_category);

        RecyclerView.LayoutManager manager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(manager);
        MyRecycleListCategory myRecycleListCategory = new MyRecycleListCategory(categories);
        recyclerView.setAdapter(myRecycleListCategory);
    }
}
