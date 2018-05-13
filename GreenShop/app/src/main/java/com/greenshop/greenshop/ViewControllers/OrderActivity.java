package com.greenshop.greenshop.ViewControllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.greenshop.greenshop.Models.Cart;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {
    private EditText edtName, edtAddress, edtNote, edtEmail, edtPhone;
    private Button btnOrder;
    private ArrayList<Cart> carts;
    private Intent intent;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRef = database.getReference().child("Order");
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        intent = getIntent();
        carts = (ArrayList<Cart>) intent.getBundleExtra("data").getSerializable("cart");
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = myRef.push().getKey();
                myRef.child(id).child("name").setValue(edtName.getText());
                myRef.child(id).child("address").setValue(edtAddress.getText());
                myRef.child(id).child("phone").setValue(edtPhone.getText());
                myRef.child(id).child("note").setValue(edtNote.getText());
                myRef.child(id).child("email").setValue(edtEmail.getText());
                for (Cart cart: carts) {
                    myRef.child(id).child("product").child(cart.getName()).child("price").setValue(cart.getPrice());
                    myRef.child(id).child("product").child(cart.getName()).child("quantity").setValue(cart.getQty());
                }
                Toast.makeText(OrderActivity.this, "Cảm ơn bạn đã đặt hàng, chúng tôi sẽ liên lạc với bạn sớm nhất có thể", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}
