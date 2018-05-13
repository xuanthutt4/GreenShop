package com.greenshop.greenshop.ViewControllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
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
        ImageView btnReturn = (ImageView) findViewById(R.id.btn_return);
        if (intent.getBundleExtra("bundle") != null) {
            Bundle bundle = intent.getBundleExtra("bundle");
            String nameCat = (String) bundle.getString("nameCat");
            String idCat = bundle.getString("idCat");
            Log.d("idCat", idCat);
            lstName.setText(nameCat);
            products = (ArrayList<Product>) bundle.getSerializable("data");

            ArrayList<Product> data = new ArrayList<>();
            for (Product product:products) {
                Log.d("idPro", product.getIdCategory());
                if (product.getIdCategory().equals(idCat))
                    data.add(product);
            }

            LinearLayoutManager manager = new LinearLayoutManager(this);
            manager.setOrientation(LinearLayoutManager.VERTICAL);
            lst.setLayoutManager(manager);
            MyRecycleProByCat adapter = new MyRecycleProByCat(data, this);
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
