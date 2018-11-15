package boundary;

import java.awt.*;  
import javax.swing.*;  
  
   
//Customize a panel class
public class MyPanel extends JPanel{  
    public void paintComponent(Graphics g){  
        super.paintComponent(g);  
       
        Image image = new ImageIcon("background.png").getImage();  
        g.drawImage(image, 0, 0, this);  
    }  
}  