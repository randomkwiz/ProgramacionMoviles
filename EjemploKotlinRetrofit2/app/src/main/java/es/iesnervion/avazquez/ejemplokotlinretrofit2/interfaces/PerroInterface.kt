package es.iesnervion.avazquez.ejemplokotlinretrofit2.interfaces

import es.iesnervion.avazquez.ejemplokotlinretrofit2.entities.Perrete
import retrofit2.http.GET
import retrofit2.Call;

interface PerroInterface {
    @GET("/list/all")
    fun getListadoRazasExistentes() : Call<Perrete> //no devuelve una lista, cuidao! devuelve un solo objeto!
}