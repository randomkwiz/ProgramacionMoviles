package es.iesnervion.avazquez.ejerciciolistanba_1.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import es.iesnervion.avazquez.ejerciciolistanba_1.Clases.EmpresaImpl
import es.iesnervion.avazquez.ejerciciolistanba_1.R
import es.iesnervion.avazquez.ejerciciolistanba_1.Utilidades.EmpresaAdapter

class MainActivity : AppCompatActivity() {


    /*lateinit es pa que se inicialice mas tarde y estas seguro que
    * no va a tener un valor de null*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listView = findViewById<ListView>(R.id.listviewNBA)

        var listaEmpresas = ArrayList<EmpresaImpl>()
        listaEmpresas.add(EmpresaImpl("Twitter", R.drawable.twitter))
        listaEmpresas.add(EmpresaImpl("Youtube", R.drawable.youtube))
        listaEmpresas.add(EmpresaImpl("Facebook", R.drawable.facebook))
        listaEmpresas.add(EmpresaImpl("Instagram", R.drawable.instagram))
        listaEmpresas.add(EmpresaImpl("Google", R.drawable.google))
        for(x in 0 .. 1000 )   //incluye el 0 y el 10
            listaEmpresas.add(EmpresaImpl("Empresa"))


        val adaptador = EmpresaAdapter(listaEmpresas, this)

        //relaciono la listView con el arraylist creado
        listView.adapter = adaptador


    }
}
