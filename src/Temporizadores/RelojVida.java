/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Temporizadores;
/**
 *
 * @author User
 */
public class RelojVida {
    //atributos de la clase
    private int segundos;
    private int minutos;
    private int horas;
    //metodos de acceso  
    public int getSegundos() {
        return segundos;
    }

    public int getMinutos() {
        return minutos;
    }

    public int getHoras() {
        return horas;
    }
    //Este metodo se encarga de verificar las divisas de tiempo y restringe los valores
    public void iniciar(){
       this.segundos++;
        if(this.segundos == 60){
            this.minutos++;
            this.segundos=0;
        } if(this.minutos == 60){
            this.horas++;
            this.minutos=0;
        }
        if(this.horas == 24){
            this.segundos=0;
            this.minutos=0;
            this.horas=00;
        }
    }
    //constructor que toma todos los datos controlados del metodo iniciar
    public RelojVida() {
        this.getSegundos();
        this.getMinutos();
        this.getHoras();
    }
}
 