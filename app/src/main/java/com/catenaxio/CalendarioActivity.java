package com.catenaxio;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.catenaxio.R;

import java.util.Vector;

public class CalendarioActivity extends Activity {

    private Vector<String> lista_jornada;
    private Vector<String> lista_fecha;
    private Vector<String> lista_hora;
    private Vector<String> lista_rival;
    private Vector<String> lista_lugar;
    private Vector<Integer> lista_estadios;

    private ListView miLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario);

        //creo los vectores
        lista_jornada=new Vector<String>();
        lista_fecha=new Vector<String>();
        lista_hora=new Vector<String>();
        lista_rival=new Vector<String>();
        lista_lugar=new Vector<String>();
        lista_estadios=new Vector<Integer>();

        lista_jornada.add("1");
        lista_jornada.add("2");
        lista_jornada.add("3");

        lista_fecha.add("10/10/2014");
        lista_fecha.add("20/12/2014");
        lista_fecha.add("20/1/2015 ");

        lista_hora.add("18:00");
        lista_hora.add("9:00 ");
        lista_hora.add("14;00");

        lista_rival.add("Getafe United");
        lista_rival.add("Las eras     ");
        lista_rival.add("AJ trasgu    ");

        lista_estadios.add(0);
        lista_estadios.add(1);
        lista_estadios.add(2);

        lista_lugar.add("giner     ");
        lista_lugar.add("perales   ");
        lista_lugar.add("sector III");

        miLista=(ListView)findViewById(R.id.listView);
        miLista.setAdapter(new MiAdaptador(this,lista_jornada,lista_fecha,lista_hora,lista_rival,lista_estadios,lista_lugar));



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.calendario, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
