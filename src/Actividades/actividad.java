/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actividades;

/**
 *
 * @author User
 */
public class actividad {//clase con constructor para crear una actividad
    private int actFisica;
    private int ActEntrenamiento;
    private String nombreAct;
    //Metodos de acceso
    public int getActFisica() {
        return actFisica;
    }

    public int getEntrenamiento() {
        return ActEntrenamiento;
    }

    public String getNombreAct() {
        return nombreAct;
    }

    //Constructor que crea una nueva actividad
    public actividad(String nombreAct,int actFisica, int entrenamiento) {
        this.nombreAct = nombreAct;
        this.actFisica = actFisica;
        this.ActEntrenamiento = entrenamiento;
    }
    
}
