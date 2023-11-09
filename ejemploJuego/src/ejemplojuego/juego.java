package ejemplojuego;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;
import java.net.URL;
import javax.swing.JPanel;

public class juego extends JPanel{
    
    AudioInputStream direccionSonidoSalto,direccionSonidoChoque;
    Clip sonidoChoque,sonidoSalto;
    pajaro matacho=new pajaro(this);
    tubos lapices=new tubos(this);
    fondo matrix=new fondo(this);
    
    
    static boolean juegoFinalizado=false;
    static boolean pierdeVida=false;
    static int vidas=3;
    static int puntos=0;
    static int nivel=1;
    
    public juego(){
        try {
            direccionSonidoChoque= AudioSystem.getAudioInputStream(juego.class.getResource("/multimedia/choque.wav"));
            sonidoChoque= AudioSystem.getClip();
            sonidoChoque.open(direccionSonidoChoque);
            //sonidoChoque.start();
        } catch (Exception e) {
                e.printStackTrace();
            }
        try {
            direccionSonidoSalto= AudioSystem.getAudioInputStream(juego.class.getResource("/multimedia/salto.wav"));
            sonidoSalto= AudioSystem.getClip();
            sonidoSalto.open(direccionSonidoSalto);
            //sonidoSalto.start();
        } catch (Exception e) {
                e.printStackTrace();
            }
        addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode()== KeyEvent.VK_SPACE) {
                    sonidoSalto.start();
                    pajaro.keyPressed(e);
                    
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
        });
        setFocusable(true);
    }
}
