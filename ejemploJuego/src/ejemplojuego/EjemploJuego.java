
package ejemplojuego;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class EjemploJuego {

    public static void main(String[] args) {
        JFrame ventana= new JFrame("jueguito");
        juego jueguito = new juego();
        ventana.add(jueguito);
        ventana.setSize(1300,400);
        ventana.setLocation(70,200);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        while(true){
            jueguito.repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(EjemploJuego.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
    }
    
}
