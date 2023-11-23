package ejemplojuego;

import java.awt.Graphics2D;
import javax.swing.ImageIcon;


public class puntos {
    juego jueguito;
    
    int anchoPuntos=300, altoPuntos=110;
    
    public puntos(juego jueguito){
        this.jueguito=jueguito;
    }
    public void paint(Graphics2D g){        
        ImageIcon laptop=new ImageIcon(getClass().getResource("/multimedia/barra0.png"));
        g.drawImage(laptop.getImage(), 1000,5 ,anchoPuntos,altoPuntos,null);
        if (jueguito.punticos==1||jueguito.punticos==11||jueguito.punticos==21) {
            ImageIcon laptop1=new ImageIcon(getClass().getResource("/multimedia/barra1.png"));
            g.drawImage(laptop1.getImage(), 1000,5,anchoPuntos,altoPuntos,null);
        } else if (jueguito.punticos==2||jueguito.punticos==12||jueguito.punticos==22) {
            ImageIcon laptop2=new ImageIcon(getClass().getResource("/multimedia/barra2.png"));
            g.drawImage(laptop2.getImage(), 1000,5,anchoPuntos,altoPuntos,null);
        }else if (jueguito.punticos==3||jueguito.punticos==13||jueguito.punticos==23) {
            ImageIcon laptop3=new ImageIcon(getClass().getResource("/multimedia/barra3.png"));
            g.drawImage(laptop3.getImage(), 1000,5,anchoPuntos,altoPuntos,null);
        }else if (jueguito.punticos==4||jueguito.punticos==14||jueguito.punticos==24) {
            ImageIcon laptop4=new ImageIcon(getClass().getResource("/multimedia/barra4.png"));
            g.drawImage(laptop4.getImage(), 1000,5,anchoPuntos,altoPuntos,null);
        }else if (jueguito.punticos==5||jueguito.punticos==15||jueguito.punticos==25) {
            ImageIcon laptop5=new ImageIcon(getClass().getResource("/multimedia/barra5.png"));
            g.drawImage(laptop5.getImage(), 1000,5,anchoPuntos,altoPuntos,null);
        }else if (jueguito.punticos==6||jueguito.punticos==16||jueguito.punticos==26) {
            ImageIcon laptop6=new ImageIcon(getClass().getResource("/multimedia/barra6.png"));
            g.drawImage(laptop6.getImage(), 1000,5,anchoPuntos,altoPuntos,null);
        }else if (jueguito.punticos==7||jueguito.punticos==17||jueguito.punticos==27) {
            ImageIcon laptop7=new ImageIcon(getClass().getResource("/multimedia/barra7.png"));
            g.drawImage(laptop7.getImage(), 1000,5,anchoPuntos,altoPuntos,null);
        }else if (jueguito.punticos==8||jueguito.punticos==18||jueguito.punticos==28) {
            ImageIcon laptop8=new ImageIcon(getClass().getResource("/multimedia/barra8.png"));
            g.drawImage(laptop8.getImage(), 1000,5,anchoPuntos,altoPuntos,null);
        }else if (jueguito.punticos==9||jueguito.punticos==19||jueguito.punticos==29) {
            ImageIcon laptop9=new ImageIcon(getClass().getResource("/multimedia/barra9.png"));
            g.drawImage(laptop9.getImage(), 1000,5,anchoPuntos,altoPuntos,null);
        }else if (jueguito.punticos==10||jueguito.punticos==20||jueguito.punticos==30) {
            ImageIcon laptop10=new ImageIcon(getClass().getResource("/multimedia/barra10.png"));
            g.drawImage(laptop10.getImage(), 1000,5,anchoPuntos,altoPuntos,null);
        }
    }
    
}
