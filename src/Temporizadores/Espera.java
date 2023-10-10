/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Temporizadores;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.Timer;

/**
 *
 * @author User
 */
public class Espera {
    private JMenuItem accion;
    private int minutosProceso;
    private String infoComida;
//timer de tiempo de espera de los alimentos
    // se ejecuta cada 1 minuto 
private Timer esperando = new Timer(60000, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
           minutosProceso--;
           // vuelve a cargar la info de los minutos restantes 
            accion.setToolTipText(("Disponible en " + minutosProceso + " minutos "));
           if(minutosProceso==0){
               accion.setEnabled(true);//habilita los JMenuItem
               //guarda el contenido de JMenuItem
               accion.setToolTipText(infoComida);
               esperando.stop();
           }
        }
    });

    public Espera(int minutos, JMenuItem accion) {
        this.minutosProceso = minutos;
        this.accion = accion;
        this.infoComida = this.accion.getToolTipText();
        this.accion.setToolTipText(("Disponible en " + minutosProceso + " minutos ")); //tiempo de espera para cada actividad y comida 
        this.accion.setEnabled(false);//Deshabilita temporalmente el JMenuItem seleccionado
        esperando.start();
    }

    public Espera() {
    }
    
    
}
