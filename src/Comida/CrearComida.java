/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comida;

import Interfaces.Interfaz;

/**
 *
 * @author User
 */
public class CrearComida implements Interfaz<comida>{//Implementacion de la interfaz de nombre Interfaz
    
    @Override
    public comida crear(String nombre) {
        return null;
    }
     public comida crear(int energia,int satisfaccion,int tiempoRecuperacion,String nombreComida) {
        return new comida(energia,satisfaccion,tiempoRecuperacion,nombreComida);
    }
    
}
