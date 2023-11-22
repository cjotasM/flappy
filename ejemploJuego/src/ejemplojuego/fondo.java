package ejemplojuego;

import java.awt.Graphics2D;
import javax.swing.ImageIcon;


public class fondo {
    juego jueguito;
    //Varibles del tamaño del fondo
    int anchoFondo=1300,altoFondo=400;
    //Coordenadas iniciales para mover el fondo
    int x1=1300;
    int y1=0;
    //Coordenadas iniciales para mover fondo
    int x2=0;
    int y2=0;
    
    public fondo(juego jueguito){
        this.jueguito=jueguito;
    }
    
    public void mover(){
        x1-=2;
        x2-=2;
        if (x1==0 && x2==-1300) {
            x1=1300;
            x2=0;
        }
    }
    
    public void paint(Graphics2D g){
        ImageIcon fondo1=new ImageIcon(getClass().getResource("/multimedia/matrix.jpg"));
        g.drawImage(fondo1.getImage(), x1,y1,anchoFondo,altoFondo,null);
        g.drawImage(fondo1.getImage(), x2,y2,anchoFondo,altoFondo,null);
        if (jueguito.nivel==2) {
            ImageIcon fondo2=new ImageIcon(getClass().getResource("/multimedia/matrix2.jpg"));
            g.drawImage(fondo2.getImage(), x1,y1,anchoFondo,altoFondo,null);
            g.drawImage(fondo2.getImage(), x2,y2,anchoFondo,altoFondo,null);
        }else if (jueguito.nivel==3) {
            ImageIcon fondo3=new ImageIcon(getClass().getResource("/multimedia/matrix3.jpg"));
            g.drawImage(fondo3.getImage(), x1,y1,anchoFondo,altoFondo,null);
            g.drawImage(fondo3.getImage(), x2,y2,anchoFondo,altoFondo,null);
        }
    }
   
}
