package es.iesnervion.avazquez.recyclerviewkotlin.Utilidades

import android.content.Context
import es.iesnervion.avazquez.recyclerviewkotlin.Clases.Movimiento
import es.iesnervion.avazquez.recyclerviewkotlin.Clases.Pokemon

import org.json.JSONArray
import org.json.JSONObject

import java.io.InputStream

class Utilidad {


    fun crearArrayListTodosLosPokemon(contexto: Context): ArrayList<Pokemon> {


        var cadenaJson: String? = readJSONFromAsset(contexto, "pokedex.json")


        var listaPokemon: ArrayList<Pokemon> = ArrayList()
        var objetoJSON: JSONObject

        var arrayJSON: JSONArray = JSONArray(cadenaJson)

        var cadenaImagen: String = "img_pkmn_"
        var idImagen: Int
        var nuevoPokemon: Pokemon
        for(i in 0 until arrayJSON.length()){
            var itemArray = arrayJSON[i].toString()

            objetoJSON = JSONObject(itemArray)
            idImagen = contexto.resources.getIdentifier(cadenaImagen+(i+1), "drawable","es.iesnervion.avazquez.recyclerviewkotlin" )
            nuevoPokemon = Pokemon(objetoJSON, idImagen )
            listaPokemon.add(nuevoPokemon)

        }




        return listaPokemon
    }


    fun crearArrayListTodosLosItems(contexto: Context): ArrayList<String> {

        var cadenaJson: String? = readJSONFromAsset(contexto, "items.json")

        var listaItems: ArrayList<String> = ArrayList()
        var objetoJSON: JSONObject

        var arrayJSON: JSONArray = JSONArray(cadenaJson)


        for(i in 1 until arrayJSON.length()){   //empieza en 1 porque en el archivo de los items, el primero es "ningun objeto" xD
            var itemArray = arrayJSON[i].toString()

            objetoJSON = JSONObject(itemArray)

            var objetoItem: JSONObject = objetoJSON.getJSONObject("name")

            var nombreItem = objetoItem.get("english").toString()


            listaItems.add(nombreItem)

        }


        return listaItems
    }


    fun crearArrayListTodosLosMovimientos(contexto: Context): ArrayList<Movimiento> {

        var cadenaJson: String = readJSONFromAsset(contexto, "moves.json")!!



        var listaMovimientos: ArrayList<Movimiento> = ArrayList()
        var objetoJSON: JSONObject

        var arrayJSON = JSONArray(cadenaJson)
        var movimiento: Movimiento

        for(i in 0 until arrayJSON.length()){
            var itemArray = arrayJSON[i].toString()



            objetoJSON = JSONObject(itemArray)
            movimiento= Movimiento(objetoJSON)

            listaMovimientos.add(movimiento)

        }


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