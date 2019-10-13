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
        final ContactoImpl contacto = contactoArrayList.get(position);

        //inflamos el contacto con el layout de contactos
        if(convertView == null ){
            final LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.layout_contacto,parent, false);
        }

        //creamos referencias
        //foto contacto
        final CircleImageView fotoContacto =
                (CircleImageView)convertView.findViewById(R.id.fotoContacto);

        //nombre
        final TextView nombreContacto =
                (TextView)convertView.findViewById(R.id.textoNombre);

        //apellido
        final TextView apellidoContacto =
                (TextView)convertView.findViewById(R.id.textoApellidos);

        //fechaNacimiento
        final TextView fechaNacimientoContacto = (TextView)convertView.findViewById(R.id.textoFechaNacimiento);

        //bio
        //final TextView bioContacto = (TextView)convertView.findViewById(R.id.txtViewBio); //VER ANOTACION ABAJO

        //ahora usamos esas referencias pa ponerselas al contacto actual

        fotoContacto.setImageResource(contacto.getImgResource());
        nombreContacto.setText(contacto.getNombre());
        apellidoContacto.setText(contacto.getApellidos());
        fechaNacimientoContacto.setText(contacto.obtenerFechaNacimientoCorta());


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
