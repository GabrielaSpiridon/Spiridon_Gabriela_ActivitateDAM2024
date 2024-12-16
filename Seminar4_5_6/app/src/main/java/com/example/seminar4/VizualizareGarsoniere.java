package com.example.seminar4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class VizualizareGarsoniere extends AppCompatActivity {

    List<Garsoniera> garsoniere=null;
    public GarsonieraDatabase garsonieraDb=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vizualizare_garsoniere);

        Intent it=getIntent();

        garsoniere=new ArrayList<>();
        garsonieraDb= Room.databaseBuilder(getApplicationContext(),GarsonieraDatabase.class,"GarsonieraDatabase").build();


        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                List<Garsoniera> listaDB = garsonieraDb.garsonieraDAO().getAllGarsoniere();
                garsoniere.addAll(listaDB);
            }
        });

         /*
        ArrayList<Garsoniera> garsoniere = getIntent().getParcelableArrayListExtra("garsoniere");

        // Verifică dacă lista a fost primită corect
        if (garsoniere == null || garsoniere.isEmpty()) {
            //Toast.makeText(this, "Nu s-au primit garsoniere!", Toast.LENGTH_LONG).show();
            return;
        }
        */
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