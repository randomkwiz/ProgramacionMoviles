package es.iesnervion.avazquez.centroeducativo.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.ListView;

import es.iesnervion.avazquez.centroeducativo.R;
import es.iesnervion.avazquez.centroeducativo.adapter.PersonasAdapter;
import es.iesnervion.avazquez.centroeducativo.viewModel.MainVM;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainVM viewModel = ViewModelProviders.of(this).get(MainVM.class);

        ListView listView = findViewById(R.id.listviewPersonas);
        PersonasAdapter adapter = new PersonasAdapter(this, viewModel.getListaPersonas());
        listView.setAdapter(adapter);
    }
}
