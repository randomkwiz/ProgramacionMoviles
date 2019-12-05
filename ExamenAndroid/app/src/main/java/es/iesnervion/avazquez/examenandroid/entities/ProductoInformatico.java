package es.iesnervion.avazquez.examenandroid.entities;

import es.iesnervion.avazquez.examenandroid.R;

public abstract class ProductoInformatico {

    private int id;
    private boolean isInStock;
    private int imgSrcProducto;
    private String nombreProducto;

    public ProductoInformatico( int id,boolean isInStock,  int imgSrcProducto, String nombreProducto) {
        this.isInStock = isInStock;
        this.id = id;
        this.imgSrcProducto = imgSrcProducto;
        this.nombreProducto = nombreProducto;
    }

    public ProductoInformatico() {
       this.isInStock = false;
        this.imgSrcProducto = 0;
        this.nombreProducto = "";
    }

    public int getId() {
        return id;
    }

    /*Prop derivada*/
    public int getImgSrcIsEnStock() {
        int imgStock = R.drawable.rojo;
        if(isInStock){
            imgStock = R.drawable.verde;
        }
        return imgStock;
    }


    public int getImgSrcProducto() {
        return imgSrcProducto;
    }

    public void setImgSrcProducto(int imgSrcProducto) {
        this.imgSrcProducto = imgSrcProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public boolean isInStock() {
        return isInStock;
    }

    public void setInStock(boolean inStock) {
        isInStock = inStock;
    }
}
