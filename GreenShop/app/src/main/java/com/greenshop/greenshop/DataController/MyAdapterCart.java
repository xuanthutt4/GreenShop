package com.greenshop.greenshop.DataController;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.greenshop.greenshop.Models.Cart;
import com.greenshop.greenshop.R;

import java.util.ArrayList;

/**
 * Created by IT on 5/7/2018.
 */

public class MyAdapterCart extends ArrayAdapter<Cart> {
    private ArrayList<Cart> carts = new ArrayList<>();
    private int idLayout;
    private Context context;
    private int number=1;

    public MyAdapterCart(@NonNull AppCompatActivity context, @LayoutRes int resource, ArrayList<Cart> carts) {
        super(context, resource);
        this.idLayout = resource;
        this.carts = carts;
    }
    public class ViewHolder{
        TextView txtTensp;
        ImageView imgSp;
        Button btncong;
        Button btntru;
        TextView txtCartnum;
    }

    @NonNull
    @Override
    public View getView(int i, @Nullable View view, @NonNull ViewGroup viewGroup) {
        final ViewHolder viewHolder;
        int number=1;
        if (view == null){
            viewHolder= new ViewHolder();
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view= inflater.inflate(R.layout.listviewsp,null);
            viewHolder.txtTensp= (TextView) view.findViewById(R.id.cart_name);
            viewHolder.imgSp= (ImageView) view.findViewById(R.id.cart_img);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();

        }

        viewHolder.txtCartnum.setText(number+"");
        viewHolder.btncong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewHolder.txtCartnum.setText((Integer.parseInt(viewHolder.txtCartnum.getText()+"")+1)+"");
            }
        });

        viewHolder.btntru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Integer.parseInt(viewHolder.txtCartnum.getText()+"") == 0){
                    viewHolder.txtCartnum.setText("0");
                }else {
                    viewHolder.txtCartnum.setText((Integer.parseInt((viewHolder.txtCartnum.getText()+"")) - 1)+"");
                }
            }
        });
        return view;
    }
}
