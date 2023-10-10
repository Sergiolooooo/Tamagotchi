/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mascota;

import Actividades.actividad;
import Comida.comida;
import Medicina.Estados;
import Medicina.medicina;

/**
 *
 * @author User
 */
public class mascota {//Clase mascota con restricciones y 
    //algunos metodos de clase para su funcionamiento
   
    private int energia;
    private int edad;
    private String nombreMascota;
    private int hambre;
    private int aburrimiento;
    private int baño;
     private Estados estado;

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        if (energia >= 0 && energia <= 100) {
            this.energia = energia;
        }
    }

    public int getEdad() {
        return edad;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public int getHambre() {
        return hambre;
    }

    public int getAburrimiento() {
        return aburrimiento;
    }

    public void setAburrimiento(int aburrimiento) {
        if (aburrimiento >= 0 && aburrimiento <= 100) {
            this.aburrimiento = aburrimiento;
        }
    }

    public void setHambre(int hambre) {
        if (hambre >= 0 && hambre <= 100) {
            this.hambre = hambre;
        } else if (hambre > 100) {
            this.hambre = 100;
        }
    }

    public Estados getEstado() {
        return estado;
    }

    public void setEstado(Estados estado) {
        this.estado = estado;
    }

    public int getBaño() {
        return baño;
    }

    public void setBaño(int baño) {
        if (baño >= 0 && baño <= 100) {
            this.baño = baño;
        } else if (baño < 0) {
            this.baño = 0;
        } else if (baño > 100) {
            this.baño = 100;
        }
    }

    public void comer(comida comer) {
        if (this.hambre == 0) {
            this.setEstado(estado.ENFERMO);
        } else {
            if (this.hambre >= comer.getSatisfaccion()) {
                this.setHambre(hambre - comer.getSatisfaccion());
            } else {
                this.hambre = 0;
            }
            if (this.energia + comer.getEnergia() > 100) {
                this.energia = 100;
            } else {
                this.energia += comer.getEnergia();
            }
        }
    }

    public void actividad(actividad actividades) {
        if (this.energia == 10) {
            this.energia = 0;
            this.setEstado(estado.ENFERMO);
        } else {
            if (this.energia >= actividades.getActFisica()) {
                this.setEnergia(energia - actividades.getActFisica());
            } else {
                this.energia = 0;
            }
            if (this.aburrimiento - actividades.getEntrenamiento() < 0) {
                this.aburrimiento = 0;
            } else {
                this.aburrimiento -= actividades.getEntrenamiento();
            }
        }
    }

    public void tomarMedicina(medicina medicina) {
        if (this.estado == estado.SALUDABLE) {
            this.setEstado(estado.ENFERMO);
        } else {
            if (this.aburrimiento >= 90) {
                this.setAburrimiento(aburrimiento - medicina.getRecupera());
            }
            if (this.baño >= 90) {
                this.baño -= medicina.getRecupera();
            }
            if (this.energia <= 10) {
                this.energia += medicina.getRecupera();
            }
            if (this.hambre >= 90) {
                this.hambre -= medicina.getRecupera();
            }
            this.setEstado(estado.SALUDABLE);
        }
    }

    public void aumentarEstadistica() {
        this.setHambre(hambre + 5);
        this.setAburrimiento(aburrimiento + 5);
        this.setEnergia(energia - 5);
        this.setBaño(baño + 20);
    }

    public void dormir() {
        this.setEnergia(100);
        this.setHambre(hambre + 20);
        this.setBaño(baño + 30);
    }

    public void Baño() {
        this.setBaño(baño - 30);
    }

    public void aumentarEdad() {
        this.edad++;
    }
//constructor que define el estado inicial de la mascota
    public mascota(String nombreMascota) {
        this.estado = Estados.SALUDABLE;
        this.energia = 50;
        this.nombreMascota = nombreMascota;
        this.hambre = 50;
        this.aburrimiento = 50;
        this.baño = 50;
    }
}
