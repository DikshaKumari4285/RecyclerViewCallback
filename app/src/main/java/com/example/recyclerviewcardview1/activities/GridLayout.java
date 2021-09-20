package com.example.recyclerviewcardview1.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.recyclerviewcardview1.model.Model;
import com.example.recyclerviewcardview1.MyAdapter;
import com.example.recyclerviewcardview1.R;

import java.util.ArrayList;

public class GridLayout extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    MyAdapter myAdapter;
    ArrayList<Model> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_layout);
        init();
    }


    public void init(){
        generateData();
        recyclerView = findViewById(R.id.rvGrid);
        myAdapter = new MyAdapter(this,mList);
        layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(myAdapter);
    }

    private void generateData() {
        mList.add(new Model("Grid 1","Hello world", R.drawable.flag));
        mList.add(new Model("Grid2","Hello world", R.drawable.flag2));
        mList.add(new Model("Grid3","Hello world", R.drawable.flag3));
        mList.add(new Model("Grid4","Hello world", R.drawable.flag));
        mList.add(new Model("Grid5","Hello world", R.drawable.flag2));
        mList.add(new Model("Grid6","Hello world", R.drawable.flag3));
        mList.add(new Model("Grid7","Hello world", R.drawable.flag4));
        mList.add(new Model("Grid8","Hello world", R.drawable.flag));
        mList.add(new Model("Grid9","Hello world", R.drawable.flag2));
        mList.add(new Model("Grid10","Hello world", R.drawable.flag3));
    }
}