package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class EditItemActivity extends AppCompatActivity {

    private TextInputEditText editText;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        editText = findViewById(R.id.editText);
        saveButton = findViewById(R.id.saveButton);

        String item = getIntent().getStringExtra("item");
        editText.setText(item);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String updatedItem = editText.getText().toString();
                Intent resultIntent = new Intent();
                resultIntent.putExtra("updatedItem", updatedItem);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}