package com.catenaxio;

/**
 * Created by hugoizquierdo on 8/31/14.
 */
import java.util.Vector;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

    public class MiAdaptadorConvocatoria extends BaseAdapter {
        private final Activity actividad;
        private final Vector<Integer> lista_resultado;


        public MiAdaptadorConvocatoria(Activity actividad, Vector<Integer> result) {
            super();
            this.actividad = actividad;
            this.lista_resultado=result;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            //System.out.println("cargo position"+position);
            LayoutInflater inflater = actividad.getLayoutInflater();
            View view = inflater.inflate(R.layout.celdaconvocatoria, null, true);
            //lista jornada
            ImageView imagenJugador=(ImageView)view.findViewById(R.id.imagenConvocatoria);
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
            else if(position==4){ //javi
                imagenJugador.setImageResource(R.drawable.javi);
            }
            else if(position==5){ //jordan
                imagenJugador.setImageResource(R.drawable.jordan);
            }
            else if(position==6){ //juanito
                imagenJugador.setImageResource(R.drawable.juanito);
            }
            else if(position==7){ //meri
                imagenJugador.setImageResource(R.drawable.meri);
            }
            else if(position==8){ //meri
                imagenJugador.setImageResource(R.drawable.fer);
            }

            ImageView imageViewBaja=(ImageView)view.findViewById(R.id.imageBaja);

            //segun el estadio introduzco la imagen
            switch (lista_resultado.get(position)){
                case 0: //para 0 es alta
                    imageViewBaja.setImageResource(R.drawable.alta);
                    break;
                case 1: //si es 1 es baja
                    imageViewBaja.setImageResource(R.drawable.baja);
                    break;
                case 2: //si es 2 es duda
                    imageViewBaja.setImageResource(R.drawable.warning);
                    break;




                default:
                    imageViewBaja.setImageResource(R.drawable.estadiogetafe);
                    break;
            }
            return view;
        }

        public int getCount() {
            return lista_resultado.size();
        }

        public Object getItem(int arg0) {
            return lista_resultado.elementAt(arg0);
        }

        public long getItemId(int position) {
            return position;
        }
    }



