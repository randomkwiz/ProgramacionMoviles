package es.iesnervion.avazquez.recyclerviewkotlin.Utilidades

import android.content.Context
import es.iesnervion.avazquez.recyclerviewkotlin.Clases.Movimiento
import es.iesnervion.avazquez.recyclerviewkotlin.Clases.Pokemon

import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader

import java.io.InputStream

class Utilidad {


    fun crearArrayListTodosLosPokemon(contexto: Context): ArrayList<Pokemon> {


        //saco el json
        var cadenaJson: String? = readJSONFromAsset(contexto, "pokedex.json")

        var listaPokemon: ArrayList<Pokemon> = ArrayList()
        var objetoJSON: JSONObject

        //saco el array del json
        var arrayJSON = JSONArray(cadenaJson)

        var cadenaImagen = "img_pkmn_"
        var idImagen: Int
        var nuevoPokemon: Pokemon
        for(i in 0 until arrayJSON.length()){

            var itemArray = arrayJSON[i].toString() //saco el elemento del array (en forma de cadena)

            objetoJSON = JSONObject(itemArray)      //saco el objeto de la cadena json previamente separada

            //formo el nombre correcto de la imagen y extraigo su ID
            idImagen = contexto.resources.getIdentifier(cadenaImagen+(i+1), "drawable","es.iesnervion.avazquez.recyclerviewkotlin" )

            //creo el nuevo pokemon con su imagen y su objeto json
            nuevoPokemon = Pokemon(objetoJSON, idImagen )

            //lo añado a la lista
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


        var arrayJSON = JSONArray(cadenaJson)   //extraigo el array principal del JSON
        var movimiento: Movimiento

        for(i in 0 until arrayJSON.length()){

            var itemArray = arrayJSON[i].toString() //extraigo el elemento del array
            objetoJSON = JSONObject(itemArray)      //le saco el objeto al elemento
            movimiento= Movimiento(objetoJSON)      //instancio el movimiento con ese objeto

            listaMovimientos.add(movimiento)        //lo añado a la lista

        }


        return listaMovimientos
    }


    /*
    * Signatura: fun readJSONFromAsset(contexto: Context, filename:String): String?
    * Comentario: Extrae el contenido de un fichero localizado en assets y lo devuelve como cadena
    * Precondiciones: El archivo debe estar en la carpeta Assets
    * Entradas: Contexto, nombre del fichero
    * Salidas: cadena con el contenido del fichero
    * Postcondiciones: Asociado al nombre devuelve una cadena con el contenido del fichero pasado como parametro de entrada
    * */

    fun readJSONFromAsset(contexto: Context, filename:String): String? {
        var json: String? = null
        try {

            val  inputStream: InputStream = contexto.assets.open(filename)
            json = inputStream.
                        bufferedReader()
                        .use(BufferedReader::readText)
                    //kotlin te permite hacer esto pa leer rapido y fasi de un archivo



        } catch (ex: Exception) {
            ex.printStackTrace()
        }
        return json
    }


}