package es.iesnervion.avazquez.recyclerviewkotlin.Clases

import org.json.JSONObject
import java.io.Serializable



class Pokemon (id:Int, name: String, tipo1: String, tipo2: String,
               hp:Int, attack:Int, defense:Int, spAttack:Int,
               spDefense:Int, speed:Int, img: Int
)
    :Serializable  //tiene que ser serializable pa poder hacer lo del json

{
    val id : Int = id
    val name: String = name
    val tipo1: String = tipo1
    val tipo2:String = tipo2
    val hp: Int = hp
    val attack: Int = attack
    val defense: Int = defense
    val spAttack: Int = spAttack
    val spDefense: Int = spDefense
    val speed: Int = speed
    var img: Int = img

    /*constructor secundario por si el pokemon no tiene segundo tipo*/

    constructor(id:Int, name: String, tipo1: String,
                hp:Int, attack:Int, defense:Int, spAttack:Int,
                spDefense:Int, speed:Int, img: Int ):
            this(id, name, tipo1, "", hp, attack, defense, spAttack, spDefense, speed, img)

    /*Constructor para JSON*/

    constructor(objetoJSON: JSONObject, img:Int):
            this(objetoJSON.getInt("id"),
                objetoJSON.getJSONObject("name").getString("english"),
                objetoJSON.getJSONArray("type")[0].toString(),
               //arreglar esto, que ahora mismo solo pilla un tipo
                objetoJSON.getJSONObject("base").getInt("HP"),
                objetoJSON.getJSONObject("base").getInt("Attack"),
                objetoJSON.getJSONObject("base").getInt("Defense"),
                objetoJSON.getJSONObject("base").getInt("Sp. Attack"),
                objetoJSON.getJSONObject("base").getInt("Sp. Defense"),
                objetoJSON.getJSONObject("base").getInt("Speed"),
                img
            )



}