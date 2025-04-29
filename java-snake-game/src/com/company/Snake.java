package com.company;

import java.awt.*;
import java.util.ArrayList;

public class Snake {

    private ArrayList<Node> snakebody;

    public Snake() {
        snakebody = new ArrayList<>();
        snakebody.add(new Node(140, 0));
        snakebody.add(new Node(120, 0));
        snakebody.add(new Node(100, 0));
        snakebody.add(new Node(80, 0));
        snakebody.add(new Node(60, 0));
        snakebody.add(new Node(40, 0));
        snakebody.add(new Node(20, 0));
    }

    public ArrayList<Node> getSnakebody() {
        return this.snakebody;
    }

    public void drawSnack(Graphics g) {
        for (int i = 0; i < snakebody.size(); i++) {
            if (i == 0) {
                g.setColor(Color.GREEN);
            } else {
                g.setColor(Color.CYAN);
            }
            Node n = snakebody.get(i);
            if (n.x < 0) n.x += Main.width;
            if (n.x >= Main.width) n.x -= Main.width;
            if (n.y < 0) n.y += Main.height;
            if (n.y >= Main.height) n.y -= Main.height;

            g.fillOval(n.x, n.y, Main.CELL_SIZE, Main.CELL_SIZE);
        }
    }

}
