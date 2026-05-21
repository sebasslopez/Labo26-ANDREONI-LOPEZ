package personas;

public class Empleado extends Persona{
    private String provincia;
    private String telefono;
    private String codigoPais;
    private String franjaHoraria;

    public Empleado(String nombre, String apellido, int dni, String pais,
                    String telefono, String provincia, String codigoPais, String franjaHoraria) {
        super(nombre, apellido, dni, pais);
        this.telefono = telefono;
        this.provincia = provincia;
        this.codigoPais = codigoPais;
        this.franjaHoraria = franjaHoraria;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public String getFranjaHoraria() {
        return franjaHoraria;
    }

    public boolean tieneTelefono(String telefono) {
        return this.telefono.equals(telefono);
    }
}
