/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ContMascota;

import Actividades.actividad;
import Comida.comida;
import Mascota.mascota;
import Medicina.Estados;
import Medicina.medicina;
import Temporizadores.Espera;
import Temporizadores.RelojVida;
import Frame.FrmTamagochi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author User
 */
public class controlaMascota {//Clae que controladora para conectar la interfaz grafica con la parte logica 

    private mascota mascota;
    private FrmTamagochi tamagochi;
     //instancia de un nuevo objeto reloj
    private RelojVida crecimiento = new RelojVida();
    int critico = 0; //contador de criticos criticos 
    boolean baño = false;
    boolean aburrimiento = false;
    boolean energia = false;
    boolean hambre = false;
    

    public void comer(comida come, JMenuItem accion) {
       //se instancia esperar de comida y actividades para uzarse en el constructor
        Espera espera = new Espera(come.getTiempoRecuperacion(), accion);
     //se llama el metodo comer recibe una comida
        mascota.comer(come);
    }

    public void dormir() {
        mascota.dormir();//llama dormir
    }

    public void actividad(actividad act) {
        mascota.actividad(act);//llama clase actividad 
    }

    public void tomarMedicina(medicina med, JMenuItem accion) {
        Espera espera = new Espera(med.getTiempoRecuperacion(), accion);
        mascota.tomarMedicina(med);
        this.aburrimiento = false;
        this.baño = false;
        this.energia = false;
        this.hambre = false;
        this.critico = 0;
        this.mensajEnfermo = true;
    }

    public void Baño() {
        mascota.Baño();
    }
    boolean mensajEnfermo = true;//exclusivo para verificar estado de salud enfermo para los mjs

    // metodo para comprabar los estados de salud 
    private void verSalud() {
        if (mascota.getAburrimiento() >= 90 && aburrimiento == false) {
            mascota.setEstado(Estados.ENFERMO);
            aburrimiento = true;
            critico++;
        }
        if (mascota.getBaño() >= 90 && baño == false) {
            mascota.setEstado(Estados.ENFERMO);
            baño = true;
            critico++;
        }
        if (mascota.getEnergia() <= 10 && energia == false) {
            mascota.setEstado(Estados.ENFERMO);
            energia = true;
            critico++;
        }
        if (mascota.getHambre() >= 90 && hambre == false) {
            mascota.setEstado(Estados.ENFERMO);
            hambre = true;
            critico++;
        }
        if (mascota.getEstado() == Estados.ENFERMO && mensajEnfermo) {// si estado es enfermo
            JOptionPane.showMessageDialog(tamagochi, " La mascota ha enfermado debes tomar precausiones"
                    + "Cuidado", "Oh.", 2, null);
            mensajEnfermo = false;//desabilita el mensaje hasta que haya otro critico
        }
        if (mascota.getAburrimiento() < 90) {
            aburrimiento = false;
        }
        if (mascota.getBaño() < 90 && baño) {
            baño = false;
        }
        if (mascota.getEnergia() > 10) {
            energia = false;
        }
        if (mascota.getHambre() < 90) {
            hambre = false;
        }
        muerte();
    }

    private void muerte() {//combrueba el estado de muerte y reinicia el ciclo y sus componentes al llegar a 2 criticos
        if (mascota.getEstado() == Estados.ENFERMO && critico >= 2) {
            CICLODIA.stop();
            DISMINUIR_EST.stop();
            mascota.setEstado(Estados.MUERTO);
            JOptionPane.showMessageDialog(tamagochi, " Tu mascota ha muerto"
                    + "El juego se reiniciará", "Mala suerte.", 1, null);
            FrmTamagochi nuevo = new FrmTamagochi();// crea nuevo juego 
            tamagochi.setVisible(false);// oculta el anterior juego
            tamagochi.dispose();//cierra el juego sin cerrar el ejecutable
            nuevo.setVisible(true);// para visualisar el nuevo juego
        }
    }
    boolean nace = true;// exclusivo para verificar el nacimiento de huevo a bebe;

    private Timer CICLODIA = new Timer(1000, new ActionListener() {//controla los dias del juego...
        public void actionPerformed(ActionEvent e) {
            if (mascota.getEstado() == Estados.SALUDABLE || mascota.getEstado() == Estados.ENFERMO) {
                crecimiento.iniciar();//con esto el reloj avanza
                verSalud();//comprueba salud
                getEstadisticas();//varifica estadisticas
//                if (crecimiento.getHoras() == 23 && crecimiento.getMinutos() == 59 && crecimiento.getSegundos() == 59) {
                 if(crecimiento.getSegundos()==1){
                    mascota.aumentarEdad();
                    tamagochi.getLEDAD().setText(String.valueOf(mascota.getEdad()));//envia la edad al label 
                }
                verificarCrecimiento();//verfifica si debe cambiar de icono
            }
        }
    });

    private Timer DISMINUIR_EST = new Timer(60000, new ActionListener() {//disminuye y aumenta las estadisticas cada 1 minutos
        public void actionPerformed(ActionEvent e) {
            mascota.aumentarEstadistica();
        }
    });

    private void verificarCrecimiento() {
        if (nace && crecimiento.getSegundos()== 30) {// despues de 30 seg pasa a bebé
            nace = false;// comprovacion de nacimiento
            accion();
            this.DISMINUIR_EST.start();//Se obtienen los iconos del label de la mascota y se cambia segun la restriccion
            tamagochi.getLMASCOTA().setIcon((new javax.swing.ImageIcon(getClass().getResource("/Img/zorro2.png"))));
        } else if (crecimiento.getMinutos()== 2) {
        //}else if(mascota.getEdad()==3){
            tamagochi.getLMASCOTA().setIcon((new javax.swing.ImageIcon(getClass().getResource("/Img/zorro3.png"))));
       }else if (crecimiento.getMinutos()==2){
       // } else if (mascota.getEdad() == 10) {
            tamagochi.getLMASCOTA().setIcon((new javax.swing.ImageIcon(getClass().getResource("/Img/adulto.png"))));
        }
    }

    private void getEstadisticas() {
        tamagochi.getBABURRIMIENTO().setValue(mascota.getAburrimiento());
        tamagochi.getBBAÑO().setValue(mascota.getBaño());
        tamagochi.getBENERGIA().setValue(mascota.getEnergia());
        tamagochi.getBHAMBRE().setValue(mascota.getHambre());
    }

    private void accion() {
        //recibe el botton group (JBITEM) y habilita la JBBAR que contiene el grupo de btns
        Enumeration<AbstractButton> tareas = this.tamagochi.getACCIONESMASCOTA().getElements();
        while (tareas.hasMoreElements()) {//si la lista de tareas tiene mas elementos la activa 
            tareas.nextElement().setEnabled(true);
        }
    }

    public controlaMascota(mascota miMascota, FrmTamagochi tamagochi) {
        this.mascota = miMascota;
        this.tamagochi = tamagochi;
        this.tamagochi.getLNOMBRE().setText(miMascota.getNombreMascota());
        CICLODIA.start();
    }

}
