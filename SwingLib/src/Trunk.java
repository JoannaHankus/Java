import java.awt.*;

public class Trunk implements XmasShape {

    int x;
    int y;
    int width;
    int height;
    double scale;

    Trunk(int x,int y,int width,int height,double scale){
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        this.scale=scale;
    }


    @Override
    public void transform(Graphics2D g2d) {
        g2d.translate(x,y);
        g2d.scale(scale,scale);

    }

    @Override
    public void render(Graphics2D g2d) {
        g2d.setColor(new Color(120, 25, 9));
        g2d.fillRect(0,0,width,height);
    }
}