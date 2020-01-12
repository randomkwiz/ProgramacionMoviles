package es.iesnervion.avazquez.ejemplokotlinretrofit2.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import es.iesnervion.avazquez.ejemplokotlinretrofit2.entities.Perrete
import es.iesnervion.avazquez.ejemplokotlinretrofit2.interfaces.PerroInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SharedViewModel : ViewModel() {
    private var fotos : MutableLiveData<ArrayList<String>>
    private var razaElegida : MutableLiveData<String>

    init{
        this.razaElegida = MutableLiveData()
        this.fotos = MutableLiveData()
    }

    fun setRazaElegida(razaElegida :String){
        this.razaElegida.value = razaElegida
        cargarFotos()
    }

    fun getRazaElegida() : MutableLiveData<String>{
        return this.razaElegida
    }


    fun getURLsFotos(): ArrayList<String> {

//        if(this.fotos.value != null && this.fotos.value!!.size > 0){
//            this.fotos.value = ArrayList()
//        }

        this.fotos.value = arrayListOf( "https://images.dog.ceo/breeds/hound-afghan/n02088094_1003.jpg",
            "https://images.dog.ceo/breeds/hound-afghan/n02088094_1007.jpg",
            "https://images.dog.ceo/breeds/hound-afghan/n02088094_1023.jpg",
            "https://images.dog.ceo/breeds/hound-afghan/n02088094_10263.jpg",
            "https://images.dog.ceo/breeds/hound-afghan/n02088094_10715.jpg",
            "https://images.dog.ceo/breeds/hound-afghan/n02088094_10822.jpg")
        return this.fotos.value!!
    }

    fun getMutableLiveDataFotos() : MutableLiveData<ArrayList<String>>{
        return this.fotos
    }

    private fun cargarFotos() {
        /*Aqui hago lo de la API*/
        var retrofit : Retrofit =
            Retrofit.Builder()
                .baseUrl("https://dog.ceo/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        var perroInterface = retrofit.create(PerroInterface::class.java)

        var call: Call<Perrete> = perroInterface.getFotosDeRaza(razaElegida.value!!)

        call.enqueue(object : Callback<Perrete> {
            override fun onFailure(call: Call<Perrete>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<Perrete>, response: Response<Perrete>) {
                fotos.value = ArrayList(response.body()?.fotos!!)
            }
        })






    }



}