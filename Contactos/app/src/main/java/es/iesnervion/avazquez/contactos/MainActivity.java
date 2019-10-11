package es.iesnervion.avazquez.contactos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import es.iesnervion.avazquez.contactos.Clases.ContactoImpl;

public class MainActivity extends AppCompatActivity {

    ArrayList<ContactoImpl> contactoArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listViewContactos = (ListView)findViewById(R.id.listViewContactos);

        contactoArrayList = new ArrayList<>();
        contactoArrayList.add(new ContactoImpl("Angela","Vazquez Dominguez", new GregorianCalendar(), "Esto es mi bio"));
        contactoArrayList.add(new ContactoImpl());
        contactoArrayList.add(new ContactoImpl("Pepito", "Perez Perez"));

        ContactAdapter contactAdapter = new ContactAdapter(this, contactoArrayList);

        listViewContactos.setAdapter(contactAdapter);
    }
}
