package es.iesnervion.avazquez.fragmentslivedatakotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import es.iesnervion.avazquez.fragmentslivedatakotlin.viewmodel.SharedViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProviders.of(this).get(SharedViewModel::class.java)
        viewModel.data.observe(this, Observer {

        })
    }
}
