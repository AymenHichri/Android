package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class EditItemActivity extends AppCompatActivity {

    private String currentItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        // Retrieve the item from the intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            currentItem = extras.getString("item");
            Toast.makeText(this, "Editing item: " + currentItem, Toast.LENGTH_SHORT).show();
        }

        // Button to navigate to details page
        Button detailsButton = findViewById(R.id.detailsButton);
        detailsButton.setOnClickListener(new View.OnClickListener() {
            //Ce bloc de code définit un écouteur d'événement onClick pour un bouton ou une vue. Lorsque le bouton ou la vue est cliqué, il crée un objet Intent pour démarrer une nouvelle activité appelée ItemDetailsActivity,
            //en transmettant l'élément actuel en tant que données supplémentaires. Il démarre alors la nouvelle activité et termine l'activité en cours,
            // empêchant l'utilisateur d'y revenir.
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditItemActivity.this, ItemDetailsActivity.class);
                intent.putExtra("item", currentItem);
                startActivity(intent);
                finish(); // Finish the current activity to prevent going back to it
            }
        });
    }
}