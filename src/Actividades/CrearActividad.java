/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actividades;

import Interfaces.Interfaz;

/**
 *
 * @author User
 */
public class CrearActividad implements Interfaz<actividad> {
//fabrica de actividades
    @Override
    public actividad crear(String nombre) {
        return null;
    }
     public actividad crear(String nombre,int energia,int aburrimiento) {
    return new actividad(nombre,energia,aburrimiento);
     }
     
}
