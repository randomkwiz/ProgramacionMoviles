package es.iesnervion.avazquez.fragmentslivedatakotlin.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import es.iesnervion.avazquez.fragmentslivedatakotlin.viewmodel.SharedViewModel
import java.nio.channels.Selector

class WallFragment : Fragment() {

    private lateinit var itemSelector: Selector
    private lateinit var model: SharedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        model = activity?.run {
            ViewModelProviders.of(this).get(SharedViewModel::class.java)
        } ?: throw Exception("Invalid Activity")
        itemSelector.setOnClickListener { item ->
            model.data.value = item
        }
    }
}

