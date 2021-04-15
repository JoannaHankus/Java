import java.awt.*;

public class Star implements XmasShape{
    int midX;
    int midY;
    double scale;
    int radius[] = {118,40,90,40};
    int nPoints = 20;
    int[] X = new int[nPoints];
    int[] Y = new int[nPoints];

    Star(int x, int y, double scale){
        this.midX=x;
        this.midY=y;
        this.scale=scale;
    }

    @Override
    public void transform(Graphics2D g2d) {

        g2d.translate(midX,midY);
        g2d.scale(scale,scale);
    }

    @Override
     public void render(Graphics2D g2d){
        g2d.setColor(new Color(255, 254, 45));

        for(double current=0.0; current<nPoints; current++)
        {
            int i = (int) current;
            double x = Math.cos(current*((2*Math.PI)/nPoints))*radius[i % 4];
            double y = Math.sin(current*((2*Math.PI)/nPoints))*radius[i % 4];

            X[i] = (int) x+midX;
            Y[i] = (int) y+midY;
        }
        g2d.fillPolygon(X, Y, nPoints);
    }

}