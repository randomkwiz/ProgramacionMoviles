package es.iesnervion.avazquez.fragmentslivedatakotlin.fragments

import android.content.ClipData.Item
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import es.iesnervion.avazquez.fragmentslivedatakotlin.viewmodel.SharedViewModel

class WallDetailFragment : Fragment() {
    private lateinit var model: SharedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        model = activity?.run {
            ViewModelProviders.of(this).get(SharedViewModel::class.java)
        } ?: throw Exception("Invalid Activity")
        model.data.observe(this, Observer<Item> { item ->
            // Update the UI
        })
    }
}