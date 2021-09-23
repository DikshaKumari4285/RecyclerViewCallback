package com.example.recyclerviewcardview1.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Filter;

import com.example.recyclerviewcardview1.CallbackListener;
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
    Button buttonGrid, buttonRetrofit;
    EditText editTextSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        myAdapter.callBack(new CallbackListener() {
            @Override
            public void callBack(Model model) {
                Intent intent = new Intent(MainActivity.this,DetailFlagActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("modelID",model);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    public void init() {
        generateData();

        recyclerView = findViewById(R.id.rv);
        editTextSearch = findViewById(R.id.edit_search);
        myAdapter = new MyAdapter(this, mList);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(myAdapter);

        buttonGrid = findViewById(R.id.button);
        buttonRetrofit = findViewById(R.id.button_retrofit);
        buttonGrid.setOnClickListener(this);
        buttonRetrofit.setOnClickListener(this);

        editTextSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(editable.length()>2) {
                    filter(editable.toString());
                }
            }
        });

    }

    private void filter(String text) {
        ArrayList<Model> filteredList = new ArrayList<>();
        for (Model item : mList) {
            if (item.getDescription().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }
        myAdapter.filterList(filteredList);
    }

    public void generateData() {
        mList.add(new Model("Title1", "first ", R.drawable.flag4));
        mList.add(new Model("Title2", "second   I am fine", R.drawable.flag));
        mList.add(new Model("Title3", "third flag   I am fine", R.drawable.flag4));
        mList.add(new Model("Title4", "fourth flag  I am fine", R.drawable.flag));
        mList.add(new Model("Title5", "Hello fifth    I am fine", R.drawable.flag4));
        mList.add(new Model("Title6", "Hello sixth    I am fine", R.drawable.flag3));
        mList.add(new Model("Title7", "seventh world    I am fine", R.drawable.flag2));
        mList.add(new Model("Title8", "Hello wgdfgdforld    I am fine", R.drawable.flag3));
        mList.add(new Model("Title9", "Hello world    I am fine", R.drawable.flag2));
        mList.add(new Model("Title10", "Hello ghdfgdfworld   I am fine", R.drawable.flag));
        mList.add(new Model("Title11", "Hello wgdfgdfgorld    I am fine", R.drawable.flag));
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
}
