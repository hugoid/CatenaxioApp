package com.catenaxio;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
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
    public static final String PREFS_NAME = "Preferencias";
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

        SharedPreferences sharedPref = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);


        String inicio=sharedPref.getString("inicioAplicacion", "0");

        Log.d("mostrar","el valor: "+inicio);

        if(inicio.equalsIgnoreCase("0")){ //primera vez que se carga la aplicacion
            //set de alamar
            Log.d("mostrar","primera vez aplicacion");
            alarmMgr = (AlarmManager)getApplicationContext().getSystemService(Context.ALARM_SERVICE);
            Intent intent = new Intent(getApplicationContext(), Receiver.class);
            alarmIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, intent, 0);
            // Set the alarm to start at 8:30 a.m.
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.MONTH,8);
            calendar.set(Calendar.DAY_OF_MONTH,26);
            calendar.set(Calendar.HOUR_OF_DAY, 23);
            calendar.set(Calendar.MINUTE, 20);
            calendar.set(Calendar.SECOND, 00);
            calendar.set(Calendar.AM_PM, Calendar.PM);

            AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
            am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), alarmIntent);

/*
            //jordanda 2
            calendar.set(Calendar.MONTH,8);
            calendar.set(Calendar.DAY_OF_MONTH,18);
            calendar.set(Calendar.HOUR_OF_DAY, 16);
            calendar.set(Calendar.MINUTE, 49);
            calendar.set(Calendar.SECOND, 00);
            calendar.set(Calendar.AM_PM, Calendar.PM);

            alarmIntent = PendingIntent.getBroadcast(getApplicationContext(), 1, intent, 0);
            am = (AlarmManager) getSystemService(ALARM_SERVICE);
            am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), alarmIntent);

            //jordanda 3
            calendar.set(Calendar.MONTH,8);
            calendar.set(Calendar.DAY_OF_MONTH,18);
            calendar.set(Calendar.HOUR_OF_DAY, 16);
            calendar.set(Calendar.MINUTE, 50);
            calendar.set(Calendar.SECOND, 00);
            calendar.set(Calendar.AM_PM, Calendar.PM);

            alarmIntent = PendingIntent.getBroadcast(getApplicationContext(), 2, intent, 0);
            am = (AlarmManager) getSystemService(ALARM_SERVICE);
            am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), alarmIntent);

            //jordanda 4
            calendar.set(Calendar.MONTH,8);
            calendar.set(Calendar.DAY_OF_MONTH,18);
            calendar.set(Calendar.HOUR_OF_DAY, 16);
            calendar.set(Calendar.MINUTE, 51);
            calendar.set(Calendar.SECOND, 00);
            calendar.set(Calendar.AM_PM, Calendar.PM);

            alarmIntent = PendingIntent.getBroadcast(getApplicationContext(), 3, intent, 0);
            am = (AlarmManager) getSystemService(ALARM_SERVICE);
            am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), alarmIntent);

            //jordanda 5
            calendar.set(Calendar.MONTH,8);
            calendar.set(Calendar.DAY_OF_MONTH,18);
            calendar.set(Calendar.HOUR_OF_DAY, 16);
            calendar.set(Calendar.MINUTE, 51);
            calendar.set(Calendar.SECOND, 00);
            calendar.set(Calendar.AM_PM, Calendar.PM);

            alarmIntent = PendingIntent.getBroadcast(getApplicationContext(), 4, intent, 0);
            am = (AlarmManager) getSystemService(ALARM_SERVICE);
            am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), alarmIntent);

            //jordanda 6
            calendar.set(Calendar.MONTH,8);
            calendar.set(Calendar.DAY_OF_MONTH,18);
            calendar.set(Calendar.HOUR_OF_DAY, 16);
            calendar.set(Calendar.MINUTE, 51);
            calendar.set(Calendar.SECOND, 00);
            calendar.set(Calendar.AM_PM, Calendar.PM);

            alarmIntent = PendingIntent.getBroadcast(getApplicationContext(), 5, intent, 0);
            am = (AlarmManager) getSystemService(ALARM_SERVICE);
            am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), alarmIntent);

            //jordanda 7
            calendar.set(Calendar.MONTH,8);
            calendar.set(Calendar.DAY_OF_MONTH,18);
            calendar.set(Calendar.HOUR_OF_DAY, 16);
            calendar.set(Calendar.MINUTE, 51);
            calendar.set(Calendar.SECOND, 00);
            calendar.set(Calendar.AM_PM, Calendar.PM);

            alarmIntent = PendingIntent.getBroadcast(getApplicationContext(), 6, intent, 0);
            am = (AlarmManager) getSystemService(ALARM_SERVICE);
            am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), alarmIntent);

            //jordanda 8
            calendar.set(Calendar.MONTH,8);
            calendar.set(Calendar.DAY_OF_MONTH,18);
            calendar.set(Calendar.HOUR_OF_DAY, 16);
            calendar.set(Calendar.MINUTE, 51);
            calendar.set(Calendar.SECOND, 00);
            calendar.set(Calendar.AM_PM, Calendar.PM);

            alarmIntent = PendingIntent.getBroadcast(getApplicationContext(), 7, intent, 0);
            am = (AlarmManager) getSystemService(ALARM_SERVICE);
            am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), alarmIntent);

            //jordanda 9
            calendar.set(Calendar.MONTH,8);
            calendar.set(Calendar.DAY_OF_MONTH,18);
            calendar.set(Calendar.HOUR_OF_DAY, 16);
            calendar.set(Calendar.MINUTE, 51);
            calendar.set(Calendar.SECOND, 00);
            calendar.set(Calendar.AM_PM, Calendar.PM);

            alarmIntent = PendingIntent.getBroadcast(getApplicationContext(), 8, intent, 0);
            am = (AlarmManager) getSystemService(ALARM_SERVICE);
            am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), alarmIntent);

            //jordanda 10
            calendar.set(Calendar.MONTH,8);
            calendar.set(Calendar.DAY_OF_MONTH,18);
            calendar.set(Calendar.HOUR_OF_DAY, 16);
            calendar.set(Calendar.MINUTE, 51);
            calendar.set(Calendar.SECOND, 00);
            calendar.set(Calendar.AM_PM, Calendar.PM);

            alarmIntent = PendingIntent.getBroadcast(getApplicationContext(), 9, intent, 0);
            am = (AlarmManager) getSystemService(ALARM_SERVICE);
            am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), alarmIntent);

            //jordanda 11
            calendar.set(Calendar.MONTH,8);
            calendar.set(Calendar.DAY_OF_MONTH,18);
            calendar.set(Calendar.HOUR_OF_DAY, 16);
            calendar.set(Calendar.MINUTE, 51);
            calendar.set(Calendar.SECOND, 00);
            calendar.set(Calendar.AM_PM, Calendar.PM);

            alarmIntent = PendingIntent.getBroadcast(getApplicationContext(), 10, intent, 0);
            am = (AlarmManager) getSystemService(ALARM_SERVICE);
            am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), alarmIntent);

            //jordanda 12
            calendar.set(Calendar.MONTH,8);
            calendar.set(Calendar.DAY_OF_MONTH,18);
            calendar.set(Calendar.HOUR_OF_DAY, 16);
            calendar.set(Calendar.MINUTE, 51);
            calendar.set(Calendar.SECOND, 00);
            calendar.set(Calendar.AM_PM, Calendar.PM);

            alarmIntent = PendingIntent.getBroadcast(getApplicationContext(), 11, intent, 0);
            am = (AlarmManager) getSystemService(ALARM_SERVICE);
            am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), alarmIntent);

            //jordanda 13
            calendar.set(Calendar.MONTH,8);
            calendar.set(Calendar.DAY_OF_MONTH,18);
            calendar.set(Calendar.HOUR_OF_DAY, 16);
            calendar.set(Calendar.MINUTE, 51);
            calendar.set(Calendar.SECOND, 00);
            calendar.set(Calendar.AM_PM, Calendar.PM);

            alarmIntent = PendingIntent.getBroadcast(getApplicationContext(), 12, intent, 0);
            am = (AlarmManager) getSystemService(ALARM_SERVICE);
            am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), alarmIntent);

            //jordanda 14
            calendar.set(Calendar.MONTH,8);
            calendar.set(Calendar.DAY_OF_MONTH,18);
            calendar.set(Calendar.HOUR_OF_DAY, 16);
            calendar.set(Calendar.MINUTE, 51);
            calendar.set(Calendar.SECOND, 00);
            calendar.set(Calendar.AM_PM, Calendar.PM);

            alarmIntent = PendingIntent.getBroadcast(getApplicationContext(), 13, intent, 0);
            am = (AlarmManager) getSystemService(ALARM_SERVICE);
            am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), alarmIntent);

            //jordanda 15
            calendar.set(Calendar.MONTH,8);
            calendar.set(Calendar.DAY_OF_MONTH,18);
            calendar.set(Calendar.HOUR_OF_DAY, 16);
            calendar.set(Calendar.MINUTE, 51);
            calendar.set(Calendar.SECOND, 00);
            calendar.set(Calendar.AM_PM, Calendar.PM);

            alarmIntent = PendingIntent.getBroadcast(getApplicationContext(), 14, intent, 0);
            am = (AlarmManager) getSystemService(ALARM_SERVICE);
            am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), alarmIntent);

            //jordanda 16
            calendar.set(Calendar.MONTH,8);
            calendar.set(Calendar.DAY_OF_MONTH,18);
            calendar.set(Calendar.HOUR_OF_DAY, 16);
            calendar.set(Calendar.MINUTE, 51);
            calendar.set(Calendar.SECOND, 00);
            calendar.set(Calendar.AM_PM, Calendar.PM);

            alarmIntent = PendingIntent.getBroadcast(getApplicationContext(), 15, intent, 0);
            am = (AlarmManager) getSystemService(ALARM_SERVICE);
            am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), alarmIntent);

            //jordanda 17
            calendar.set(Calendar.MONTH,8);
            calendar.set(Calendar.DAY_OF_MONTH,18);
            calendar.set(Calendar.HOUR_OF_DAY, 16);
            calendar.set(Calendar.MINUTE, 51);
            calendar.set(Calendar.SECOND, 00);
            calendar.set(Calendar.AM_PM, Calendar.PM);

            alarmIntent = PendingIntent.getBroadcast(getApplicationContext(), 16, intent, 0);
            am = (AlarmManager) getSystemService(ALARM_SERVICE);
            am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), alarmIntent);

            //jordanda 18
            calendar.set(Calendar.MONTH,8);
            calendar.set(Calendar.DAY_OF_MONTH,18);
            calendar.set(Calendar.HOUR_OF_DAY, 16);
            calendar.set(Calendar.MINUTE, 51);
            calendar.set(Calendar.SECOND, 00);
            calendar.set(Calendar.AM_PM, Calendar.PM);

            alarmIntent = PendingIntent.getBroadcast(getApplicationContext(), 17, intent, 0);
            am = (AlarmManager) getSystemService(ALARM_SERVICE);
            am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), alarmIntent);

            //jordanda 19
            calendar.set(Calendar.MONTH,8);
            calendar.set(Calendar.DAY_OF_MONTH,18);
            calendar.set(Calendar.HOUR_OF_DAY, 16);
            calendar.set(Calendar.MINUTE, 51);
            calendar.set(Calendar.SECOND, 00);
            calendar.set(Calendar.AM_PM, Calendar.PM);

            alarmIntent = PendingIntent.getBroadcast(getApplicationContext(), 18, intent, 0);
            am = (AlarmManager) getSystemService(ALARM_SERVICE);
            am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), alarmIntent);

            //jordanda 20
            calendar.set(Calendar.MONTH,8);
            calendar.set(Calendar.DAY_OF_MONTH,18);
            calendar.set(Calendar.HOUR_OF_DAY, 16);
            calendar.set(Calendar.MINUTE, 51);
            calendar.set(Calendar.SECOND, 00);
            calendar.set(Calendar.AM_PM, Calendar.PM);

            alarmIntent = PendingIntent.getBroadcast(getApplicationContext(), 19, intent, 0);
            am = (AlarmManager) getSystemService(ALARM_SERVICE);
            am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), alarmIntent);

            //jordanda 21
            calendar.set(Calendar.MONTH,8);
            calendar.set(Calendar.DAY_OF_MONTH,18);
            calendar.set(Calendar.HOUR_OF_DAY, 16);
            calendar.set(Calendar.MINUTE, 51);
            calendar.set(Calendar.SECOND, 00);
            calendar.set(Calendar.AM_PM, Calendar.PM);

            alarmIntent = PendingIntent.getBroadcast(getApplicationContext(), 20, intent, 0);
            am = (AlarmManager) getSystemService(ALARM_SERVICE);
            am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), alarmIntent);

            //jordanda 22
            calendar.set(Calendar.MONTH,8);
            calendar.set(Calendar.DAY_OF_MONTH,18);
            calendar.set(Calendar.HOUR_OF_DAY, 16);
            calendar.set(Calendar.MINUTE, 51);
            calendar.set(Calendar.SECOND, 00);
            calendar.set(Calendar.AM_PM, Calendar.PM);

            alarmIntent = PendingIntent.getBroadcast(getApplicationContext(), 21, intent, 0);
            am = (AlarmManager) getSystemService(ALARM_SERVICE);
            am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), alarmIntent);*/


            //SharedPreferences.Editor editor = sharedPref.edit();
//                editor.putInt("inicioAplicacion", 1);

            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("inicioAplicacion", "1");
            editor.commit();
        }
        else{

        }




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
