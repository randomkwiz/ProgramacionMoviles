package es.iesnervion.avazquez.ejemplokotlinretrofit2.interfaces

import es.iesnervion.avazquez.ejemplokotlinretrofit2.entities.Perrete
import retrofit2.http.GET
import retrofit2.Call;
import retrofit2.http.Path

interface PerroInterface {
    @GET("/api/breed/{raza_perro}/images")
    fun getFotosDeRaza(@Path(value = "raza_perro") raza_perro:String) : Call<Perrete>

}