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
The adapter acts as the middleman between the GridView and the data source.
It loads the information to be displayed in your grid view from a data source,
such as an array or database query, then creates a view for each item.
-----------------
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

    //No lo necesitaremos así que por eso ponemos  y null
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
        // 1 You find the proper card for this cell by using the position index.
        final Card card = cards[position];

        // 2 GridView optimizes memory usage by recycling the cells.
        // This means that if view is null, you instantiate a new cell view
        // by using a LayoutInflater and inflating your linear layout card layout.
        if (view == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            view = layoutInflater.inflate(R.layout.linearlayout_card, null);
        }

        // 3 You create references for each individual view you created in your XML layout file.
        final ImageView imagenCarta = (ImageView)view.findViewById(R.id.cardImg);
        final TextView nombreCarta = (TextView)view.findViewById(R.id.cardName);
        final ImageView imagenCartaTapada = (ImageView)view.findViewById(R.id.cardImgTapada);

        // 4 You set the card's img and name using the above references.
        imagenCarta.setImageResource(card.getImageResource());
        nombreCarta.setText(getContext().getString(card.getName()));

        if(cards[position].isFlipped()){
            //esta destapada
           imagenCartaTapada.setVisibility(View.INVISIBLE);

        }else{
            //esta tapada
            imagenCartaTapada.setVisibility(View.VISIBLE);
        }

        return view;
    }
}
