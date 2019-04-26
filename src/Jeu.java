import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Jeu {
    void init(){

        for( int i =0;i<nbVille;i++){

            Ville ville = new Ville(nomVilles.get(i), (int)(Math.random()*11));  // x un entier aleatoire representant le nombre de voiture creees par tour
            villes.add(ville);
        }
        for (Ville i : villes){
            for (int j=0;j<nbVille-1;j++){

                if (j<0.2*nbVille){
                    // creer autoroute
                }
                else if ((j<0.3*nbVille)&&(j>0.2*nbVille)){
                    // crrer Nationale
                }
                else System.out.println("zegfzgzegzge");// creer route
                // du style i.voies.add("LaVoieCree");
            }
        }
        // une fois les schemas de villes fait on sait exactement quelles routes ce croiseront et on les implementera en dur ,
        // si 4 villes alors la route 2 de la ville 1 et la route 3 de la ville 3 ce ccoupe


    }
    public void deplacementVehicules(){
    	int compteur=0;
    	for (Ville i : villes){
    		for (int j=compteur;j<nbVille-1;j++){
    			for ( Voie k : i.voies){
    				for (Vehicule l : k.voitures){
    					// test() ?
    					l.accelerer(); // a faire
					}
				}
			}
    		compteur++;
		}
	}
    public void DebutTour(){ // init de chaque tours
        for ( Ville i : villes){
            i.Generer_vehicule();
        }
        for ( Feu i : feux){
            i.tour();
        }

        deplacementVehicules();
    }

    //public Vector<String> nomVilles = new Vector<>();
    List<String> nomVilles = new ArrayList<String>(Arrays.asList("Paris","Versailles","Lille","Marseilles","Lyon","Perpignan","Strasbourg","Brest","Toulon","Monaco"));


    public ArrayList<Ville> villes = new ArrayList<Ville>();
    public int nbVille;
    public ArrayList<Feu> feux = new ArrayList<Feu>();

    void Jeu() {
        // demander le nombre de villes voulus
        this.nbVille=0;// reponse apporte
    }





    public static void main( String[] args){
        //S'exec
    }
}


