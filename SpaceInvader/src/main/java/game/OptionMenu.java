package game;

import javafx.scene.control.CheckBox;
import javafx.scene.layout.*;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class OptionMenu extends AnchorPane {
    private int SCENE_HEIGHT = 720;
    private int SCENE_WIDTH = 1080;
    private Text selectShip;
    private CheckBox vfxBox;
    private CheckBox backgroundSound;
    OptionMenu(StackPane stackPane, Hero hero, Pane pane, AnchorPane anchorPane, GameScene gameScene,  VFXSound vfxSound){
        this.setTranslateX((SCENE_WIDTH/2)-150);
        this.setTranslateY((SCENE_HEIGHT/2)-150);



        selectShip = new Text("Select Ship");
        selectShip.setX((this.getMaxWidth()/2)+80);
        selectShip.setY((this.getMaxHeight()/2)+100);
        selectShip.setFont(new Font(20));
        selectShip.setFill(Color.WHITE);
        selectShip.setOnMouseEntered(e->{
            selectShip.setFill(Color.RED);
        });
        selectShip.setOnMouseExited(e->{
            selectShip.setFill(Color.WHITE);
        });
        selectShip.setOnMouseClicked(e->{
            try{
                stackPane.getChildren().remove(this);
                SelectShip selectShip1 = new SelectShip(hero, pane, stackPane, anchorPane, gameScene);
                stackPane.getChildren().add(selectShip1);
            }catch (Exception exception){
                exception.printStackTrace();
            }
        });



        vfxBox = new CheckBox("VFX Sound");
        vfxBox.setTranslateX((this.getMaxWidth()/2)+80);
        vfxBox.setTranslateY((this.getMaxHeight()/2)+150);
        vfxBox.setTextFill(Color.WHITE);
        vfxBox.setFont(new Font(15));
        vfxBox.setSelected(true);
        vfxBox.setOnMouseEntered(e->{
            vfxBox.setTextFill(Color.RED);
        });
        vfxBox.setOnMouseExited(e->{
            vfxBox.setTextFill(Color.WHITE);
        });
        vfxBox.setOnMouseClicked(e->{
            if (vfxBox.isSelected()){
                vfxSound.unmuteAll();
            }else {
                vfxSound.muteAll();
            }
        });


        backgroundSound = new CheckBox("Background Sound");
        backgroundSound.setTranslateX((this.getMaxWidth()/2)+80);
        backgroundSound.setTranslateY((this.getMaxHeight()/2)+200);
        backgroundSound.setTextFill(Color.WHITE);
        backgroundSound.setFont(new Font(15));
        backgroundSound.setSelected(true);
        backgroundSound.setOnMouseEntered(e->{
            backgroundSound.setTextFill(Color.RED);
        });
        backgroundSound.setOnMouseExited(e->{
            backgroundSound.setTextFill(Color.WHITE);
        });
        backgroundSound.setOnMouseClicked(e->{
            if (backgroundSound.isSelected()){
                vfxSound.unmuteBgMusic();
            }else {
               vfxSound.muteBgMusic();
            }
        });


        this.getChildren().addAll(selectShip, vfxBox, backgroundSound);
    }
}
