package com.catenaxio;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Button;
import android.widget.Toast;

import com.catenaxio.R;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Vector;

public class EstadisticasActivity extends Activity implements View.OnClickListener{
    private Vector<String> lista_partidos;
    private Vector<String> lista_titulares;
    private Vector<String> lista_goles;
    private Vector<String> lista_asistencias;
    private Vector<String> lista_partidosGanados;

    private ListView miLista;
    private Button botonActualizar;

    private DownloadFilesTask hiloDescarga;
    private String[] nombres={"Abel","Anton","Cano","Hugo","Javi","Jordan","Juanito","Meri","Fer"};
    public MiAdaptadorEstadistica adapter;
    public static final String PREFS_NAME = "Preferencias";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas);

        //
        for(int i=0;i<9;i++){
            Log.d("nombres","nombres:"+nombres[i]);
        }

        SharedPreferences sharedPref = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        lista_partidos=new Vector<String>();
        lista_titulares=new Vector<String>();
        lista_goles=new Vector<String>();
        lista_asistencias=new Vector<String>();
        lista_partidosGanados=new Vector<String>();
        for(int i=0;i<=8;i++){
            lista_partidos.add(sharedPref.getString(nombres[i]+"partidos", "0"));
            lista_titulares.add(sharedPref.getString(nombres[i]+"titulares", "0"));
            lista_goles.add(sharedPref.getString(nombres[i]+"goles", "0"));
            lista_asistencias.add(sharedPref.getString(nombres[i]+"asistencias", "0"));
            lista_partidosGanados.add(sharedPref.getString(nombres[i]+"partidosGanados", "0"));

        }

        /*
        lista_partidos.add("10");
        lista_partidos.add("10");
        lista_partidos.add("10");
        lista_partidos.add("10");
        lista_partidos.add("10");
        lista_partidos.add("10");
        lista_partidos.add("10");
        lista_partidos.add("10");
        lista_partidos.add("10");


        lista_titulares.add("10");
        lista_titulares.add("10");
        lista_titulares.add("10");
        lista_titulares.add("10");
        lista_titulares.add("10");
        lista_titulares.add("10");
        lista_titulares.add("10");
        lista_titulares.add("10");
        lista_titulares.add("10");


        lista_goles.add("10");
        lista_goles.add("10");
        lista_goles.add("10");
        lista_goles.add("10");
        lista_goles.add("10");
        lista_goles.add("10");
        lista_goles.add("10");
        lista_goles.add("10");
        lista_goles.add("10");


        lista_asistencias.add("10");
        lista_asistencias.add("10");
        lista_asistencias.add("10");
        lista_asistencias.add("10");
        lista_asistencias.add("10");
        lista_asistencias.add("10");
        lista_asistencias.add("10");
        lista_asistencias.add("10");
        lista_asistencias.add("10");
*/
        miLista=(ListView)findViewById(R.id.listView);
        adapter=new MiAdaptadorEstadistica(this,lista_partidos,lista_titulares,lista_goles,lista_asistencias,lista_partidosGanados);
        miLista.setAdapter(adapter);

        botonActualizar=(Button)findViewById(R.id.botonActualizar);
        botonActualizar.setOnClickListener(this);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.estadisticas, menu);
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
        hiloDescarga=new DownloadFilesTask();
        hiloDescarga.execute("http://hidandroid.hol.es/catenaxio/obtener_estadisticas.php");
    }


    //clase asyntask de recibir
    class DownloadFilesTask extends AsyncTask<String,Integer,Integer> {

        private ProgressDialog progreso;
        @Override
        protected void onPreExecute(){
            Log.d("background", "inicio ");

            progreso=new ProgressDialog(EstadisticasActivity.this);
            progreso.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progreso.setMessage("Contactando con la federacion");
            progreso.setCancelable(false);
            progreso.show();


        }




        @Override
        protected Integer doInBackground(String... urls) {
            String urlString=urls[0];

            Log.d("background","mi url: "+urlString);
            for(int i=0;i<2;i++){
                Log.d("background","cuenta:"+i);
                SystemClock.sleep(1000);
            }


            InputStream is = null;
            String result = "";
            JSONObject json = null;
            try{
                HttpClient httpclient = new DefaultHttpClient();
                HttpGet httppost = new HttpGet(urlString);
                //aadir url al post si quiero enviar la fecha
                //HttpPost httppost = new HttpPost(serverUrl);
                //List<NameValuePair> params = new ArrayList<NameValuePair>();
                //  params.add(new BasicNameValuePair("iddevice", regId));
                //httppost.setEntity(new UrlEncodedFormEntity(params));
                HttpResponse response = httpclient.execute(httppost);
                HttpEntity entity = response.getEntity();
                is = entity.getContent();

            }
            catch(Exception e){
                Log.d("background","error "+e);
                return 1;
            }


            try{
                BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
                StringBuilder sb = new StringBuilder();
                String line = null;
                while ((line = reader.readLine()) != null) {
                    sb.append(line + "\n");
                }
                is.close();
                result=sb.toString();
            } catch(Exception e){ return 1;}

            try{
                json = new JSONObject(result);
            }catch(JSONException e){return 1;}

            try {
                Log.d("background","resultado: "+json.getJSONArray("datos"));


                if(lista_partidos.capacity()!=0){
                    lista_partidos.removeAllElements();
                }
                if(lista_titulares.capacity()!=0){
                    lista_titulares.removeAllElements();
                }
                if(lista_goles.capacity()!=0){
                    lista_goles.removeAllElements();
                }
                if(lista_asistencias.capacity()!=0){
                    lista_asistencias.removeAllElements();
                }
                if(lista_partidosGanados.capacity()!=0){
                    lista_partidosGanados.removeAllElements();
                }
                for(int i=0;i<=8;i++){

                    String nombre=json.getJSONArray("datos").getJSONObject(i).getString("jugador");
                    String partidos=json.getJSONArray("datos").getJSONObject(i).getString("partidos");
                    String titulares=json.getJSONArray("datos").getJSONObject(i).getString("titulares");
                    String goles=json.getJSONArray("datos").getJSONObject(i).getString("goles");
                    String asistencias=json.getJSONArray("datos").getJSONObject(i).getString("asistencias");
                    String partidos_ganados=json.getJSONArray("datos").getJSONObject(i).getString("partidosGanados");

                    //lista_bajas_actualizado.add(Integer.parseInt(resultado));
                    Log.d("background","Filtrando nombre "+nombre+" partidos_jugados: "+partidos+" titulares:"+titulares+" goles:"+goles+" asistencias:"+asistencias +" pg:" + partidos_ganados);
                    lista_partidos.add(partidos);
                    lista_titulares.add(titulares);
                    lista_goles.add(goles);
                    lista_asistencias.add(asistencias);
                    lista_partidosGanados.add(partidos_ganados);
                   /* SharedPreferences settings = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putInt(nombre, Integer.parseInt(resultado));
                    editor.commit();*/
                }

                for(String x : lista_partidosGanados) {
                    Log.d("mostrar", "partidos ganados:" +x);
                }

                 SharedPreferences settings = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
                 SharedPreferences.Editor editor = settings.edit();
                for(int i=0;i<=8;i++){
                    editor.putString(nombres[i]+"partidos", lista_partidos.get(i));
                    editor.putString(nombres[i]+"titulares", lista_titulares.get(i));
                    editor.putString(nombres[i]+"goles", lista_goles.get(i));
                    editor.putString(nombres[i]+"asistencias", lista_asistencias.get(i));
                    editor.putString(nombres[i]+"partidosGanados", lista_partidosGanados.get(i));
                    editor.commit();
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }


            return 0;
        }

        @Override
        protected void onProgressUpdate(Integer... progress) {
            //setProgressPercent(progress[0]);
        }

        @Override
        protected void onPostExecute(Integer result) {
            Log.d("backgorund","terminado");
            if(result==0){
                progreso.dismiss();
                adapter.notifyDataSetChanged();
            }
            else{
                progreso.dismiss();
                Toast.makeText(getApplicationContext(), "Esta la federacion como para atenderte", Toast.LENGTH_LONG).show();
            }

        }
    }
}
