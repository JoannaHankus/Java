import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class DrawPanel extends JPanel{

    List<XmasShape> shapes = new ArrayList<>();
    Image img = Toolkit.getDefaultToolkit().getImage("śnieżynki.jpg");
    DrawPanel(){
        //GradientPaint grad = new GradientPaint(0,0,new Color(0,255,0),0,100, new Color(0,10,0));
        //setBackground(new Color(grad));
        //setBackground(new Color(39, 133, 116));
    }

    DrawPanel addShape(XmasShape object){
        shapes.add(object);
        return this;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(img,0,0,getWidth(),getHeight(),this);
        g.setColor(new Color(252, 13, 0));
        g.setFont(new Font("Helvetica", Font.BOLD, 65));
        g.drawString("Wesołych Świąt!", 710, 180);
        for(XmasShape s:shapes){
            s.draw((Graphics2D)g);

        }

    }
}