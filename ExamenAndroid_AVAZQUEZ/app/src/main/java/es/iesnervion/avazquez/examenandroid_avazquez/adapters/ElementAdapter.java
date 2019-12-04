package es.iesnervion.avazquez.examenandroid_avazquez.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class ElementAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Object> lista;


    //Constructor
    public ElementAdapter(Context context, ArrayList<Object> lista) {
        this.context = context;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
/*
    //Esto para lista heterogenea

    @Override
    public int getItemViewType(int position) {
        //de que tipo es el elemento de la posicion X en la lista
        return super.getItemViewType(position);
    }

    //Esto para lista heterogenea
    @Override
    public int getViewTypeCount() {
        //tipos diferentes que hay
        return super.getViewTypeCount();
    }
*/
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        /*PSEUDOCODIGO DEL GET VIEW PARA LISTAS HETEROGENEAS*/
        /*
         * COGER OBJETO SELECCIONADO
         * SI EL CONVERT VIEW ES NULL
         *       SI EL OBJETO VA A SER DE TIPO 0
         *               INFLALO CON EL LAYOUT TIPO 0
         *       SINO
         *               INFLALO CON EL LAYOUT TIPO 1
         *       FINSI
         *       CREAR REFERENCIAS
         *       RELACIONAR REFERENCIAS CON OBJETO ACTUAL
         *       INSTANCIAR VIEW HOLDER
         *       RELACIONAR VIEW HOLDER CON LA VISTA
         * SINO
         *       COGER REFERENCIAS DE LA VISTA
         * FIN SI
         *       ACTUALIZAR LOS ELEMENTOS
         *
         * */


        return null;
    }
}
