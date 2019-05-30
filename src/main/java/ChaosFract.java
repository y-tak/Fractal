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
