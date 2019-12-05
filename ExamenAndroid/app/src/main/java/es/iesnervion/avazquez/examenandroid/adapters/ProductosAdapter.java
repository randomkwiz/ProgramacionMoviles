package es.iesnervion.avazquez.examenandroid.adapters;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import es.iesnervion.avazquez.examenandroid.R;
import es.iesnervion.avazquez.examenandroid.entities.Impresora;
import es.iesnervion.avazquez.examenandroid.entities.Ordenador;
import es.iesnervion.avazquez.examenandroid.entities.ProductoInformatico;
import es.iesnervion.avazquez.examenandroid.viewHolder.ViewHolderImpresora;
import es.iesnervion.avazquez.examenandroid.viewHolder.ViewHolderOrdenador;

public class ProductosAdapter extends BaseAdapter {

    Context context;
    ArrayList<ProductoInformatico> listaProductos;


    public ProductosAdapter(Context context, ArrayList<ProductoInformatico> listaProductos) {
        this.context = context;
        this.listaProductos = listaProductos;

    }

    @Override
    public int getCount() {
        return listaProductos.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    /*
     * Devuelve 0 si es tipo impresora
     * devuelve 1 si es tipo ordenador
     * el elemento de la lista de la posicion 'position'
     * */
    @Override
    public int getItemViewType(int position) {
        int tipo = -1;

        //Lo hago asi por si en un futuro hay mas tipos
        if(listaProductos.get(position) instanceof Impresora){
            tipo = 0;   //es impresora
        }else if (listaProductos.get(position) instanceof Ordenador){
            tipo = 1;
        }

        return tipo;
    }

    /*Devuelve la cantidad de tipos diferentes que hay, en este caso son dos
     * elementos diferentes.
     * Es como un array, 0 y 1.*/
    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ProductoInformatico productoInformatico = listaProductos.get(position);
        ViewHolderOrdenador viewHolderOrdenador = null;
        ViewHolderImpresora viewHolderImpresora = null;


        if(convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            if(getItemViewType(position) == 0)  //es impresora
            {
                convertView = inflater.inflate(R.layout.fila_impresora, parent, false);

                //Creamos referencias

                ImageView imgStock = (ImageView) convertView.findViewById(R.id.imgDisponibilidadImpr);
                ImageView imgImpresora = (ImageView) convertView.findViewById(R.id.imgImpr);
                TextView nombreImpresora = (TextView) convertView.findViewById(R.id.TVnombreImpr);
                TextView tipoImpresora = (TextView) convertView.findViewById(R.id.TVtipoImpr);

                //Le ponemos esas referencias al product actual
                imgStock.setImageResource(productoInformatico.getImgSrcIsEnStock());
                imgImpresora.setImageResource(productoInformatico.getImgSrcProducto());
                nombreImpresora.setText(productoInformatico.getNombreProducto());
                tipoImpresora.setText(((Impresora)productoInformatico).getTipoImpresion());


                viewHolderImpresora = new ViewHolderImpresora(
                        imgStock,imgImpresora, nombreImpresora, tipoImpresora);



                convertView.setTag(viewHolderImpresora);


            }else if(getItemViewType(position) == 1) { //es un pc
                convertView = inflater.inflate(R.layout.fila_ordenador, parent, false);


                //Creamos referencias

                ImageView imgStock = (ImageView) convertView.findViewById(R.id.imgDisponibilidadOrd);
                ImageView imgPC = (ImageView) convertView.findViewById(R.id.imgOrd);
                TextView nombrePC = (TextView) convertView.findViewById(R.id.TVnombreOrd);
                ImageView imgCPU = (ImageView) convertView.findViewById(R.id.imgCPU);

                //Le ponemos esas referencias al product actual
                imgStock.setImageResource(productoInformatico.getImgSrcIsEnStock());
                imgPC.setImageResource(productoInformatico.getImgSrcProducto());
                nombrePC.setText(productoInformatico.getNombreProducto());
                imgCPU.setImageResource(((Ordenador)productoInformatico).getImgCPU());


                viewHolderOrdenador = new ViewHolderOrdenador(
                        imgStock,imgPC, nombrePC, imgCPU);



                convertView.setTag(viewHolderOrdenador);


            }

        }else{
            if(getItemViewType(position) == 0){ //impr

                viewHolderImpresora = (ViewHolderImpresora) convertView.getTag();


            }else if (getItemViewType(position) == 1){  //pc


                viewHolderOrdenador = (ViewHolderOrdenador) convertView.getTag();
            }

            //Actualizamos los elementos

            if(getItemViewType(position) == 0){ //impr
                viewHolderImpresora.getDisponibilidad().setImageResource(productoInformatico.getImgSrcIsEnStock());
                viewHolderImpresora.getImgImpr().setImageResource(productoInformatico.getImgSrcProducto());
                viewHolderImpresora.getTxtNombreImpr().setText(productoInformatico.getNombreProducto());
                viewHolderImpresora.getTxtTipoImpr().setText(((Impresora)productoInformatico).getTipoImpresion());

            }else if (getItemViewType(position) == 1){  //pc
                viewHolderOrdenador.getDisponibilidad().setImageResource(productoInformatico.getImgSrcIsEnStock());
                viewHolderOrdenador.getImgOrd().setImageResource(productoInformatico.getImgSrcProducto());
                viewHolderOrdenador.getTxtNombreOrd().setText(productoInformatico.getNombreProducto());
                viewHolderOrdenador.getImgCPU().setImageResource(((Ordenador)productoInformatico).getImgCPU());

            }


        }

        return convertView;
    }
}
