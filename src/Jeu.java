import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Jeu {

    public List<String> nomVilles = new ArrayList<String>(Arrays.asList("Paris", "Versailles", "Lille", "Marseilles", "Lyon", "Perpignan", "Strasbourg", "Brest", "Toulon", "Monaco"));
    public ArrayList<Ville> villes = new ArrayList<Ville>();
    public int nbVille;
    public ArrayList<Feu> feux = new ArrayList<Feu>(); // a mettre dans route



    public void init() {
        System.out.println("entrée init");
        Random rand = new Random();
        for( int i =0;i<nbVille;i++){
            System.out.println("1 ville cree");
            Ville ville = new Ville(nomVilles.get(i),10);  // x un entier aleatoire representant le nombre de voiture creees par tour
            villes.add(ville);
        }

        //System.out.println(villes.get(5).nom);
        int compteur=0;
        for (Ville i : villes){
            System.out.println("for villes");
            for (int j=compteur;j<nbVille;j++){
                System.out.println(j);



                    switch ((int) (Math.random() * 3)) {
                        case 0:
                            System.out.println("cree route");
                            Route route1 = new Route(villes.get(j).nom + i.nom);
                            i.voies.add((Voie) route1);
                            if (i.nom!= villes.get(j).nom)
                            {villes.get(j).voies.add((Voie)route1);}
                            break;
                        case 1:
                            System.out.println("cree nationale");
                            Nationale route2 = new Nationale(villes.get(j).nom + i.nom);
                            i.voies.add((Voie) route2);
                            if (i.nom!= villes.get(j).nom)
                            villes.get(j).voies.add((Voie)route2);
                            break;
                        case 2:
                            System.out.println("cree autoroute");
                            Autoroute route3 = new Autoroute(villes.get(j).nom + i.nom);
                            i.voies.add((Voie) route3);
                            if (i.nom!= villes.get(j).nom)
                            villes.get(j).voies.add((Voie)route3);
                            break;
                    }

            }
            compteur++;
        }


        if(nbVille==6){
            villes.get(0).voies.get(3).intersection = 1;
            //villes.get(0).voies = villes.get(1).voies.get(1).voie; // intersection entre ville 0 voie 3 et ville 1 voie 1
            villes.get(1).voies.get(1).intersection =1;
           // villes.get(1).voies = villes.get(0).voies.get(3).voie;

            if (villes.get(0).voies.get(3).nb_voies == villes.get(1).voies.get(1).nb_voies){
                // on met un feu
                Feu newfeu1 = new Feu("allume",((villes.get(0).voies.get(3).distances)/2));
                villes.get(0).voies.get(3).intersections.add((Intersection)newfeu1);
                Feu newfeu2 = new Feu("eteind",((villes.get(1).voies.get(1).distances)/2));
                villes.get(1).voies.get(1).intersections.add((Intersection)newfeu2);

            }
            else if (villes.get(0).voies.get(3).nb_voies < villes.get(1).voies.get(1).nb_voies){
                // on met un stop sur la ville.get(0).voies.get(3).voie
                int position=villes.get(0).voies.get(3).distances/2;
                Stop newstop = new Stop();
                newstop.position=position;
                // je ne comprends pas
                villes.get(0).voies.get(3).intersections.add((Intersection)newstop); //

            }
            else { // on met un stop sur ville.get(1).voies.get(1).voie
                int position=villes.get(1).voies.get(1).distances/2;
                Stop newstop = new Stop();
                newstop.position=position;                        // je ne comprends pas
                villes.get(1).voies.get(1).intersections.add((Intersection)newstop); //

            }



            villes.get(1).voies.get(3).intersection = 1;
           // villes.get(1).voies = villes.get(3).voies.get(1).voie;
            villes.get(3).voies.get(1).intersection =1;
           // villes.get(3).voies = villes.get(1).voies.get(3).voie;

            if (villes.get(1).voies.get(3).nb_voies == villes.get(3).voies.get(1).nb_voies){
                // on met un feu
                Feu newfeu1 = new Feu("allume",((villes.get(1).voies.get(3).distances)/2));
                villes.get(1).voies.get(3).intersections.add((Intersection)newfeu1);

                Feu newfeu2 = new Feu("eteind",((villes.get(3).voies.get(1).distances)/2));
                villes.get(3).voies.get(1).intersections.add((Intersection)newfeu2);
            }
            else if (villes.get(1).voies.get(3).nb_voies < villes.get(3).voies.get(1).nb_voies){
                // on met un stop sur la ville.get(0).voies.get(3).voie
                //Stop newstop = new Stop(villes.get(1).voies.get(3).nb_voies);                             Gné ?!
                int position=villes.get(0).voies.get(3).distances/2;
                Stop newstop = new Stop();
                newstop.position=position;                        // je ne comprends pas
                villes.get(0).voies.get(3).intersections.add((Intersection)newstop); //

            }
            else { // on met un stop sur ville.get(1).voies.get(1).voie
               // Stop newstop = new Stop(villes.get(3).voies.get(1).nb_voies);                             Gné     2,!
                int position=villes.get(1).voies.get(1).distances/2;
                Stop newstop = new Stop();
                newstop.position=position;                       // je ne comprends pas
                villes.get(1).voies.get(1).intersections.add((Intersection)newstop); //

            }



            villes.get(2).voies.get(0).intersection = 2;
            villes.get(4).voies.get(0).intersection = 1;
            villes.get(1).voies.get(3).intersection = 1;
           // villes.get(4).voies = villes.get(2).voies.get(0).voie; // wtf dude
            //villes.get(1).voies = villes.get(2).voies.get(0).voie;


            if (villes.get(2).voies.get(0).nb_voies == villes.get(4).voies.get(0).nb_voies){
                // on met un feu
                Feu newfeu1 = new Feu("allume",((villes.get(2).voies.get(0).distances)/2));
                villes.get(2).voies.get(0).intersections.add((Intersection)newfeu1);

                Feu newfeu2 = new Feu("eteind",((villes.get(4).voies.get(0).distances)/2));
                villes.get(4).voies.get(0).intersections.add((Intersection)newfeu2);
            }
            else if (villes.get(2).voies.get(0).nb_voies < villes.get(4).voies.get(0).nb_voies){
                // on met un stop sur la ville.get(0).voies.get(3).voie
               // Stop newstop = new Stop(villes.get(2).voies.get(0).nb_voies);                         Gné
                int position=villes.get(0).voies.get(3).distances/2;
                Stop newstop = new Stop();
                newstop.position=position;                       // je ne comprends pas
                villes.get(0).voies.get(3).intersections.add((Intersection)newstop); //

            }
            else { // on met un stop sur ville.get(1).voies.get(1).voie                                 Gné
               // Stop newstop = new Stop(villes.get(4).voies.get(0).nb_voies);
                int position=villes.get(1).voies.get(1).distances/2;
                Stop newstop = new Stop();
                newstop.position=position;                     // je ne comprends pas
                villes.get(1).voies.get(1).intersections.add((Intersection)newstop); //              oulah 2 eme stop sur la meme voie

            }

            if (villes.get(2).voies.get(0).nb_voies == villes.get(1).voies.get(3).nb_voies){
                // on met un feu
                Feu newfeu1 = new Feu("allume",((villes.get(2).voies.get(0).distances)/2));
                villes.get(2).voies.get(0).intersections.add((Intersection)newfeu1);

                Feu newfeu2 = new Feu("eteind",((villes.get(1).voies.get(3).distances)/2));
                villes.get(1).voies.get(3).intersections.add((Intersection)newfeu2);
            }
            else if (villes.get(2).voies.get(0).nb_voies < villes.get(1).voies.get(3).nb_voies){
                // on met un stop sur la ville.get(0).voies.get(3).voie
               // Stop newstop = new Stop(villes.get(2).voies.get(0).nb_voies);                         Gné
                int position=villes.get(0).voies.get(3).distances/2;
                Stop newstop = new Stop();
                newstop.position=position;                       // je ne comprends pas
                villes.get(0).voies.get(3).intersections.add((Intersection)newstop);

            }
            else { // on met un stop sur ville.get(1).voies.get(1).voie
                //Stop newstop = new Stop(villes.get(1).voies.get(3).nb_voies);                    // Gné 3 feu sur la meme voie
                int position=villes.get(1).voies.get(1).distances/2;
                Stop newstop = new Stop();
                newstop.position=position;                       // je ne comprends pas
                villes.get(1).voies.get(1).intersections.add((Intersection)newstop);
            }



        }
        // une fois les schemas de villes fait on sait exactement quelles routes ce croiseront et on les implementera en dur ,
        // si 4 villes alors la route 2 de la ville 1 et la route 3 de la ville 3 ce ccoupe


    }

    public void deplacementVehicules() {
        int compteur = 0;
        for (Ville i : villes) {
            for (int j = compteur; j < nbVille - 1; j++) {
                for (Voie k : i.voies) {
                    for (Vehicule l : k.voitures) {
                        // test() ?
                        for ( Vehicule m : k.voitures){
                            if ((m.destination==l.destination)&(l.position-m.position<3)&(l.position-m.position<0)) // doubler
                            {
                                for ( Vehicule n : k.voitures){
                                if ( (n.destination!= l.destination )&(l.position+m.position-k.distances>-3)&(l.position+m.position-k.distances<0))
                                {
                                    if (m.vitesse<l.vitesse){
                                        l.decelerer();
                                    }
                                    //decelerer peu pas doubler
                                }
                                else {
                                    // changement de voie , doubler
                                        l.accelerer(k);
                                }

                            }
                            }
                        }

                    }
                }
            }
            compteur++;
        }
    }


    public void DebutTour() { // init de chaque tours
        for (Ville i : villes) {
            System.out.println("generation voiture");
            i.Generer_vehicule(villes, i);
        }
        for (Feu i : feux) {
            i.tour();
        }
        System.out.println("deplacement vehicules");
        deplacementVehicules();
    }

    //public Vector<String> nomVilles = new Vector<>();


    public void afficherRoute(){
        for ( Ville i : this.villes){
            System.out.println("~~~~ville~ : "+i.nom);
            for ( Voie j : i.voies){
                System.out.println(j.destination);

            }
        }
    }

    public static void main( String[] args){
        /*Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir le nombre de villes souhaité: (implémenté par defaut mais cest la ) ");
        int i = sc.nextInt();*/
        Jeu FlashMc = new Jeu ();
        FlashMc.nbVille=6;
        FlashMc.init();
        FlashMc.afficherRoute();
        FlashMc.DebutTour();
        for( Vehicule i :FlashMc.villes.get(0).voies.get(1).voitures){
            System.out.println(i.destination);
        }


    }
}



