package personas;

public class Cliente extends Persona {
private int tel;

    public Cliente(){
        super();
        this.tel = 1123622201;
    }

    public Cliente(int tel){
        super();
        this.tel = tel;
    }
    public Cliente(String nombre, String apellido, int tel) {
        super(nombre, apellido);
        this.tel = tel;

    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }
}
