import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Jeu {
    public List<String> nomVilles = new ArrayList<String>(Arrays.asList("Paris", "Versailles", "Lille", "Marseilles", "Lyon", "Perpignan", "Strasbourg", "Brest", "Toulon", "Monaco"));
    public ArrayList<Ville> villes = new ArrayList<Ville>();
    public int nbVille;
    public ArrayList<Feu> feux = new ArrayList<Feu>(); // a mettre dans route

    void Jeu() { // remettre l'argument ici
        this.nbVille = 6;
    }

    public void init() {

        for (int i = 0; i < nbVille; i++) {

            Ville ville = new Ville(nomVilles.get(i), (int) (Math.random() * 11));  // x un entier aleatoire representant le nombre de voiture creees par tour
            villes.add(ville);
        }
        for (Ville i : villes) {
            for (int j = 0; j < nbVille - 1; j++) {

                if (j < 0.2 * nbVille) {
                    // creer autoroute
                } else if ((j < 0.3 * nbVille) && (j > 0.2 * nbVille)) {
                    // crrer Nationale
                } else System.out.println("zegfzgzegzge");// creer route
                // du style i.voies.add("LaVoieCree");
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
                            if ((m.destination==l.destination)&(l.position-m.position<3))
                            {
                                if ( (m.destination!= l.destination )&(l.position+m.position-k.distances>-3)&(l.position+m.position-k.distances<0)){}//decelerer
                                    //if ()
                            }
                        }
                        l.accelerer(); // a faire
                    }
                }
            }
            compteur++;
        }
    }


    public void DebutTour() { // init de chaque tours
        for (Ville i : villes) {
            i.Generer_vehicule(villes, i);
        }
        for (Feu i : feux) {
            i.tour();
        }
        deplacementVehicules();
    }

    //public Vector<String> nomVilles = new Vector<>();




    public static void main( String[] args){
        /*Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir le nombre de villes souhaité: (implémenté par defaut mais cest la ) ");
        int i = sc.nextInt();*/
        Jeu FlashMc = new Jeu ();
        FlashMc.init();
        System.out.println(FlashMc.villes);
        System.out.println("test");
        FlashMc.DebutTour();

    }
}