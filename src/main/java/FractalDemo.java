import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;


public final class FractalDemo {


    public static void main(String[] args) throws IOException {
//        draw(new Mandelbrot());
//        draw(new Julia(-0.55,-0.55));
//        draw(new Julia(0.45,0.14828));
//        draw(new Julia(-0.70176,-0.2321));
//        draw(new Julia(-0.835,0.156));
//        draw(new Julia(-0.8,-0.7269));
//        draw(new Julia(-0.7269,0.1889));
//        draw(new Julia(0.0,-0.8));
       // draw(new ChaosGame(0.787879, -0.424242,0.242424,0.859848,1.758647 ,1.408065));
     //   draw(new ChaosGame(0.43,0.52,-0.45,0.50,1.49 ,-0.75));
        draw(new ChaosGame(0.2020 ,-0.8050,-0.6890,-0.3420,-0.3730 ,-0.6530));
     //   draw(new ChaosGame(-0.0100 ,0.0000,0.0000,-0.4500 ,0.0000 ,0.4000));


       ////------------для ввода вручную-----------------------
//        Scanner in=new Scanner(System.in);
//        System.out.println("Введите два числа от [-1,5;1,5] для констант множества Жули a ");
//        String a=in.next();
//        System.out.println("-------------------");
//        Scanner in1=new Scanner(System.in);
//        System.out.println("Введите два числа от [-1,5;1,5] для констант множества Жули b: =");
//        String b=in.next();
//        draw(new Julia(Double.parseDouble(a),Double.parseDouble(b)));


    }

    private static void draw(Fractal fractal) throws IOException {
        BmpImage bmp = new BmpImage();
        Palette palette = new BlackAndWhite256Palette();
        Progress image = new Progress(new FractalImage(1920, 1080, fractal, palette));
        bmp.image = image;
        Date data=new Date();
        File file = new File(image.getFractalName() +""+data.hashCode()+ ".bmp");
        FileOutputStream out = new FileOutputStream(file);
        BmpWriter.write(out, bmp);
        out.close();
    }
}