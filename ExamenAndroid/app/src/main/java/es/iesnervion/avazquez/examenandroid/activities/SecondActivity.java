package es.iesnervion.avazquez.examenandroid.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.ToggleButton;

import java.util.ArrayList;

import es.iesnervion.avazquez.examenandroid.R;
import es.iesnervion.avazquez.examenandroid.Utilidad;
import es.iesnervion.avazquez.examenandroid.adapters.ProductosAdapter;
import es.iesnervion.avazquez.examenandroid.entities.Impresora;
import es.iesnervion.avazquez.examenandroid.entities.Ordenador;
import es.iesnervion.avazquez.examenandroid.entities.ProductoInformatico;
import es.iesnervion.avazquez.examenandroid.viewModel.SecondViewModel;

public class SecondActivity extends AppCompatActivity implements
        AdapterView.OnItemClickListener, View.OnClickListener {

    SecondViewModel viewModel;
    ListView lista;
    RadioGroup radioGroupFiltrarCPU;
    ImageView imgProducto;
    ImageView imgCPU;
    ToggleButton stock;
    EditText editTextNombre;
    Button btnGuardar;
    Button btnAnterior;
    Button btnSiguiente;
    ArrayList<ProductoInformatico> listaElementos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        final Utilidad utilidad = new Utilidad();
        Intent intent = getIntent();
        viewModel = ViewModelProviders.of(this).get(SecondViewModel.class);

        viewModel.setOpcionElegida(intent.getStringExtra("elementoElegido"));
        lista = findViewById(R.id.lista);

        radioGroupFiltrarCPU = findViewById(R.id.RGfiltrarCPU);
        imgProducto = findViewById(R.id.imgproducto);
        imgCPU = findViewById(R.id.imgCPU);
        stock = findViewById(R.id.Toggdisponibilidad);
        editTextNombre = findViewById(R.id.ETnombre);
        btnGuardar = findViewById(R.id.btnGuardarNombre);
        btnAnterior = findViewById(R.id.btnAnterior);
        btnSiguiente = findViewById(R.id.btnSiguiente);

        listaElementos = viewModel.getListaProductos().getValue();

        final ProductosAdapter productosAdapter = new ProductosAdapter(this,
                listaElementos);



        //El observer de la lista
        final Observer<ArrayList<ProductoInformatico>> listObserver =
                new Observer<ArrayList<ProductoInformatico>>() {
            @Override
            public void onChanged(ArrayList<ProductoInformatico> list) {
                //Actualizar la UI
                lista.invalidate(); //Se tiene que poner esto
                ProductosAdapter productosAdapter2 = new ProductosAdapter(getApplicationContext(),
                        viewModel.getListaProductos().getValue());
                lista.setAdapter(productosAdapter2);

            }
        };

        //lista.setAdapter(productosAdapter);
        //Observo el LiveData con ese observer que acabo de crear
        viewModel.getListaProductos().observe(this, listObserver);

        lista.setOnItemClickListener(this);


        if(viewModel.getProductoSeleccionado().getValue() != null){

            if(viewModel.getProductoSeleccionado().getValue() instanceof Ordenador){
                imgCPU.setVisibility(View.VISIBLE);
                imgCPU.setImageResource(((Ordenador)viewModel.getProductoSeleccionado().getValue()).getImgCPU());
            }else{
                imgCPU.setVisibility(View.INVISIBLE);
            }
            imgProducto.setImageResource(viewModel.getProductoSeleccionado().getValue().getImgSrcProducto());
            stock.setChecked(viewModel.getProductoSeleccionado().getValue().isInStock());


            /*Si el valor del toggle es diferente al que tiene el elemento seleccionado,
             * deberá cambiarse el valor del elemento seleccionado */
            if(stock.isChecked() != viewModel.getProductoSeleccionado().getValue().isInStock()){
                int posicion = utilidad.obtenerPosicionPorIDEnLista(viewModel.getListaProductos().getValue(),
                        viewModel.getProductoSeleccionado().getValue().getId());
                boolean nuevoValor = stock.isChecked();
                viewModel.getListaProductos().getValue().get(posicion).setInStock(nuevoValor);
            }

        }


        //El observer del elemento seleccionado
        final Observer<ProductoInformatico> elementObserver = new Observer<ProductoInformatico>() {
            @Override
            public void onChanged(ProductoInformatico elemento) {
                //Actualizar la UI
                if(viewModel.getProductoSeleccionado().getValue() != null){

                    if(viewModel.getProductoSeleccionado().getValue() instanceof Ordenador){
                        imgCPU.setVisibility(View.VISIBLE);
                        imgCPU.setImageResource(((Ordenador)viewModel.getProductoSeleccionado().getValue()).getImgCPU());
                    }else{
                        imgCPU.setVisibility(View.INVISIBLE);
                    }
                    imgProducto.setImageResource(viewModel.getProductoSeleccionado().getValue().getImgSrcProducto());
                    stock.setChecked(viewModel.getProductoSeleccionado().getValue().isInStock());
                    Utilidad utilidad = new Utilidad();

                    /*Si el valor del toggle es diferente al que tiene el elemento seleccionado,
                     * deberá cambiarse el valor del elemento seleccionado */
                    if(stock.isChecked() != viewModel.getProductoSeleccionado().getValue().isInStock()){
                        int posicion = utilidad.obtenerPosicionPorIDEnLista(viewModel.getListaProductos().getValue(),
                                viewModel.getProductoSeleccionado().getValue().getId());
                        boolean nuevoValor = stock.isChecked();
                        viewModel.getListaProductos().getValue().get(posicion).setInStock(nuevoValor);
                    }
                }
            }
        };
//observo
        viewModel.getProductoSeleccionado().observe(this,elementObserver);



        switch (viewModel.getOpcionElegida().getValue()){
            case "Impresoras":
                //Se debe mostrar una lista de impresoras
                ArrayList<ProductoInformatico> listaImpresoras = utilidad.obtenerSoloImpresoras(viewModel.getListaProductos().getValue());
                listaElementos = listaImpresoras;
                //Como trabajamos con live data, con hacer esto ya se cambia solo
                viewModel.setListaProductos(listaElementos);
                //Por dentro se cambia pero la vista no se actualiza

                break;
            case "Portátiles":
                //Se debe mostrar una lista de portatiles
                ArrayList<ProductoInformatico> listaPC = utilidad.obtenerSoloOrdenadores(viewModel.getListaProductos().getValue());
                listaElementos = listaPC;
                viewModel.setListaProductos(listaElementos);
                //Por dentro se cambia pero la vista no se actualiza

                break;
            case "Todo":
                //Se debe mostrar lista het
                viewModel.cargarProductos();


                break;
        }



        radioGroupFiltrarCPU.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                switch (radioGroupFiltrarCPU.getCheckedRadioButtonId()){
                    case R.id.RBtodos:
                        viewModel.cargarProductos();
                        break;
                    case R.id.RBintel:

                        viewModel.setListaProductos(utilidad.eliminarAMD(viewModel.getListaProductos().getValue()));

                        break;
                    case R.id.RBamd:
                        viewModel.setListaProductos(utilidad.eliminarINTEL(viewModel.getListaProductos().getValue()));

                        break;
                }
            }
        });



        btnGuardar.setOnClickListener(this);
        btnAnterior.setOnClickListener(this);
        btnSiguiente.setOnClickListener(this);




    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if(i >= 0){
            this.viewModel.setProductoSeleccionado(viewModel.getListaProductos().getValue().get(i));
        }

    }

    @Override
    public void onClick(View view) {
        Utilidad utilidad = new Utilidad();


        int posicionActual = utilidad.obtenerPosicionPorIDEnLista(viewModel.getListaProductos().getValue(),
                viewModel.getProductoSeleccionado().getValue().getId());

        //ProductoInformatico producto ;

        switch (view.getId()){
            case R.id.btnAnterior:
                if(posicionActual>0){
                    viewModel.setProductoSeleccionado(viewModel.getListaProductos().getValue().get(posicionActual-1));
                }
                //Si la posicion actual es 0, no se podra ir atras

                break;
            case R.id.btnGuardarNombre:
                int posicion = utilidad.obtenerPosicionPorIDEnLista(viewModel.getListaProductos().getValue(),
                        viewModel.getProductoSeleccionado().getValue().getId());
                String nuevoNombre = editTextNombre.getText().toString();
                viewModel.getListaProductos().getValue().get(posicion).setNombreProducto(nuevoNombre);
                viewModel.getProductoSeleccionado().getValue().setNombreProducto(nuevoNombre);

                //Esto es una prueba
//                listaElementos.add(new Ordenador(5, false, R.drawable.acera515, "NuevoPC", R.drawable.amd));
//                viewModel.setListaProductos(listaElementos);
                break;
            case R.id.btnSiguiente:
                if(posicionActual < viewModel.getListaProductos().getValue().size()-1){
                    //producto = viewModel.getListaProductos().getValue().get(posicionActual+1);
                    //viewModel.setProductoSeleccionado(producto);

                    viewModel.setProductoSeleccionado(viewModel.getListaProductos().getValue().get(posicionActual+1));

                }
                //Si la posicion actual es la ultima, no podra ir adelante

                break;
        }
    }
}
