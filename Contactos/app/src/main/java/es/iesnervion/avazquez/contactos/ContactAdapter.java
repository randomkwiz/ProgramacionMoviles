package es.iesnervion.avazquez.contactos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import es.iesnervion.avazquez.contactos.Clases.ContactoImpl;
import es.iesnervion.avazquez.contactos.Interfaces.Contacto;

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
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //cogemos el contacto seleccionado
         ContactoImpl contacto = contactoArrayList.get(position);


        /*Ahora vamos a hacerlo con ViewHolder*/
        ViewHolder holder ;



        //inflamos el contacto con el layout de contactos
        if(convertView == null ){
             LayoutInflater layoutInflater = LayoutInflater.from(context);
             //prueba el getLayoutInflater();
            convertView = layoutInflater.inflate(R.layout.layout_contacto,parent, false);


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

            //bio
            //final TextView bioContacto = (TextView)convertView.findViewById(R.id.txtViewBio); //VER ANOTACION ABAJO


            //ahora usamos esas referencias pa ponerselas al contacto actual

            fotoContacto.setImageResource(contacto.getImgResource());
            nombreContacto.setText(contacto.getNombre());
            apellidoContacto.setText(contacto.getApellidos());
            fechaNacimientoContacto.setText(contacto.obtenerFechaNacimientoCorta());

            holder = new ViewHolder(fotoContacto, nombreContacto, apellidoContacto, fechaNacimientoContacto);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        holder.getFotoContacto().setImageResource(contacto.getImgResource());
        holder.getNombreContacto().setText(contacto.getNombre());
        holder.getApellidosContacto().setText(contacto.getApellidos());
        holder.getFechaNacimientoContacto().setText(contacto.obtenerFechaNacimientoCorta());






        //bioContacto.setText(contacto.getBiografia());

        /*ANOTACION:
        * ME HE TIRADO DOS DIAS PENSANDO EN ESTE FALLO Y NO LO ENTENDIA
        * Y RESULTA QUE ES LA GILIPOLLEZ MAS GRANDE DE LA HISTORIA
        * EN EL LAYOUT layout_contacto.xml, NO TENGO EL TEXTVIEW BIO,
        * ESTABA INTENTANTO LINKARLO CON UN TXTVIEW DE OTRO LAYOUT
        *  !!!!!!!!!!!!!!!!!!!
        * */

        return convertView;
    }
}
