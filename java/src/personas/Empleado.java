package personas;

import organizacion.empresa.Empresa;
import organizacion.empresa.sistemaLlamada.Llamada;
import organizacion.empresa.sistemaLlamada.SistemaLlamadas;

public class Empleado extends Persona{
    private Empresa empresa;
    private String provincia;
    private int telefono;
    private String pais;

    public Empleado(String apellido, String nombre, int DNI, String pais, int telefono, Empresa empresa, String provincia) {
        super(apellido, nombre, DNI);
        this.empresa = empresa;
        this.provincia = provincia;
        this.telefono = telefono;
        this.pais = pais;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void llamar(int numero) {
        Llamada llamada = this.empresa.getSistema().addLlamada(this, numero, "UTF-3");
        if (llamada == null) {
            System.out.println("se ha intentado llamar a un numero fuera de la empresa");
        } else {
            this.empresa.getSistema().registrarLlamada(llamada, 10);
        }
    }
}
