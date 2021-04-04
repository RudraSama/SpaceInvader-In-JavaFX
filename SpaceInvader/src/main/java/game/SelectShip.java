package game;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;


import java.io.File;
import java.net.MalformedURLException;

public class SelectShip extends AnchorPane {
    private int SCENE_HEIGHT = 720;
    private int SCENE_WIDTH = 1080;
    ImageView ship1;
    ImageView ship2;
    ImageView ship3;
    ImageView ship4;
    ImageView ship5;
    ImageView ship6;
    private int height = 70;
    private int width = 130;



    SelectShip(Hero hero, Pane pane, StackPane stackPane, AnchorPane anchorPane, GameScene gameScene) throws MalformedURLException {

        this.setTranslateX((SCENE_WIDTH/2)-150);
        this.setTranslateY((SCENE_HEIGHT/2)-150);

        GridPane gridPane = new GridPane();
        gridPane.setTranslateX((this.getMaxWidth()/2)-95);
        gridPane.setTranslateY((this.getMaxHeight()/2));
        gridPane.setHgap(40);
        gridPane.setVgap(40);

        ship1 = new ImageView();
        ship1.setImage(new Image(String.valueOf(new File("images/ship1.png").toURI().toURL())));
        ship1.setFitHeight(height);
        ship1.setFitWidth(width);
        ship1.setX((this.getMaxWidth()/2)+80);
        ship1.setY((this.getMaxHeight()/2)+100);
        ship1.setOnMouseClicked(e->{
            pane.getChildren().remove(hero);
            gameScene.setSHIPCASE(1);
            pane.getChildren().add(hero);
            stackPane.getChildren().remove(this);
            stackPane.getChildren().add(anchorPane);


        });

        ship2 = new ImageView();
        ship2.setImage(new Image(String.valueOf(new File("images/ship2.png").toURI().toURL())));
        ship2.setFitHeight(height);
        ship2.setFitWidth(width);
        ship2.setX((this.getMaxWidth()/2)+80);
        ship2.setY((this.getMaxHeight()/2)+100);
        ship2.setOnMouseClicked(e->{
            pane.getChildren().remove(hero);
            hero.setImage(ship2.getImage());
            pane.getChildren().add(hero);
            gameScene.setSHIPCASE(2);
            stackPane.getChildren().remove(this);
            stackPane.getChildren().add(anchorPane);
        });

        ship3 = new ImageView();
        ship3.setImage(new Image(String.valueOf(new File("images/ship3.png").toURI().toURL())));
        ship3.setFitHeight(height);
        ship3.setFitWidth(width);
        ship3.setX((this.getMaxWidth()/2)+80);
        ship3.setY((this.getMaxHeight()/2)+100);
        ship3.setOnMouseClicked(e->{
            pane.getChildren().remove(hero);
            hero.setImage(ship3.getImage());
            pane.getChildren().add(hero);
            gameScene.setSHIPCASE(3);
            stackPane.getChildren().remove(this);
            stackPane.getChildren().add(anchorPane);
        });

        ship4 = new ImageView();
        ship4.setImage(new Image(String.valueOf(new File("images/ship4.png").toURI().toURL())));
        ship4.setFitHeight(height);
        ship4.setFitWidth(width);
        ship4.setX((this.getMaxWidth()/2)+80);
        ship4.setY((this.getMaxHeight()/2)+100);
        ship4.setOnMouseClicked(e->{
            pane.getChildren().remove(hero);
            hero.setImage(ship4.getImage());
            pane.getChildren().add(hero);
            gameScene.setSHIPCASE(4);
            stackPane.getChildren().remove(this);
            stackPane.getChildren().add(anchorPane);
        });

        ship5 = new ImageView();
        ship5.setImage(new Image(String.valueOf(new File("images/ship5.png").toURI().toURL())));
        ship5.setFitHeight(height);
        ship5.setFitWidth(width);
        ship5.setX((this.getMaxWidth()/2)+80);
        ship5.setY((this.getMaxHeight()/2)+100);
        ship5.setOnMouseClicked(e->{
            pane.getChildren().remove(hero);
            hero.setImage(ship5.getImage());
            pane.getChildren().add(hero);
            gameScene.setSHIPCASE(5);
            stackPane.getChildren().remove(this);
            stackPane.getChildren().add(anchorPane);
        });

        ship6 = new ImageView();
        ship6.setImage(new Image(String.valueOf(new File("images/ship6.png").toURI().toURL())));
        ship6.setFitHeight(height);
        ship6.setFitWidth(width);
        ship6.setX((this.getMaxWidth()/2)+80);
        ship6.setY((this.getMaxHeight()/2)+100);
        ship6.setOnMouseClicked(e->{
            pane.getChildren().remove(hero);
            hero.setImage(ship6.getImage());
            pane.getChildren().add(hero);
            gameScene.setSHIPCASE(6);
            stackPane.getChildren().remove(this);
            stackPane.getChildren().add(anchorPane);
        });




        gridPane.add(ship1, 0, 0, 1, 1);
        gridPane.add(ship2, 1, 0, 1, 1);
        gridPane.add(ship3, 2, 0, 1, 1);
        gridPane.add(ship4, 0, 1, 1, 1);
        gridPane.add(ship5, 1, 1, 1, 1);
        gridPane.add(ship6, 2, 1, 1, 1);


        this.getChildren().add(gridPane);
    }
}
