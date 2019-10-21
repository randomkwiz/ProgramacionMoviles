package es.iesnervion.avazquez.recyclerviewkotlin.Clases

import org.json.JSONObject

class Movimiento (tipo:String, precision: Int, ename:String, potencia: Int, pp:Int){
    val tipo: String = tipo
    val precision: Int = precision
    val ename:String = ename
    val potencia: Int = potencia
    val pp: Int = pp

    constructor(objeto: JSONObject):
            this(
        objeto.getString("type"),
                0,
       // objeto.getInt("accuracy"),
        objeto.getString("ename"),
                0,
        //objeto.getInt("power"),   //hay veces que power es null (ataques de estado)
                0
        //objeto.getInt("pp")
        )

}