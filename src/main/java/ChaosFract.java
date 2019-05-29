import javax.swing.*;
import java.awt.*;

public class ChaosFract extends JPanel {
    private static double a;
    private static double b;
    private static double c;
    private static double d;
    private static double f;
    private static double e;
     private static final long serialVersionUID = 1L;
    static int iter = 6;//количество итераций

    public ChaosFract(double a, double b, double c, double d,double e,double f)
    {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.f = f;
        this.e = e;
    }

//
//    public void paintComponent(Graphics g){
//        Graphics2D g2d = (Graphics2D) g;
//        g.setColor(Color.BLACK);
//        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);   //сглаживание
//        Point z=new Point(300,300);
//        Point z1=new Point(300,300);
//        DrLine(z, z1, g,1000);           //центр и размер фрактала
//    }
//
//    public void DrLine(Point z, Point z1,Graphics g,int iter) {
//
//        //всего получится (N+1) окружность
//        //новые окружности будут иметь радиус size/c
//        if (iter > 0) {
//
//
//           int x2 = (int) a*10*z.x+(int)b*10*z.y+(int)c*10;
//           int y2 = (int)d*10*z.x+(int)e*10*z.y+(int)f*10;
//            z1.x = x2;
//            z1.y = y2;
//
//        //    xx[iter]=x2;
//         //   yy[iter]=y2;
//
//            DrLine(z,z1, g,iter-1);           //центральная окружность
//
//
//
//        }
//        //xx[5000]=300;
//      //  yy[5000]=300;
//        g.setColor(Color.BLUE);
//        g.fillRect(z1.x,z1.y,2,2);
//      //  g.drawLine((int)z.x, (int)z.y, z1.x, z1.y);
//
//    }



    public static int drawTSQ(Graphics g, Point A, int size, int iter) {
        //параметры А - координата левого верхнего угла квадрата
        //size - длина стороны
        //iter - кол-во итераций
        //g - экземпляр библиотечного класса, ответственного за отрисовку
        if(iter==1){//если итерация одна, просто рисуем заполненный прямоугольник
            g.fillRect(A.x, A.y, size, size);
            return 0;
        }
        int dd=size/4; //вспомогательная переменная, четверть длины исходного квадрата
        Point M[]=new Point[4];//координаты левых верхних углов порожденных квадратов
        for(int i=0;i<4;i++){
            M[i]=new Point();
        }

        M[0].x=(int)a*A.x+(int)b*A.y+(int)e-dd;//левый верхний квадрат
        M[0].y=(int)c*A.y+(int)d*A.y+(int)f-dd;
        M[1].x=(int)a*A.x+(int)b*A.y+(int)e-dd;//левый нижний
        M[1].y=(int)c*A.y+(int)d*A.y+(int)f+size-dd;
        M[2].x=(int)a*A.x+(int)b*A.y+(int)e+size-dd;//правый верхний
        M[2].y=(int)c*A.y+(int)d*A.y+(int)f-dd;
        M[3].x=(int)a*A.x+(int)b*A.y+(int)e+size-dd;//правый нижний
        M[3].y=(int)c*A.y+(int)d*A.y+(int)f+size-dd;


        for(int i=0;i<4;i++){
            drawTSQ(g, M[i], size/2, iter-1);//вызываем рекурсивно для каждого квадрата
        }
        g.fillRect(A.x, A.y, size, size);//отрисовываем исходный квадрат
        return 0;

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.WHITE);
        g.setColor(Color.BLACK);
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension size = kit.getScreenSize();
        int h=size.height;
        int w=size.width;
        Point A=new Point(w/2-h/4,h/4);//координаты левого верхнего угла исходного квадрата

        drawTSQ(g, A, h/2-h/10, iter);//вызываем отрисовку фрактала
        repaint();

    }
}
