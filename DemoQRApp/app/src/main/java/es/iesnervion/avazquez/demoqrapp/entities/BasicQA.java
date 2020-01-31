package es.iesnervion.avazquez.demoqrapp.entities;

public class BasicQA extends Pregunta {

    private String[] respuestas;
    private String respuestaCorrecta;

    public BasicQA(String titulo, String tipo,String[] respuestas, String respuestaCorrecta) {
        super(titulo,tipo);
        this.respuestas = respuestas;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public BasicQA() {
        super();
    }

    public String[] getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(String[] respuestas) {
        this.respuestas = respuestas;
    }

    public String getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void setRespuestaCorrecta(String respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }
}
