package es.iesnervion.avazquez.practicaspinneryautocomplete.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import es.iesnervion.avazquez.practicaspinneryautocomplete.Clases.AnimalImpl;
import es.iesnervion.avazquez.practicaspinneryautocomplete.R;
import es.iesnervion.avazquez.practicaspinneryautocomplete.ViewHolder;

public class MySpinnerAdapter extends BaseAdapter implements SpinnerAdapter
{
    Context context;
    ArrayList<AnimalImpl> listaAnimales;

    public MySpinnerAdapter(Context context, ArrayList<AnimalImpl> listaAnimales) {
        this.context = context;
        this.listaAnimales = listaAnimales;
    }

    @Override
    public int getCount() {
        return listaAnimales.size();
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
        AnimalImpl animalActual = listaAnimales.get(position);
        TextView nombre;
        ImageView imagen;
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewHolder viewHolder;

        if(convertView == null){
            convertView = inflater.inflate(R.layout.fila_spinner, parent, false);

            nombre = convertView.findViewById(R.id.nombre);
            imagen = convertView.findViewById(R.id.imagen);

            nombre.setText(animalActual.getNombre());
            imagen.setImageResource(animalActual.getImagen());


            viewHolder = new ViewHolder(nombre, imagen);

            convertView.setTag(viewHolder);



        }else{
            viewHolder = (ViewHolder) convertView.getTag();

        }

        viewHolder.getImagen().setImageResource(animalActual.getImagen());
        viewHolder.getNombre().setText(animalActual.getNombre());

        return convertView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        AnimalImpl animalActual = listaAnimales.get(position);
        TextView nombre;
        ImageView imagen;
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewHolder viewHolder;

        if(convertView == null){
            convertView = inflater.inflate(R.layout.layout_spinner, parent, false);

            nombre = convertView.findViewById(R.id.nombre);
            imagen = convertView.findViewById(R.id.imagen);

            nombre.setText(animalActual.getNombre());
            imagen.setImageResource(animalActual.getImagen());


            viewHolder = new ViewHolder(nombre, imagen);

            convertView.setTag(viewHolder);



        }else{
            viewHolder = (ViewHolder) convertView.getTag();

        }

        viewHolder.getImagen().setImageResource(animalActual.getImagen());
        viewHolder.getNombre().setText(animalActual.getNombre());

        return convertView;
    }
}
