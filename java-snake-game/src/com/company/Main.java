package com.company;

import javax.swing.*;
import java.awt.*;
import java.sql.Time;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;


public class Main extends JPanel {

    public static final int CELL_SIZE = 20;
    public static int width = 400;
    public static int height = 400;
    public static int row = height / CELL_SIZE;
    public static int column = width / CELL_SIZE;
    private Snake snake;
    private Fruit fruit;
    private Timer t;
    private int speed = 100;
    private static String direction ;

    public Main() {
        snake = new Snake();
        fruit = new Fruit();
        t = new Timer();
        t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                repaint();
            }
        },0,speed);
        direction = "Right";
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

        switch (direction){
            case "Right":
                snakeX += CELL_SIZE;
                break;
            case "Left":
                snakeX -= CELL_SIZE;
                break;
        }
        Node newNode = new Node(snakeX,snakeY);
        snake.getSnakebody().removeLast();
        snake.getSnakebody().addFirst(newNode);
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
}
