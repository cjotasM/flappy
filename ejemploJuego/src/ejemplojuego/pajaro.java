package ejemplojuego;

import java.awt.event.KeyEvent;


public class pajaro {
    juego jueguito;
    static boolean saltando=false;
    boolean sube=false;
    boolean baja=false;
    public pajaro(juego jueguito){
        
        this.jueguito=jueguito;
        
    }
    @Override
    public void keyPressed(KeyEvent e){
        if (e.getKeyCode()==KeyEvent.VK_SPACE) {
            saltando=true;
        }
    }
}
