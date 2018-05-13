package com.greenshop.greenshop.ViewControllers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.greenshop.greenshop.DataController.DataController;
import com.greenshop.greenshop.DataController.MyAdapterCart;
import com.greenshop.greenshop.DataController.MyCallBack;
import com.greenshop.greenshop.Models.Cart;
import com.greenshop.greenshop.Models.Product;
import com.greenshop.greenshop.R;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {
    private ArrayList<Cart> carts = new ArrayList<>();
    private DataController controller = new DataController();
    private TextView totalPrice, title;
    private ListView lst;
    private MyAdapterCart adapter;
    private DecimalFormat format = new DecimalFormat("#,###,###");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.co_sp_layout);

        ImageView imgBack = findViewById(R.id.detail_product_button_back);
        lst = (ListView) findViewById(R.id.lst_cart);
        title = findViewById(R.id.cart_title);
        final ImageView imgPanda = findViewById(R.id.cart_panda);
        totalPrice = findViewById(R.id.cart_total);
        controller.getCart(new MyCallBack() {
            @Override
            public void onCallback(ArrayList<Product> value) {

            }

            @Override
            public void onCallbackCart(ArrayList<Cart> value) {
                carts = value;

                if (carts.isEmpty())
                    imgPanda.setImageDrawable(getResources().getDrawable(R.drawable.panda));
                else {
                    adapter = new MyAdapterCart(CartActivity.this, R.layout.listviewsp, carts);
                    lst.setAdapter(adapter);
                    title.setText(String.valueOf("Giỏ hàng("+carts.size()+")"));
                    getTotalPrice();
                }
            }
        });

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    public int getTotalPrice() {
        int total = 0;
        for (Cart cart: carts) {
            total += cart.getPrice() * cart.getQty();
        }
        totalPrice.setText(String.valueOf(format.format(total) + " đ"));
        return total;
    }

    public void removeItem(Cart cart) {
        carts.remove(cart);
        adapter.notifyDataSetChanged();
        getTotalPrice();
        title.setText(String.valueOf("Giỏ hàng("+carts.size()+")"));
    }
}
