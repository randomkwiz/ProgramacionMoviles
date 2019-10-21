package es.iesnervion.avazquez.recyclerviewkotlin.Actividades

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import es.iesnervion.avazquez.recyclerviewkotlin.Adapters.CustomStringAdapter
import es.iesnervion.avazquez.recyclerviewkotlin.Adapters.PokemonAdapter
import es.iesnervion.avazquez.recyclerviewkotlin.Clases.Pokemon
import es.iesnervion.avazquez.recyclerviewkotlin.R
import es.iesnervion.avazquez.recyclerviewkotlin.Utilidades.Utilidad

class Lista : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)
        var listview: RecyclerView = findViewById(R.id.listaActividadLista)
        var utilidad: Utilidad = Utilidad()
        var intent: Intent = intent

        if (intent.getStringExtra("tipo").equals("pokemon") ){

            var listaPokemon: ArrayList<Pokemon> = utilidad.crearArrayListTodosLosPokemon(this)


            var layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)

            var adaptador = PokemonAdapter(listaPokemon, this)
            listview.layoutManager = layoutManager  //indica como se van a ver los elementos
            listview.adapter = adaptador

        } else if (intent.getStringExtra("tipo").equals("movimientos")){
            var listaMovimientos: ArrayList<String> = utilidad.crearArrayListTodosLosMovimientos(this)

            var layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)

            var adaptador = CustomStringAdapter(listaMovimientos,this)
            listview.layoutManager = layoutManager  //indica como se van a ver los elementos
            listview.adapter = adaptador
        }




    }
}
