package game;


import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class GameScene extends Application {

    private final int SCENE_WIDTH = 1080;
    private final int SCENE_HEIGHT = 720;
    private double SPACE_SPEED = 2.0;
    private double ENEMIES_SPEED = 3;
    private StackPane stackPane = new StackPane();
    private PauseScreen pauseScreen = new PauseScreen();
    private Pane pane = new Pane();
    private List<Space> elements = new ArrayList<>();
    private List<Enemies> enemiesList = new ArrayList<>();
    private List<HeroBullets> bulletsList = new ArrayList<>();
    private int[] posX = new int[]{200, 300, 400, 500, 600, 700, 100};
    private boolean GAME_OVER = false;
    private Random random = new Random();
    private Enemies enemies;
    private Space space;
    private HeroBullets bullets;
    private boolean isPause = false;
    private int SCORE;
    private Text score = new Text();



    @Override
    public void start(Stage primaryStage) throws Exception {

        Hero hero = new Hero();
        pane.getChildren().addAll(hero, score);
        score.setFont(new Font("Monospaced", 25));
        score.setFill(Color.rgb(255,255,255, 0.7));
        score.setX(1);
        score.setY(25);
        score.setText("SCORE : "+ SCORE);


        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                System.out.println(SPACE_SPEED);
                if (elements.size() < 50 || now%2== 0){
                    space = new Space();
                    pane.getChildren().add(space);
                    elements.add(space);
                }
                for (Space elements: elements) {
                    elements.move(SPACE_SPEED);
                }
                Iterator<Space> elementsItr = elements.iterator();
                while (elementsItr.hasNext()){
                    Space space = elementsItr.next();
                    if (space.getCenterY() > SCENE_HEIGHT){
                        pane.getChildren().remove(space);
                        elementsItr.remove();
                    }
                }

                for (Enemies enemies: enemiesList) {
                    enemies.move(ENEMIES_SPEED);
                    if (enemies.collide(hero)) {
                        pane.getChildren().remove(hero);
                        GAME_OVER = true;
                    }
                }

                Iterator<Enemies> itr = enemiesList.iterator();
                while (itr.hasNext()){
                    Enemies enemies = itr.next();

                    Iterator<HeroBullets> iterator = bulletsList.iterator();
                    while (iterator.hasNext()){
                        HeroBullets bullets = iterator.next();
                        if (bullets.collide(enemies)){
                            SCORE +=1;
                            score.setText("SCORE : "+ SCORE);
                            iterator.remove();
                            itr.remove();
                            pane.getChildren().remove(bullets);
                            pane.getChildren().remove(enemies);
                        }
                    }
                    if (enemies.getPosY() > SCENE_HEIGHT){

                        pane.getChildren().remove(enemies);
                        itr.remove();
                    }

                }
                if (enemiesList.size() < 5 || now%71 == 0){
                    try {
                        enemies = new Enemies(posX[random.nextInt(7)], -10, 50, 90);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    enemiesList.add(enemies);
                    pane.getChildren().add(enemies.show());
                }

                for (HeroBullets bullets : bulletsList){
                    bullets.move();
                    if (SCORE > 50){
                        bullets.upgrade();
                    }
                }

                if (GAME_OVER){
                    GameOverScreen gameOverScreen = new GameOverScreen();
                    stackPane.getChildren().add(gameOverScreen);
                    gameOverScreen.setVisible(true);
                    for (HeroBullets bullets : bulletsList){
                        pane.getChildren().remove(bullets);
                    }
                    bulletsList.clear();
                }
                SPACE_SPEED += 0.002;
                ENEMIES_SPEED += 0.002;
            }


        };
        timer.start();





        pauseScreen.setVisible(false);
        stackPane.getChildren().addAll(pane, pauseScreen);

        Scene scene =new Scene(stackPane, SCENE_WIDTH, SCENE_HEIGHT);
        scene.setOnKeyPressed(e ->{
	    if(!GAME_OVER){
           	 if (e.getCode() == KeyCode.P)
              	   checkPause(timer);
           	 else
               	 controls(e.getCode(), hero);
	    }

        });

        scene.setFill(Color.BLACK);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    public void checkPause(AnimationTimer timer){
        if (isPause == false) {
            timer.stop();
            isPause = true;
            pauseScreen.setVisible(true);
        }else if (isPause == true){
            timer.start();
            isPause = false;
            pauseScreen.setVisible(false);
        }
    }

    public void controls(KeyCode keyCode, Hero hero){
        if (keyCode == KeyCode.RIGHT)
            hero.setTranslateX(hero.getHeroX() + 10);
        if (keyCode == KeyCode.LEFT)
            hero.setTranslateX(hero.getHeroX() - 10);
        if (keyCode == KeyCode.SPACE){
            bullets = new HeroBullets(hero);
            bulletsList.add(bullets);
            pane.getChildren().add(bullets);
        }

    }

    public class Enemies extends ImageView {
        private Image[] images = new Image[]{
                new Image(String.valueOf(new File("src/main/resources/enemtship3.png").toURI().toURL())),
                new Image(String.valueOf(new File("src/main/resources/enemyShip2.png").toURI().toURL())),
                new Image(String.valueOf(new File("src/main/resources/enemyShip4.png").toURI().toURL())),
                new Image(String.valueOf(new File("src/main/resources/enemyShip5.png").toURI().toURL())),
                new Image(String.valueOf(new File("src/main/resources/enemyShip1.png").toURI().toURL()))
        };

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

    public class Space extends Circle{
        int RADIUS = random.nextInt(3);
        Space(){
            this.setRadius(RADIUS);
            this.setFill(Color.rgb(255, 255, 255, 0.5));
            this.setCenterX(random.nextInt(SCENE_WIDTH));
            this.setCenterY(0);
        }

        public void move(double SPEED){
            this.setCenterY(this.getCenterY() + SPEED);
        }
    }

    public class Hero extends ImageView{
        Hero() throws Exception{
            this.setImage(new Image(String.valueOf(new File("src/main/resources/heroSpaceShip.png").toURI().toURL())));
            this.setFitHeight(50);
            this.setFitWidth(100);
            this.setTranslateX(540);
            this.setTranslateY(650);
        }
        public double getHeroX(){
            return this.getTranslateX();
        }


    }
    public class HeroBullets extends Rectangle{
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
    public class PauseScreen extends StackPane{
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

    public class GameOverScreen extends VBox {
        private Rectangle rectangle;
        GameOverScreen(){
            this.setHeight(SCENE_HEIGHT-200);
            this.setWidth(SCENE_WIDTH - 200);
            this.setTranslateX((SCENE_WIDTH/2)-100);
            this.setTranslateY((SCENE_HEIGHT/2)-50);

            rectangle = new Rectangle(this.getWidth(), this.getHeight(), Color.rgb(255,255,255,0.2));
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

            this.getChildren().addAll(head, scoreToShow);
        }
    }
}
