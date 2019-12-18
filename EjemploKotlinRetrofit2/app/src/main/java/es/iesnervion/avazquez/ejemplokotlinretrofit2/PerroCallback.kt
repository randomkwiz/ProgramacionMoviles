package es.iesnervion.avazquez.ejemplokotlinretrofit2

import android.util.Log
import androidx.lifecycle.ViewModelProviders
import com.google.gson.Gson
import es.iesnervion.avazquez.ejemplokotlinretrofit2.activities.MainActivity
import es.iesnervion.avazquez.ejemplokotlinretrofit2.entities.Perrete
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PerroCallback : Callback<Perrete> {

    override fun onFailure(call: Call<Perrete>, t: Throwable) {
        t?.printStackTrace()
    }

    override fun onResponse(call: Call<Perrete>, response: Response<Perrete>) {
        var perro : Perrete?
        perro = response?.body()
        val TAG_LOGS = "estoEsElJSON"
        if(response.isSuccessful){
            if(perro != null){
                Log.i(TAG_LOGS, Gson().toJson(perro))
            }else{
                Log.i(TAG_LOGS, response.message())
            }

        }else{
            Log.i(TAG_LOGS, response.message())
        }


    }
}