package es.iesnervion.avazquez.recyclerviewkotlin.Utilidades

import es.iesnervion.avazquez.recyclerviewkotlin.Clases.Pokemon
import es.iesnervion.avazquez.recyclerviewkotlin.R
import org.json.JSONArray
import org.json.JSONObject

class Utilidad {


    fun crearArrayListTodosLosPokemon(): ArrayList<Pokemon> {
        //var cadenaJson: String = R.string.json.toString()
        var listaPokemon: ArrayList<Pokemon> = ArrayList()
        var objetoJSON: JSONObject

       // var arrayJSON: JSONArray = JSONArray(cadenaJson)
        for(x in 0 .. 1000) {
            listaPokemon.add(
                Pokemon(
                    6,
                    "Charizard",
                    "Fire",
                    "Flying",
                    78,
                    84,
                    78,
                    109,
                    85,
                    100,
                    R.drawable.img_pkmn_006
                )
            )
        }
/*
        for(i in 0 until arrayJSON.length()){
            var itemArray = arrayJSON[i].toString()

            objetoJSON = JSONObject(itemArray)

            var nuevoPokemon: Pokemon = Pokemon(objetoJSON, R.drawable.img_pkmn_006)
            listaPokemon.add(nuevoPokemon)

        }
*/



        return listaPokemon
    }




}