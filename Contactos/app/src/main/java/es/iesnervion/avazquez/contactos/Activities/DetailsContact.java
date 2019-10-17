package es.iesnervion.avazquez.contactos.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import de.hdodenhof.circleimageview.CircleImageView;
import es.iesnervion.avazquez.contactos.Clases.ContactoImpl;
import es.iesnervion.avazquez.contactos.R;

public class DetailsContact extends AppCompatActivity {

    TextView nombreCompleto;
    TextView fechaNacimiento;
    TextView bio;
    CircleImageView foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//mirar parcelable
        Intent intentRecibido = getIntent();
        //le pido el el valor correspondiente a la clave "contacto"
        ContactoImpl contactoElegido = (ContactoImpl) intentRecibido.getSerializableExtra("contacto");
        if(contactoElegido.isFavorito()){   //si el contacto que me llega pa mostra sus detalles es fav, le pongo un layout y si no, otro
            setContentView(R.layout.activity_details_contact_fav);
        }else{
            setContentView(R.layout.activity_details_contact);
        }


        //hago los vinculos entre el java y el xml
        foto = findViewById(R.id.imgContacto);
        nombreCompleto = findViewById(R.id.txtViewNombreCompleto);
        fechaNacimiento = findViewById(R.id.txtViewFechaNacimiento);
        bio = findViewById(R.id.txtViewBio);

        //le pongo al xml los datos del objeto en cuestion
        foto.setImageResource(contactoElegido.getImgResource());
        nombreCompleto.setText(contactoElegido.getNombre() +" " +contactoElegido.getApellidos());
        fechaNacimiento.setText(contactoElegido.obtenerFechaNacimientoCorta());
        bio.setText(contactoElegido.getBiografia());
    }
}
