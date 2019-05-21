import java.util.Random;

public class ChaosGame implements Fractal {
    private double a,b,c,d,f,e;

    public ChaosGame(double a, double b, double c, double d,double e,double f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.f = f;
        this.e = e;
    }

    @Override
    public Position getZoom() {
        return new Position(-1.0, 1.0, -1.0, 1.0); }



    @Override
    public int getFunction(double x0, double y0, int iterations) {


        double x = x0;
        double y = y0;
        int color = iterations;

        double r=0;
        double r1=0;
        double r2=0;


        while (x>-0.1&& x <0.1)
         {
            double x2 = a*x+b*y+c;
            double y2 = d*x+e*y+f;
            x = x2;
            y = y2;

            color--;
        }

        return color;
    }
}
