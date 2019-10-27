package es.iesnervion.avazquez.intentemail;

public interface Email {
    public void setEmailDestinatario(String emailDestinatario) ;

    public String getSubject() ;

    public void setSubject(String subject) ;

    public String getMsj() ;

    public void setMsj(String msj) ;
}
