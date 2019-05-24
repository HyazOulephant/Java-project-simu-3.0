package sample;
import javafx.animation.AnimationTimer;
import javafx.animation.Transition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import prog.Jeu;

import java.util.ArrayDeque;

import javafx.animation.AnimationTimer;
import javafx.animation.Transition;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;
import  java.lang.Thread;
import java.lang.Runnable;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.geometry.Insets;
import prog.Vehicule;
import prog.Ville;
import prog.Voie;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main extends Application {

    private Button button,button2,button3;
    private Label text,text2,text3;
    private TextField textField,textField2,textField3, textField4;
    private ImageView imageView,imageView2;
    private VBox vBox,vBox2;
    private VBox mainPane;
    private HBox hBox,hBox2,hBox3,hBox4;
    private StackPane Pane;
    private Group Animated;
    private Group Sanics;
    private Group Background;
    private MenuBar menuBar;



    @Override
    public void start(Stage primaryStage) throws Exception {
        menuBar = new MenuBar();
        //Partie droite/haut
        this.text = new Label("Sanics/min");
        this.textField = new TextField();
        textField.setPrefWidth(80);
        this.button = new Button("Submit ");

        this.text2 = new Label("Vit moy");
        this.textField2 = new TextField();
        textField2.setPrefWidth(80);
        this.textField4 = new TextField();
        textField4.setPrefWidth(40);
        textField4.setDisable(true);

        this.button2 = new Button("Submit ");

        this.text3 = new Label("Autre");
        this.textField3 = new TextField();
        textField3.setPrefWidth(80);
        this.button3 = new Button("Submit ");

        //Partie gauche/bas

        Image image = new Image(new FileInputStream("src/sample/Ways.png"));
        this.imageView = new ImageView(image);
        imageView.setFitWidth(600);
        imageView.setPreserveRatio(true);

        //Horizontal display
        hBox = new HBox();
        hBox.setSpacing(8);

        hBox2 = new HBox();
        hBox2.setSpacing(8);
        hBox2.getChildren().addAll(text, textField, button);

        hBox3 = new HBox();
        hBox3.setSpacing(8);
        hBox3.getChildren().addAll(text2, textField2, textField4, button2);

        hBox4 = new HBox();
        hBox4.setSpacing(8);
        hBox4.getChildren().addAll(text3, textField3, button3);


        //Vertical display
        vBox = new VBox();
        vBox.setSpacing(8);
        vBox2 = new VBox();
        vBox2.setSpacing(8);
        vBox2.getChildren().addAll(hBox2, hBox3, hBox4);

        //Partie animee (jeu)
        Animated = new Group();
        Background = new Group();
        Background.getChildren().add(imageView);
        Sanics = new Group();
        Animated.getChildren().addAll(Background, Sanics);


        Pane = new StackPane();
        Pane.setPadding(new Insets(24));
        mainPane = new VBox();
        mainPane.setSpacing(8);

        //Barre de menu
        menuBar = new MenuBar();
        Menu creer = new Menu("Créer");
        menuBar.getMenus().add(creer);
        MenuItem ville = new MenuItem("Ville");
        Menu chemin = new Menu("Chemin");
        MenuItem subMenuChemin = new MenuItem("Route");
        MenuItem subMenuChemin2 = new MenuItem("Nationale");
        MenuItem subMenuChemin3 = new MenuItem("Autoroute");
        Menu intersection = new Menu("Intersection");
        MenuItem subMenuIntersection = new MenuItem("Stop");
        MenuItem subMenuIntersection2 = new MenuItem("Feu");

        creer.getItems().add(ville);
        creer.getItems().add(chemin);
        chemin.getItems().addAll(subMenuChemin, subMenuChemin2, subMenuChemin3);
        creer.getItems().add(intersection);
        intersection.getItems().addAll(subMenuIntersection, subMenuIntersection2);

        mainPane.getChildren().addAll(menuBar, Pane);


        changeToLargeLayout();

        primaryStage.widthProperty().addListener(e -> {
            if (primaryStage.getWidth() < 650) {
                changeToSmallLayout();
            } else {
                changeToLargeLayout();
            }
        });

        primaryStage.setScene(new Scene(mainPane, 900, 500));
        primaryStage.setTitle("Simu 2.0");
        primaryStage.show();
        Image image2 = new Image(new FileInputStream("src/sample/sanic.png"));
        this.imageView2 = new ImageView(image2);
        imageView2.setFitWidth(30);
        imageView2.setPreserveRatio(true);

        System.out.println("JEU EXECUTE");

        Jeu FlashMc = new Jeu();
        FlashMc.nbVille = 6;
        FlashMc.init();

        new AnimationTimer()//gestion de l'animation
        {
            int i = 0;

            public void handle(long currentNanoTime) {
                i++;

                System.out.println("test");
                System.out.println("testdedef");

                // FlashMc.DebutTour(Sanics);

                Sanics.getChildren().clear();
                Circle circle = new Circle();
                circle.setCenterX(i);
                circle.setCenterY(i);
                circle.setRadius(5);
                Sanics.getChildren().add(circle);
            }


        }.start();

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    Integer.parseInt(textField.getText());
                    System.out.println(Integer.parseInt(textField.getText()));
                    for (Ville i : FlashMc.villes) {
                        i.nbVehicules = (Integer.parseInt(textField.getText()) / FlashMc.nbVille) / 60;
                    }

                } catch (Exception u) {
                    System.out.println("Entiers seulement!");
                }
                //System.out.println(textField.getText());
            }
        });
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    Integer.parseInt(textField2.getText());
                    System.out.println(Integer.parseInt(textField2.getText()));
                    //utilise ca et tas ta moyenne frer
                    // -> FlashMc.moyenne;
                    // met la nouvelle moyenne saisie par lutilisateur dans FlashMc.coef

                } catch (Exception u) {
                    System.out.println("Entiers seulement!");
                }
                //System.out.println(textField.getText());
            }
        });

        //Pas utilisee
        button3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    Integer.parseInt(textField3.getText());
                    System.out.println(Integer.parseInt(textField.getText()));
                    for (Ville i : FlashMc.villes) {
                        i.nbVehicules = (Integer.parseInt(textField.getText()) / FlashMc.nbVille) / 60;
                    }

                } catch (Exception u) {
                    System.out.println("Entiers seulement!");
                }
                //System.out.println(textField.getText());
            }
        });
    }







    public void changeToSmallLayout() {
        hBox.getChildren().clear();
        vBox.getChildren().clear();
        vBox.getChildren().addAll(Animated, vBox2);
        Pane.getChildren().clear();
        Pane.getChildren().add(vBox);
    }

    public void changeToLargeLayout() {
        hBox.getChildren().clear();
        vBox.getChildren().clear();
        hBox.getChildren().addAll(Animated, vBox2);
        Pane.getChildren().clear();
        Pane.getChildren().add(hBox);
    }
}
