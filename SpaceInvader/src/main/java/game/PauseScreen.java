package game;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class PauseScreen extends StackPane {
    private int SCENE_HEIGHT = 720;
    private int SCENE_WIDTH = 1080;
    private Rectangle rectangle;
    PauseScreen(){
        this.setHeight(SCENE_HEIGHT-100);
        this.setWidth(SCENE_WIDTH -100);
        rectangle = new Rectangle(this.getWidth(), this.getHeight(), Color.rgb(255,255,255,0.2));
        Text head = new Text("PAUSED");
        head.setFont(new Font(25));
        this.getChildren().addAll(rectangle,head);
    }
}
