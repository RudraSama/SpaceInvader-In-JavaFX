package game;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class HeroBullets extends Rectangle {
    HeroBullets(Hero hero){
        this.setHeight(3);
        this.setWidth(3);
        this.setFill(Color.RED);
        this.setTranslateX(hero.getTranslateX()+(hero.getFitWidth()/2));
        this.setTranslateY(hero.getTranslateY()-10);
    }
    public void move(){
        this.setTranslateY(this.getTranslateY()-5);
    }
    public boolean collide(Enemies enemies){
        boolean isCollide = false;
        if (enemies.getBoundsInParent().intersects(this.getBoundsInParent())){
            isCollide = true;
        }
        return isCollide;
    }
    public void upgrade(){
        this.setHeight(8);
        this.setWidth(8);
        this.setFill(Color.DARKBLUE);
    }
}