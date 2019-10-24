package es.iesnervion.avazquez.recyclerviewkotlin.Actividades

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.ImageView
import android.widget.TextView
import es.iesnervion.avazquez.recyclerviewkotlin.Clases.Pokemon
import es.iesnervion.avazquez.recyclerviewkotlin.R
import kotlinx.android.synthetic.main.layout_details_pokemon.*

class PokemonDetails : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_details_pokemon)

        //Recogemos el pokemon elegido
        var pokemon: Pokemon = intent.getSerializableExtra("pokemonElegido") as Pokemon



        //enlazamos las variables con los elementos del XML

        var fotoPokemon: ImageView = findViewById(R.id.image_details_pokemon)
        var idPokemon: TextView = findViewById(R.id.id_details_pokemon)
        var nombrePokemon: TextView = findViewById(R.id.nombre_pokemon)
        var tipoUno: TextView = findViewById(R.id.tipo_1)
        var tipoDos: TextView = findViewById(R.id.tipo_2)
        var hp: TextView = findViewById(R.id.stats_hp)
        var attack: TextView = findViewById(R.id.stats_attack)
        var defense: TextView = findViewById(R.id.stats_defense)
        var spAttack: TextView = findViewById(R.id.stats_spAttack)
        var spDefense: TextView = findViewById(R.id.stats_spDefense)
        var speed: TextView = findViewById(R.id.stats_speed)


        //Enlazamos datos del pokemon elegido

        fotoPokemon.setImageResource(pokemon.img)
        idPokemon.text = pokemon.id.toString()
        nombrePokemon.text = pokemon.name
        tipoUno.text = pokemon.tipo1
        //TODO añadir tipo 2 en algun momento cuando arregles el constructor de Pokemon
        hp.text = pokemon.hp.toString()
        attack.text = pokemon.attack.toString()
        defense.text = pokemon.defense.toString()
        spAttack.text = pokemon.spAttack.toString()
        spDefense.text = pokemon.spDefense.toString()
        speed.text = pokemon.speed.toString()


    }
}
