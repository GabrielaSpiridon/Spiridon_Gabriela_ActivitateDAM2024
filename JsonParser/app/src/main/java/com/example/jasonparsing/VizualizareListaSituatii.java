package com.example.jasonparsing;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class VizualizareListaSituatii extends AppCompatActivity {

    private List<SituatiiDiscipline> situatiiList=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_vizualizare_lista_situatii);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        situatiiList = new ArrayList<>();

        Button btn=findViewById(R.id.buttonExtragereSituatiiDiscipline);
        btn.setOnClickListener((View view) ->{
            Executor executor= Executors.newSingleThreadExecutor();
            Handler handler = new Handler(Looper.getMainLooper());

            executor.execute(new Runnable() {
                @Override
                public void run() {
                    HttpURLConnection connection=null;
                    try{
                       URL url = new URL("https://pdm.ase.ro/situatii.json");
                       connection = (HttpURLConnection) url.openConnection();

                        InputStream is=connection.getInputStream();
                        InputStreamReader inputStreamReader=new InputStreamReader(is);
                        BufferedReader buffer = new BufferedReader(inputStreamReader);
                        StringBuilder sb=new StringBuilder();

                        String line = null;
                        while((line=buffer.readLine())!=null)
                        {
                            sb.append(line);
                        }

                        JSONObject jsonObject=new JSONObject(sb.toString());
                        JSONArray situatiiArray = jsonObject.getJSONArray("situatii");

                          for(int i=0;i<situatiiArray.length();i++)
                          {
                              JSONObject situatie = situatiiArray.getJSONObject(i);
                              String disciplina = situatie.getString("disciplina");
                              String activitate = situatie.getString("activitate");
                              int valoare = situatie.getInt("valoare");
                              double pondere = situatie.getDouble("pondere");
                              String data = situatie.getString("data");
                              String descriere = situatie.getString("descriere");

                              situatiiList.add(new SituatiiDiscipline(disciplina,activitate,valoare,pondere,data,descriere));
                          }

                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }  catch (JSONException e) {
                        throw new RuntimeException(e);
                    }

                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            ListView lv=findViewById(R.id.situatiiLV);
                            ArrayAdapter<SituatiiDiscipline> adapter = new ArrayAdapter<>(getApplication(), android.R.layout.simple_list_item_1,situatiiList);
                            lv.setAdapter(adapter);
                        }
                    });
                }
            });
        });
    }
}