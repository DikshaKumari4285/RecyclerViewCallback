package com.example.recyclerviewcardview1.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.recyclerviewcardview1.model.Model;
import com.example.recyclerviewcardview1.MyAdapter;
import com.example.recyclerviewcardview1.R;

import java.util.ArrayList;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private static final String TAG = MainActivity.class.getSimpleName();
    ArrayList<Model> mList = new ArrayList<>();

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    MyAdapter myAdapter;
    Button buttonGrid,buttonRetrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init() {
        generateData();

        recyclerView = findViewById(R.id.rv);
        myAdapter = new MyAdapter(this, mList);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(myAdapter);

        buttonGrid = findViewById(R.id.button);
        buttonRetrofit = findViewById(R.id.button_retrofit);
        buttonGrid.setOnClickListener(this);
        buttonRetrofit.setOnClickListener(this);

    }

    public void generateData() {
        mList.add(new Model("Title1", "Hello world    I am fine", R.drawable.flag4));
        mList.add(new Model("Title2", "Hello world    I am fine", R.drawable.flag));
        mList.add(new Model("Title3", "Hello world    I am fine", R.drawable.flag4));
        mList.add(new Model("Title4", "Hello world    I am fine", R.drawable.flag));
        mList.add(new Model("Title5", "Hello world    I am fine", R.drawable.flag4));
        mList.add(new Model("Title6", "Hello world    I am fine", R.drawable.flag3));
        mList.add(new Model("Title7", "Hello world    I am fine", R.drawable.flag2));
        mList.add(new Model("Title8", "Hello world    I am fine", R.drawable.flag3));
        mList.add(new Model("Title9", "Hello world    I am fine", R.drawable.flag2));
        mList.add(new Model("Title10", "Hello world   I am fine", R.drawable.flag));
        mList.add(new Model("Title11", "Hello world    I am fine", R.drawable.flag));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                Intent intent = new Intent(this, GridLayout.class);
                startActivity(intent);
                break;
            case R.id.button_retrofit:
                startActivity(new Intent(this, RetrofitActivity.class));
                break;

        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//
//        getMenuInflater().inflate(R.menu.my_menu_search,menu);
//        MenuItem menuItem = findViewById(R.id.search_menu);
////        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
//        SearchView searchView = (SearchView)menuItem.getActionView();
////        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
//        if (searchView != null){
//            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//
//                myAdapter.getFilter().filter(newText);
//                return true;
//            }
//        });
//        }
//        else {
//            Log.d(TAG, "SearchView is null");
//        }
//
//        return super.onCreateOptionsMenu(menu);
//    }

}