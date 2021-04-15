import java.awt.*;

public class Light implements XmasShape {
    int x;
    int y;
    double scale;
    Color fillColor;

    Light (int x, int y, double scale, Color fillColor){
        this.x = x;
        this.y = y;
        this.scale = scale;
        this.fillColor = fillColor;
    }

    @Override
    public void render(Graphics2D g2d){
        g2d.setColor(fillColor);
        g2d.fillOval(0,0,100,100);
    }

    @Override
    public void transform(Graphics2D g2d) {
        g2d.translate(x,y);
        g2d.scale(scale, scale);
    }
}
