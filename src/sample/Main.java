package sample;
import prog.Jeu;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.geometry.Insets;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main extends Application {

    private Label textLabel;
    private ImageView imageView,imageView2;
    private VBox vBox;
    private VBox mainPane;
    private HBox hBox;
    private StackPane Pane;
    private Group Animated;
    MenuBar menuBar;

    @Override
    public void start(Stage primaryStage) throws Exception{
        menuBar = new MenuBar();
        //Partie droite/haut
        this.textLabel = new Label("Lorem ipsum dolor sit amet aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        textLabel.setWrapText(true);

        //Partie gauche/bas

        Image image = new Image(new FileInputStream("C:\\Users\\hyach\\Documents\\java\\JavaFX_tests\\src\\sample\\Ways.png"));
        this.imageView = new ImageView(image);
        imageView.setFitWidth(600);
        imageView.setPreserveRatio(true);

        //Horizontal display
        hBox = new HBox();
        hBox.setSpacing(8);

        //Vertical display
        vBox = new VBox();
        vBox.setSpacing(8);

        //Partie animee (jeu)
        Animated = new Group();
        Animated.getChildren().add(imageView);


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
            chemin.getItems().addAll(subMenuChemin,subMenuChemin2,subMenuChemin3);
        creer.getItems().add(intersection);
            intersection.getItems().addAll(subMenuIntersection,subMenuIntersection2);

        mainPane.getChildren().addAll(menuBar,Pane);



        changeToLargeLayout();

        primaryStage.widthProperty().addListener(e -> {
            if(primaryStage.getWidth() < 650) {
                changeToSmallLayout();
            } else {
                changeToLargeLayout();
            }
        });

        primaryStage.setScene(new Scene(mainPane,900,500));
        primaryStage.setTitle("Simu 2.0");
        primaryStage.show();
        Image image2 = new Image(new FileInputStream("C:\\Users\\hyach\\Documents\\java\\JavaFX_tests\\src\\sample\\sanic.png"));
        this.imageView2 = new ImageView(image2);
        imageView2.setFitWidth(30);
        imageView2.setPreserveRatio(true);


            Jeu FlashMc = new Jeu ();
            FlashMc.nbVille=6;
            FlashMc.init();
            refresh();

    }

    public void refresh() throws FileNotFoundException {
        Animated.getChildren().remove(imageView2);
        //clear
        //code
        //show


        imageView2.setX(200);
        imageView2.setY(300);
        Animated.getChildren().add(imageView2);




    }

    public void changeToSmallLayout() {
        hBox.getChildren().clear();
        vBox.getChildren().clear();
        vBox.getChildren().addAll(Animated, textLabel);
        Pane.getChildren().clear();
        Pane.getChildren().add(vBox);
    }

    public void changeToLargeLayout() {
        hBox.getChildren().clear();
        vBox.getChildren().clear();
        hBox.getChildren().addAll(Animated, textLabel);
        Pane.getChildren().clear();
        Pane.getChildren().add(hBox);
    }
        //FXMLLoader.load(getClass().getResource("sample.fxml"));


    /*public static void main(String[] args) {
        Jeu FlashMc = new Jeu ();
        FlashMc.nbVille=6;
        FlashMc.init();
        Application.launch(Main.class,args);
    }*/
}
