package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
    private int speed = 100;
    private static String direction;
    private boolean allowKeyPress;    //Set the delay-time
    private int score;
    private int highestScore;
    String desktop = System.getProperty("user.home")+"/Desktop/";
    String myFile =  desktop + "snake_filename.txt";

    public Main() {
        reset();
        readHighestScore();
        addKeyListener(this);
    }

    private void setTimer() {
        t = new Timer();
        t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                repaint();
            }
        }, 0, speed);
    }

    private void reset() {
        score = 0;
        if (snake != null) {
            snake.getSnakebody().clear();
        }
        allowKeyPress = true;
        direction = "Right";
        snake = new Snake();
        fruit = new Fruit();
        setTimer();
    }

    @Override
    public void paintComponent(Graphics g) {
        //check if the snake bites itself
        ArrayList<Node> snakeBody = snake.getSnakebody();
        Node head = snakeBody.getFirst();

        for (int i = 1; i < snakeBody.size(); i++) {
            Node body = snakeBody.get(i);
            if (body.x == head.x && body.y == head.y) {
                allowKeyPress = false;
                t.cancel();
                t.purge();
                writeHighestScore(score);
                int response = JOptionPane.showOptionDialog(this, "Game Over! Your score :" + score + ",\nThe highest score is "+highestScore +",\nWould u like to start over?", "Game Over", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, JOptionPane.YES_OPTION);
                switch (response) {
                    case JOptionPane.CLOSED_OPTION:
                    case JOptionPane.NO_OPTION:
                        System.exit(0);
                        break;
                    case JOptionPane.YES_OPTION:
                        reset();
                        return;

                }
            }
        }
        //black bg
        g.fillRect(0, 0, width, height);
        fruit.drawFruit(g);
        snake.drawSnack(g);

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

        //Check if the snake eats the fruits.
        if (snake.getSnakebody().getFirst().x == fruit.getX() && snake.getSnakebody().getFirst().y == fruit.getY()) {
            //1.Set new fruit and draw it.
            fruit.setNewLocation(snake);
            fruit.drawFruit(g);
            //2.Extend the size of snake. -> Don't Remove.
            //3.Add score.
            score++;

        } else {
            snake.getSnakebody().removeLast();
        }
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

    public void readHighestScore() {
        try {
            File myObj = new File(myFile);
            Scanner reader = new Scanner(myObj);
            highestScore = reader.nextInt();
            reader.close();
        } catch (FileNotFoundException e) {
            highestScore = 0;
            try {
                File myObj = new File(myFile);
                if (myObj.createNewFile()) {
                    System.out.println("File created." + myObj.getName());
                }
                FileWriter myWriter = new FileWriter(myObj.getName());
                myWriter.write(""+0);
            } catch (IOException ex) {
                System.out.println("In READ, some error occurred!");
                ex.printStackTrace();
            }
        }
    }

    public void writeHighestScore(int score){
        try {
            FileWriter myWriter = new FileWriter(myFile);
            if(score > highestScore){
                highestScore = score;
            }
            myWriter.write(""+highestScore);
            myWriter.close();
        } catch (IOException ex) {
            System.out.println("In Write, some error occurred!");
            ex.printStackTrace();
        }
    }
}
