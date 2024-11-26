package com.example.seminar4;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class VizualizareGarsoniere extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vizualizare_garsoniere);

        ArrayList<Garsoniera> garsoniere = getIntent().getParcelableArrayListExtra("garsoniere");

        // Verifică dacă lista a fost primită corect
        if (garsoniere == null || garsoniere.isEmpty()) {
            //Toast.makeText(this, "Nu s-au primit garsoniere!", Toast.LENGTH_LONG).show();
            return;
        }
        ListView listaGarsoniere = findViewById(R.id.listaGarsoniere);

        /*
        List<Garsoniera> garsoniere = new ArrayList<>();
        garsoniere = new ArrayList<>();
        garsoniere.add(new Garsoniera("București", "Strada Unirii", 2, 12, true));
        garsoniere.add(new Garsoniera("Cluj-Napoca", "Strada Memorandumului", 1, 5, false));
        garsoniere.add(new Garsoniera("Iași", "Strada Cuza Vodă", 3, 18, true));
        */


        // Configurează adapterul
        Shape adapter = new Shape(garsoniere, this, R.layout.shape);
        listaGarsoniere.setAdapter(adapter);
    }
}