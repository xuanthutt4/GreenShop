package com.greenshop.greenshop.ViewControllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.greenshop.greenshop.DataController.MyAdapterCart;
import com.greenshop.greenshop.Models.Cart;
import com.greenshop.greenshop.R;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {
    private ArrayList<Cart> carts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.co_sp_layout);

        ImageView imgBack = findViewById(R.id.detail_product_button_back);
        ListView lst = (ListView) findViewById(R.id.lst_cart);
        ImageView imgPanda = findViewById(R.id.cart_panda);
        if (carts.isEmpty())
            imgPanda.setImageDrawable(getResources().getDrawable(R.drawable.panda));

        MyAdapterCart adapter = new MyAdapterCart(this, R.layout.listviewsp, carts);
        lst.setAdapter(adapter);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CartActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

}
