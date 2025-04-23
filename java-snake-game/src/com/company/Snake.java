package com.company;

import java.awt.*;
import java.util.ArrayList;

public class Snake {

    private ArrayList<Node> snakebody;

    public Snake() {
        snakebody = new ArrayList<>();
        snakebody.add(new Node(80, 0));
        snakebody.add(new Node(60, 0));
        snakebody.add(new Node(40, 0));
        snakebody.add(new Node(20, 0));
    }

    public void drawSnack(Graphics g) {
        g.setColor(Color.GREEN);
        for (Node n: snakebody){
            g.fillOval(n.x,n.y,Main.CELL_SIZE,Main.CELL_SIZE);
        }
    }

}
