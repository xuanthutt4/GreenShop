package com.greenshop.greenshop.ViewControllers;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.greenshop.greenshop.DataController.CustomLinearLayout;
import com.greenshop.greenshop.DataController.DataController;
import com.greenshop.greenshop.DataController.MyRecycleAdapter;
import com.greenshop.greenshop.DataController.MyRecycleCategory;
import com.greenshop.greenshop.DataController.MyRecycleChau;
import com.greenshop.greenshop.DataController.MySearch;
import com.greenshop.greenshop.Models.Category;
import com.greenshop.greenshop.Models.Product;
import com.greenshop.greenshop.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private ArrayList<Product> data = new ArrayList<>();
    private ArrayList<Category> categories = new ArrayList<>();
    private DataController controller = new DataController();
    private RecyclerView recyclerView, recyclerViewchau, recycleCategory;
    private int position = 0;
    private MySearch mySearch;
    private String[] banner = new String[] {"banner"};

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
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //FrameLayout container = (FrameLayout) findViewById(R.id.frame_container);
        //getLayoutInflater().inflate(R.layout.content_main, container);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string
                .navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //banner
        data = controller.getAllProducts();
        categories = controller.getAllCategory();
        recyclerView = (RecyclerView) findViewById(R.id.recycler);

        recyclerViewchau = (RecyclerView) findViewById(R.id.recycleChau);
        recycleCategory = (RecyclerView) findViewById(R.id.recycle_category);

        CustomLinearLayout customLinearLayout= new CustomLinearLayout(this);
        customLinearLayout.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(customLinearLayout);
        MyRecycleAdapter adapte= new MyRecycleAdapter(banner, this);
        recyclerView.setAdapter(adapte);
        scrollByTime();

        CustomLinearLayout customLinearLayoutchau= new CustomLinearLayout(this);
        customLinearLayoutchau.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerViewchau.setLayoutManager(customLinearLayoutchau);
        MyRecycleChau adapterchau= new MyRecycleChau(data, this);
        recyclerViewchau.setAdapter(adapterchau);

        LinearLayoutManager manager = new LinearLayoutManager(this) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recycleCategory.setLayoutManager(manager);
        MyRecycleCategory myRecycleCategory = new MyRecycleCategory(this, data, categories);
        recycleCategory.setAdapter(myRecycleCategory);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        // Get the search menu.
        MenuItem searchMenu = menu.findItem(R.id.app_bar_menu_search);

        // Get SearchView object.
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchMenu);

        final SearchView.SearchAutoComplete searchAutoComplete = (SearchView.SearchAutoComplete)searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);
        //searchAutoComplete.setDropDownWidth(getResources().getDisplayMetrics().widthPixels);
        //String dataArr[] = {"Apple" , "Amazon" , "Amd", "Microsoft", "Microwave", "MicroNews", "Intel", "Intelligence"};
        //ArrayAdapter<String> newsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, dataArr);
        mySearch = new MySearch(this, R.layout.list_item, data);
        searchAutoComplete.setAdapter(mySearch);

        searchAutoComplete.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int itemIndex, long id) {
                Product queryString=(Product)adapterView.getItemAtPosition(itemIndex);
                searchAutoComplete.setText("" + queryString);
                Toast.makeText(MainActivity.this, "you clicked " + queryString, Toast.LENGTH_LONG).show();
            }
        });

        // Below event is triggered when submit search query.
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                alertDialog.setMessage("Search keyword is " + query);
                alertDialog.show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText.length() > 2) {
                    ArrayList<Product> temp = new ArrayList<>();
                    for (Product product:data) {
                        if (product.getName().toLowerCase().contains(newText.toLowerCase()))
                            temp.add(product);
                    }
                    searchAutoComplete.setVisibility(View.VISIBLE);
                    mySearch = new MySearch(MainActivity.this, R.layout.list_item, temp);
                    searchAutoComplete.setAdapter(mySearch);
                }
                //else
                    //searchAutoComplete.setVisibility(View.INVISIBLE);

                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_cart) {
            Intent intent = new Intent(this, CartActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
