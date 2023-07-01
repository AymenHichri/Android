package com.example.project;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ItemDetailsActivity extends AppCompatActivity {

    private TextView itemDetailsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);

        itemDetailsTextView = findViewById(R.id.itemDetailsTextView);

        String item = getIntent().getStringExtra("item");
        itemDetailsTextView.setText(item);
    }
}
