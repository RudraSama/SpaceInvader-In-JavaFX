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
    public void shipCase(int x){
        switch (x){
            case 1:
                this.setFill(Color.GREEN);
                break;
            case 2:
                this.setFill(Color.WHITE);
                break;
            case 3:
                this.setFill(Color.RED);
                break;
            case 4:
                this.setFill(Color.YELLOW);
                break;
            case 5:
                this.setFill(Color.ORANGE);
                break;
            case 6:
                this.setFill(Color.CYAN);
                break;
        }
    }
}