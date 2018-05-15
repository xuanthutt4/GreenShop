package com.greenshop.greenshop.ViewControllers;

import android.content.Intent;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;
import com.greenshop.greenshop.Models.Product;
import com.greenshop.greenshop.R;

public class DetailProductActivity extends AppCompatActivity {

    private Product product;
    private ImageView imgBack, imgShare, imgAddCart, imgProduct;
    private Button btnAddToCart;
    private TextView txtPriceBottom, txtOldPrice, txtCurrentPrice, txtName, txtDescription,
            txtDescriptionBenefits, txtSale;
    private DatabaseReference mDatabase;
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

    }

    void setUpFindView() {
        imgBack = findViewById(R.id.detail_product_button_back);
        imgAddCart = findViewById(R.id.detail_product_button_cart);
        imgProduct = findViewById(R.id.detail_product_images_product);

        //Set event
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        imgAddCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailProductActivity.this, CartActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        btnAddToCart = findViewById(R.id.detail_product_button_add_to_card);
        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mDatabase = FirebaseDatabase.getInstance().getReference().child("Cart");
                final String idDevice = FirebaseInstanceId.getInstance().getToken();
                Log.d("TestToken", idDevice);
                mDatabase.child(idDevice).child(product.getId()).setValue(product.getIdCategory());

                Toast.makeText(DetailProductActivity.this, "Đã thêm vào giỏ hàng", Toast.LENGTH_SHORT).show();
            }
        });

        txtCurrentPrice = findViewById(R.id.detail_product_current_price);
        txtOldPrice = findViewById(R.id.detail_product_old_price);
        txtPriceBottom = findViewById(R.id.detail_product_price_bottom);
        txtName = findViewById(R.id.detail_product_text_view_name_product);
        txtDescription = findViewById(R.id.detail_product_description);
        txtDescriptionBenefits = findViewById(R.id.detail_product_description_benefits);
        txtSale = findViewById(R.id.detail_product_sale);

    }

    void disPlayProduct(Product product) {
        txtName.setText(product.getName());
        txtOldPrice.setText(product.getStringOldPrice());
        if (product.getSale() > 0) {
            txtOldPrice.setPaintFlags(txtOldPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            txtCurrentPrice.setText(product.getStringPrice());
            txtSale.setText(String.valueOf("-" + product.getSale() + "%"));
        }
        txtDescriptionBenefits.setText(product.getDescriptionBenefits());
        txtPriceBottom.setText(product.getStringPrice());
        txtDescription.setText(product.getDescription());
        int img = getResources().getIdentifier(product.getImages()[0], "drawable", getPackageName());
        Drawable drawable = imgProduct.getResources().getDrawable(img);
        imgProduct.setImageDrawable(drawable);
        Log.d("testImg", drawable.toString());
    }
}
