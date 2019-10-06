package es.iesnervion.avazquez.juegoencontrarparejas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CardsAdapter extends BaseAdapter {

/*
El adaptador actua de intermediario entre el GridView y la fuente de datos.
Carga la información que será mostrada en el gridview desde una fuente de datos,
como un array o una consulta de bbdd, luego crea una vista para cada elemento.
 */

    private final Context context;
    private final Card[] cards;


    //constructor
    public CardsAdapter (Context context, Card[] cards){
        this.context = context;
        this.cards = cards;
    }

    public Context getContext() {
        return context;
    }

    //You return the number of cells to render here.
    @Override
    public int getCount() {
        return cards.length;
    }

    //No lo necesitaremos así que por eso ponemos 0 y null
    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        // 1 -pillamos la carta por la posicion
        final Card card = cards[position];

        // 2 -Si la vista es nula, la "infla" (le dice como ponerse) con el XML que he creado exclusivo para la
        // carta.
        if (view == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            view = layoutInflater.inflate(R.layout.linearlayout_card, null);
        }

        // 3 - Creamos las referencias
        final ImageView imagenCarta = (ImageView)view.findViewById(R.id.cardImg);
        final TextView nombreCarta = (TextView)view.findViewById(R.id.cardName);
        final ImageView imagenCartaTapada = (ImageView)view.findViewById(R.id.cardImgTapada);

        // 4 - Establecemos la imagen y el nombre de la carta con las referencias
        // anteriores
        imagenCarta.setImageResource(card.getImageResource());
        nombreCarta.setText(getContext().getString(card.getName()));

        if(cards[position].isFlipped()){
            //asi esta destapada (se ve la carta)
           imagenCartaTapada.setVisibility(View.INVISIBLE);

        }else{
            //asi esta tapada (se ve negro)
            imagenCartaTapada.setVisibility(View.VISIBLE);
        }

        return view;
    }
}
