package com.greenshop.greenshop.DataController;

import android.graphics.drawable.Drawable;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.greenshop.greenshop.Models.Cart;
import com.greenshop.greenshop.R;
import com.greenshop.greenshop.ViewControllers.CartActivity;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by IT on 5/7/2018.
 */

public class MyAdapterCart extends ArrayAdapter<Cart> {
    private AppCompatActivity context;
    private ArrayList<Cart> carts = new ArrayList<>();
    private int idLayout;

    public MyAdapterCart(@NonNull AppCompatActivity context, @LayoutRes int resource, ArrayList<Cart> carts) {
        super(context, resource, carts);
        this.context = context;
        this.idLayout = resource;
        this.carts = carts;
    }
    public class ViewHolder{
        TextView txtTensp, txtPrice;
        ImageView imgSp;
        Button btncong, btntru;
        ImageButton btnRemove;
        TextView txtCartnum;
    }

    @NonNull
    @Override
    public View getView(int i, @Nullable View view, @NonNull ViewGroup viewGroup) {
        final ViewHolder viewHolder;
        LayoutInflater inflater = context.getLayoutInflater();
        Log.d("TestCart", carts.size()+"");
        if (view == null){
            view= inflater.inflate(idLayout, viewGroup,false);
            viewHolder= new ViewHolder();
            viewHolder.txtTensp= (TextView) view.findViewById(R.id.cart_name);
            viewHolder.imgSp= (ImageView) view.findViewById(R.id.cart_img);
            viewHolder.txtPrice= view.findViewById(R.id.cart_price);
            viewHolder.txtCartnum= view.findViewById(R.id.cart_number);
            viewHolder.btncong = view.findViewById(R.id.btnPlus);
            viewHolder.btntru= view.findViewById(R.id.btnMinus);
            viewHolder.btnRemove= view.findViewById(R.id.cart_remove);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }
        final Cart cart = carts.get(i);
        viewHolder.txtTensp.setText(cart.getName());
        final DecimalFormat format = new DecimalFormat("#,###,###");
        viewHolder.txtPrice.setText(format.format(cart.getPrice())  + " đ");
        int img = context.getResources().getIdentifier(cart.getImg(), "drawable", context.getPackageName());
        Drawable drawable = viewHolder.imgSp.getResources().getDrawable(img);
        viewHolder.imgSp.setImageDrawable(drawable);

        viewHolder.txtCartnum.setText(String.valueOf(cart.getQty()));
        viewHolder.btncong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cart.setQty(Integer.parseInt(viewHolder.txtCartnum.getText()+"")+1);
                viewHolder.txtCartnum.setText(String.valueOf(cart.getQty()));
                int price = cart.getPrice() * cart.getQty();
                viewHolder.txtPrice.setText(String.valueOf(format.format(price) + "đ"));
                ((CartActivity) context).getTotalPrice();
            }
        });

        viewHolder.btntru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cart.getQty() > 1){
                    cart.setQty(Integer.parseInt((viewHolder.txtCartnum.getText()+"")) - 1);
                    viewHolder.txtCartnum.setText(String.valueOf(cart.getQty()));
                    int price = cart.getPrice() * cart.getQty();
                    viewHolder.txtPrice.setText(String.valueOf(format.format(price) + " đ"));
                    ((CartActivity) context).getTotalPrice();
                }
            }
        });
        viewHolder.btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((CartActivity) context).removeItem(cart);
            }
        });
        return view;
    }
}
