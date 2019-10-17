package es.iesnervion.avazquez.contactos.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import es.iesnervion.avazquez.contactos.Clases.ContactoImpl;
import es.iesnervion.avazquez.contactos.R;
import es.iesnervion.avazquez.contactos.ViewHolder.ViewHolder;

public class ContactAdapter extends BaseAdapter {

    private final Context context;
    private final ArrayList<ContactoImpl> contactoArrayList;

    public ContactAdapter(Context context, ArrayList<ContactoImpl> contactoArrayList ) {
        this.context = context;
        this.contactoArrayList = contactoArrayList;
    }

    @Override
    public int getCount() {
        return contactoArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public int getItemViewType(int position) {
        int tipo = 0;   //0 no es fav

        if(contactoArrayList.get(position).isFavorito()){
            tipo = 1;   //1 si es fav
        }

        return tipo;
    }

    @Override
    public int getViewTypeCount() {

        return 2;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    /*PSEUDOCODIGO DEL GET VIEW */
    /*
    * COGER OBJETO SELECCIONADO
    * SI EL CONVERT VIEW ES NULL
    *       SI EL OBJETO VA A SER DE TIPO 1
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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //cogemos el contacto seleccionado
        ContactoImpl contacto = contactoArrayList.get(position);
        /*Ahora vamos a hacerlo con ViewHolder*/
        ViewHolder holder ;


            if(convertView == null){
                LayoutInflater layoutInflater = LayoutInflater.from(context);
                if(getItemViewType(position)==0){
                    convertView = layoutInflater.inflate(R.layout.layout_contacto,parent, false);
                }else{
                    convertView = layoutInflater.inflate(R.layout.layout_contacto_fav,parent, false);
                }

                //creamos referencias
                //foto contacto
                CircleImageView fotoContacto =
                        (CircleImageView)convertView.findViewById(R.id.fotoContacto);

                //nombre
                TextView nombreContacto =
                        (TextView)convertView.findViewById(R.id.textoNombre);

                //apellido
                TextView apellidoContacto =
                        (TextView)convertView.findViewById(R.id.textoApellidos);

                //fechaNacimiento
                TextView fechaNacimientoContacto = (TextView)convertView.findViewById(R.id.textoFechaNacimiento);



                //ahora usamos esas referencias pa ponerselas al contacto actual

                fotoContacto.setImageResource(contacto.getImgResource());
                nombreContacto.setText(contacto.getNombre());
                apellidoContacto.setText(contacto.getApellidos());
                fechaNacimientoContacto.setText(contacto.obtenerFechaNacimientoCorta());

                holder = new ViewHolder(fotoContacto, nombreContacto, apellidoContacto, fechaNacimientoContacto);

                convertView.setTag(holder);
            }else{
                //si no es null, recicla
                holder = (ViewHolder) convertView.getTag();
            }

            //ACTUALIZAMOS LOS ELEMENTOS
        holder.getFotoContacto().setImageResource(contacto.getImgResource());
        holder.getNombreContacto().setText(contacto.getNombre());
        holder.getApellidosContacto().setText(contacto.getApellidos());
        holder.getFechaNacimientoContacto().setText(contacto.obtenerFechaNacimientoCorta());


        return convertView;
    }
}
