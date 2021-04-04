package game;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

public class Hero extends ImageView {
    private int height = 70;
    private int width = 130;
    Hero() throws Exception{
        this.setImage(new Image(String.valueOf(new File("images/heroSpaceShip.png").toURI().toURL())));
        this.setFitHeight(height);
        this.setFitWidth(width);
        this.setTranslateX(480);
        this.setTranslateY(650);
    }
    public double getHeroX(){
        return this.getTranslateX();
    }


}
