package prog;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import sample.Main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import java.util.concurrent.TimeUnit;
import java.lang.Object;
import javafx.animation.AnimationTimer;
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
import prog.Vehicule;
import prog.Ville;
import prog.Voie;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class Jeu extends Application {
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

        Image image = new Image(new FileInputStream("src/prog/Ways.png"));
        imageView = new ImageView(image);
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
        /*Image image2 = new Image(new FileInputStream("src/sample/sanic.png"));
        this.imageView2 = new ImageView(image2);
        imageView2.setFitWidth(30);
        imageView2.setPreserveRatio(true);*/



    }





    //public void refresh(Jeu game) throws FileNotFoundException {}

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


    public List<String> nomVilles = new ArrayList<String>(Arrays.asList("Paris", "Versailles", "Lille", "Marseilles", "Lyon", "Perpignan", "Strasbourg", "Brest", "Toulon", "Monaco"));
    public List<Integer> positionX = new ArrayList<Integer>(Arrays.asList(25,235,465,25,235,465));
    public List<Integer> positionY = new ArrayList<Integer>(Arrays.asList(100,100,100,25,235,465));
    public ArrayList<Ville> villes = new ArrayList<Ville>();
    public int nbVille;
    public ArrayList<Feu> feux = new ArrayList<Feu>(); // a mettre dans route


    public void init() {
        System.out.println("Initiaisation...");
        //System.out.println("entrée init");
        Random rand = new Random();
        for (int i = 0; i < nbVille; i++) {
            // System.out.println("1 ville cree");
            Ville ville = new Ville(nomVilles.get(i), 1,positionX.get(i),positionY.get(i));  // x un entier aleatoire representant le nombre de voiture creees par tour
            villes.add(ville);
        }

        //System.out.println(villes.get(5).nom);
        int compteur = 0;
        for (Ville i : villes) {
            // System.out.println("for villes");
            for (int j = compteur; j < nbVille; j++) {
                //System.out.println(j);


                switch ((int) (Math.random() * 3)) {
                    case 0:
                        //   System.out.println("cree route");
                        Route route1 = new Route(villes.get(j).nom + i.nom);
                        i.voies.add((Voie) route1);
                        if (i.nom != villes.get(j).nom)
                            villes.get(j).voies.add((Voie) route1);
                        break;
                    case 1:
                        //System.out.println("cree nationale");
                        Nationale route2 = new Nationale(villes.get(j).nom + i.nom);
                        i.voies.add((Voie) route2);
                        if (i.nom != villes.get(j).nom)
                            villes.get(j).voies.add((Voie) route2);
                        break;
                    case 2:
                        //System.out.println("cree autoroute");
                        Autoroute route3 = new Autoroute(villes.get(j).nom + i.nom);
                        i.voies.add((Voie) route3);
                        if (i.nom != villes.get(j).nom)
                            villes.get(j).voies.add((Voie) route3);
                        break;
                }

            }//matthieyu was here lol
            compteur++;
        }


        if (nbVille == 6) {

            /*Feu newfeu = new Feu("allume",((villes.get(0).voies.get(2).distances)/2));
            villes.get(0).voies.get(2).intersections.add((Intersection)newfeu);
            //villes.get(4).voies.get(0).intersection +=1;
            villes.get(0).voies.get(2).intersection +=1;   // TEST A NE SURTOUT PAS LAISSER*/


            //villes.get(0).voies = villes.get(1).voies.get(1).voie; // intersection entre ville 0 voie 3 et ville 1 voie 1

            // villes.get(1).voies = villes.get(0).voies.get(3).voie;

            if (villes.get(0).voies.get(4).nb_voies == villes.get(1).voies.get(3).nb_voies) {
                // on met un feu

                Feu newfeu1 = new Feu("allume", ((villes.get(0).voies.get(4).distances) / 2));
                villes.get(0).voies.get(4).intersections.add((Intersection) newfeu1);
                //villes.get(4).voies.get(0).intersection +=1;
                villes.get(0).voies.get(4).intersection += 1;
                Feu newfeu2 = new Feu("eteind", ((villes.get(1).voies.get(3).distances) / 2));
                villes.get(1).voies.get(3).intersections.add((Intersection) newfeu2);
                villes.get(1).voies.get(3).intersection += 1;

            } else if (villes.get(0).voies.get(4).nb_voies < villes.get(1).voies.get(3).nb_voies) {
                // on met un stop sur la ville.get(0).voies.get(3).voie
                int position = villes.get(0).voies.get(4).distances / 2;
                Stop newstop = new Stop();
                newstop.position = position;
                // je ne comprends pas
                villes.get(0).voies.get(4).intersections.add((Intersection) newstop);
                villes.get(0).voies.get(4).intersection += 1;


            } else { // on met un stop sur ville.get(1).voies.get(1).voie
                int position = villes.get(1).voies.get(3).distances / 2;
                Stop newstop = new Stop();
                newstop.position = position;                        // je ne comprends pas
                villes.get(1).voies.get(3).intersections.add((Intersection) newstop);
                villes.get(1).voies.get(3).intersection += 1;

            }


            // villes.get(1).voies = villes.get(3).voies.get(1).voie;

            // villes.get(3).voies = villes.get(1).voies.get(3).voie;

            if (villes.get(2).voies.get(4).nb_voies == villes.get(1).voies.get(5).nb_voies) {
                // on met un feu
                Feu newfeu1 = new Feu("allume", ((villes.get(2).voies.get(4).distances) / 2));
                villes.get(2).voies.get(4).intersections.add((Intersection) newfeu1);
                villes.get(2).voies.get(4).intersection += 1;

                Feu newfeu2 = new Feu("eteind", ((villes.get(1).voies.get(5).distances) / 2));
                villes.get(1).voies.get(5).intersections.add((Intersection) newfeu2);
                villes.get(1).voies.get(5).intersection += 1;
            } else if (villes.get(2).voies.get(4).nb_voies < villes.get(1).voies.get(5).nb_voies) {
                // on met un stop sur la ville.get(0).voies.get(3).voie
                //Stop newstop = new Stop(villes.get(1).voies.get(3).nb_voies);                             Gné ?!
                int position = villes.get(2).voies.get(4).distances / 2;
                Stop newstop = new Stop();
                newstop.position = position;                        // je ne comprends pas
                villes.get(2).voies.get(4).intersections.add((Intersection) newstop);
                villes.get(2).voies.get(4).intersection += 1;

            } else { // on met un stop sur ville.get(1).voies.get(1).voie
                // Stop newstop = new Stop(villes.get(3).voies.get(1).nb_voies);                             Gné     2,!
                int position = villes.get(1).voies.get(5).distances / 2;
                Stop newstop = new Stop();
                newstop.position = position;                       // je ne comprends pas
                villes.get(1).voies.get(5).intersections.add((Intersection) newstop);
                villes.get(1).voies.get(5).intersection += 1;

            }


            // villes.get(4).voies = villes.get(2).voies.get(0).voie; // wtf dude
            //villes.get(1).voies = villes.get(2).voies.get(0).voie;


            if (villes.get(2).voies.get(3).nb_voies == villes.get(1).voies.get(5).nb_voies) {
                // on met un feu
                Feu newfeu1 = new Feu("allume", ((villes.get(2).voies.get(3).distances) / 2));
                villes.get(2).voies.get(3).intersections.add((Intersection) newfeu1);
                villes.get(2).voies.get(3).intersection += 1;

                Feu newfeu2 = new Feu("eteind", ((villes.get(1).voies.get(5).distances) / 2));
                villes.get(1).voies.get(5).intersections.add((Intersection) newfeu2);
                villes.get(1).voies.get(5).intersection += 1;
            } else if (villes.get(2).voies.get(3).nb_voies < villes.get(1).voies.get(5).nb_voies) {
                // on met un stop sur la ville.get(0).voies.get(3).voie
                // Stop newstop = new Stop(villes.get(2).voies.get(0).nb_voies);                         Gné
                int position = villes.get(2).voies.get(3).distances / 2;
                Stop newstop = new Stop();
                newstop.position = position;                       // je ne comprends pas
                villes.get(2).voies.get(3).intersections.add((Intersection) newstop);
                villes.get(2).voies.get(3).intersection += 1;

            } else { // on met un stop sur ville.get(1).voies.get(1).voie                                 Gné
                // Stop newstop = new Stop(villes.get(4).voies.get(0).nb_voies);
                int position = villes.get(1).voies.get(5).distances / 2;
                Stop newstop = new Stop();
                newstop.position = position;                     // je ne comprends pas
                villes.get(1).voies.get(5).intersections.add((Intersection) newstop);
                villes.get(1).voies.get(5).intersection += 1;

            }

            if (villes.get(2).voies.get(3).nb_voies == villes.get(4).voies.get(5).nb_voies) {
                // on met un feu
                Feu newfeu1 = new Feu("allume", ((villes.get(2).voies.get(3).distances) / 2));
                villes.get(2).voies.get(3).intersections.add((Intersection) newfeu1);
                villes.get(2).voies.get(3).intersection += 1;

                Feu newfeu2 = new Feu("eteind", ((villes.get(4).voies.get(5).distances) / 2));
                villes.get(4).voies.get(5).intersections.add((Intersection) newfeu2);
                villes.get(4).voies.get(5).intersection += 1;
            } else if (villes.get(2).voies.get(3).nb_voies < villes.get(1).voies.get(5).nb_voies) {
                // on met un stop sur la ville.get(0).voies.get(3).voie
                // Stop newstop = new Stop(villes.get(2).voies.get(0).nb_voies);                         Gné
                int position = villes.get(2).voies.get(3).distances / 2;
                Stop newstop = new Stop();
                newstop.position = position;                       // je ne comprends pas
                villes.get(2).voies.get(3).intersections.add((Intersection) newstop);
                villes.get(2).voies.get(3).intersection += 1;

            } else { // on met un stop sur ville.get(1).voies.get(1).voie
                //Stop newstop = new Stop(villes.get(1).voies.get(3).nb_voies);                    // Gné 3 feu sur la meme voie
                int position = villes.get(4).voies.get(5).distances / 2;
                Stop newstop = new Stop();
                newstop.position = position;                       // je ne comprends pas
                villes.get(4).voies.get(5).intersections.add((Intersection) newstop);
                villes.get(4).voies.get(5).intersection += 1;
            }


        }
        // une fois les schemas de villes fait on sait exactement quelles routes ce croiseront et on les implementera en dur ,
        // si 4 villes alors la route 2 de la ville 1 et la route 3 de la ville 3 ce ccoupe


    }

    public void deplacementVehicules() {  // a bosser !!!!   probleme voiture 3/4 tour par tour
        int compteur = 0;
        for (Ville i : villes) {
            //System.out.println(("for ville :"+i.nom));
            //System.out.println((i.nom));
            for (int j = compteur; j < nbVille; j++) {
                //System.out.println("for compteur"+(j));
                Voie k = i.voies.get(j);
                // System.out.println(("for voies :"+k.destination)); // tous ca ok

                for (Vehicule l : k.voitures) {
                    //System.out.println("acceleration");
                    //l.accelerer(k);

                    //System.out.println(("test0"));
                    // test 1 collision vehicules a doubler ?
                    // test 2 collision en doublant ( celon le type de la voie si ya moins de x vehicules a +/- 3 a la meme position)
                    // test 3
                    int compteur2 = 0;
                    int compteur3 = 0;
                    if (l.position < 16) {
                        l.accelerer(k);
                    } else {
                        for (Vehicule m : k.voitures) {


                            //System.out.println("test1");
                            //System.out.println("intersection : "+k.intersection + "voiture :"+ m.destination);
                            if ((m.destination == l.destination) & (l.position < m.position) & (l.position - m.position < 16) & (l.position - m.position > 0)) // doubler
                            {
                                if (l.vitesse > m.vitesse) {
                                    compteur2++;
                                }
                            }
                            //System.out.println("compteur 2:"+compteur2 + "  compteur3 : "+compteur3);
                            //  System.out.println("l.position :"+l.position + " k.distances : "+k.distances);
                            float res1 = l.position / k.distances;
                            float res2 = m.position / k.distances;
                            //System.out.println("res 1 :"+res1 + "  res2 : "+res2);
                            if ((m.destination != l.destination) & (res1 + res2 > 0.90)) { // ancien : (l.position + m.position - k.distances > -8) & (l.position + m.position - k.distances < 0)
                                if (l.vitesse > m.vitesse) {
                                    compteur3++;
                                }
                            }


                        }
                        if (((compteur2 + compteur3) <= k.nb_voies)) {
                            l.accelerer(k);
                            break;
                        } else {
                            if (compteur2 != 0) {
                                l.accelerer(k);
                                break;
                            } else {
                                l.decelerer();
                                //System.out.println("freinage " + compteur2 + " voiture devant");
                            }
                        }
                    }
                } // ici for each voiture
            }
            compteur++;

        }


    }


    public void tourFeu() {
        for (Ville i : villes) {
            for (Voie j : i.voies) {
                for (Intersection k : j.intersections) {
                    if (k instanceof Feu) {
                        ((Feu) k).tour();
                    }
                }
            }
        }

    }

    public void DebutTour() { // init de chaque tours
        for (Ville i : villes) {
            //System.out.println("generation voiture");
            i.Generer_vehicule(villes, i);
        }

        //System.out.println("tour feu");
        tourFeu();

        //System.out.println("deplacement vehicules");
        deplacementVehicules();
    }

    public void FinTour(){

        Animated.getChildren().remove(imageView2);
        //clear
        //code
        //show
        this.DebutTour();

        int compteur = 0;
        for (Ville i : this.villes) {

            for (int j = compteur; j < this.nbVille; j++) {
                Voie k = i.voies.get(j);

                for (Vehicule l : k.voitures) {
                    Ville destination=this.villes.get(0);
                    System.out.println("pour chaque voiture ");
                    switch(l.destination){
                        case "Paris":destination=this.villes.get(0);break;
                        case "Versailles":destination=this.villes.get(1);break;
                        case "Lille":destination=this.villes.get(2);break;
                        case "Marseilles":destination=this.villes.get(3);break;
                        case "Lyon":destination=this.villes.get(4);break;
                        case "Perpignan": destination=this.villes.get(5);break;
                        default : System.out.println("destination dune voiture eroné");break;}

                    Image image2 = null;
                    try {
                        image2 = new Image(new FileInputStream("src/prog/sanic.png"));
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    imageView2 = new ImageView(image2);
                    float position=l.position/k.distances;
                    imageView2.setX(i.posX+position*destination.posX);
                    imageView2.setY(i.posY+position*destination.posY);
                    imageView2.setFitWidth(30);
                    imageView2.setPreserveRatio(true);
                    Animated.getChildren().add(imageView2);
                }
            }




        }

    }

    //public Vector<String> nomVilles = new Vector<>();


    public void afficherRoute() {
        for (Ville i : this.villes) {
            //System.out.println("~~~~ville~ : "+i.nom);
            for (Voie j : i.voies) {
                //System.out.println(j.destination);

            }
        }
    }

    public void afficherToutesRoutes() {
        for (Ville i : villes) {
            //System.out.println("~~~~ville~ : "+i.nom);
            for (Voie j : i.voies) {
                System.out.println(j.destination);

            }
        }
    }

    public void afficherVoitureRoute() {
        for (Voie i : this.villes.get(5).voies) {
            for (Vehicule j : i.voitures) {
                //System.out.println(j.destination);
            }
        }
    }

    public static void main(String[] args)  {
        System.out.println("JEU EXECUTE");

        Jeu FlashMc = new Jeu ();
        FlashMc.nbVille=6;
        FlashMc.init();
        Application.launch(Main.class,args);
        AnimationTimer h = new AnimationTimer() {

            private long lastUpdate ;

            private double speed = 50 ; // pixels per second

            @Override
            public void start() {
                lastUpdate = System.nanoTime();
                super.start();
                System.out.println("start");
            }

            @Override
            public void handle(long now) {
                long elapsedNanoSeconds = now - lastUpdate ;
                double elapsedSeconds = elapsedNanoSeconds / 1_000_000_000.0 ;
                System.out.println("refresh");
                FlashMc.FinTour();

                lastUpdate = now ;

            }
        };h.start();



    }
}




