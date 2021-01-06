package game;

import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class GameOverScreen extends VBox {
    private int SCENE_HEIGHT = 720;
    private int SCENE_WIDTH = 1080;

    GameOverScreen(int SCORE, GameScene scene, StackPane stackPane){
        this.setHeight(SCENE_HEIGHT-200);
        this.setWidth(SCENE_WIDTH - 200);
        this.setTranslateX((SCENE_WIDTH/2)-100);
        this.setTranslateY((SCENE_HEIGHT/2)-50);

        Text head = new Text("GAME OVER");
        head.setFont(new Font(25));
        head.setFill(Color.WHITE);
        head.setX(this.getWidth()/2);
        head.setY((this.getHeight()/2));

        Text scoreToShow = new Text("Your Score is : "+ SCORE);
        scoreToShow.setFont(new Font(20));
        scoreToShow.setFill(Color.WHITE);
        scoreToShow.setX(this.getWidth()/2);
        scoreToShow.setY((this.getHeight()/2)+50);

        Text gameMenu = new Text("Start Menu");
        gameMenu.setFont(new Font(20));
        gameMenu.setFill(Color.DARKMAGENTA);
        gameMenu.setX(this.getWidth()/2);
        gameMenu.setY((this.getHeight()/2)+100);
        gameMenu.setOnMousePressed(e->{
            scene.gameStartMenu();
            stackPane.getChildren().remove(this);

        });


        this.getChildren().addAll(head, scoreToShow, gameMenu);

    }
}
