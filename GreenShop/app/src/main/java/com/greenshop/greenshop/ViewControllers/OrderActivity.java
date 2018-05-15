package com.greenshop.greenshop.ViewControllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;
import com.greenshop.greenshop.DataController.MyAdapterOrder;
import com.greenshop.greenshop.Models.Cart;
import com.greenshop.greenshop.R;

import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends AppCompatActivity {
    private EditText edtName, edtAddress, edtNote, edtEmail, edtPhone;
    private Button btnOrder;
    private ListView lstOrder;
    private ImageView btnBack;
    private List<Cart> carts;
    private Intent intent;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRef = database.getReference().child("Order");
    private DatabaseReference mDatabase;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order);

        edtName = findViewById(R.id.edtHoTen);
        edtEmail = findViewById(R.id.edtEmail);
        edtPhone = findViewById(R.id.edtDienThoai);
        edtAddress = findViewById(R.id.edtDiaChi);
        edtNote = findViewById(R.id.edtGhiChu);
        btnOrder = findViewById(R.id.btnOrder);
        btnBack = findViewById(R.id.order_button_back);
        lstOrder = findViewById(R.id.lst_order);

        intent = getIntent();
        Bundle bundle = intent.getBundleExtra("bundleCart");
        Log.d("TestBundle", bundle.toString());
        carts = (ArrayList<Cart>) bundle.getSerializable("arrCart");

        MyAdapterOrder adapterOrder = new MyAdapterOrder(this, R.layout.list_item_order, carts);
        lstOrder.setAdapter(adapterOrder);
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtName.getText().toString().equals("") || edtEmail.getText().toString().equals("") || edtPhone.getText().toString().equals("") || edtAddress.getText().toString().equals("")) {
                    Toast.makeText(OrderActivity.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_LONG).show();
                    return;
                }
                String id = myRef.push().getKey();
                myRef.child(id).child("name").setValue(edtName.getText().toString());
                myRef.child(id).child("address").setValue(edtAddress.getText().toString());
                myRef.child(id).child("phone").setValue(edtPhone.getText().toString());
                myRef.child(id).child("note").setValue(edtNote.getText().toString());
                myRef.child(id).child("email").setValue(edtEmail.getText().toString());
                for (Cart cart: carts) {
                    myRef.child(id).child("product").child(cart.getName()).child("price").setValue(cart.getPrice());
                    myRef.child(id).child("product").child(cart.getName()).child("quantity").setValue(cart.getQty());
                }
                Toast.makeText(OrderActivity.this, "Cảm ơn bạn đã đặt hàng, chúng tôi sẽ liên lạc với bạn sớm nhất có thể", Toast.LENGTH_LONG).show();

                mDatabase = FirebaseDatabase.getInstance().getReference().child("Cart");
                final String idDevice = FirebaseInstanceId.getInstance().getToken();
                Log.d("TestToken", idDevice);
                mDatabase.child(idDevice).removeValue();

                finish();
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
