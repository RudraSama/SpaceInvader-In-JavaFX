package game;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

public class Hero extends ImageView {
    Hero() throws Exception{
        this.setImage(new Image(String.valueOf(new File("images/heroSpaceShip.png").toURI().toURL())));
        this.setFitHeight(50);
        this.setFitWidth(100);
        this.setTranslateX(540);
        this.setTranslateY(650);
    }
    public double getHeroX(){
        return this.getTranslateX();
    }


}
