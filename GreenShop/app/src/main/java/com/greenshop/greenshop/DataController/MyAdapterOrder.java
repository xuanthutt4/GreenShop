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
import android.widget.ImageView;
import android.widget.TextView;

import com.greenshop.greenshop.Models.Cart;
import com.greenshop.greenshop.R;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MyAdapterOrder extends ArrayAdapter<Cart>{
    private AppCompatActivity context;
    private List<Cart> carts = new ArrayList<>();
    private int idLayout;

    public MyAdapterOrder(@NonNull AppCompatActivity context, @LayoutRes int resource, List<Cart> carts) {
        super(context, resource, carts);
        this.context = context;
        this.idLayout = resource;
        this.carts = carts;
    }

    public class ViewHolder{
        TextView txtTensp, txtPrice, txtQty, txtTotal;
        ImageView imgSp;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final ViewHolder viewHolder;
        LayoutInflater inflater = context.getLayoutInflater();
        if (convertView == null){
            convertView= inflater.inflate(idLayout, parent,false);
            viewHolder= new ViewHolder();
            viewHolder.txtTensp= (TextView) convertView.findViewById(R.id.order_name);
            viewHolder.imgSp= (ImageView) convertView.findViewById(R.id.order_img);
            viewHolder.txtPrice= (TextView) convertView.findViewById(R.id.order_price);
            viewHolder.txtQty= (TextView) convertView.findViewById(R.id.order_qty);
            viewHolder.txtTotal= (TextView) convertView.findViewById(R.id.order_total_item);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Cart cart = carts.get(position);
        Log.d("TestOrder", carts.size()+"");
        viewHolder.txtTensp.setText(cart.getName());
        viewHolder.txtQty.setText(String.valueOf(cart.getQty()));
        viewHolder.txtTotal.setText(String.valueOf(cart.getPrice() * cart.getQty()));
        final DecimalFormat format = new DecimalFormat("#,###,###");
        viewHolder.txtPrice.setText(format.format(cart.getPrice())  + " đ");
        int img = context.getResources().getIdentifier(cart.getImg(), "drawable", context.getPackageName());
        Drawable drawable = viewHolder.imgSp.getResources().getDrawable(img);
        viewHolder.imgSp.setImageDrawable(drawable);
        return convertView;
    }
}
