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
        //System.out.println("entrée init");
        Random rand = new Random();
        for( int i =0;i<nbVille;i++){
           // System.out.println("1 ville cree");
            Ville ville = new Ville(nomVilles.get(i),1);  // x un entier aleatoire representant le nombre de voiture creees par tour
            villes.add(ville);
        }

        //System.out.println(villes.get(5).nom);
        int compteur=0;
        for (Ville i : villes){
           // System.out.println("for villes");
            for (int j=compteur;j<nbVille;j++){
                //System.out.println(j);



                    switch ((int) (Math.random() * 3)) {
                        case 0:
                         //   System.out.println("cree route");
                            Route route1 = new Route(villes.get(j).nom + i.nom);
                            i.voies.add((Voie) route1);
                            if (i.nom!= villes.get(j).nom)
                            villes.get(j).voies.add((Voie)route1);
                            break;
                        case 1:
                            //System.out.println("cree nationale");
                            Nationale route2 = new Nationale(villes.get(j).nom + i.nom);
                            i.voies.add((Voie) route2);
                            if (i.nom!= villes.get(j).nom)
                            villes.get(j).voies.add((Voie)route2);
                            break;
                        case 2:
                            //System.out.println("cree autoroute");
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

            /*Feu newfeu = new Feu("allume",((villes.get(0).voies.get(2).distances)/2));
            villes.get(0).voies.get(2).intersections.add((Intersection)newfeu);
            //villes.get(4).voies.get(0).intersection +=1;
            villes.get(0).voies.get(2).intersection +=1;   // TEST A NE SURTOUT PAS LAISSER*/



            //villes.get(0).voies = villes.get(1).voies.get(1).voie; // intersection entre ville 0 voie 3 et ville 1 voie 1

           // villes.get(1).voies = villes.get(0).voies.get(3).voie;

            if (villes.get(0).voies.get(4).nb_voies == villes.get(1).voies.get(3).nb_voies){
                // on met un feu

                Feu newfeu1 = new Feu("allume",((villes.get(0).voies.get(4).distances)/2));
                villes.get(0).voies.get(4).intersections.add((Intersection)newfeu1);
                //villes.get(4).voies.get(0).intersection +=1;
                villes.get(0).voies.get(4).intersection +=1;
                Feu newfeu2 = new Feu("eteind",((villes.get(1).voies.get(3).distances)/2));
                villes.get(1).voies.get(3).intersections.add((Intersection)newfeu2);
                villes.get(1).voies.get(3).intersection += 1;

            }
            else if (villes.get(0).voies.get(4).nb_voies < villes.get(1).voies.get(3).nb_voies){
                // on met un stop sur la ville.get(0).voies.get(3).voie
                int position=villes.get(0).voies.get(4).distances/2;
                Stop newstop = new Stop();
                newstop.position=position;
                // je ne comprends pas
                villes.get(0).voies.get(4).intersections.add((Intersection)newstop);
                villes.get(0).voies.get(4).intersection +=1;


            }
            else { // on met un stop sur ville.get(1).voies.get(1).voie
                int position=villes.get(1).voies.get(3).distances/2;
                Stop newstop = new Stop();
                newstop.position=position;                        // je ne comprends pas
                villes.get(1).voies.get(3).intersections.add((Intersection)newstop);
                villes.get(1).voies.get(3).intersection += 1;

            }




           // villes.get(1).voies = villes.get(3).voies.get(1).voie;

           // villes.get(3).voies = villes.get(1).voies.get(3).voie;

            if (villes.get(2).voies.get(4).nb_voies == villes.get(1).voies.get(5).nb_voies){
                // on met un feu
                Feu newfeu1 = new Feu("allume",((villes.get(2).voies.get(4).distances)/2));
                villes.get(2).voies.get(4).intersections.add((Intersection)newfeu1);
                villes.get(2).voies.get(4).intersection += 1;

                Feu newfeu2 = new Feu("eteind",((villes.get(1).voies.get(5).distances)/2));
                villes.get(1).voies.get(5).intersections.add((Intersection)newfeu2);
                villes.get(1).voies.get(5).intersection +=1;
            }
            else if (villes.get(2).voies.get(4).nb_voies < villes.get(1).voies.get(5).nb_voies){
                // on met un stop sur la ville.get(0).voies.get(3).voie
                //Stop newstop = new Stop(villes.get(1).voies.get(3).nb_voies);                             Gné ?!
                int position=villes.get(2).voies.get(4).distances/2;
                Stop newstop = new Stop();
                newstop.position=position;                        // je ne comprends pas
                villes.get(2).voies.get(4).intersections.add((Intersection)newstop);
                villes.get(2).voies.get(4).intersection += 1;

            }
            else { // on met un stop sur ville.get(1).voies.get(1).voie
               // Stop newstop = new Stop(villes.get(3).voies.get(1).nb_voies);                             Gné     2,!
                int position=villes.get(1).voies.get(5).distances/2;
                Stop newstop = new Stop();
                newstop.position=position;                       // je ne comprends pas
                villes.get(1).voies.get(5).intersections.add((Intersection)newstop);
                villes.get(1).voies.get(5).intersection +=1;

            }












           // villes.get(4).voies = villes.get(2).voies.get(0).voie; // wtf dude
            //villes.get(1).voies = villes.get(2).voies.get(0).voie;


            if (villes.get(2).voies.get(3).nb_voies == villes.get(1).voies.get(5).nb_voies){
                // on met un feu
                Feu newfeu1 = new Feu("allume",((villes.get(2).voies.get(3).distances)/2));
                villes.get(2).voies.get(3).intersections.add((Intersection)newfeu1);
                villes.get(2).voies.get(3).intersection +=1;

                Feu newfeu2 = new Feu("eteind",((villes.get(1).voies.get(5).distances)/2));
                villes.get(1).voies.get(5).intersections.add((Intersection)newfeu2);
                villes.get(1).voies.get(5).intersection +=1;
            }
            else if (villes.get(2).voies.get(3).nb_voies < villes.get(1).voies.get(5).nb_voies){
                // on met un stop sur la ville.get(0).voies.get(3).voie
               // Stop newstop = new Stop(villes.get(2).voies.get(0).nb_voies);                         Gné
                int position=villes.get(2).voies.get(3).distances/2;
                Stop newstop = new Stop();
                newstop.position=position;                       // je ne comprends pas
                villes.get(2).voies.get(3).intersections.add((Intersection)newstop);
                villes.get(2).voies.get(3).intersection +=1;

            }
            else { // on met un stop sur ville.get(1).voies.get(1).voie                                 Gné
               // Stop newstop = new Stop(villes.get(4).voies.get(0).nb_voies);
                int position=villes.get(1).voies.get(5).distances/2;
                Stop newstop = new Stop();
                newstop.position=position;                     // je ne comprends pas
                villes.get(1).voies.get(5).intersections.add((Intersection)newstop);
                villes.get(1).voies.get(5).intersection +=1;

            }

            if (villes.get(2).voies.get(3).nb_voies == villes.get(4).voies.get(5).nb_voies){
                // on met un feu
                Feu newfeu1 = new Feu("allume",((villes.get(2).voies.get(3).distances)/2));
                villes.get(2).voies.get(3).intersections.add((Intersection)newfeu1);
                villes.get(2).voies.get(3).intersection +=1;

                Feu newfeu2 = new Feu("eteind",((villes.get(4).voies.get(5).distances)/2));
                villes.get(4).voies.get(5).intersections.add((Intersection)newfeu2);
                villes.get(4).voies.get(5).intersection += 1;
            }
            else if (villes.get(2).voies.get(3).nb_voies < villes.get(1).voies.get(5).nb_voies){
                // on met un stop sur la ville.get(0).voies.get(3).voie
               // Stop newstop = new Stop(villes.get(2).voies.get(0).nb_voies);                         Gné
                int position=villes.get(2).voies.get(3).distances/2;
                Stop newstop = new Stop();
                newstop.position=position;                       // je ne comprends pas
                villes.get(2).voies.get(3).intersections.add((Intersection)newstop);
                villes.get(2).voies.get(3).intersection +=1;

            }
            else { // on met un stop sur ville.get(1).voies.get(1).voie
                //Stop newstop = new Stop(villes.get(1).voies.get(3).nb_voies);                    // Gné 3 feu sur la meme voie
                int position=villes.get(4).voies.get(5).distances/2;
                Stop newstop = new Stop();
                newstop.position=position;                       // je ne comprends pas
                villes.get(4).voies.get(5).intersections.add((Intersection)newstop);
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
            for (int j = compteur; j < nbVille ; j++) {
                //System.out.println("for compteur"+(j));
                Voie k =i.voies.get(j) ;
                  // System.out.println(("for voies :"+k.destination)); // tous ca ok

                    for (Vehicule l : k.voitures) {
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
                        }
                        else{
                        for ( Vehicule m : k.voitures) {




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
                            }}
                        } // ici for each voiture
                    }  compteur++;

                }


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

    public static void main( String[] args){
        /*Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir le nombre de villes souhaité: (implémenté par defaut mais cest la ) ");
        int i = sc.nextInt();*/
        Jeu FlashMc = new Jeu ();
        FlashMc.nbVille=6;
        FlashMc.init();
       // FlashMc.afficherToutesRoutes();
        //FlashMc.afficherRoute();
        //FlashMC.afficherVoitureRoute();
        /*for ( Voie i : FlashMc.villes.get(5).voies){
            System.out.println(i.distances);
        }*/

       /* System.out.println(FlashMc.villes.get(0).voies.get(4).intersection); // on doit avoir 1
        System.out.println(FlashMc.villes.get(1).voies.get(3).intersection); // on doit avoir 1 // test intersections
        System.out.println(FlashMc.villes.get(1).voies.get(5).intersection); //2
        System.out.println(FlashMc.villes.get(2).voies.get(4).intersection);//1
        System.out.println(FlashMc.villes.get(2).voies.get(3).intersection);// 2
        System.out.println(FlashMc.villes.get(4).voies.get(5).intersection); // 1*/


       // System.out.println("intersection :"+FlashMc.villes.get(0).voies.get(4).intersection);
       // System.out.println("nb voie :"+FlashMc.villes.get(0).voies.get(4).nb_voies);
        //System.out.println("chaufard :"+FlashMc.villes.get(0).voies.get(1).voitures.get(0).chaufard);
        for ( int i = 0 ; i<10; i++) {
            //System.out.println("~~~~~~~~~~~~~~~~tour :" + i);
            FlashMc.DebutTour();

            //System.out.println("vitesse : " + FlashMc.villes.get(0).voies.get(4).voitures.get(0).vitesse);
            //System.out.println("position : " + FlashMc.villes.get(0).voies.get(4).voitures.get(0).position);
            //if (i < 1) System.out.println("chaufard :" + FlashMc.villes.get(0).voies.get(4).voitures.get(0).chaufard);

           /* int s = 0;
            for (Vehicule j : FlashMc.villes.get(0).voies.get(1).voitures) { // test nbr de voiture sur la route

                s++;
            }
            System.out.println("nb voiture : " + s);*/
            //for (Vehicule j : FlashMc.villes.get(1).voies.get(2).voitures) {
               // System.out.println("possition : " + j.vitesse);
                //if (FlashMc.villes.get(0).voies.get(4).intersections.get(0) instanceof Feu) {//

                    // }

                    // }

                    // System.out.println(FlashMc.villes.get(1).voies.get(1).voitures.get(0).position);
                //}


            }
        }
    }




