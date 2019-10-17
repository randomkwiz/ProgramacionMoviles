package es.iesnervion.avazquez.practicaspinneryautocomplete;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import java.util.ArrayList;

import es.iesnervion.avazquez.practicaspinneryautocomplete.Adaptadores.AutoTextAdapter;
import es.iesnervion.avazquez.practicaspinneryautocomplete.Adaptadores.MySpinnerAdapter;
import es.iesnervion.avazquez.practicaspinneryautocomplete.Clases.AnimalImpl;

public class MainActivity extends AppCompatActivity {

    ArrayList<AnimalImpl> animalArrayList;
    Spinner spinner;
    AutoCompleteTextView autoCompleteTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        autoCompleteTextView = findViewById(R.id.autoComplete);
        animalArrayList = new ArrayList<>();
        animalArrayList.add(new AnimalImpl("Perro", R.drawable.dog));
        animalArrayList.add(new AnimalImpl("Gato", R.drawable.cat));
        animalArrayList.add(new AnimalImpl("Pez", R.drawable.fish));
        animalArrayList.add(new AnimalImpl("Pez payaso", R.drawable.clownfish));
        animalArrayList.add(new AnimalImpl());

        SpinnerAdapter spinnerAdapter = new MySpinnerAdapter(this, animalArrayList);
        ArrayAdapter<AnimalImpl> arrayAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, animalArrayList);
        //AutoTextAdapter autoTextAdapter = new AutoTextAdapter(this, R.layout.fila_spinner,animalArrayList);

        spinner.setAdapter(spinnerAdapter);
        autoCompleteTextView.setThreshold(2);
        autoCompleteTextView.setAdapter(arrayAdapter);


    }
}
