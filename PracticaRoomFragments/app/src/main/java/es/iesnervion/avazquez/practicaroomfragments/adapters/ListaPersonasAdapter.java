package es.iesnervion.avazquez.practicaroomfragments.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import es.iesnervion.avazquez.practicaroomfragments.R;
import es.iesnervion.avazquez.practicaroomfragments.fragments.ListaPersonas;
import es.iesnervion.avazquez.practicaroomfragments.room.entities.Persona;

public class ListaPersonasAdapter extends BaseAdapter {

    private List<Persona> listaPersonas;
    private Context context;

    public ListaPersonasAdapter(List<Persona> listaPersonas, Context context) {
        this.listaPersonas = listaPersonas;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listaPersonas.size();
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
    public View getView(int position, View convertView, ViewGroup parent) {
        //cogemos el contacto seleccionado
        Persona persona = listaPersonas.get(position);
        /*Ahora vamos a hacerlo con ViewHolder*/
        ViewHolder holder ;
        //int orientacion = context.getResources().getConfiguration().orientation;

        if(convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.lista_personas_row,parent, false);


            //creamos referencias

            //nombre
            TextView nombrePersona=
                    (TextView)convertView.findViewById(R.id.nombrePersona);


            //ahora usamos esas referencias pa ponerselas a la persona actual
            nombrePersona.setText(persona.getNombre());

            holder = new ViewHolder(nombrePersona);

            convertView.setTag(holder);
        }else{
            //si no es null, recicla
            holder = (ViewHolder) convertView.getTag();
        }

        //ACTUALIZAMOS LOS ELEMENTOS
        holder.getNombrePersona().setText(persona.getNombre());


        return convertView;
    }
}
