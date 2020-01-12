package es.iesnervion.avazquez.ejemplokotlinretrofit2.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView

import es.iesnervion.avazquez.ejemplokotlinretrofit2.R
import es.iesnervion.avazquez.ejemplokotlinretrofit2.adapter.ImageAdapter
import es.iesnervion.avazquez.ejemplokotlinretrofit2.viewModel.SharedViewModel

/**
 * A simple [Fragment] subclass.
 */
class ImageListFragment : Fragment() {

    lateinit var viewModel : SharedViewModel
    lateinit var recyclerViewImagenes : RecyclerView
    lateinit var listadoURLs : ArrayList<String>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

            // Inflate the layout for this fragment
            val view = inflater.inflate(R.layout.fragment_image_list, container, false)
            viewModel = ViewModelProviders.of(activity!!).get(SharedViewModel::class.java)

            recyclerViewImagenes = view!!.findViewById(R.id.recyclerViewImagenes)
            //recyclerViewImagenes.adapter = RecyclerAdapter(viewModel.getURLsFotos(), activity!!)
        recyclerViewImagenes.adapter = ImageAdapter()

/*

        // Create the observer which updates the UI.
        val razaElegidaObserver = Observer<ArrayList<String>> { observer ->
            // Update the UI
            //recyclerViewImagenes.adapter = RecyclerAdapter(viewModel.getURLsFotos(), activity!!)
            recyclerViewImagenes.adapter = ImageAdapter()
        }

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        viewModel.getMutableLiveDataFotos().observe(this, razaElegidaObserver)

*/

        return view
    }


}
