package com.dariojolo.cursoudemyii_listviews;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lista;
    private List<String> nombres;
    private int contador = 0;
    private MyAdapter myAdapter;

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
        nombres.add("Dario");
        nombres.add("Alejandra");
        nombres.add("Pedro");
        nombres.add("Carlos");
        nombres.add("Dario");
        nombres.add("Alejandra");
        nombres.add("Pedro");
        nombres.add("Carlos");
        nombres.add("Dario");
        nombres.add("Alejandra");
        nombres.add("Pedro");
        nombres.add("Carlos");
        nombres.add("Dario");
        nombres.add("Alejandra");
        nombres.add("Pedro");
        nombres.add("Carlos");

        //Adaptador - La forma en que se vera el listado
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, nombres);

        //Enlazamos el adaptador con nuestra lista
        //lista.setAdapter(adapter);


        //Enlazamos con nuestro adaptador personalizado
        myAdapter = new MyAdapter(this,R.layout.list_item,nombres);
        lista.setAdapter(myAdapter);

        registerForContextMenu(lista);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"Clicked: " + nombres.get(position),Toast.LENGTH_LONG).show();
            }
        });
    }

    //Inflamos el layout del menu de opciones
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar_menu, menu);
        return true;
    }

    //Manejamos eventos en el menu de opciones
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.add_item:
                //Añadimos nuevo nombre
                this.nombres.add("Agregado nº: " + (++contador ));
                //Notificamos al adaptador del cambio
                this.myAdapter.notifyDataSetChanged();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //Inflamos layout del context menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater = getMenuInflater();
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        menu.setHeaderTitle(nombres.get(info.position));

        inflater.inflate(R.menu.context_menu, menu);

    }
    //Manejamos eventos del context menu
    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();

        switch(item.getItemId()){
            case R.id.delete_item:
                //Eliminamos el nombre seleccionado
                this.nombres.remove(info.position);
                //Notificamos al adaptador del cambio
                this.myAdapter.notifyDataSetChanged();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}

