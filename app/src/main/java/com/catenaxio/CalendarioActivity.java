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
        lista_jornada.add("4");
        lista_jornada.add("5");
        lista_jornada.add("6");
        lista_jornada.add("7");
        lista_jornada.add("8");
        lista_jornada.add("9");
        lista_jornada.add("10");
        lista_jornada.add("11");
        lista_jornada.add("12");
        lista_jornada.add("13");
        lista_jornada.add("14");
        lista_jornada.add("15");
        lista_jornada.add("16");
        lista_jornada.add("17");
        lista_jornada.add("18");
        lista_jornada.add("19");
        lista_jornada.add("20");
        lista_jornada.add("21");
        lista_jornada.add("22");

        lista_fecha.add("05/10/2014");
        lista_fecha.add("18/10/2014");
        lista_fecha.add("26/10/2014");
        lista_fecha.add("08/11/2014");
        lista_fecha.add("15/11/2014");
        lista_fecha.add("23/11/2014");
        lista_fecha.add("29/11/2014");
        lista_fecha.add("14/12/2014");
        lista_fecha.add("20/12/2014");
        lista_fecha.add("11/01/2015");
        lista_fecha.add("17/01/2015");
        lista_fecha.add("25/01/2015");
        lista_fecha.add("31/01/2015");
        lista_fecha.add("08/02/2015");
        lista_fecha.add("14/02/2015");
        lista_fecha.add("21/02/2015");
        lista_fecha.add("01/03/2015");
        lista_fecha.add("07/03/2015");
        lista_fecha.add("15/03/2015");
        lista_fecha.add("21/03/2015");
        lista_fecha.add("12/04/2015");
        lista_fecha.add("18/04/2015");

        lista_hora.add("17:00");
        lista_hora.add("17:30");
        lista_hora.add("10:00");
        lista_hora.add("18:00");
        lista_hora.add("15:00");
        lista_hora.add("13:00");
        lista_hora.add("18:00");
        lista_hora.add("12:00");
        lista_hora.add("15:00");
        lista_hora.add("10:00");
        lista_hora.add("18:00");
        lista_hora.add("14:00");
        lista_hora.add("17:30");
        lista_hora.add("10:00");
        lista_hora.add("18:00");
        lista_hora.add("15:00");
        lista_hora.add("13:00");
        lista_hora.add("18:00");
        lista_hora.add("12:00");
        lista_hora.add("15:00");
        lista_hora.add("10:00");
        lista_hora.add("18:00");



        lista_rival.add("DEMACIO FC           ");
        lista_rival.add("DEL TIRON            ");
        lista_rival.add("REAL BARRIL          ");
        lista_rival.add("AD MERCOMA A         ");
        lista_rival.add("LA NARANJA MECANICA B");
        lista_rival.add("GALATASARAY FS       ");
        lista_rival.add("LOS BUCANEROS        ");
        lista_rival.add("ASTON BIRRA          ");
        lista_rival.add("SPORTOMARLA          ");
        lista_rival.add("KR FUTSAL            ");
        lista_rival.add("CHUMAXOS             ");
        lista_rival.add("DEMACIA FX           ");
        lista_rival.add("DEL TIRON            ");
        lista_rival.add("REAL BARRIL          ");
        lista_rival.add("AD MERCOMA A         ");
        lista_rival.add("LA NARANJA MECANICA B");
        lista_rival.add("GALATASARAY FS       ");
        lista_rival.add("LOS BUCANEROS        ");
        lista_rival.add("ASTON BIRRA          ");
        lista_rival.add("SPORTOMARLA          ");
        lista_rival.add("KR FUTSAL            ");
        lista_rival.add("CHUMAXOS             ");





        lista_estadios.add(1);
        lista_estadios.add(0);
        lista_estadios.add(1);
        lista_estadios.add(0);
        lista_estadios.add(1);
        lista_estadios.add(0);
        lista_estadios.add(1);
        lista_estadios.add(0);
        lista_estadios.add(1);
        lista_estadios.add(0);
        lista_estadios.add(1);
        lista_estadios.add(0);
        lista_estadios.add(1);
        lista_estadios.add(0);
        lista_estadios.add(1);
        lista_estadios.add(0);
        lista_estadios.add(1);
        lista_estadios.add(0);
        lista_estadios.add(1);
        lista_estadios.add(0);
        lista_estadios.add(1);
        lista_estadios.add(0);

        lista_lugar.add("PERALES          ");
        lista_lugar.add("GINER            ");
        lista_lugar.add("JUAN DE LA CIERVA");
        lista_lugar.add("BERCIAL          ");
        lista_lugar.add("PERALES          ");
        lista_lugar.add("GINER            ");
        lista_lugar.add("SECTOR III       ");
        lista_lugar.add("BERCIAL          ");
        lista_lugar.add("JUAN DE LA CIERVA");
        lista_lugar.add("SECTOR III       ");
        lista_lugar.add("M4               ");
        lista_lugar.add("PERALES          ");
        lista_lugar.add("GINER            ");
        lista_lugar.add("JUAN DE LA CIERVA");
        lista_lugar.add("BERCIAL          ");
        lista_lugar.add("PERALES          ");
        lista_lugar.add("GINER            ");
        lista_lugar.add("SECTOR III       ");
        lista_lugar.add("BERCIAL          ");
        lista_lugar.add("JUAN DE LA CIERVA");
        lista_lugar.add("SECTOR III       ");
        lista_lugar.add("M4               ");



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
