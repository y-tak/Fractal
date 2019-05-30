import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.AbstractDocument;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.Date;

import java.util.Scanner;


public final class FractalDemo {


    public static void main(String[] args) throws IOException {
        draw(new Mandelbrot(), 6);
        draw(new Julia(-0.55, -0.55), 5);
        draw(new Julia(0.45, 0.14828), 4);
        draw(new Julia(-0.70176, -0.2321), 3);
        draw(new Julia(-0.835, 0.156), 1);
        draw(new Julia(-0.7269, 0.1889), 2);


        drawCircFract();
        drawTFract();
        drawSperansky();
        drawChaos();
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

    private static void drawCircFract()
    {
        JFrame window = new JFrame("CircFract");
        window.setSize(600, 600);
        window.setContentPane(new CircFractal());
        window.setBackground(Color.WHITE);
        window.setResizable(false);
        window.setDefaultCloseOperation(3);
        window.setVisible(true);

    }
    private static void drawChaos()
    {
        JFrame window = new JFrame("ChaosFract");
        window.setSize(600, 600);
       //window.setContentPane(new ChaosFract(0.014,0.01,0.000,0.5100,-0.0800,-1.31));
        window.setContentPane(new ChaosFract(0.7878,-0.4242,0.2424,0.8598,1.7586,1.408));
        window.setBackground(Color.WHITE);
        window.setResizable(false);
        window.setDefaultCloseOperation(3);
        window.setVisible(true);

    }

    private static void drawSperansky()
    {
       JFrame window = new JFrame("SperanskyFract");
        window.setSize(650, 650);
//        window.setContentPane(new SperanskyFractal());
        window.setBackground(Color.WHITE);
        window.setResizable(false);
        window.setDefaultCloseOperation(3);
        window.setVisible(true);
        SperanskyFractal sp=new SperanskyFractal();
        window.add(sp);
        BufferedImage image =(BufferedImage)
              sp.createImage(650, 650);
        Graphics g2 = image.createGraphics();
        sp.paintComponent(g2);
        g2.dispose();
        try {
            ImageIO.write(image, "bmp", new File("src/speransky.bmp"));
        }
        catch(IOException io) { io.printStackTrace(); }



    }

    private static void drawTFract()
    {
        final long serialVersionUID = -7737600175393242130L;
        Toolkit kit = Toolkit.getDefaultToolkit();

        JFrame window = new JFrame("TFract");
       // window.setSize(600, 600);
        window.setSize(kit.getScreenSize());
        window.setContentPane(new TFract());
        window.setBackground(Color.WHITE);
        window.setResizable(false);
        window.setDefaultCloseOperation(3);
        window.setVisible(true);

    }

    private static void draw(Fractal fractal,int kol) throws IOException {

        BmpImage bmp = new BmpImage();
        Palette palette = new BlackAndWhite256Palette();
        Progress image = new Progress(new FractalImage(1920, 1080, fractal, palette));
        bmp.image = image;
        Date data=new Date();
        File file = new File("src/"+image.getFractalName()+kol+ ".bmp");
        String nameFile=image.getFractalName()+kol+ ".bmp";
        FileOutputStream out = new FileOutputStream(file);
        BmpWriter.write(out, bmp);
        out.close();


               //показать все картинки
        ImageFrame frame = new ImageFrame(nameFile);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}