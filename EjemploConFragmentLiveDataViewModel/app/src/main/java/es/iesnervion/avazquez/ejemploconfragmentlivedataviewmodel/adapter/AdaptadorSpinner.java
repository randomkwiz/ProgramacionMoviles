package es.iesnervion.avazquez.ejemploconfragmentlivedataviewmodel.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import es.iesnervion.avazquez.ejemploconfragmentlivedataviewmodel.R;
import es.iesnervion.avazquez.ejemploconfragmentlivedataviewmodel.entities.ContactImpl;
import es.iesnervion.avazquez.ejemploconfragmentlivedataviewmodel.viewHolder.ViewHolderSpinner;

public class AdaptadorSpinner extends BaseAdapter implements SpinnerAdapter {

    Context context;
    ArrayList<ContactImpl> listaContactos;

    public AdaptadorSpinner(Context context, ArrayList<ContactImpl> listaContactos) {
        this.context = context;
        this.listaContactos = listaContactos;
    }


    @Override
    public int getCount() {
        return listaContactos.size();
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
        return obtenerVistaAdecuada(position, convertView, parent, R.layout.layout_row_spinner);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        return obtenerVistaAdecuada(position, convertView, parent, R.layout.layout_spinner);
    }


    public View obtenerVistaAdecuada(int position, View convertView, ViewGroup parent, int layout) {
        ContactImpl contactoActual = listaContactos.get(position);
        TextView nombre;
        CircleImageView imagen;
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewHolderSpinner viewHolder;

        if(convertView == null){
            convertView = inflater.inflate(layout, parent, false);

            nombre = convertView.findViewById(R.id.nombreContacto_row_spinner);
            imagen = convertView.findViewById(R.id.fotoContacto_row_spinner);

            nombre.setText(contactoActual.getNombre());
            imagen.setImageResource(contactoActual.getImgResource());


            viewHolder = new ViewHolderSpinner(imagen,nombre);

            convertView.setTag(viewHolder);



        }else{
            viewHolder = (ViewHolderSpinner) convertView.getTag();

        }

        viewHolder.getImagen().setImageResource(contactoActual.getImgResource());
        viewHolder.getNombreCompleto().setText(contactoActual.getNombre()+ " "+ contactoActual.getApellidos());

        return convertView;
    }

}
