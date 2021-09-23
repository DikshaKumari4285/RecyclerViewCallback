package com.example.recyclerviewcardview1.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.recyclerviewcardview1.R;
import com.example.recyclerviewcardview1.model.Model;

public class DetailFlagActivity extends AppCompatActivity {

    TextView title2,desc2;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_flag);

        imageView = findViewById(R.id.image2);
        title2 = findViewById(R.id.title2);
        desc2 = findViewById(R.id.desc2);

        Intent i = getIntent();
        Bundle bundle = i.getExtras();
        Model model = (Model) bundle.getSerializable("modelID");
        imageView.setImageResource(model.getImage());
        title2.setText(model.getTitle());
        desc2.setText(model.getDescription());
    }
}