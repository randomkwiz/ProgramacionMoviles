package es.iesnervion.avazquez.contactos.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;

import de.hdodenhof.circleimageview.CircleImageView;
import es.iesnervion.avazquez.contactos.Clases.ContactoImpl;
import es.iesnervion.avazquez.contactos.Adaptadores.ContactAdapter;
import es.iesnervion.avazquez.contactos.ViewModel.MainViewModel;
import es.iesnervion.avazquez.contactos.R;
import es.iesnervion.avazquez.contactos.UtilidadesContactos;

public class MainActivity extends AppCompatActivity

        implements AdapterView.OnItemClickListener, //para cuando se hace click en un item del listview
        View.OnClickListener

{

    CircleImageView addButton ;
    CircleImageView searchButton ;
    AutoCompleteTextView autoCompleteTextView;
    ContactAdapter contactAdapter;
    MainViewModel mainViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ViewModel
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);


        addButton = findViewById(R.id.addButton);
        searchButton = findViewById(R.id.searchButton);
        autoCompleteTextView = findViewById(R.id.autoCompleteMainActivity);

        //Listeners
        addButton.setOnClickListener(this);
        searchButton.setOnClickListener(this);

        //ListView
        ListView listViewContactos = (ListView)findViewById(R.id.listViewContactos);

        //Adapters
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_dropdown_item_1line,
                mainViewModel.getContactoArrayList());
        contactAdapter = new ContactAdapter(this, mainViewModel.getContactoArrayList());
        listViewContactos.setAdapter(contactAdapter);
        autoCompleteTextView.setAdapter(arrayAdapter);

        listViewContactos.setOnItemClickListener(this); //establecemos un listener
        // para cuando se haga click en un item.
            //es exactamente igual que pa los botones
        //contactAdapter.notifyDataSetChanged();

    }

    //implementamos el metodo on item click... es igual que pa los botones
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this,DetailsContact.class );
        ContactoImpl contactoSeleccionado = mainViewModel.getContactoArrayList().get(position);
        //clave - valor (la clave es "contacto" y el valor pues es el objeto contacto
        intent.putExtra("contacto", contactoSeleccionado);

        startActivity(intent);


    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.addButton:
                intent = new Intent(this,AddContact.class );

                startActivity(intent);
                break;
            case R.id.searchButton:
                intent = new Intent(this,DetailsContact.class );
                    ContactoImpl contactoSeleccionado = UtilidadesContactos.
                            encontrarContactoPorNombreYApellidos
                                    (mainViewModel.getContactoArrayList(),
                                            autoCompleteTextView.getText().toString());
                    //clave - valor (la clave es "contacto" y el valor pues es el objeto contacto
                    intent.putExtra("contacto", contactoSeleccionado);
                    if(mainViewModel.getContactoArrayList()
                            .contains(contactoSeleccionado)){   //solo cambiara de act si el contacto existe
                        startActivity(intent);
                    }


                break;

        }



        //clave - valor (la clave es "contacto" y el valor pues es el objeto contacto
       // intentAddContact.putExtra("arrayListContactos", contactoArrayList);

    }
}
