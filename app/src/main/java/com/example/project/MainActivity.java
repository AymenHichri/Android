package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private String[] items = {"Pizza", "Pasta", "Salad", "Chocolate", "Candy"};

    //Ce bloc de code configure l'activité principale en affectant la mise en page appropriée,
    // en initialisant un adaptateur personnalisé pour une vue de liste et en définissant un écouteur de clic d'élément.

    //Lorsqu'un élément de la vue de liste est cliqué, il récupère l'élément correspondant, crée un objet Intent pour démarrer une nouvelle activité appelée ItemDetailsActivity,
    // en transmettant l'élément sélectionné en tant que donnée supplémentaire, et démarre la nouvelle activité.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        CustomAdapter adapter = new CustomAdapter();
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = items[position];
                Intent intent = new Intent(MainActivity.this, ItemDetailsActivity.class);
                intent.putExtra("item", item);
                startActivity(intent);
            }
        });
    }

    private class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return items.length;
        }

        @Override
        public Object getItem(int position) {
            return items[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }
       //Ce bloc de code définit la méthode getView pour un adaptateur personnalisé utilisé dans une vue de liste.
       // Il gonfle la disposition de chaque ligne, définit le texte d'un élément et définit un écouteur onClick pour un bouton d'édition dans chaque ligne.
        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(MainActivity.this).inflate(R.layout.item_row, parent, false);
            }

            TextView itemTextView = convertView.findViewById(R.id.itemTextView);
            Button editButton = convertView.findViewById(R.id.editButton);

            final String item = items[position];
            itemTextView.setText(item);

            editButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, EditItemActivity.class);
                    intent.putExtra("item", item);
                    startActivity(intent);
                }
            });

            return convertView;
        }
    }
}
