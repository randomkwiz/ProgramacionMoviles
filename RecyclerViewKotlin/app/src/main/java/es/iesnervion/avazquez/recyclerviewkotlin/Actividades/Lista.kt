package es.iesnervion.avazquez.recyclerviewkotlin.Actividades

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
        var listaPokemon: ArrayList<Pokemon> = utilidad.crearArrayListTodosLosPokemon()


        var layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)

        var adaptador = PokemonAdapter(listaPokemon, this)
        listview.layoutManager = layoutManager  //indica como se van a ver los elementos
        listview.adapter = adaptador

    }
}
