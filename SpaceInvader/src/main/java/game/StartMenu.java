package game;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class StartMenu extends AnchorPane {
    private int SCENE_WIDTH = 1080;
    private int SCENE_HEIGHT = 720;
    StartMenu(StackPane stackPane, GameScene gameScene, Pane pane, Hero hero, VFXSound vfxSound){

        this.setTranslateX((SCENE_WIDTH/2)-150);
        this.setTranslateY((SCENE_HEIGHT/2)-150);

        Text logo = new Text("SPACE WAR");
        logo.setFill(Color.WHITE);
        logo.setFont(new Font(50));
        logo.setStyle("-fx-font-family: FreeMono");
        logo.setX(this.getMaxWidth()/2);
        logo.setY(this.getMaxHeight()/2);

        Text newGame = new Text("New Game");
        newGame.setFill(Color.WHITE);
        newGame.setFont(new Font(20));
        newGame.setX((this.getMaxWidth()/2)+80);
        newGame.setY((this.getMaxHeight()/2)+100);
        newGame.setOnMouseEntered(e->{
            newGame.setFill(Color.RED);
        });
        newGame.setOnMouseExited(e->{
            newGame.setFill(Color.WHITE);
        });

        Text option = new Text("Options");
        option.setFill(Color.WHITE);
        option.setFont(new Font(20));
        option.setX((this.getMaxWidth()/2)+95);
        option.setY((this.getMaxHeight()/2)+150);
        option.setOnMouseEntered(e->{
            option.setFill(Color.RED);
        });
        option.setOnMouseExited(e->{
            option.setFill(Color.WHITE);
        });



        newGame.setOnMouseClicked(e ->{
            gameScene.gameReset();
            gameScene.setStart(true);
            stackPane.getChildren().remove(this);
            pane.getChildren().remove(hero);
            pane.getChildren().add(hero);

        });

        option.setOnMouseClicked(e->{
            stackPane.getChildren().remove(this);
            OptionMenu optionMenu = new OptionMenu(stackPane, hero, pane, this, gameScene, vfxSound );
            stackPane.getChildren().add(optionMenu);
        });
        this.getChildren().addAll(logo,newGame, option);
        stackPane.getChildren().add(this);
    }
}
