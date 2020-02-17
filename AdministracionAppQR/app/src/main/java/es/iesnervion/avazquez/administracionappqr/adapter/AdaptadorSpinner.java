package es.iesnervion.avazquez.administracionappqr.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SpinnerAdapter;

import java.util.ArrayList;

public class AdaptadorSpinner extends BaseAdapter implements SpinnerAdapter {

    Context context;
    ArrayList<String> lista;

    public AdaptadorSpinner(Context context, ArrayList<String> lista) {
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


    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(android.R.layout.simple_spinner_dropdown_item, parent, false);

        return convertView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
            convertView = LayoutInflater.from(context).inflate(android.R.layout.simple_spinner_item, parent, false);

        return convertView;
    }


}
