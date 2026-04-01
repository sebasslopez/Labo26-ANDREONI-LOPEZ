public class Persona {
    private String nombre;
    private int edad;
    private String direccion;

    public Persona(String nombre,int edad, String direccion){
    this.nombre=nombre;
    this.edad=edad;
    this.direccion=direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


    public String datos() {

        return "los datos son: Nombre:"+nombre+" Edad:"+edad+" Dirección:"+direccion;
    }

    public static void main(String[] args) {
        Persona persona = new Persona("Raquel",10,"Constituyentes 5848");
        System.out.println(persona.datos());

    }
}
