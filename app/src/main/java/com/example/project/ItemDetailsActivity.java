package com.example.project;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ItemDetailsActivity extends AppCompatActivity {

    private TextView itemDetailsTextView;
    //Ce bloc de code configure l'ItemDetailsActivity en affectant la mise en page appropriée,
    // en récupérant les données d'élément transmises par l'activité précédente et en affichant les détails de l'élément dans une vue texte.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);

        itemDetailsTextView = findViewById(R.id.itemDetailsTextView);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String item = extras.getString("item");
            displayItemDetails(item);
        }
    }

    private void displayItemDetails(String item) {
        String details = "There are details regarding item: " + item + "\n"+"This item is know dish and is usually associated with mediterranean areas";
        itemDetailsTextView.setText(details);
    }
}