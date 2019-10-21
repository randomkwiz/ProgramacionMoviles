package es.iesnervion.avazquez.recyclerviewkotlin.Utilidades

import android.content.Context
import es.iesnervion.avazquez.recyclerviewkotlin.Clases.Pokemon
import es.iesnervion.avazquez.recyclerviewkotlin.R
import org.json.JSONArray
import org.json.JSONObject
import java.io.File
import java.io.InputStream
import java.nio.charset.Charset

class Utilidad {


    fun crearArrayListTodosLosPokemon(contexto: Context): ArrayList<Pokemon> {


        var cadenaJson: String? = readJSONFromAsset(contexto, "pokedex.json")


        var listaPokemon: ArrayList<Pokemon> = ArrayList()
        var objetoJSON: JSONObject

        var arrayJSON: JSONArray = JSONArray(cadenaJson)
/*
        for(pokemon in arrayJSON) {
            listaPokemon.add(
                Pokemon(arrayJSON.getJSONObject(pokemon), R.drawable.img_pkmn_001)
            )
        }

 */

        for(i in 0 until arrayJSON.length()){
            var itemArray = arrayJSON[i].toString()

            objetoJSON = JSONObject(itemArray)

            var nuevoPokemon: Pokemon = Pokemon(objetoJSON, R.drawable.prod)
            listaPokemon.add(nuevoPokemon)

        }




        return listaPokemon
    }


    fun crearArrayListTodosLosItems(contexto: Context): ArrayList<String> {

        var cadenaJson: String? = readJSONFromAsset(contexto, "items.json")

        var listaItems: ArrayList<String> = ArrayList()

        return listaItems
    }


    fun crearArrayListTodosLosMovimientos(contexto: Context): ArrayList<String> {

        var cadenaJson: String? = readJSONFromAsset(contexto, "moves.json")

        var listaMovimientos: ArrayList<String> = ArrayList()

        return listaMovimientos
    }


    fun readJSONFromAsset(contexto: Context, filename:String): String? {
        var json: String? = null
        try {
            val  inputStream: InputStream = contexto.assets.open(filename)
            json = inputStream.bufferedReader().use{it.readText()}
        } catch (ex: Exception) {
            ex.printStackTrace()
            return null
        }
        return json
    }


}