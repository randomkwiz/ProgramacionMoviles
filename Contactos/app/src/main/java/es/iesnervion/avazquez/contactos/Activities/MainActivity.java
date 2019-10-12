package es.iesnervion.avazquez.contactos.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;

import de.hdodenhof.circleimageview.CircleImageView;
import es.iesnervion.avazquez.contactos.Clases.ContactoImpl;
import es.iesnervion.avazquez.contactos.ContactAdapter;
import es.iesnervion.avazquez.contactos.Interfaces.Contacto;
import es.iesnervion.avazquez.contactos.R;

public class MainActivity extends AppCompatActivity

implements AdapterView.OnItemClickListener //para cuando se hace click en un item del listview

{

    /*TODO ordenar el array por A-Z*/
    ArrayList<ContactoImpl> contactoArrayList;
    CircleImageView addButton ;
    ContactAdapter contactAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contactoArrayList = new ArrayList<ContactoImpl>();
        contactoArrayList.add(new ContactoImpl("Angela","Vazquez Dominguez", new GregorianCalendar(1997, 6, 23), "Esta es mi biografia", R.drawable.femaleimg));
        contactoArrayList.add(new ContactoImpl("Nzhdeh", "Yeghiazaryan"));
        contactoArrayList.add(new ContactoImpl("Pepito", "Perez Perez"));
        contactoArrayList.add(new ContactoImpl("Angel", "Luna Duran"));
        contactoArrayList.add(new ContactoImpl("Miguel Angel", "Longa Garcia"));
        contactoArrayList.add(new ContactoImpl("Joaquines", "Bello Hidalgo"));
        contactoArrayList.add(new ContactoImpl("Ariana", "Bello Hidalgo"));
        contactoArrayList.add(new ContactoImpl("Manuel", "Limon"));
        contactoArrayList.add(new ContactoImpl("Maria Isabel", "Martin Gamarra"));
        contactoArrayList.add(new ContactoImpl("Usu", "normal"));

        Collections.sort(contactoArrayList);
        addButton = findViewById(R.id.addButton);

        ListView listViewContactos = (ListView)findViewById(R.id.listViewContactos);
        contactAdapter = new ContactAdapter(this, contactoArrayList);
        listViewContactos.setAdapter(contactAdapter);


        listViewContactos.setOnItemClickListener(this); //establecemos un listener para cuando se haga click en un item.
            //es exactamente igual que pa los botones
        contactAdapter.notifyDataSetChanged();

    }

    //implementamos el metodo on item click... es igual que pa los botones
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this,DetailsContact.class );
        ContactoImpl contactoSeleccionado = contactoArrayList.get(position);
        //clave - valor (la clave es "contacto" y el valor pues es el objeto contacto
        intent.putExtra("contacto", contactoSeleccionado);

        startActivity(intent);


    }

    public void onClick(View v) {
        Intent intentAddContact = new Intent(this,AddContact.class );
        //clave - valor (la clave es "contacto" y el valor pues es el objeto contacto
       // intentAddContact.putExtra("arrayListContactos", contactoArrayList);
        startActivity(intentAddContact);
    }
}
