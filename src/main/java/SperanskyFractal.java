import javax.swing.*;
import java.awt.*;

public class SperanskyFractal extends JPanel {
  //  private static Graphics2D g2d;

    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.BLACK);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);   //сглаживание
        drawSerpinsky(10, new  int[]{40, 320, 600}, new  int[]{470, 10, 470},g2d);           //центр и размер фрактала
    }
private void drawSerpinsky(int n,  int[] x,  int[] y,Graphics2D g2d) {
        if(n > 0) {
        int x1 = (x[0] + x[1]) / 2;
            int y1 = (y[0] + y[1]) / 2;

            int x2 = (x[1] + x[2]) / 2;
            int y2 = (y[1] + y[2]) / 2;

            int x3 = (x[2] + x[0]) / 2;
            int y3 = (y[2] + y[0]) / 2;

            g2d.setColor(Color.BLACK);
            g2d.fillPolygon(x, y, 3);

            g2d.setColor(Color.WHITE);
            g2d.fillPolygon(new  int[]{x1, x2, x3}, new  int[]{y1, y2, y3}, 3);

                drawSerpinsky(n-1, new  int[]{x[0], x1, x3}, new  int[]{y[0], y1, y3},g2d);
                drawSerpinsky(n-1, new  int[]{x1, x[1], x2}, new  int[]{y1, y[1], y2},g2d);
                drawSerpinsky(n-1, new  int[]{x3, x2, x[2]}, new  int[]{y3, y2, y[2]},g2d);
            }

            }

//
//        Platform.runLater(() -> {
//        drawSerpinsky(n-1, new double[]{x[0], x1, x3}, new double[]{y[0], y1, y3});
//        drawSerpinsky(n-1, new double[]{x1, x[1], x2}, new double[]{y1, y[1], y2});
//        drawSerpinsky(n-1, new double[]{x3, x2, x[2]}, new double[]{y3, y2, y[2]});
  //      });
        }
