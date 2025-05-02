package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Fruit {
    private int x;
    private int y;
    private ImageIcon img;

    public Fruit(){
        //img = new ImageIcon("fruit.png");
        img = new ImageIcon(getClass().getResource("fruit.png"));
        this.x = (int)(Math.floor(Math.random()* Main.column)*Main.CELL_SIZE);
        this.y = (int)(Math.floor(Math.random()* Main.row)*Main.CELL_SIZE);
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public void drawFruit(Graphics g){
//        g.setColor(Color.orange);
//        g.fillOval(this.x,this.y,Main.CELL_SIZE,Main.CELL_SIZE);
        img.paintIcon(null,g,this.x,this.y);
    }

    public void setNewLocation(Snake s){
        //Need to avoid generating on snake body location.
        int new_x;
        int new_y;
        boolean isOverlapping = false;
        do{
            new_x = (int)(Math.floor(Math.random()* Main.column)*Main.CELL_SIZE);
            new_y = (int)(Math.floor(Math.random()* Main.row)*Main.CELL_SIZE);
            isOverlapping = checkOverlap(new_x,new_y,s);
        }while (isOverlapping);

        this.x = new_x;
        this.y = new_y;
    }

    private boolean checkOverlap(int x,int y, Snake s){
        ArrayList<Node> snakeBody = s.getSnakebody();
        for(int i = 0;i<s.getSnakebody().size();i++){
            if(x == snakeBody.get(i).x && y == snakeBody.get(i).y){
                return  true;
            }
        }
        return  false;
    }
}
