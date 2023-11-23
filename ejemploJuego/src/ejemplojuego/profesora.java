package ejemplojuego;

import java.awt.Graphics2D;
import javax.swing.ImageIcon;


public class profesora {
    juego jueguito;
    
    int anchoProfesora=100, altoProfesora=100;
    
    public profesora(juego jueguito){
        this.jueguito=jueguito;
    }
    
    public void paint(Graphics2D g){        
        ImageIcon profe=new ImageIcon(getClass().getResource("/multimedia/profeosora.gif"));        
        if (jueguito.vidas==0) {
            g.drawImage(profe.getImage(), 285,90 ,anchoProfesora,altoProfesora,null);
        }
        
        
        
    }
}
