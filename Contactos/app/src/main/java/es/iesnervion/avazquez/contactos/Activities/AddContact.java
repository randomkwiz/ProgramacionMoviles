package es.iesnervion.avazquez.contactos.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;


import de.hdodenhof.circleimageview.CircleImageView;
import es.iesnervion.avazquez.contactos.Clases.ContactoImpl;
import es.iesnervion.avazquez.contactos.ContactAdapter;
import es.iesnervion.avazquez.contactos.Interfaces.Contacto;
import es.iesnervion.avazquez.contactos.R;

public class AddContact extends AppCompatActivity
implements View.OnClickListener
{

    EditText nombre;
    EditText apellidos;
    EditText bio;
    CircleImageView foto;
    DatePicker fechaNacimiento;
    ContactoImpl contactoCreado = new ContactoImpl();
    Button addButton;
   // ArrayList<ContactoImpl> listaDeContactos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        GregorianCalendar dateNow = new GregorianCalendar();    //me servira para definir la fecha maxima
        setContentView(R.layout.layout_add_contact);

        //listaDeContactos = (ArrayList<ContactoImpl>) getIntent().getSerializableExtra("arrayListContactos");


        nombre = findViewById(R.id.editName);
        apellidos = findViewById(R.id.editSurname);
        bio = findViewById(R.id.editBio);
        fechaNacimiento = findViewById(R.id.calendario);    //link con su xml
        fechaNacimiento.setMaxDate(dateNow.getTimeInMillis());  //set max date tiene que estar DESPUES de hacer el link con su XML obviamente
        foto = findViewById(R.id.imgContacto);
        addButton = findViewById(R.id.btnAdd);
        addButton.setOnClickListener(this);






    }

    @Override
    public void onClick(View v) {

        Intent intentMain = new Intent(this,MainActivity.class );

        contactoCreado.setNombre(nombre.getText().toString());
        contactoCreado.setApellidos(apellidos.getText().toString());
        contactoCreado.setBiografia(bio.getText().toString());
        contactoCreado.setImgResource(R.drawable.imgdefault);
        /*Haz la parte del calendario*/
        //contacto.setFechaNacimiento(fechaNacimiento.);

        //listaDeContactos.add(contactoCreado);

        startActivity(intentMain);
    }
}
