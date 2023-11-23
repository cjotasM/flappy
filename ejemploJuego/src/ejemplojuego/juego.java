package ejemplojuego;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;
import javax.swing.JPanel;

public class juego extends JPanel{
    
    AudioInputStream direccionSonidoSalto,direccionSonidoChoque,direccionSonidoFondo,direccionSonidoFondo2,direccionSonidoFondo3;
    Clip sonidoChoque,sonidoSalto,sonidoFondo,sonidoFondo2,sonidoFondo3;
    pajaro matacho=new pajaro(this);
    tubos lapices=new tubos(this);
    fondo matrix=new fondo(this);
    puntos laptos=new puntos(this);
    profesora profe=new profesora(this);
    
    
    
    public static boolean juegoFinalizado=false;
    public static boolean pierdeVida=false;
    public static int vidas=3;
    public static int punticos=0;
    public static int nivel=1;
    private boolean isFondoPlaying = false;
    
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
        try {
            direccionSonidoFondo= AudioSystem.getAudioInputStream(juego.class.getResource("/multimedia/beat1.wav"));
            sonidoFondo= AudioSystem.getClip();
            sonidoFondo.open(direccionSonidoFondo);
            
            //sonidoFondo.start();
        } catch (Exception e) {
                e.printStackTrace();
            }
         try {
            direccionSonidoFondo2= AudioSystem.getAudioInputStream(juego.class.getResource("/multimedia/beat2.wav"));
            sonidoFondo2= AudioSystem.getClip();
            sonidoFondo2.open(direccionSonidoFondo2);
            
            //sonidoFondo.start();
        } catch (Exception e) {
                e.printStackTrace();
            }
          try {
            direccionSonidoFondo3= AudioSystem.getAudioInputStream(juego.class.getResource("/multimedia/beat3.wav"));
            sonidoFondo3= AudioSystem.getClip();
            sonidoFondo3.open(direccionSonidoFondo3);
            
            //sonidoFondo.start();
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
                    
                    sonidoSalto.setFramePosition(0);
                    sonidoSalto.start();
                    pajaro.keyPressed(e);            
                    
                    
                }else if (sonidoSalto.isRunning()) {
                    sonidoSalto.stop();              
                }                
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
        });
        setFocusable(true);
        iniciarHiloSonidoFondo();
    }
    private void iniciarHiloSonidoFondo() {
        Thread sonidoFondoThread = new Thread(() -> {
            while (true) {
                if (nivel==1) {
                    if (!isFondoPlaying) {
                        sonidoFondo.setFramePosition(0);
                        sonidoFondo.start();
                        sonidoFondo.loop(Clip.LOOP_CONTINUOUSLY); 
                        isFondoPlaying = true;
                    }
                }else if (nivel==2) {
                    if (!isFondoPlaying) {
                        sonidoFondo2.setFramePosition(0);
                        sonidoFondo2.start();
                        sonidoFondo2.loop(Clip.LOOP_CONTINUOUSLY); 
                        isFondoPlaying = true;
                    }
                }else if (nivel==3) {
                    if (!isFondoPlaying) {
                        sonidoFondo3.setFramePosition(0);
                        sonidoFondo3.start();
                        sonidoFondo3.loop(Clip.LOOP_CONTINUOUSLY); 
                        isFondoPlaying = true;
                    }
                }
                
            }
        });

        sonidoFondoThread.start();
    }
    
    public void mover (){
        lapices.mover();
        matacho.mover();
        matrix.mover();
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2=(Graphics2D)g;
        dibujar(g2);
        dibujarPuntaje(g2);
    }
    
    public void dibujar(Graphics2D g){
        matrix.paint(g);
        matacho.paint(g);
        lapices.paint(g);
        laptos.paint(g);
        profe.paint(g);
       
        mover();
    }
    
    public void dibujarPuntaje(Graphics2D g){
        Graphics2D g1=g, g2=g;
        Font score=new Font("Arial",Font.BOLD,30);
        g.setFont(score);
        g.setColor(Color.blue);        
        g1.drawString("Vidas: "+vidas,20,70);
        g1.drawString("Nivel: "+nivel,570,70);
        if (juegoFinalizado) {
            g2.setColor(Color.red);
            g2.drawString("¡Has Reprobado!",((float)getBounds().getCenterX()/2)+170,100); 
            
        }
        
    }
    
    public void finJuego () {
        juegoFinalizado=true;
        if (sonidoChoque.isRunning()) {
            sonidoChoque.stop();         
        }  
        sonidoChoque.setFramePosition(0);
        sonidoChoque.start();
        
    }
    
    public void pierdeVida () {
        if (sonidoChoque.isRunning()) {
            sonidoChoque.stop();                   
        }  
        sonidoChoque.setFramePosition(0);        
        sonidoChoque.start();
        pierdeVida=true;
    }    
   
}
