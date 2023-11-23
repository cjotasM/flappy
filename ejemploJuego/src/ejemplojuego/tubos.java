
package ejemplojuego;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Area;
import javax.swing.ImageIcon;


public class tubos {
    //Objeto clase juego
    juego jueguito;
    //Variable que delimitan el area del lapiz
    Area lado1,mitad,lapiz;
    //Varibles de tamaño lapiz
    int anchoLapiz=70,altoLapiz=70;
    //Coordenadas iniciales del lapiz
    static int x_inicial=1300;
    static int y_inicial=270;
    //Coordenadas para manipular el lapiz
    static int x_auxiliar=-4;
    
    
    public tubos(juego jueguito){
        this.jueguito=jueguito;
    }
    
    public void mover(){
        if (x_inicial<=-100) {
            jueguito.punticos++;
            x_inicial=1300;
            if (jueguito.punticos==10 | jueguito.punticos==20 | jueguito.punticos==30) {
                x_auxiliar+=-2;
                jueguito.nivel++;
            }
        }else{
            
            if (colision()) {
                if (jueguito.vidas==0) {
                    jueguito.finJuego();
                }else{
                    jueguito.pierdeVida();
                }
            }else{
               x_inicial+=x_auxiliar;
            }
        }
    }
    
    public void paint(Graphics2D g){
        ImageIcon lapiz1=new ImageIcon(getClass().getResource("/multimedia/Lapiz2.png"));
        g.drawImage(lapiz1.getImage(), x_inicial,y_inicial,anchoLapiz,altoLapiz,null);
    }
    
    public Area getBounds(){
        Rectangle forma1=new Rectangle (x_inicial,y_inicial,55,55);
        lado1=new Area(forma1);
        Rectangle forma2= new Rectangle (x_inicial,y_inicial,55,55);
        mitad=new Area (forma2);
        
        lapiz=lado1;
        lapiz.add(lado1);
        lapiz.add(mitad);
        return lapiz;
    }
    
    public boolean colision(){
        Area areaA=new Area (jueguito.matacho.getBounds());
        areaA.intersect(getBounds());
        return !areaA.isEmpty();
    }
}
