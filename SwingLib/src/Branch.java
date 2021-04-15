import java.awt.*;

public class Branch implements XmasShape {
    int x;
    int y;
    int width;
    int height;
    double scale;

    Branch(int x,int y, int width,int height,double scale){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.scale = scale;
         }


    @Override
    public void transform(Graphics2D g2d) {
        g2d.translate(x, y);
        g2d.scale(scale, scale);


    }

    @Override
    public void render(Graphics2D g2d) {

        g2d.setColor(new Color(9,100,50));
        int [] X = {0, width, -width};
        int [] Y = {0, height, height};
        g2d.fillPolygon(X,Y,X.length);

    }


}