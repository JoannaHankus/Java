import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Main{
    public static void main(String[] args){

        DrawPanel Tree = new DrawPanel();
        int size=4;
        int width=1000;
        int height=400;

        for (int i=1;i<=size;i++){
            int tmp = 0;
            tmp = tmp + i;
            int tmp1 = 1;
            tmp1 = tmp1 + i;
            Tree.addShape(new Branch(width/2,height/10+(tmp)*100,width/5+i*30,height/3+(tmp1)*50,0.8));
        }

        Tree.addShape(new Star(width/2-185,80,0.6));

        for (int j=1;j<54;j++){
            Tree.addShape(new Light(width/2-150+j*5,270+j*2,0.2, new Color(255, 163-2*j, 14)));
        }
        for (int j=1;j<50;j++){
            Tree.addShape(new Light(width/2+120-j*5,378+j*2,0.2, new Color(255, 25+2*j, 0)));
        }
        for (int j=1;j<54;j++){
            Tree.addShape(new Light(width/2-130+j*5,478+j*2,0.2, new Color(255, 163-2*j, 0)));
        }
        for (int j=1;j<70;j++){
            Tree.addShape(new Light(width/2+140-j*5,586+j*2,0.2, new Color(255, 25+2*j, 0)));
        }

        Tree.addShape(new Bubble(width/2,height/2,0.3,new Color(255, 6, 190)));
        Tree.addShape(new Bubble(width/2+40,height/2+50,0.3,new Color(169, 13, 255)));
        Tree.addShape(new Bubble(width/2+30,height/2+150,0.3,new Color(169, 13, 255)));
        Tree.addShape(new Bubble(width/2-60,height/2+160,0.3,new Color(0, 30, 230)));
        Tree.addShape(new Bubble(width/2-90,height/2+80,0.3,new Color(255, 6, 190)));
        Tree.addShape(new Bubble(width/2+110,height/2+200,0.3,new Color(0, 30, 230)));
        Tree.addShape(new Bubble(width/2-10,height/2+215,0.3,new Color(255, 6, 190)));
        Tree.addShape(new Bubble(width/2-60,height/2+250,0.3,new Color(169, 13, 255)));
        Tree.addShape(new Bubble(width/2-120,height/2+300,0.3,new Color(0, 30, 230)));
        Tree.addShape(new Bubble(width/2+40,height/2+330,0.3,new Color(255, 6, 190)));
        Tree.addShape(new Bubble(width/2+30,height/2+450,0.3,new Color(0, 30, 230)));
        Tree.addShape(new Bubble(width/2-90,height/2+370,0.3,new Color(169, 13, 255)));
        Tree.addShape(new Bubble(width/2+110,height/2+490,0.3,new Color(255, 6, 190)));
        Tree.addShape(new Bubble(width/2-60,height/2+415,0.3,new Color(255, 6, 190)));
        Tree.addShape(new Bubble(width/2-120,height/2+440,0.3,new Color(169, 13, 255)));

        for (int i=0;i<40;i++) {
            double randomDoubleX = Math.random();
            randomDoubleX = randomDoubleX * (width/2-150)+ (width/2-200);
            int randomIntX = (int) randomDoubleX;

            double randomDoubleY = Math.random();
            randomDoubleY = randomDoubleY * (700)+ (height/3+50);
            int randomIntY = (int) randomDoubleY;
            Tree.addShape(new Star(randomIntX,randomIntY,0.1));

        }
        Tree.addShape(new Trunk(width/2,740,50,100,1));

        JFrame frame = new JFrame("ChristmasTree");
        frame.add(Tree);
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(true);
        frame.setVisible(true);
    }
}