package es.iesnervion.avazquez.juegoencontrarparejas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Card[] cards = {
            new Card(R.string.card1, R.drawable.intellij, 1),
            new Card(R.string.card2, R.drawable.intellij, 1),
            new Card(R.string.card3, R.drawable.androidstudio, 2),
            new Card(R.string.card4, R.drawable.androidstudio, 2),
            new Card(R.string.card5, R.drawable.angelagit, 3),
            new Card(R.string.card6, R.drawable.angelagit, 3),
            new Card(R.string.card7, R.drawable.geany, 4),
            new Card(R.string.card8, R.drawable.geany, 4),
            new Card(R.string.card9, R.drawable.sqlserver, 5),
            new Card(R.string.card10, R.drawable.sqlserver, 5),
            new Card(R.string.card11, R.drawable.vagrant, 6),
            new Card(R.string.card12, R.drawable.vagrant, 6),
            new Card(R.string.card13, R.drawable.visualstudio, 7),
            new Card(R.string.card14, R.drawable.visualstudio, 7),
            new Card(R.string.card15, R.drawable.github, 8),
            new Card(R.string.card16, R.drawable.github, 8)
    };

    Card primeraCarta;
    TextView textViewPuntuacion;
    boolean isPrimeraCarta = false;
    double puntuacion = 0;

    //se debe declarar como final para poderse usar en clases anidadas
    //lo pongo aqui porque tengo que acceder a cardsAdapter desde reiniciar()
    final CardsAdapter cardsAdapter = new CardsAdapter(this, cards);

    //esto lo necesito para mantener el estado de las cartas (giradas o no) al rotar
    private static final String imagenesGiradas = "imagenesGiradas";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView gridView = (GridView)findViewById(R.id.gridview);
        gridView.setAdapter(cardsAdapter);
        final Intent intent = new Intent(this, AnotherActivity.class);
        textViewPuntuacion = findViewById(R.id.puntuacion);

        //Problema: cada vez que giras la pantalla se ejecuta esto así que
        //se barajan las cartas cada vez aunque las que estén levantadas se mantienen levantadas
        barajarCartas();

        //ojitocuidao clase anidada
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                Card card = cards[position];
                //asi cuando la carta este con su pareja, ya no se pueden volver a girar
                if(!card.isEncontrada()){
                    card.girarCarta();
                    isPrimeraCarta = !isPrimeraCarta;
                    // This tells the GridView to redraw itself
                    // in turn calling your card adapter's getView method again for each cell
                    cardsAdapter.notifyDataSetChanged();
                    if (isPrimeraCarta) {
                        primeraCarta = card;
                        //textViewPuntuacion.setText("Puntos: "+String.valueOf(puntuacion));


                    }else if (isAMatch(primeraCarta, card)) {
                        puntuacion += 1.25;
                        primeraCarta.setEncontrada(true);
                        card.setEncontrada(true);
                        primeraCarta.setFlipped(true);
                        card.setFlipped(true);

                    }else if(!isPrimeraCarta && !isAMatch(primeraCarta, card)){
                        primeraCarta.setFlipped(false);
                        card.setFlipped(false);
                        cardsAdapter.notifyDataSetChanged();
                    }else{
                        card.girarCarta();
                        cardsAdapter.notifyDataSetChanged();

                    }
                    textViewPuntuacion.setText(getString(R.string.points)+ " "+String.valueOf(puntuacion));
                    if(puntuacion == 10){
                        startActivity(intent);

                    }
                }
            }
        });


    }

    //Esto es para guardar las cartas que han sido giradas al poner el modo landscape
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // construct a list of cards you've flipped
        final ArrayList<Integer> cartasGiradas = new ArrayList<>();
        for (Card card : cards) {
            if (card.isFlipped()) {
                cartasGiradas.add(card.getName());
            }
        }

        // save that list to outState for later
        outState.putIntegerArrayList(imagenesGiradas, cartasGiradas);
    }



    //To restore the selections when the activity is recreated
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // get our previously saved list of flipped cards
        final ArrayList<Integer> cartasGiradas =
                savedInstanceState.getIntegerArrayList(imagenesGiradas);

        // look at all of your cards and figure out which are the flipped
        for (int cardName : cartasGiradas) {
            for (Card card : cards) {
                if (card.getName() == cardName) {
                    card.setFlipped(true);
                    break;
                }
            }
        }
    }


    public void barajarCartas (){
        Random rgen = new Random();
        for (int i=0; i<cards.length; i++) {

            int randomPosition = rgen.nextInt(cards.length);

            Card temp = cards[i];

            cards[i] = cards[randomPosition];
            cards[randomPosition] = temp;
        }

    }

    public void reiniciar(View v){

        barajarCartas();
        girarTodasLasCartas(false);
        isPrimeraCarta = false;
        desparejarTodasLasCartas();
        cardsAdapter.notifyDataSetChanged();
        puntuacion = 0;
        textViewPuntuacion.setText(getString(R.string.points)+ " "+String.valueOf(puntuacion));


    }

    private void girarTodasLasCartas(boolean b) {
        for (int i=0; i<cards.length; i++) {
            cards[i].setFlipped(b);
        }

    }
    private void desparejarTodasLasCartas() {
        for (int i=0; i<cards.length; i++) {
            cards[i].setEncontrada(false);
        }

    }

    public boolean isAMatch(Card carta1, Card carta2){
        boolean match = false;
        if(  (carta1.getPareja() == carta2.getPareja()) && carta1.getName() != carta2.getName()   ){
            match = true;
        }
        return match;
    }

}
