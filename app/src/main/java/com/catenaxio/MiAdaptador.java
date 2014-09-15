package com.catenaxio;

/**
 * Created by hugoizquierdo on 8/30/14.
 */
import java.util.Vector;
import android.content.*;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MiAdaptador extends BaseAdapter {
    private final Activity actividad;
    private final Vector<String> lista_jornada;
    private final Vector<String> lista_fecha;
    private final Vector<String> lista_hora;
    private final Vector<String> lista_rival;
    private final Vector<String> lista_lugar;
    private  final  Vector<Integer> lista_estadio;

    public MiAdaptador(Activity actividad, Vector<String> jor,Vector<String> fecha,Vector<String> hora, Vector<String> rival,
                       Vector<Integer> estadios,Vector<String> lugares) {
        super();
        this.actividad = actividad;
        this.lista_jornada = jor;
        this.lista_fecha=fecha;
        this.lista_hora=hora;
        this.lista_rival=rival;
        this.lista_estadio=estadios;
        this.lista_lugar=lugares;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        //System.out.println("cargo position"+position);
        LayoutInflater inflater = actividad.getLayoutInflater();
        View view = inflater.inflate(R.layout.cellcalendario, null, true);
        //lista jornada
        TextView textViewJornada =(TextView)view.findViewById(R.id.labelJornada);
        textViewJornada.setText(lista_jornada.elementAt(position));

        //lista fecha
        TextView textViewFecha =(TextView)view.findViewById(R.id.labelFecha);
        textViewFecha.setText(lista_fecha.elementAt(position));

        //lista hora
        TextView textViewHora=(TextView)view.findViewById(R.id.labelHora);
        textViewHora.setText(lista_hora.elementAt(position));

        //lista rival
        TextView textViewRival=(TextView)view.findViewById(R.id.labelRival);
        textViewRival.setText(lista_rival.elementAt(position));

        //lista lugar
        TextView textViewLugar=(TextView)view.findViewById(R.id.labelEstadio);
        textViewLugar.setText(lista_lugar.elementAt(position));

        //ImageView imageView=(ImageView)view.findViewById(R.id.imagenEstadio);
        Context context = parent.getContext();
        //segun el estadio introduzco la imagen
        switch (lista_estadio.get(position)){
            case 0:


                view.setBackgroundColor(context.getResources().getColor(R.color.darkdarkblue));
                break;
            case 1:

                view.setBackgroundColor(context.getResources().getColor(R.color.blueLigth));
                break;





            default:
                view.setBackgroundColor(context.getResources().getColor(R.color.blueLigth));
                break;
        }
        return view;
    }

    public int getCount() {
        return lista_jornada.size();
    }

    public Object getItem(int arg0) {
        return lista_jornada.elementAt(arg0);
    }

    public long getItemId(int position) {
        return position;
    }
}
