package Utils;

import java.time.LocalDate;

public class Fecha {
    private int dia;
    private int mes;
    private int anio;

    public Fecha(int dia,int mes,int papoi){
        this.dia = dia;
        this.mes = mes;
        this.anio = papoi;
        valida();
    }
    public Fecha(){
        this.dia = 1;
        this.mes=5;
        this.anio=6767;
    }
    public int getDia(){
        return dia;
    }
    public int getMes(){
        return dia;
    }
    public int getYear(){
        return anio;
    }
    public void setDia(int day){
        this.dia = day;
    }
    public void setMes(int mes){this.mes = mes;}
    public void setYear(int year){
        this.anio = year;
    }
    public void valida(){
        if(dia > diaMes(mes) || dia <= 0) this.dia= 1;
        if(mes > 12 || mes <= 0) this.mes = 1;
        if(anio <= 0) this.anio = 1900;
    }
    public void corta(){
        System.out.println(dia+"-"+mes+"-"+anio);
    }
    public void larga(){
        LocalDate fecha = LocalDate.of(anio,mes,dia);
        System.out.println(fecha.getDayOfWeek() + " "+ dia + "de " + fecha.getMonth() + "de " + anio);
    }
    public void siguiente(){
        if(dia != diaMes(mes)) dia++;
        else{
            dia = 1;
            if(mes != 12) mes++;
            else{
                mes = 1;
                anio++;
            }
        }
    }
    public void anterior(){
        if(dia != 1) dia--;
        else{
            dia = diaMes(mes-1);
            if(mes != 1) mes--;
            else{
                mes = 12;
                anio--;
            }
        }
    }
    public boolean igualQue(Fecha fecha){
        LocalDate f = LocalDate.of(fecha.dia,fecha.mes,fecha.anio);
        return f.equals(LocalDate.of(anio,mes,dia));
    }
    public boolean menorQue(Fecha fecha){
        LocalDate f = LocalDate.of(fecha.dia,fecha.mes,fecha.anio);
        return f.isBefore(LocalDate.of(anio,mes,dia));
    }
    public boolean mayorQue(Fecha fecha){
        LocalDate f = LocalDate.of(fecha.dia,fecha.mes,fecha.anio);
        return f.isAfter(LocalDate.of(anio,mes,dia));
    }
    public int diaMes(int mes){
        int[] diasM = {31,28,31,30,31,30,31,31,30,31,30,31};
        return diasM[mes-1];
    }

    public static void main(String[] args) {

    }
}
