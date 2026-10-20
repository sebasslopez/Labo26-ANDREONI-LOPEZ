package plataformas.campaniaElectoral;

import utils.Fecha;

import java.util.HashSet;

public class PartidoPolitico {
    private String nombre;
    private String direccion;
    private int cantAfiliados;
    private HashSet<Activista> enviadores;

    public PartidoPolitico(int cantAfiliados, String direccion, String nombre) {
        this.cantAfiliados = cantAfiliados;
        this.direccion = direccion;
        this.nombre = nombre;
        this.enviadores = new HashSet<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public HashSet<Activista> getEnviadores() {
        return enviadores;
    }

    public void setEnviadores(HashSet<Activista> enviadores) {
        this.enviadores = enviadores;
    }

    public int getCantAfiliados() {
        return cantAfiliados;
    }

    public void setCantAfiliados(int cantAfiliados) {
        this.cantAfiliados = cantAfiliados;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void anadirEnviador(Activista a){
        enviadores.add(a);
    }

    public void eliminarEnviador(Activista a){
        enviadores.remove(a);
    }

    public void hacerCampania(){
        for(Activista a : enviadores){
            a.enviarMensaje("Vote por el partido para un mejor futuro.");
        }
    }

    static void main() {
        PartidoPolitico p1 = new PartidoPolitico(2,"larralde 123","Pepe Avanza");
        PartidoPolitico p2 = new PartidoPolitico(5,"terraria 4580","Más libertad");

        TrabajadorActivista t1 = new TrabajadorActivista("Pepe","Saturnino","Leandro Niceforo Alem 7880", new Fecha(),46547878,0.01F,"15-46547878-8 ");
        TrabajadorActivista t2 = new TrabajadorActivista("Germinia","Saturnino","Leandro Niceforo Alem 7880", new Fecha(),46547879,0.02F,"0xF-0xDEFA1585-0x8");
        TrabajadorActivista t3 = new TrabajadorActivista("Claudio","Saturnino","Leandro Niceforo Alem 7880", new Fecha(),46547880,1.0F,"15-46547880-8 ");
        TrabajadorActivista t4 = new TrabajadorActivista("Charlotte","Saturnino","Leandro Niceforo Alem 7880", new Fecha(),46547881,79.01F,"0xF-0xDEFA1581-0x8");
        PalomaMensajera pm1 = new PalomaMensajera("Tutú",true);
        PalomaMensajera pm2 = new PalomaMensajera("Totó",false);
        TelefonoMensajero tm1 = new TelefonoMensajero(5662346,"Fernandito Ruiz","uqhfkefjhwef",78797888,CompaniaTelefonica.TUENTI);

        p1.anadirEnviador(t1);
        p1.anadirEnviador(t3);
        p1.anadirEnviador(pm1);
        p1.anadirEnviador(tm1);
        p2.anadirEnviador(t2);
        p2.anadirEnviador(t4);
        p2.anadirEnviador(pm2);
        p1.hacerCampania();
    }
}
