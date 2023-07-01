package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private String[] items = {" Pizza", "Pasta", "Salad", "Chocolate", "Candy"};

    private static final int EDIT_ITEM_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        ItemAdapter adapter = new ItemAdapter(items);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, ItemDetailsActivity.class);
                intent.putExtra("item", items[position]);
                startActivity(intent);
            }
        });
    }

    private class ItemAdapter extends ArrayAdapter<String> {

        ItemAdapter(String[] items) {
            super(MainActivity.this, 0, items);
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_row, parent, false);
            }

            TextView itemTextView = convertView.findViewById(R.id.itemTextView);
            Button editButton = convertView.findViewById(R.id.editButton);

            final String item = getItem(position);
            itemTextView.setText(item);

            editButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, EditItemActivity.class);
                    intent.putExtra("item", item);
                    startActivityForResult(intent, EDIT_ITEM_REQUEST_CODE);
                }
            });

            return convertView;
        }
    }
}
