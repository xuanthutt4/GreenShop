package com.example.it.Project;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.example.it.Project.adapter.CustomLinearLayout;
import com.example.it.Project.adapter.MyRecycleAdapter;
import com.example.it.Project.adapter.MyRecycleCategory;
import com.example.it.Project.adapter.MyRecycleChau;
import com.example.it.Project.data_models.CardViewModel;
import com.example.it.Project.data_models.CardViewModelchau;
import com.example.it.hdt.R;

import java.util.Vector;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{
    private Vector<CardViewModel> data = new Vector<>();
    private Vector<CardViewModelchau> chau = new Vector<>(), dataItem = new Vector<>();

    private RecyclerView recyclerView;
    private RecyclerView recyclerViewchau, recycleCategory;
    private int position = 0;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private ArrayAdapter<String> adapter;
    private String[] mdata;
    private SearchView searchView;

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
        setContentView(R.layout.drawer_menu);
        Toolbar toolbar ;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        FrameLayout container = (FrameLayout) findViewById(R.id.content_frame);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerMenu);//Lấy layout của Activity
        ListView drawer = (ListView) findViewById(R.id.drawer);//Lấy ListView
        mdata = getResources().getStringArray(R.array.menu);//Lấy mảng
        getLayoutInflater().inflate(R.layout.activity_main, container);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mdata);
        drawer.setAdapter(adapter); // Thiết lập nội dung của ListView

        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.app_name, R.string.app_name) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                invalidateOptionsMenu();
            }
        };
        drawerToggle.setDrawerIndicatorEnabled(true);
        drawerLayout.addDrawerListener(drawerToggle);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /*getMenuInflater().inflate(R.menu.search_view, menu);
        MenuItem itemSearch = menu.findItem(R.id.searchView);
        searchView = (SearchView) itemSearch.getActionView();
        //set OnQueryTextListener cho search view để thực hiện search theo text
        //  searchView.setOnQueryTextListener(this);*/
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_view, menu);

        MenuItem searchMenuItem = menu.findItem(R.id.searchView);
        searchView = (SearchView) searchMenuItem.getActionView();

        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return true;
    }
}
