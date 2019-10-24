package es.iesnervion.avazquez.recyclerviewkotlin.Actividades

import android.content.Intent
import android.os.Bundle
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
        var utilidad: Utilidad = Utilidad()
        var intent: Intent = intent
        var opcion = intent.getStringExtra("tipo") !!
        var recyclerView: RecyclerView = findViewById(R.id.listaActividadLista)
        var layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)

        /*Sobre el LayoutManager:
        * Para usar RecyclerView tienes que definir un adaptador con un LayoutManager.
        * El adaptador acercará el modelo de datos para ser mostrados y el
        * LayoutManager será el responsable de posicionar cada ítem dentro
        * del RecyclerView y de decidir cuándo reciclar las
        * vistas de items que ya no son visibles.
        * */



        if (opcion.equals("pokemon") ){

            listaPokemon = utilidad.crearArrayListTodosLosPokemon(this)

            //le tengo que pasar tambien el metodo que actuara cuando clicken en un pokemon
            var adaptador = PokemonAdapter(listaPokemon, {pokemon -> pokemonItemClicked(pokemon)}, this)

            recyclerView.layoutManager = layoutManager  //indica como se van a ver los elementos
            recyclerView.adapter = adaptador



        } else if (opcion.equals("movimientos")){

            var listaMovimientos: ArrayList<Movimiento> = utilidad.crearArrayListTodosLosMovimientos(this)

            var adaptador = MovimientosAdapter(this,listaMovimientos)
            recyclerView.layoutManager = layoutManager  //indica como se van a ver los elementos
            recyclerView.adapter = adaptador
        }else if(opcion.equals("items")){


            var listaItems: ArrayList<String> = utilidad.crearArrayListTodosLosItems(this)

            //Aunque solo vaya a mostrar strings, al ser RecyclerView no me deja usar ArrayAdapter
           var adaptador = CustomStringAdapter(listaItems, this)
            recyclerView.layoutManager = layoutManager
            recyclerView.adapter = adaptador
        }




    }

    /*tienes que implementarte tu las cosillas porque no existe el OnItemClickListener con RecyclerView
        */
    private fun pokemonItemClicked(pokemon: Pokemon) {
        var intent: Intent = Intent(this, PokemonDetails::class.java)

        intent.putExtra("pokemonElegido", pokemon)

        startActivity(intent)
    }
}
