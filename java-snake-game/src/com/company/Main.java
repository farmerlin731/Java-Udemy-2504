package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Time;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;


public class Main extends JPanel implements KeyListener {

    public static final int CELL_SIZE = 20;
    public static int width = 400;
    public static int height = 400;
    public static int row = height / CELL_SIZE;
    public static int column = width / CELL_SIZE;
    private Snake snake;
    private Fruit fruit;
    private Timer t;
    private int speed = 500;
    private static String direction;
    //Set the delay-time
    private boolean allowKeyPress;


    public Main() {
        snake = new Snake();
        fruit = new Fruit();
        t = new Timer();
        t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                repaint();
            }
        }, 0, speed);
        direction = "Right";
        addKeyListener(this);
        allowKeyPress = true;
    }

    @Override
    public void paintComponent(Graphics g) {
        //black bg
        g.fillRect(0, 0, width, height);
        snake.drawSnack(g);
        fruit.drawFruit(g);

        //Remove the tail & add the new head.
        int snakeX = snake.getSnakebody().getFirst().x;
        int snakeY = snake.getSnakebody().getFirst().y;

        switch (direction) {
            case "Right":
                snakeX += CELL_SIZE;
                break;
            case "Left":
                snakeX -= CELL_SIZE;
                break;
            case "Up":
                snakeY -= CELL_SIZE;
                break;
            case "Down":
                snakeY += CELL_SIZE;
                break;
        }
        Node newNode = new Node(snakeX, snakeY);
        snake.getSnakebody().removeLast();
        snake.getSnakebody().addFirst(newNode);

        allowKeyPress = true;
        requestFocusInWindow();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(width, height);
    }

    public static void main(String[] args) {
        JFrame window = new JFrame("Snake Game");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setContentPane(new Main());
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.setResizable(false);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
//        System.out.println(e.getKeyCode());
        if (!allowKeyPress) return;

        if (e.getKeyCode() == 37 && !direction.equals("Right")) {
            direction = "Left";
        } else if (e.getKeyCode() == 38 && !direction.equals("Down")) {
            direction = "Up";
        } else if (e.getKeyCode() == 39 && !direction.equals("Left")) {
            direction = "Right";
        } else if (e.getKeyCode() == 40 && !direction.equals("Up")) {
            direction = "Down";
        }
        allowKeyPress = false;
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
