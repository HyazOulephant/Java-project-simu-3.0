package prog;

import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


public class Jeu {
    private ImageView imageView, imageView2;
    Image image2;


    public List<String> nomVilles = new ArrayList<String>(Arrays.asList("Paris", "Versailles", "Lille", "Marseilles", "Lyon", "Perpignan", "Strasbourg", "Brest", "Toulon", "Monaco"));
    public ArrayList<Ville> villes = new ArrayList<Ville>();
    public List<Integer> positionX = new ArrayList<>(Arrays.asList(25, 235, 465, 25, 235, 465));
    public List<Integer> positionY = new ArrayList<>(Arrays.asList(100, 100, 100, 25, 235, 465));
    public int nbVille;
    public ArrayList<Feu> feux = new ArrayList<Feu>(); // a mettre dans route
    public float moyenne=0;
    public float coef=1;


    public void init() {

        try {
            image2 = new Image(new FileInputStream("src/sample/sanic.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Initialisation...");
        for (int i = 0; i < nbVille; i++) {
            // System.out.println("1 ville cree");
            Ville ville = new Ville(nomVilles.get(i), 0, positionX.get(i), positionY.get(i));  // x un entier aleatoire representant le nombre de voiture creees par tour
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

            }
            compteur++;
        }

        Vehicule car = new Vehicule("Versailles");
        this.villes.get(0).voies.get(1).voitures.add(car);

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

    public void afficherVoitures(Ville i, Voie k, Vehicule l, Group Sanics) {

        Ville destination = this.villes.get(0);
        //System.out.println(l.destination);
        switch (l.destination) {
            case "Paris":
                destination = this.villes.get(0);
                break;
            case "Versailles":
                destination = this.villes.get(1);
                break;
            case "Lille":
                destination = this.villes.get(2);
                break;
            case "Marseilles":
                destination = this.villes.get(3);
                break;
            case "Lyon":
                destination = this.villes.get(4);
                break;
            case "Perpignan":
                destination = this.villes.get(5);
                break;
            default:
                System.out.println("destination dune voiture eroné");
                break;
        }


        //System.out.println(("la"));
        imageView2 = new ImageView(image2);
        float position=l.position/k.distances;//System.out.println("% sur la route "+ position);
        Circle circle = new Circle();
        if (position==0){
            imageView2.setX((i.posX+destination.posX)/(1/position));
            imageView2.setY((i.posY+destination.posY)/(1/position));
            imageView2.setFitWidth(30);
            imageView2.setPreserveRatio(true);

        }
        else {
            imageView2.setX((i.posX+destination.posX)/(1/position));
            imageView2.setY((i.posY+destination.posY)/(1/position));
            imageView2.setFitWidth(30);
            imageView2.setPreserveRatio(true);

        }
           /* Point2D test= new Point2D((double)(i.posX+destination.posX)/(1/position),(double)(i.posY+destination.posY)/(1/position));
            imageView2.setX((i.posX+destination.posX)/(1/position));
            imageView2.setY((i.posY+destination.posY)/(1/position));
            imageView2.setFitWidth(30);
            imageView2.setPreserveRatio(true);
            imageView2.*/
        Sanics.getChildren().add(imageView2);

    }



    public void deplacementVehicules(Group Sanics) {  // a bosser !!!!   probleme voiture 3/4 tour par tour
        Sanics.getChildren().clear();
        int compteur = 0;
        moyenne=0;
        int compteurDeVoiture=0;
        for (Ville i : villes) {
            //System.out.println(("for ville :"+i.nom));
            //System.out.println((i.nom));
            for (int j = compteur; j < nbVille ; j++) {
                //System.out.println("for compteur"+(j));
                Voie k =i.voies.get(j) ;
                k.vitesse=(int)(k.vitesse*coef);
                  // System.out.println(("for voies :"+k.destination)); // tous ca ok
                    for (Vehicule l : k.voitures) {
                        compteurDeVoiture++;
                        moyenne+=l.vitesse;
                        if ( l.position>=k.distances){k.voitures.remove(l);}//System.out.println("voiture suprime");}
                        else{
                        //System.out.println("acceleration");
                        //l.accelerer(k);

                        //System.out.println(("test0"));
                        // test 1 collision vehicules a doubler ?
                        // test 2 collision en doublant ( celon le type de la voie si ya moins de x vehicules a +/- 3 a la meme position)
                        // test 3
                        int compteur2=0;
                        int compteur3=0;
                        if (l.position < 16) {
                            l.accelerer(k);
                            afficherVoitures(i,k,l,Sanics);
                        }
                        else{
                        for ( Vehicule m : k.voitures) {

                            // System.out.println("voiture suprime")

                            //System.out.println("test1");
                                //System.out.println("intersection : "+k.intersection + "voiture :"+ m.destination);
                                if ((m.destination == l.destination) && (l.position < m.position) && (l.position - m.position < 16) && (l.position - m.position > 0)) // doubler
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
                                if ((m.destination != l.destination) && (res1 + res2 > 0.90)) { // ancien : (l.position + m.position - k.distances > -8) & (l.position + m.position - k.distances < 0)
                                    if (l.vitesse > m.vitesse) {
                                        compteur3++;
                                    }
                                }



                            if (((compteur2 + compteur3) <= k.nb_voies)) {
                                l.accelerer(k);
                                afficherVoitures(i,k,l,Sanics);
                                break;
                            } else {
                                if (compteur2 != 0) {
                                    l.accelerer(k);
                                    afficherVoitures(i,k,l,Sanics);
                                    break;
                                } else {
                                    l.decelerer();
                                    afficherVoitures(i,k,l,Sanics);
                                    //System.out.println("freinage " + compteur2 + " voiture devant");
                                }
                            }}
                        }} // ici for each voiture
                    }  compteur++;

                }


            }moyenne=moyenne/compteurDeVoiture;
    //System.out.println(villes.get(0).voies.get(1).voitures.get(0).vitesse);
            }





     public void tourFeu(){
        for ( Ville i : villes){
            for ( Voie j : i.voies){
                for (Intersection k : j.intersections){
                    if (k instanceof Feu )
                    {
                        ((Feu)k).tour();
                    }
                }
             }
        }

     }
    public void DebutTour(Group Sanics) { // init de chaque tours
        //System.out.println("debut tour");
        for (Ville i : villes) {
            //System.out.println("generation voiture");
            i.Generer_vehicule(villes, i);
        }



            //tourFeu();
        //System.out.println("tour feu");


        deplacementVehicules(Sanics);
        //System.out.println("deplacement vehicules");
    }

    //public Vector<String> nomVilles = new Vector<>();


    public void afficherRoute(){
        for ( Ville i : this.villes){
            //System.out.println("~~~~ville~ : "+i.nom);
            for ( Voie j : i.voies){
                //System.out.println(j.destination);

            }
        }
    }

    public void afficherToutesRoutes(){
        for ( Ville i : villes){
            //System.out.println("~~~~ville~ : "+i.nom);
            for ( Voie j : i.voies){
                System.out.println(j.destination);

            }
        }
    }

    public void afficherVoitureRoute(){
        for( Voie i :this.villes.get(5).voies){
           for ( Vehicule j : i.voitures) {
               //System.out.println(j.destination);
        }}
    }


    /*public static void main( String[] args){

        System.out.println("Main jeu");
        }*/
    }




