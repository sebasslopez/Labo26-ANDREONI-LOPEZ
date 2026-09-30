package exeptions;

public class NullNameExeption extends Exception{
    public NullNameExeption(){
        super("ERROR: El nombre es null");
    }
}
