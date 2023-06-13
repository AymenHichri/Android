package com.example.project;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ItemDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);

        TextView itemDetailsTextView = findViewById(R.id.itemDetailsTextView);
        String item = getIntent().getStringExtra("item");
        itemDetailsTextView.setText("Details for " + item);
    }
}
