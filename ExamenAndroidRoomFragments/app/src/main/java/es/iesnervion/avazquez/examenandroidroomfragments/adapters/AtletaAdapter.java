package es.iesnervion.avazquez.examenandroidroomfragments.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import es.iesnervion.avazquez.examenandroidroomfragments.R;
import es.iesnervion.avazquez.examenandroidroomfragments.room.entities.Atleta;

public class AtletaAdapter extends BaseAdapter {

    private List<Atleta> listadoAtletas;
    private Context context;

    public AtletaAdapter(List<Atleta> listadoAtletas, Context context) {
        this.listadoAtletas = listadoAtletas;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listadoAtletas.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        Atleta atleta = listadoAtletas.get(i);
        /*Ahora vamos a hacerlo con ViewHolder*/
        ViewHolder holder ;


        if(view == null){
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            view = layoutInflater.inflate(R.layout.lista_atletas_row,viewGroup, false);


            //creamos referencias

            //nombre
            TextView nombreAtleta=
                    (TextView)view.findViewById(R.id.nombreAtleta);

            nombreAtleta.setText(atleta.getNombre());

            holder = new ViewHolder(nombreAtleta);

            view.setTag(holder);
        }else{
            //si no es null, recicla
            holder = (ViewHolder) view.getTag();
        }

        //ACTUALIZAMOS LOS ELEMENTOS
        holder.getNombreAtleta().setText(atleta.getNombre());


        return view;
    }
}
