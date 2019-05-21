

public class Julia implements Fractal {

double a;
double b;

    public Julia(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public Position getZoom() {
        return new Position(-1.59, 1.527, -1.558, 1.558); }

    @Override
    public int getFunction(double x0, double y0,int iterations) {
        double r = 0;
     //  double a = -0.55;
    //   double b = -0.55;

        double x = x0;
        double y = y0;
        int color = iterations;
        while (color > 0 && r < 4) {
            double x2 = x * x;
            double y2 = y * y;
            double xy = x * y;
            x = x2 - y2 + a;
            y = 2 * xy + b;
            r = x2 + y2;
            color--;

        }
        return color;
    }
}