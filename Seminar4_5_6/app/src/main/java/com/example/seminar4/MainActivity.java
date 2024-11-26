package com.example.seminar4;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Garsoniera> garsoniere = null;
    private int idModificat=0;
    private Shape adapter = null; //adapter garsoniera

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        garsoniere = new ArrayList<>();

        Button btn = findViewById(R.id.buttonAdaugareGarsoniera);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), AdaugareGarsoniera.class);
                startActivityForResult(it, 402);
            }
        });




        Button btnVizualizare = findViewById(R.id.buttonVizualizareGarsoniere);
        btnVizualizare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(garsoniere.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Nu exista garsoniere de afisat!",Toast.LENGTH_SHORT).show();
                }
                Intent it = new Intent(getApplicationContext(),VizualizareGarsoniere.class);
                // Trimite lista de garsoniere prin intent
                it.putParcelableArrayListExtra("garsoniere",(ArrayList<? extends Parcelable>) garsoniere);
                startActivity(it);

            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 402) {
            if (resultCode == RESULT_OK) {
                Garsoniera garsoniera = data.getParcelableExtra("garsoniera");

                garsoniere.add(garsoniera);

                Toast.makeText(getApplicationContext(), garsoniera.toString(), Toast.LENGTH_LONG).show();


            }
        }
    }

}