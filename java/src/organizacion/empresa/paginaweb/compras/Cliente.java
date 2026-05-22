package organizacion.empresa.paginaweb.compras;

import organizacion.empresa.paginaweb.compras.metodoDePago.MetodoDePago;
import personas.Persona;

public class Cliente extends Persona {
private int tel;


    public Cliente(String nombre, String apellido, int tel) {
        super(nombre, apellido);
        this.tel = tel;

    }
}
