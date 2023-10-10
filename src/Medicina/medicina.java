/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Medicina;

/**
 *
 * @author User
 */
public class medicina {//Clase por defecto para crear una medicina con constructor por defecto
    private String nombreMedicina;
    private int tiempoRecuperacion;
    private static final int recupera = 20;//Agrega 20 a cada estadistica donde se utilice ejemplo si la energia es menos que 10 recupera 20 al tomar medicina 

    public String getNombreMedicina() {
        return nombreMedicina;
    }

    public int getTiempoRecuperacion() {
        return tiempoRecuperacion;
    }

    public int getRecupera() {
        return recupera;
    }

    public medicina(String nombreMedicina, int tiempoRecuperacion) {
        this.nombreMedicina = nombreMedicina;
        this.tiempoRecuperacion = tiempoRecuperacion;
    }
    
}
