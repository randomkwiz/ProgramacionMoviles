package es.iesnervion.avazquez.ejemplokotlinretrofit2.activities

import android.os.Bundle
import android.widget.AbsListView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import es.iesnervion.avazquez.ejemplokotlinretrofit2.PerroCallback
import es.iesnervion.avazquez.ejemplokotlinretrofit2.R
import es.iesnervion.avazquez.ejemplokotlinretrofit2.entities.Perrete
import es.iesnervion.avazquez.ejemplokotlinretrofit2.fragments.BreedListFragment
import es.iesnervion.avazquez.ejemplokotlinretrofit2.interfaces.PerroInterface
import es.iesnervion.avazquez.ejemplokotlinretrofit2.viewModel.SharedViewModel
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
    lateinit var viewModel : SharedViewModel
    lateinit var listaRazasFragment : Fragment
    lateinit var listadoImagenesFragment : Fragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(SharedViewModel::class.java)
        listaRazasFragment = BreedListFragment()


//        retrofit =
//        Retrofit.Builder()
//            .baseUrl("https://dog.ceo/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//        perroInterface = retrofit.create(PerroInterface::class.java)
//        perroCallback = PerroCallback()

        //perroInterface.getListadoRazasExistentes().enqueue(perroCallback)



/*Mirar aquí: https://stackoverflow.com/questions/23120238/using-picasso-library-with-listview*/



    }


}
