package es.iesnervion.avazquez.ejemplokotlinretrofit2.activities

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import es.iesnervion.avazquez.ejemplokotlinretrofit2.PerroCallback
import es.iesnervion.avazquez.ejemplokotlinretrofit2.R
import es.iesnervion.avazquez.ejemplokotlinretrofit2.entities.Perrete
import es.iesnervion.avazquez.ejemplokotlinretrofit2.interfaces.PerroInterface
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    lateinit var retrofit: Retrofit
    lateinit var perroInterface: PerroInterface
    lateinit var respuesta : Response<Perrete>
    lateinit var texto : TextView
    lateinit var mensaje : String
    lateinit var perroCallback : PerroCallback
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        texto = findViewById(R.id.txt)
        retrofit =
        Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/breeds/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        perroInterface = retrofit.create(PerroInterface::class.java)
        perroCallback = PerroCallback()

        perroInterface.getListadoRazasExistentes().enqueue(perroCallback)







    }


}
