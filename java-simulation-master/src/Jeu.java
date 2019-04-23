import java.util.Vector;

public class Jeu{
	//public Vector<String> nomVilles = new Vector<>();
	String nomVilles[]{"Paris","Versailles","Lille","Marseilles","Lyon","Perpignan","Strasbourg","Brest","Toulon","Monaco"};
	public Vector<Ville> villes = new Vector<Ville>();
	public int nbVille;
	public Vector<Feu> feux = new Vector<>();

    void Jeu() {
        // demander le nombre de villes voulus
        this.nbVille=0;// reponse apporte
    }
}

	void init(){

		for( int i =0;i<nbVille;i++){

			Ville ville = new Ville(nomVilles[i],x);  // x un entier aleatoire representant le nombre de voiture creees par tour
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
                else // creer route
                // du style i.voies.add("LaVoieCree");
            }
        }
 // une fois les schemas de villes fait on sait exactement quelles routes ce croiseront et on les implementera en dur ,
		// si 4 villes alors la route 2 de la ville 1 et la route 3 de la ville 3 ce ccoupe


}
	void DebutTour(){ // init de chaque tours
		for ( Ville i : villes){
			i.Generer_vehicule();
		}
		for ( Feu i : feux){
			i.tour();
		}
	}




/* 		for (ville i : villes)
		int nb_route=
		Ville Paris = new Ville(5);
		Route route1= new Route(); // lyon
		Paris.voies.push_back(route1);
		Autoroute route8= new Autoroute(); // marsailles
		Paris.voies.push_back(route8);
		Autoroute route9= new Autoroute(); // Versailles
		Paris.voies.push_back(route9);
		Route route6= new Route(); // lille
		Paris.voies.push_back(route6);
		Nationale route11= new Nationale(); // angers
		Paris.voies.push_back(route11);

		Ville Versailles = new Ville(4);
		Route route1= new Route(); // lyon
		Paris.voies.push_back(route1);
		Autoroute route8= new Autoroute(); // marsailles
		Paris.voies.push_back(route8);
		Autoroute route9= new Autoroute(); // Versailles
		Paris.voies.push_back(route9);
		Route route6= new Route(); // lille
		Paris.voies.push_back(route6);
		Nationale route11= new Nationale(); // angers
		Paris.voies.push_back(route11);
		Paris.voie.push_back();

		Ville Lyon = new Ville(3);
		Paris.voie.push_back();
		Ville Lille = new Ville(5);
		Paris.voie.push_back();
		Ville Marseille = new Ville(1);
		Paris.voie.push_back();
		Ville Angers = new Ville(2);
		Paris.voie.push_back();
	*/