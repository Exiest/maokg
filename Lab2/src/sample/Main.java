package sample;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.GeneralPath;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Main extends JPanel implements ActionListener {
    Timer timer;

    private static int maxWidth = 1600;
    private static int maxHeight = 900;

    private static int paddingX = 500;
    private static int paddingY = 250;

    private double angle = 0;

    private double scale = 0.1;
    private double delta = 0.01;

    private final double centerX = 1;
    private final double centerY = 1;

    public Main() {
        timer = new Timer(50, this);
        timer.start();
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHints(rh);

        g2d.setBackground(new Color(15, 127, 18));
        g2d.clearRect(0, 0, maxWidth, maxHeight);

        g2d.setColor(new Color(255, 253, 56));
        BasicStroke bs1 = new BasicStroke(10, BasicStroke.CAP_ROUND,
                BasicStroke.JOIN_BEVEL);
        g2d.setStroke(bs1);
        g2d.drawRect(0, 0, 1400, 750);

        g2d.translate(maxWidth / 2, maxHeight / 2);
        g2d.rotate(angle, centerX, centerY);
        g2d.scale(scale, scale);

        GradientPaint gp = new GradientPaint(5, 25, Color.RED, 20, 2, Color.GREEN, true);
        g2d.setPaint(gp);
        double points[][] = {
                { 180, 20 },
                { 113, 173 },
                { 280, 173 }
        };
        GeneralPath rect = new GeneralPath();
        rect.moveTo(points[0][0], points[0][1]);
        for (int k = 1; k < points.length; k++)
            rect.lineTo(points[k][0], points[k][1]);
        rect.closePath();
        g2d.fill(rect);

        g2d.setColor(Color.BLUE);

        g2d.drawLine(64, 20, 120, 20);
        g2d.drawLine(233, 20, 302, 20);

        g2d.setColor(Color.RED);

        g2d.drawPolyline(new int[]{20, 84, 313, 370}, new int[]{19, 222, 222, 19}, 4);
    }

    public void actionPerformed(ActionEvent e) {

        if (scale < 0.01) {
            delta = -delta;
        } else if (scale > 0.99) {
            delta = -delta;
        }
        angle -= 0.1;
        scale += delta;
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("lab2");
        frame.add(new Main());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(maxWidth, maxHeight);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
        Dimension size = frame.getSize();
        Insets insets = frame.getInsets();
        maxWidth = size.width - insets.left - insets.right - 1;
        maxHeight = size.height - insets.top - insets.bottom - 1;
    }
}
