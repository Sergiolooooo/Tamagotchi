/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comida;
/**
 *
 * @author User
 */
public class comida {//Clase por defecto para crear comidas 
    private int energia;
    private int satisfaccion;
    private int tiempoRecuperacion;
    private String nombreComida;

    public int getEnergia() {
        return energia;
    }

    public int getSatisfaccion() {
        return satisfaccion;
    }

    public int getTiempoRecuperacion() {
        return tiempoRecuperacion;
    }

    public String getNombreComida() {
        return nombreComida;
    }

    public comida(int energia, int satisfaccion, int tiempoRecuperacion, String nombreComida) {
        this.energia = energia;
        this.satisfaccion = satisfaccion;
        this.tiempoRecuperacion = tiempoRecuperacion;
        this.nombreComida = nombreComida;
    }
    
}
