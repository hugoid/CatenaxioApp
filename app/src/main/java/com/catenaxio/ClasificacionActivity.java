package com.catenaxio;
import android.app.Activity;


import android.os.SystemClock;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import java.io.InputStream;
import java.net.URL;
import android.os.AsyncTask;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.Toast;

import com.catenaxio.R;
import android.widget.Button;

public class ClasificacionActivity extends Activity implements View.OnClickListener{
    private ImageView imagen;
    private Bitmap bitmap;
    private ProgressDialog pDialog;
    private LoadImage hiloDescarga;

    private Button clasificacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clasificacion);

        imagen=(ImageView)findViewById(R.id.imagenClasificacion);

        clasificacion=(Button)findViewById(R.id.botonDescargaClasificacion);
        clasificacion.setOnClickListener(this);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.clasificacion, menu);
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
        if(view==clasificacion){
            hiloDescarga=new LoadImage();
            hiloDescarga.execute("http://hidandroid.hol.es/catenaxio/clasificacion.png");
        }
    }

    private class LoadImage extends AsyncTask<String, String, Bitmap> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(ClasificacionActivity.this);
            pDialog.setMessage("Cargando la clasificacion, descargando todos los virus de la pagina femafusa");
            pDialog.show();
        }
        protected Bitmap doInBackground(String... args) {
            for(int i=0;i<3;i++){
                SystemClock.sleep(1000);
            }

            try {
                bitmap = BitmapFactory.decodeStream((InputStream)new URL(args[0]).getContent());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return bitmap;
        }
        protected void onPostExecute(Bitmap image) {
            if(image != null){
                imagen.setImageBitmap(image);
                pDialog.dismiss();
            }else{
                pDialog.dismiss();
                Toast.makeText(ClasificacionActivity.this, "Te quedaste si graduacion y ahora te quedas sin clasificacion", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
