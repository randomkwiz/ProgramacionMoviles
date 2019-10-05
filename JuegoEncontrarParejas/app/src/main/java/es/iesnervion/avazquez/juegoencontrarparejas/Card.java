package es.iesnervion.avazquez.juegoencontrarparejas;

public class Card {

    private final int name;
    private int imageResource;
    private boolean isFlipped = false;
    private int pareja;
    private boolean isEncontrada = false;

    public Card(int name, int imageResource, int pareja) {
        this.name = name;
        this.imageResource = imageResource;
        this.pareja = pareja;
    }


    public int getName() {
        return name;
    }

    public int getImageResource() {
        return imageResource;
    }

    public boolean isFlipped() {
        return isFlipped;
    }

    public void setFlipped(boolean flipped) {
        isFlipped = flipped;
    }

    public boolean isEncontrada() {
        return isEncontrada;
    }

    public void setEncontrada(boolean encontrada) {
        isEncontrada = encontrada;
    }

    public void girarCarta(){
        setFlipped(!isFlipped);
        //si esta bocarriba se pone bocabajo y viceversa
    }

    public int getPareja() {
        return pareja;
    }
}
