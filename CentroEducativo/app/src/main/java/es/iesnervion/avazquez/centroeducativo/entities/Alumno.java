package es.iesnervion.avazquez.centroeducativo.entities;

public class Alumno extends Persona {
    private int curso;  // esto seria 1º
    private char grupo; //esto es lo de A, B, C
    private String nivel;   //eso seria ESO

    public Alumno(){
        super();
    }

    public Alumno(String nombre) {
        super(nombre);
    }

    public Alumno(int curso, char grupo, String nivel) {
        this.curso = curso;
        this.grupo = grupo;
        this.nivel = nivel;
    }

    //Getters y setters
    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public char getGrupo() {
        return grupo;
    }

    public void setGrupo(char grupo) {
        this.grupo = grupo;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
}
