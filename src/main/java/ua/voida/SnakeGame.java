package ua.voida;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class  SnakeGame extends JPanel implements ActionListener {
    public static final int SCALE = 32;
    public static final int WIDTH = 20;
    public static final int HEIGHT = 20;
    public static final int SPEED = 5;

    Apple apple = new Apple((int) (Math.random() * WIDTH), (int) (Math.random() * HEIGHT));
    Snake s = new Snake(10, 10, 9, 10);
    Timer t = new Timer(1000/SPEED,this);
    public SnakeGame() {
        t.start();
        addKeyListener(new Keyboard());
        setFocusable(true);
    }
    public void paint (Graphics graphics) {
        graphics.setColor(color(0, 0, 0));
        graphics.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);
        graphics.setColor(color(0, 255, 0));
        for (int xx = 0; xx <= WIDTH * SCALE ; xx += SCALE) {
            graphics.drawLine(xx, 0, xx, HEIGHT * SCALE);
        }
        for (int yy = 0; yy < HEIGHT * SCALE ; yy += SCALE) {
            graphics.drawLine(0, yy, HEIGHT * SCALE, yy);
        }
        graphics.setColor(color(255, 255, 255));
        for (int item  = 0; item  < s.lenght; item ++) {
            graphics.fillRect(s.snakeX[item] * SCALE + 1, s.snakeY[item] * SCALE + 1, SCALE - 1, SCALE - 1);
        }
        graphics.setColor(color(204, 0 , 204));
        graphics.fillRect(apple.posX * SCALE + 1, apple.posY * SCALE + 1, SCALE - 1, SCALE - 1);

    }
    public Color color (int red, int green, int blue) {
        return new Color(red, green, blue);
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(WIDTH * SCALE + 10, HEIGHT * SCALE + 30);
        frame.setLocationRelativeTo(null);
        frame.add(new SnakeGame());
        frame.setVisible(true);
    }


    public void actionPerformed(ActionEvent actionEvent) {
        s.move();
        if (s.snakeX[0] == apple.posX && s.snakeY[0] == apple.posY) {
            apple.setRandomPosition();
            s.lenght++;
        }
        for (int item = 1; item < s.lenght ; item++) {
            if (s.snakeX[item] == apple.posX && s.snakeY[item] == apple.posY) {
                apple.setRandomPosition();
            }
        }
        repaint();
    }

    private class Keyboard extends KeyAdapter {
        public void keyPressed (KeyEvent keyEvent) {
            int key = keyEvent.getKeyCode();

            if ( key == keyEvent.VK_D && s.direction != 2) {
                s.direction = 0;
            } else if ( key == keyEvent.VK_S && s.direction != 3) {
                s.direction = 1;
            }
            else if ( key == keyEvent.VK_A && s.direction != 0) {
                s.direction = 2;
            }
            else if ( key == keyEvent.VK_W && s.direction != 1) {
                s.direction = 3;
            }
        }
    }
}
