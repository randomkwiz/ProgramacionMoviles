package es.iesnervion.avazquez.recyclerviewkotlin.Actividades

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import es.iesnervion.avazquez.recyclerviewkotlin.Adapters.CustomStringAdapter
import es.iesnervion.avazquez.recyclerviewkotlin.Adapters.MovimientosAdapter
import es.iesnervion.avazquez.recyclerviewkotlin.Adapters.PokemonAdapter
import es.iesnervion.avazquez.recyclerviewkotlin.Clases.Movimiento
import es.iesnervion.avazquez.recyclerviewkotlin.Clases.Pokemon
import es.iesnervion.avazquez.recyclerviewkotlin.R
import es.iesnervion.avazquez.recyclerviewkotlin.Utilidades.Utilidad

class Lista : AppCompatActivity()

{

    lateinit var listaPokemon: ArrayList<Pokemon>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)
        var recyclerView: RecyclerView = findViewById(R.id.listaActividadLista)
        var utilidad: Utilidad = Utilidad()
        var intent: Intent = intent
        var opcion = intent.getStringExtra("tipo") !!

        var layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        if (opcion.equals("pokemon") ){

            listaPokemon = utilidad.crearArrayListTodosLosPokemon(this)
            var adaptador = PokemonAdapter(listaPokemon, {pokemon -> pokemonItemClicked(pokemon)}, this)
            recyclerView.layoutManager = layoutManager  //indica como se van a ver los elementos
            recyclerView.adapter = adaptador



        } else if (opcion.equals("movimientos")){

            var listaMovimientos: ArrayList<Movimiento> = utilidad.crearArrayListTodosLosMovimientos(this)



            //Tiene que ser un adapter personalizado porque uso recycler view, no puedo usar el Array Adapter
            var adaptador = MovimientosAdapter(this,listaMovimientos)
            recyclerView.layoutManager = layoutManager  //indica como se van a ver los elementos
            recyclerView.adapter = adaptador
        }else if(opcion.equals("items")){


            var listaItems: ArrayList<String> = utilidad.crearArrayListTodosLosItems(this)


           var adaptador = CustomStringAdapter(listaItems, this)
            recyclerView.layoutManager = layoutManager
            recyclerView.adapter = adaptador
        }




    }

    /*tienes que implementarte tu las cosillas xd*/
    private fun pokemonItemClicked(pokemon: Pokemon) {
        var intent: Intent = Intent(this, PokemonDetails::class.java)

        intent.putExtra("pokemonElegido", pokemon)

        startActivity(intent)
    }
}
