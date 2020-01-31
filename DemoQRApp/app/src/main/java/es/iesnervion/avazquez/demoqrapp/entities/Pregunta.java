package es.iesnervion.avazquez.demoqrapp.entities;

public abstract class Pregunta {
    private String titulo;
    private String tipo;

    public Pregunta(String titulo, String tipo) {
        this.titulo = titulo;
        this.tipo = tipo;
    }

    public Pregunta() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
