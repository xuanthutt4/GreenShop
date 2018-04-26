package com.greenshop.greenshop.ViewControllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.greenshop.greenshop.DataController.MyRecycleProByCat;
import com.greenshop.greenshop.Models.Product;
import com.greenshop.greenshop.R;

import java.util.ArrayList;

public class ProductByCategoryActivity extends AppCompatActivity{
    private Intent intent;
    private ArrayList<Product> products;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_by_category);

        intent = this.getIntent();

        TextView lstName = (TextView) findViewById(R.id.lst_name);
        RecyclerView lst = (RecyclerView) findViewById(R.id.lst_pro_cat);
        Button btnReturn = (Button) findViewById(R.id.btn_return);
        if (intent.getBundleExtra("bundle") != null) {
            Bundle bundle = intent.getBundleExtra("bundle");
            String nameCat = (String) bundle.getString("nameCat");
            lstName.setText(nameCat);
            products = (ArrayList<Product>) bundle.getSerializable("data");
            Log.d("testPro", products.toString());

            LinearLayoutManager manager = new LinearLayoutManager(this);
            manager.setOrientation(LinearLayoutManager.VERTICAL);
            lst.setLayoutManager(manager);
            MyRecycleProByCat adapter = new MyRecycleProByCat(products, this);
            lst.setAdapter(adapter);
        }
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
