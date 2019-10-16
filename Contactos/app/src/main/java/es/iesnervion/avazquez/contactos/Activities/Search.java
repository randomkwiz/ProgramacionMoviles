package es.iesnervion.avazquez.contactos.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;

import es.iesnervion.avazquez.contactos.Clases.ContactoImpl;
import es.iesnervion.avazquez.contactos.ContactAdapter;
import es.iesnervion.avazquez.contactos.R;

public class Search extends AppCompatActivity
    implements View.OnClickListener
{
    AutoCompleteTextView autoTextView;
    Button addButon;
    ArrayList<String> contactosElegidos;
    Spinner spinner;
    private String[] nombres = {"Angela", "Pepe", "Miguel Angel", "Fernando", "Lucia", "Macarena", "Joaquines", "Maria Isabel", "Angel", "Paola", "Burrito"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_search);


        autoTextView = findViewById(R.id.autoCompleteTxt);

        addButon = findViewById(R.id.addBtnAutoComplete);
        spinner = findViewById(R.id.spinner_contactos);
        contactosElegidos = new ArrayList<String>();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.select_dialog_item, nombres);
        ArrayAdapter<String> adapterSpinner = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, contactosElegidos);
        autoTextView.setAdapter(adapter);
        addButon.setOnClickListener(this);
        spinner.setAdapter(adapterSpinner);
        autoTextView.setThreshold(2);


    }

    @Override
    public void onClick(View v) {
        String nombre;
        boolean existe = false;
        List<String> lista = Arrays.asList(nombres);
            nombre = autoTextView.getText().toString();
            for (String name:contactosElegidos) {
                if(nombre.equals(name)){
                    existe = true;
                }
            }
            if(!existe && lista.contains(nombre)){
                contactosElegidos.add(nombre);
                if(contactosElegidos.size() >= 4){
                    addButon.setEnabled(false);
                }
            }





    }
}
