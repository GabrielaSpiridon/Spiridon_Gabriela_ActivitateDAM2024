package com.example.seminar4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AdaugareGarsoniera extends AppCompatActivity {

    private EditText editTextOras;
    private EditText editTextStrada;
    private EditText editTextNrEtaj;
    private EditText editTextNrApartament;
    private Switch switchEsteOcupata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adaugare_garsoniera);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btn = findViewById(R.id.buttonAdaugare);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText etOras = findViewById(R.id.editTextOras);
                String oras = etOras.getText().toString();

                EditText etStrada = findViewById(R.id.editTextStrada);
                String strada = etStrada.getText().toString();

                EditText edNrEtaj = findViewById(R.id.editTextEtaj);
                int nrEtaj = Integer.parseInt(edNrEtaj.getText().toString());

                EditText edrApartament = findViewById(R.id.editTextNrApartament);
                int nrApartament = Integer.parseInt(edrApartament.getText().toString());

                Switch swOcupare = findViewById(R.id.switchEsteOcupat);
                boolean esteOcupata = Boolean.parseBoolean(swOcupare.getText().toString());


                Garsoniera garsoniera = new Garsoniera(oras, strada, nrEtaj, nrApartament, esteOcupata);

                Intent it = new Intent();
                it.putExtra("garsoniera", garsoniera);
                setResult(RESULT_OK, it);
                sendBroadcast(it);
                finish();


            }
        });
    }
}