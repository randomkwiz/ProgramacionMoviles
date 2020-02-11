package es.iesnervion.avazquez.practicaroomfragments.room.POJO;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

import es.iesnervion.avazquez.practicaroomfragments.room.entities.CuentaRedSocial;
import es.iesnervion.avazquez.practicaroomfragments.room.entities.Persona;

//No se ponen anotaciones aqui, no es una entidad

public class PersonaConRedesSociales {
    @Embedded
    private Persona persona;

    //Usa lo del relation pa 1:N
    @Relation(parentColumn = "id", entityColumn = "idPersona", entity = CuentaRedSocial.class)
    private List<CuentaRedSocial> redesSociales;


    public PersonaConRedesSociales() {
    }

    public PersonaConRedesSociales(Persona persona) {
        this.persona = persona;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<CuentaRedSocial> getRedesSociales() {
        return redesSociales;
    }

    public void setRedesSociales(List<CuentaRedSocial> redesSociales) {
        this.redesSociales = redesSociales;
    }
}
