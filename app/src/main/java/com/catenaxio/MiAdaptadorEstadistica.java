package com.catenaxio;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Vector;

/**
 * Created by hugointegrasys on 9/3/14.
 */
public class MiAdaptadorEstadistica extends BaseAdapter {
    private final Activity actividad;


    private Vector<String> lista_partidos;
    private Vector<String> lista_titulares;
    private Vector<String> lista_goles;
    private Vector<String> lista_asistencias;
    private Vector<String> lista_partidosGanados;
    private Vector<String> lista_porcentajeGoles;


    public MiAdaptadorEstadistica(Activity actividad, Vector<String> partidos,Vector<String> titulares,Vector<String> goles,Vector<String> asistencias,
                                  Vector<String> partGanados,Vector<String> porcengoles) {
        super();
        this.actividad = actividad;
        this.lista_partidos=partidos;
        this.lista_titulares=titulares;
        this.lista_goles=goles;
        this.lista_asistencias=asistencias;
        this.lista_partidosGanados=partGanados;
        this.lista_porcentajeGoles=porcengoles;
        for(String x : this.lista_partidosGanados) {
            Log.d("mostrar", "partidos ganados:" +x);
        }

    }


    public View getView(int position, View convertView, ViewGroup parent) {
        //System.out.println("cargo position"+position);
        LayoutInflater inflater = actividad.getLayoutInflater();
        View view = inflater.inflate(R.layout.cellestadisticas, null, true);

        //lista jornada
        TextView textViewJornada =(TextView)view.findViewById(R.id.partidosJugados);
        textViewJornada.setText(lista_partidos.elementAt(position));

        //lista fecha
        TextView textViewFecha =(TextView)view.findViewById(R.id.partidoTitular);
        textViewFecha.setText(lista_titulares.elementAt(position));

        //lista hora
        TextView textViewHora=(TextView)view.findViewById(R.id.goles);
        textViewHora.setText(lista_goles.elementAt(position));

        //lista rival
        TextView textViewRival=(TextView)view.findViewById(R.id.asistencias);
        textViewRival.setText(lista_asistencias.elementAt(position));

        //lista partidos ganados
        TextView textViewPartidoGanados=(TextView)view.findViewById(R.id.partidosGanados);
        textViewPartidoGanados.setText(lista_partidosGanados.elementAt(position));

        //lista porcentaje goles
        TextView textViewPorcentajeGoles=(TextView)view.findViewById(R.id.porcentaje_goles);
        textViewPorcentajeGoles.setText(lista_porcentajeGoles.elementAt(position));
        System.out.println("Copio: "+lista_porcentajeGoles.elementAt(position));



        //lista jornada
        ImageView imagenJugador=(ImageView)view.findViewById(R.id.imagenJugadorEstadistica);
        if(position==0){ //abel
            imagenJugador.setImageResource(R.drawable.abel);


        }
        else if(position==1){ //anton
            imagenJugador.setImageResource(R.drawable.anton);
        }
        else if(position==2){ //cano
            imagenJugador.setImageResource(R.drawable.hector);
        }
        else if(position==3){ //hugo
            imagenJugador.setImageResource(R.drawable.hugo4);
        }
        //else if(position==4){ //javi
        //  imagenJugador.setImageResource(R.drawable.javi);
        //}
        else if(position==4){ //jordan
            imagenJugador.setImageResource(R.drawable.jordan);
        }
        else if(position==5){ //juanito
            imagenJugador.setImageResource(R.drawable.juanito);
        }
        else if(position==6){ //meri
            imagenJugador.setImageResource(R.drawable.meri);
        }
        else if(position==7){ //fer
            imagenJugador.setImageResource(R.drawable.fer);
        }

        ImageView imageViewBaja=(ImageView)view.findViewById(R.id.imageBaja);


        return view;
    }

    public int getCount() {
        return lista_partidos.size();
    }

    public Object getItem(int arg0) {
        return lista_partidos.elementAt(arg0);
    }

    public long getItemId(int position) {
        return position;
    }
}
