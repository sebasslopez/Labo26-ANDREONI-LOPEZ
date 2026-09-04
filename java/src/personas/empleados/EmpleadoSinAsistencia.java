package personas.empleados;

import empresas.PoliEmpresa.llamada.FranjaHoraria;

public class EmpleadoSinAsistencia extends Empleado{
    private String provincia;
    private String codigoPais;
    private FranjaHoraria franjaHoraria;

    public EmpleadoSinAsistencia(String nombre, String apellido, int dni, String pais, String telefono, String provincia, String codigoPais, FranjaHoraria franjaHoraria) {
        super(nombre, apellido, dni, pais,telefono);
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

    public String getCodigoPais() {
        return codigoPais;
    }

    public FranjaHoraria getFranjaHoraria() {
        return franjaHoraria;
    }

}
