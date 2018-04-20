package com.example.it.hdt;

import android.app.Activity;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView.OnItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


import com.example.it.hdt.adapter.ProductAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListProductActivity extends Activity implements OnItemClickListener{
    String[] name;
    TypedArray pro_pics;
    String[] stautes;
    String[] contact;
    List<RowItem> rowItems;
    ListView mylistview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_product);

        rowItems= new ArrayList<RowItem>();
        name= getResources().getStringArray(R.array.Product_name);
        pro_pics= getResources().obtainTypedArray(R.array.Product_picts);
        stautes= getResources().getStringArray(R.array.statuus);
        contact= getResources().getStringArray(R.array.contact);

        for (int i=0 ; i< name.length ; i++){
            RowItem item = new RowItem(name[i],pro_pics.getResourceId(i,-1),stautes[i],contact[i]);
            rowItems.add(item);
        }

        mylistview= (ListView) findViewById(R.id.List);
        ProductAdapter adapter = new ProductAdapter(this, rowItems);
        mylistview.setAdapter(adapter);

        mylistview.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String name= rowItems.get(i).getProName();
        Toast.makeText(getApplicationContext(), ""+ name, Toast.LENGTH_SHORT).show();
    }
}
