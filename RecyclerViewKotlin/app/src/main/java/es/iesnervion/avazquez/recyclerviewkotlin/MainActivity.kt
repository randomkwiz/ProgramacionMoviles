package es.iesnervion.avazquez.recyclerviewkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import es.iesnervion.avazquez.recyclerviewkotlin.Actividades.Lista

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener

{

    private val elementos:Array<String> = arrayOf("Pokemon", "Movimientos", "Items")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val lista: ListView = findViewById(R.id.listviewMenuPrincipal)
        val arrayAdapter: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, elementos)
        lista.adapter = arrayAdapter

        lista.onItemClickListener = this
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val intent = Intent(this, Lista::class.java)

        if(position == 0) {
            startActivity(intent)
        }

    }
}
