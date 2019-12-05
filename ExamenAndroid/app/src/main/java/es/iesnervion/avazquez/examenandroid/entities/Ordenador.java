package es.iesnervion.avazquez.examenandroid.entities;

public class Ordenador extends ProductoInformatico {

    private int imgCPU;

    public Ordenador(int id,boolean isInStock, int imgSrcProducto, String nombreProducto, int imgCPU) {
        super(id,isInStock, imgSrcProducto, nombreProducto);
        this.imgCPU = imgCPU;
    }

    public int getImgCPU() {
        return imgCPU;
    }

    public void setImgCPU(int imgCPU) {
        this.imgCPU = imgCPU;
    }
}
