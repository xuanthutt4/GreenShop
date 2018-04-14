package com.example.it.Project;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.it.Project.adapter.CustomLinearLayout;
import com.example.it.Project.adapter.MyRecycleAdapter;
import com.example.it.Project.data_models.CardViewModel;
import com.example.it.hdt.R;

import java.util.Vector;

public class MainActivity extends AppCompatActivity {
    private Vector<CardViewModel> data= new Vector<>();
    RecyclerView recyclerView;
    RecyclerView recyclerView1;
    private int position;


    private void scrollByTime(){
        final Handler handler= new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                position++;
                if (position >=data.size()){
                    position=0;
                }
                    recyclerView.smoothScrollToPosition(position);
                    handler.postDelayed(this,3000);

            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data.add(new CardViewModel("Pet",R.drawable.huyen));
        data.add(new CardViewModel("Pizza 1",R.drawable.pizza1));
        data.add(new CardViewModel("..........",R.drawable.images));
        data.add(new CardViewModel("Pizza 2",R.drawable.pizza2));


        // san pham 1;
        data.add(new CardViewModel("a",R.drawable.chausu));

        recyclerView1 =(RecyclerView) findViewById(R.id.chaukieng) ;

        recyclerView=(RecyclerView) findViewById(R.id.recycler);



        CustomLinearLayout customLinearLayout= new CustomLinearLayout(this);
        customLinearLayout.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(customLinearLayout);
        MyRecycleAdapter adapte= new MyRecycleAdapter(data);
        recyclerView.setAdapter(adapte);
        scrollByTime();

    }
}
