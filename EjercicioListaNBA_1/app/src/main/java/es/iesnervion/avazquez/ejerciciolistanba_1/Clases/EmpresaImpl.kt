package es.iesnervion.avazquez.ejerciciolistanba_1.Clases

import es.iesnervion.avazquez.ejerciciolistanba_1.Interfaces.Empresa
import es.iesnervion.avazquez.ejerciciolistanba_1.R


class EmpresaImpl  (nombreEmpresa: String, logo: Int)  : Empresa{

    private var nombreEmpresa: String = nombreEmpresa;
    private var logo: Int = logo;

    //si quieres crear otro constructor, debes llamar siempre a algun otro ya creado
    constructor(nombre: String)
            :this(nombre, R.drawable.android)



    //getters y setters
    fun getNombreEmpresa():String{
        return this.nombreEmpresa;
    }
    fun getLogo():Int{
        return this.logo;
    }

    fun setNombreEmpresa(nombreEmpresa: String){
        this.nombreEmpresa = nombreEmpresa;
    }

    fun setLogo(logo: Int){
        this.logo = logo;
    }

}