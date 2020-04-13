package es.iesnervion.avazquez.coordinatorlayoutprueba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {

//http://www.sgoliver.net/blog/animaciones-basicas-coordinatorlayout/
    //http://www.sgoliver.net/blog/controles-de-seleccion-v-recyclerview/

    private RecyclerView lstLista;
    private FloatingActionButton btnFab;
    private CollapsingToolbarLayout ctlLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //App bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.appbar);
        setSupportActionBar(toolbar);
       // getSupportActionBar().setTitle("Ochako");

        //RecyclerView
        RecyclerView lstLista = (RecyclerView)findViewById(R.id.lstLista);

        ArrayList<Titular> datos = new ArrayList<>();
        for(int i=0; i<50; i++)
            datos.add(new Titular("Título " + i, "Subtítulo item " + i));

        AdaptadorTitulares adaptador = new AdaptadorTitulares(datos);
        lstLista.setAdapter(adaptador);

        lstLista.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        lstLista.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        lstLista.setItemAnimator(new DefaultItemAnimator());

        //TabLayout
        //TabLayout tabLayout = (TabLayout) findViewById(R.id.appbartabs);
        //tabLayout.setTabMode(TabLayout.MODE_FIXED);
        //tabLayout.addTab(tabLayout.newTab().setText("Tab 1"));
        //tabLayout.addTab(tabLayout.newTab().setText("Tab 2"));
        //tabLayout.addTab(tabLayout.newTab().setText("Tab 3"));

        //Floating Action Button
        btnFab = (FloatingActionButton)findViewById(R.id.btnFab);
        btnFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Claro que sí wapi", Snackbar.LENGTH_LONG).show();
            }
        });

        //CollapsingToolbarLayout
        ctlLayout = (CollapsingToolbarLayout)findViewById(R.id.ctlLayout);
        ctlLayout.setTitle("Ochako Uraraka");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
