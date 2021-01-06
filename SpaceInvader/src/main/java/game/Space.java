package game;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.Random;

public class Space extends Circle {
    private Random random = new Random();
    private int SCENE_WIDTH = 1080;

    int RADIUS = random.nextInt(3);
    Space(){
        this.setRadius(RADIUS);
        this.setFill(Color.rgb(255, 255, 255, 0.5));
        this.setCenterX(random.nextInt(SCENE_WIDTH));
        this.setCenterY(0);
    }

    public void move(double SPEED){
        this.setCenterY(this.getCenterY() + SPEED);
    }
}