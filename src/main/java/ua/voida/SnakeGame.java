package ua.voida;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class  SnakeGame extends JPanel implements ActionListener {
    public static final int SCALE = 32;
    public static final int WIDTH = 25;
    public static final int HEIGHT = 25;
    public static final int SPEED = 15;

    Snake s = new Snake(12, 11, 11, 11);
    Timer t = new Timer(1000/SPEED, this);
    public SnakeGame() {
        t.start();
    }
    @Override
    public void paint (Graphics graphics) {
        graphics.setColor(color(0, 0, 0));
        graphics.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);
        graphics.setColor(color(50, 215, 0));

        for (int xx = 0; xx <= WIDTH * SCALE ; xx += SCALE) {
            graphics.drawLine(xx, 0, xx, HEIGHT * SCALE);
        }
        for (int yy = 0; yy < HEIGHT * SCALE ; yy += SCALE) {
            graphics.drawLine(0, yy, HEIGHT * SCALE, yy);
        }
        for (int item  = 0; item  < s.lenght; item ++) {
            graphics.setColor(color(0, 0, 100));
            graphics.fillRect(s.snakeX[item] * SCALE + 1, s.snakeY[item] * SCALE + 1, SCALE - 1, SCALE - 1);
        }
    }
    public Color color (int red, int green, int blue) {
        return new Color(red, green, blue);
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(WIDTH * SCALE + 7, HEIGHT * SCALE - 5);
        frame.setLocationRelativeTo(null);
        frame.add(new SnakeGame());
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        s.move();
        repaint();
    }
}
