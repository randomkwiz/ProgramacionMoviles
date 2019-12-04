package es.iesnervion.avazquez.examenandroid_avazquez.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SpinnerAdapter;

public class AdaptadorSpinner extends BaseAdapter implements SpinnerAdapter {
    @Override
    public int getCount() {
        return 0;
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
    //Este por si quiero que la vista de dropdown sea diferente
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return super.getDropDownView(position, convertView, parent);
        //aqui pondrias return obtenerVistaAdecuada....con el layout correspondiente
    }
*/
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
        //aqui pondrias return obtenerVistaAdecuada....con el layout correspondiente
    }

/*

    public View obtenerVistaAdecuada(int position, View convertView, ViewGroup parent, int layout) {
        ContactoImpl contactoActual = listaContactos.get(position);
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
    */
}
