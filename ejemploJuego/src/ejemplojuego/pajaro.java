package ejemplojuego;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import javax.swing.ImageIcon;


public class pajaro {
    juego jueguito;
    static boolean saltando=false;
    boolean sube=false;
    boolean baja=false;
    
    //Varibles que delimitan el Area del objeto
    Area cabeza,capa,cuerpo,matacho;
    
    //Variables de tamaño de matacho
    int anchoMatacho=112;
    int altoMatacho=78;
    
    
    //Coordenados iniciales del matacho
    static int x_inicial=50;
    static int y_inicial=270;
    
    //Coordenadas manipulacion matacho
    int x_auxiliar=0;
    int y_auxiliar=0;
    
    
    public pajaro(juego jueguito){
        
        this.jueguito=jueguito;   
    }
    
    public void mover (){
        if (x_inicial+x_auxiliar>0 && x_inicial+x_auxiliar<jueguito.getWidth()-anchoMatacho) {
            x_inicial+=x_auxiliar;
        }
        if (saltando) {
            if (y_inicial==270) {
                sube=true;
                y_auxiliar=-2;
                baja=false;
            }
            if (y_inicial==150) {
                baja=true;
                y_auxiliar=2;
                sube=false;
            }
            if (sube) {
                y_inicial+=y_auxiliar;
            }
            if (baja) {
                y_inicial+=y_auxiliar;
                if (y_inicial==270) {
                    saltando=false;
                }
            }
        }
    }
    
    public void paint(Graphics2D g){
        ImageIcon matacho1=new ImageIcon(getClass().getResource("/multimedia/matacho.gif"));
        g.drawImage(matacho1.getImage(), x_inicial,y_inicial,anchoMatacho,altoMatacho,null );
        
    }
    
    public static void keyPressed(KeyEvent e){
        if (e.getKeyCode()==KeyEvent.VK_SPACE) {
            saltando=true;
        }
    }
    
    public Area getBounds(){
        Rectangle forma1=new Rectangle (x_inicial,y_inicial,90,50);
        cuerpo=new Area(forma1);
        Ellipse2D forma2= new Ellipse2D.Double (x_inicial,y_inicial+28,45,45);
        capa=new Area (forma2);
        Ellipse2D forma3= new Ellipse2D.Double (x_inicial+73,y_inicial+39,25,25);
        cabeza=new Area (forma3);
        matacho=cuerpo;
        matacho.add(capa);
        matacho.add(cuerpo);
        matacho.add(cabeza);
        return matacho;
    }
}

