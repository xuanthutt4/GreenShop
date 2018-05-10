package com.greenshop.greenshop.ViewControllers;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.greenshop.greenshop.Models.Product;
import com.greenshop.greenshop.R;

public class DetailProductActivity extends AppCompatActivity {

    private Product product;
    private ImageView imgBack, imgShare, imgAddCart, imgProduct;
    private Button btnAddToCart;
    private TextView txtPriceBottom, txtOldPrice, txtCurrentPrice, txtName, txtDescription,
            txtDescriptionBenefits;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_product);
        intent = getIntent();
        product = (Product) intent.getBundleExtra("bundle").getSerializable("data");
        try {
            setUpFindView();
            if (product != null)
                disPlayProduct(product);

        } catch (Exception e) {
            Log.e("ERROR", e.getMessage());
        }

        if (getIntent() != null) {
        }


    }

    void setUpFindView() {
        imgBack = findViewById(R.id.detail_product_button_back);
        imgAddCart = findViewById(R.id.detail_product_button_cart);
        imgProduct = findViewById(R.id.detail_product_images_product);
        imgShare = findViewById(R.id.detail_product_button_share);

        //Set event
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailProductActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        imgShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DetailProductActivity.this, "Shared", Toast.LENGTH_SHORT).show();
            }
        });

        imgAddCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DetailProductActivity.this, "Added", Toast.LENGTH_SHORT).show();
            }
        });


        btnAddToCart = findViewById(R.id.detail_product_button_add_to_card);
        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DetailProductActivity.this, "Added", Toast.LENGTH_SHORT).show();
            }
        });

        txtCurrentPrice = findViewById(R.id.detail_product_current_price);
        txtOldPrice = findViewById(R.id.detail_product_old_price);
        txtPriceBottom = findViewById(R.id.detail_product_price_bottom);
        txtName = findViewById(R.id.detail_product_text_view_name_product);
        txtDescription = findViewById(R.id.detail_product_description);
        txtDescriptionBenefits = findViewById(R.id.detail_product_description_benefits);


    }

    void disPlayProduct(Product product) {
        txtName.setText(product.getName());
        txtOldPrice.setText(Float.toString(product.getOldPrice()));
        txtCurrentPrice.setText(Float.toString(product.getPrice()));
        txtDescriptionBenefits.setText(product.getDescriptionBenefits());
        txtPriceBottom.setText(Float.toString(product.getPrice()));
        txtDescription.setText(product.getDescription());
        int img = getResources().getIdentifier(product.getImages()[0], "drawable", getPackageName());
        Drawable drawable = imgProduct.getResources().getDrawable(img);
        imgProduct.setImageDrawable(drawable);
        Log.d("testImg", drawable.toString());
    }
}
