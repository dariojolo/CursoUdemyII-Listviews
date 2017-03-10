package com.dariojolo.cursoudemyii_listviews;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lista;
    private List<String> nombres;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista = (ListView)findViewById(R.id.lista);

        //Datos a mostrar
        nombres = new ArrayList<String>();
        nombres.add("Dario");
        nombres.add("Alejandra");
        nombres.add("Pedro");
        nombres.add("Carlos");

        //Adaptador - La forma en que se vera el listado
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, nombres);

        //Enlazamos el adaptador con nuestra lista
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"Clicked: " + nombres.get(position),Toast.LENGTH_LONG).show();
            }
        });
    }
}
