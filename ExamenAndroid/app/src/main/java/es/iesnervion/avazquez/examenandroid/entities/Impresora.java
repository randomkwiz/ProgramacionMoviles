package es.iesnervion.avazquez.examenandroid.entities;

public class Impresora extends ProductoInformatico {

    private String tipoImpresion;

    public Impresora(int id,boolean isInStock, int imgSrcProducto, String nombreProducto, String tipoImpresion) {
        super(id,isInStock, imgSrcProducto, nombreProducto);
        this.tipoImpresion = tipoImpresion;
    }

    public String getTipoImpresion() {
        return tipoImpresion;
    }

    public void setTipoImpresion(String tipoImpresion) {
        this.tipoImpresion = tipoImpresion;
    }
}
