package com.example.recyclerviewcardview1.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.recyclerviewcardview1.R;

public class DetailFlagActivity extends AppCompatActivity {

    String IMAGE = "image";
    String TITLE = "title";
    String DESC = "description";

    TextView title2,desc2;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_flag);

        imageView = findViewById(R.id.image2);
        title2 = findViewById(R.id.title2);
        desc2 = findViewById(R.id.desc2);

        imageView.setImageResource(getIntent().getIntExtra(IMAGE,0));
        title2.setText(getIntent().getStringExtra(TITLE));
        desc2.setText(getIntent().getStringExtra(DESC));

    }
}