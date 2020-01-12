package es.iesnervion.avazquez.ejemplokotlinretrofit2.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import es.iesnervion.avazquez.ejemplokotlinretrofit2.R
import es.iesnervion.avazquez.ejemplokotlinretrofit2.fragments.BreedListFragment
import es.iesnervion.avazquez.ejemplokotlinretrofit2.fragments.ImageListFragment
import es.iesnervion.avazquez.ejemplokotlinretrofit2.viewModel.SharedViewModel


class MainActivity : AppCompatActivity() {

    lateinit var viewModel : SharedViewModel
    lateinit var listaRazasFragment : Fragment
    lateinit var listadoImagenesFragment : Fragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
/*
        viewModel = ViewModelProviders.of(this).get(SharedViewModel::class.java)
*/
        /*Fragments*/
  //      listaRazasFragment = BreedListFragment()
        listadoImagenesFragment = ImageListFragment()
        var fm : FragmentManager = supportFragmentManager
        var fragmentTransaction : FragmentTransaction = fm.beginTransaction()

//        fragmentTransaction.replace(R.id.fragment, listaRazasFragment)
        fragmentTransaction.replace(R.id.fragment, listadoImagenesFragment)

        fragmentTransaction.commit()

/*
        // Create the observer which updates the UI.
        val razaElegidaObserver = Observer<String> { observer ->
            // Update the UI
            var fragmentTransaction : FragmentTransaction = fm.beginTransaction()

            fragmentTransaction.replace(R.id.fragment, listadoImagenesFragment).addToBackStack(null)

            fragmentTransaction.commit()
        }

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        viewModel.getRazaElegida().observe(this, razaElegidaObserver)


*/




    }


}
