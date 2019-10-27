package es.iesnervion.avazquez.intentemail;

public class EmailImpl implements Email {
    private String emailDestinatario;
    private String subject;
    private String msj;

    public EmailImpl(String emailDestinatario, String subject, String msj) {
        this.emailDestinatario = emailDestinatario;
        this.subject = subject;
        this.msj = msj;
    }

    public EmailImpl() {
        this.emailDestinatario = "";
        this.subject = "";
        this.msj = "";
    }

    public String getEmailDestinatario() {
        return emailDestinatario;
    }

    //getters y setters
    public void setEmailDestinatario(String emailDestinatario) {
        this.emailDestinatario = emailDestinatario;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMsj() {
        return msj;
    }

    public void setMsj(String msj) {
        this.msj = msj;
    }
}
