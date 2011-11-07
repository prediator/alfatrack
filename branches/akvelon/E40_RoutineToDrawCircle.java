import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author Sergii Pogodin
 */
public class E40_RoutineToDrawCircle {
    public static void draw(int r, Dottable dottable) {
        for (int x = 0, y = r-1; x <= r; x++) {
            do {
                dottable.dot(x, y);
                dottable.dot(-x, y);
                dottable.dot(x, -y);
                dottable.dot(-x, -y);
            } while (x*x + y*y >= r*r && y-- > -1);
        }
    }

    public static void main(String[] args) {
        JPanel jPanel = new JPanel() {
            @Override
            protected void paintComponent(final Graphics g) {
                super.paintComponent(g);

//                g.drawString(" Hello, Pink Panther! ", 30, 30);
//                g.drawLine(50, 50, 100, 100);
//                g.drawOval(100, 100, 50, 30);

                draw(100, new Dottable() {
                    public void dot(int x, int y) {
                        g.fillRect(150 + x, 150 + y, 1, 1);
                    }
                });
            }
        };
        jPanel.setSize(500, 500);

        JFrame jFrame = new JFrame();
        jFrame.setSize(500, 500);
        jFrame.add(jPanel);

        jFrame.setVisible(true);
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    interface Dottable {
        void dot(int x, int y);
    }
}
