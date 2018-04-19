package com.example.it.Project;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.it.Project.adapter.CustomLinearLayout;
import com.example.it.Project.adapter.MyRecycleAdapter;
import com.example.it.Project.adapter.MyRecycleChau;
import com.example.it.Project.data_models.CardViewModel;
import com.example.it.Project.data_models.CardViewModelchau;
import com.example.it.hdt.R;

import java.util.Vector;

public class MainActivity extends AppCompatActivity {
    private Vector<CardViewModel> data= new Vector<>();
    private Vector<CardViewModelchau> chau= new Vector<>();

    RecyclerView recyclerView;
    RecyclerView recyclerViewchau;
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

        // banner
        data.add(new CardViewModel("Pet",R.drawable.huyen));
        data.add(new CardViewModel("Pizza 1",R.drawable.pizza1));
        data.add(new CardViewModel("..........",R.drawable.images));
        data.add(new CardViewModel("Pizza 2",R.drawable.pizza2));

        //sp chau
        chau.add(new CardViewModelchau("as","123",R.drawable.chausu));
        chau.add(new CardViewModelchau("as","123",R.drawable.pizza2));
        chau.add(new CardViewModelchau("as","123",R.drawable.huyen));
        chau.add(new CardViewModelchau("as","123",R.drawable.pizza1));



        recyclerView=(RecyclerView) findViewById(R.id.recycler);

        recyclerViewchau=(RecyclerView) findViewById(R.id.recycle);



        CustomLinearLayout customLinearLayout= new CustomLinearLayout(this);
        customLinearLayout.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(customLinearLayout);
        MyRecycleAdapter adapte= new MyRecycleAdapter(data);
        recyclerView.setAdapter(adapte);
        scrollByTime();


        CustomLinearLayout customLinearLayoutchau= new CustomLinearLayout(this);
        customLinearLayoutchau.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerViewchau.setLayoutManager(customLinearLayoutchau);
        MyRecycleChau adapterchau= new MyRecycleChau(chau);
        recyclerViewchau.setAdapter(adapterchau);

    }
}
