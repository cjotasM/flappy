
package ejemplojuego;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class EjemploJuego {
    public static int reiniciaJuego=-1;
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null,"¿Estas listo para empezar el semestre?");
        JFrame ventana= new JFrame("jueguito");
        juego jueguito = new juego();
        ventana.add(jueguito);
        ventana.setSize(1300,400);
        ventana.setLocation(70,200);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        while(true){
            
            if (jueguito.juegoFinalizado) {
                reiniciaJuego=JOptionPane.showConfirmDialog(null,"Has reprobado,¿Quieres volver a matricular?","Has reprobado",JOptionPane.YES_NO_OPTION);
                if (reiniciaJuego==0) {
                    reiniciaValores();
                }else if (reiniciaJuego==1) {
                    System.exit(0);
                }
            }else{
                jueguito.repaint();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                    Logger.getLogger(EjemploJuego.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (juego.pierdeVida==true) {
                    JOptionPane.showMessageDialog(null,"Obtuvo mala nota");
                    juego.pierdeVida=false;
                    juego.vidas--;
                    pajaro.y_inicial=270;
                    pajaro.saltando=false;
                    tubos.x_inicial=1300;
                }
            }
            
        }   
    }
   public static void reiniciaValores(){
       juego.juegoFinalizado=false;
       tubos.x_auxiliar=-4;
       juego.punticos=0;
       juego.nivel=1;
       juego.vidas=3;
       reiniciaJuego=-1;
       tubos.x_inicial=1300;
   } 
}
