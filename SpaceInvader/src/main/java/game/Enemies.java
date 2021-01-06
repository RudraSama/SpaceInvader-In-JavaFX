package game;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.MalformedURLException;
import java.util.Random;

public class Enemies extends ImageView {
    private Image[] images = new Image[]{
            new Image(String.valueOf(new File("images/enemtship3.png").toURI().toURL())),
            new Image(String.valueOf(new File("images/enemyShip2.png").toURI().toURL())),
            new Image(String.valueOf(new File("images/enemyShip4.png").toURI().toURL())),
            new Image(String.valueOf(new File("images/enemyShip5.png").toURI().toURL())),
            new Image(String.valueOf(new File("images/enemyShip1.png").toURI().toURL()))
    };
    private Random random = new Random();

    Enemies(double posX, double posY, double height, double width) throws MalformedURLException {
        this.setImage(images[random.nextInt(5)]);
        this.setFitWidth(width);
        this.setFitHeight(height);
        this.setTranslateX(posX);
        this.setTranslateY(posY);
    }

    public void move(double SPEED){
        this.setTranslateY(this.getTranslateY()+SPEED);
    }

    public Enemies show(){
        return this;
    }
    public double getPosY(){
        return this.getTranslateY();
    }
    public boolean collide(Hero hero){
        boolean isCollide = false;
        if (hero.getBoundsInParent().intersects(this.getBoundsInParent())) {
            isCollide = true;
        }
        return isCollide;
    }

}
