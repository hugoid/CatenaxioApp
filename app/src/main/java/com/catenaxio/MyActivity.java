package com.catenaxio;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.app.PendingIntent;
import android.app.AlarmManager;
import android.content.Context;

import java.util.Calendar;


public class MyActivity extends Activity implements View.OnClickListener{

    private AlarmManager alarmMgr;
    private PendingIntent alarmIntent;
    Button botonCalendario,botonConvocatoria,botonEstadistica,botonX;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        Log.d("mostrar","jj");

        botonCalendario=(Button)findViewById(R.id.botonCalendario);
        botonConvocatoria=(Button)findViewById(R.id.BotonConvocatoria);
        botonEstadistica=(Button)findViewById(R.id.botonEstadisticas);
        botonX=(Button)findViewById(R.id.botonX);
        botonCalendario.setOnClickListener(this);
        botonConvocatoria.setOnClickListener(this);
        botonEstadistica.setOnClickListener(this);
        botonX.setOnClickListener(this);


        //set de alamar
        alarmMgr = (AlarmManager)getApplicationContext().getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(getApplicationContext(), Receiver.class);
        alarmIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, intent, 0);

// Set the alarm to start at 8:30 a.m.
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH,8);
        calendar.set(Calendar.DAY_OF_MONTH,15);
        calendar.set(Calendar.HOUR_OF_DAY, 17);
        calendar.set(Calendar.MINUTE, 50);
        calendar.set(Calendar.SECOND, 00);
        calendar.set(Calendar.AM_PM, Calendar.PM);

        AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
        am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), alarmIntent);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
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

    @Override
    public void onClick(View view) {
        if(view==botonCalendario){


            Intent lanzarActividad=new Intent(this,CalendarioActivity.class);
            startActivity(lanzarActividad);
        }
        else if(view==botonConvocatoria){
            Intent lanzarActividad=new Intent(this,ConvocatoriaActivity.class);
            startActivity(lanzarActividad);
        }
        else if(view==botonEstadistica){
            Intent lanzarActividad=new Intent(this,EstadisticasActivity.class);
            startActivity(lanzarActividad);
        }
        else if(view==botonX){
            // Intent lanzarActividad=new Intent(this,ClasificacionActivity.class);
            // startActivity(lanzarActividad);
            Intent lanzarActividad=new Intent(this,TablLiga.class);
            startActivity(lanzarActividad);

        }
    }
}
