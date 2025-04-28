package com.company;

import javax.swing.*;
import java.awt.*;

public class Fruit {
    private int x;
    private int y;
    private ImageIcon img;

    public Fruit(){
        img = new ImageIcon("fruit.png");
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
}
