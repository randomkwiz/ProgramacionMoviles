package es.iesnervion.avazquez.ejemplokotlinretrofit2.entities

import com.google.gson.annotations.SerializedName

/*LAS DATA CLASS SON LA OCTAVA MARAVILLA DEL MUNDO */
data class Perrete (
    @SerializedName("status")   // @SerializedName indica el nombre exacto del valor que devuelve la API (se puede quitar si el nombre que tu le pones es el mismo)
    var exito:String,
    @SerializedName("message")
    var fotos: List<String>)