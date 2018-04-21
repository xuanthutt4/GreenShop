package com.example.it.Project;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.it.Project.adapter.CustomLinearLayout;
import com.example.it.Project.adapter.MyRecycleAdapter;
import com.example.it.Project.adapter.MyRecycleCategory;
import com.example.it.Project.adapter.MyRecycleChau;
import com.example.it.Project.data_models.CardViewModel;
import com.example.it.Project.data_models.CardViewModelchau;
import com.example.it.hdt.R;

import java.util.Vector;

public class MainActivity extends AppCompatActivity {
    private Vector<CardViewModel> data = new Vector<>();
    private Vector<CardViewModelchau> chau = new Vector<>(), dataItem = new Vector<>();

    RecyclerView recyclerView;
    RecyclerView recyclerViewchau, recycleCategory;
    private int position = 0;

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
        chau.add(new CardViewModelchau("eas", 123, R.drawable.chausu, 1));
        chau.add(new CardViewModelchau("eas", 123, R.drawable.pizza2, 1));
        chau.add(new CardViewModelchau("edas", 123, R.drawable.huyen, 1));
        chau.add(new CardViewModelchau("eads", 123, R.drawable.pizza1, 1));
        chau.add(new CardViewModelchau("asbd", 123, R.drawable.chausu, 2));
        chau.add(new CardViewModelchau("asv", 123, R.drawable.pizza2, 2));
        chau.add(new CardViewModelchau("ads", 123, R.drawable.huyen, 2));
        chau.add(new CardViewModelchau("asg", 123, R.drawable.pizza1, 2));

        recyclerView = (RecyclerView) findViewById(R.id.recycler);

        recyclerViewchau = (RecyclerView) findViewById(R.id.recycleChau);
        recycleCategory = (RecyclerView) findViewById(R.id.recycle_category);

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

        dataItem.add(new CardViewModelchau("Cây 1", 20000, R.drawable.lvn1521459111, 1));
        dataItem.add(new CardViewModelchau("Cây 2", 20000, R.drawable.cay_canh, 1));
        dataItem.add(new CardViewModelchau("Cây 3", 20000, R.drawable.lvn1521459111, 1));
        dataItem.add(new CardViewModelchau("Cây 4", 20000, R.drawable.cay_canh, 1));
        dataItem.add(new CardViewModelchau("Cây 5", 20000, R.drawable.lvn1521459111, 2));
        dataItem.add(new CardViewModelchau("Cây 6", 20000, R.drawable.cay_canh, 2));
        dataItem.add(new CardViewModelchau("Cây 7", 20000, R.drawable.lvn1521459111, 2));
        dataItem.add(new CardViewModelchau("Cây 8", 20000, R.drawable.cay_canh, 2));

        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recycleCategory.setLayoutManager(manager);
        MyRecycleCategory myRecycleCategory = new MyRecycleCategory(this, dataItem, 2);
        recycleCategory.setAdapter(myRecycleCategory);
    }
}
