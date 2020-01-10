package es.iesnervion.avazquez.ejemplokotlinretrofit2.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView

import es.iesnervion.avazquez.ejemplokotlinretrofit2.R
import es.iesnervion.avazquez.ejemplokotlinretrofit2.viewModel.SharedViewModel

class BreedListFragment : Fragment() {

    lateinit var viewModel : SharedViewModel
    lateinit var listView: ListView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View = inflater.inflate(R.layout.fragment_breed_list, container, false)

        listView = view.findViewById(R.id.listViewRazas)
        val listaRazas = arrayListOf<String>("akita","husky","labrador","malamute")
        var adapter = ArrayAdapter(activity,
            android.R.layout.simple_list_item_1, 
            listaRazas)
        listView.adapter = adapter



        return view
    }


}
