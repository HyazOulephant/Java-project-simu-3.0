import java.util.Vector;

public class Ville {

    public String nom;
    public int nbVehicules;
    public Vector<Voie> voies = new Vector<Voie>();

    public Ville(String nom,int nbVehicule){
    	this.nbVehicules=nbVehicule;
    	this.nom=nom;
    }

    void Generer_vehicule (){
        for ( int i = 0;i<this.nbVehicules;i++){
            Vehicule car = new Vehicule("destination");
             // nombre aleatoire dans le tableau deds nom de villes avec exceptoion pour la ville qui la genere
            switch(car.destination){
                case "Versailles" :
                    this.voies.elementAt(1).voitures.add(car);break; // cas pour chaque ville dans lordre du tableau de nom de ville
                                                        // voir implementation de voies[] en java
                case "Paris" :
                    this.voies.elementAt(0).voitures.add(car);break;
                case "Lille" :
                    this.voies.elementAt(2).voitures.add(car);break;
                case "Marseilles" :
                    this.voies.elementAt(3).voitures.add(car);break;
                case "Lyon" :
                    this.voies.elementAt(4).voitures.add(car);break;
                case "Perpignan" :
                    this.voies.elementAt(5).voitures.add(car);break;
                case "Strabourg" :
                    this.voies.elementAt(6).voitures.add(car);break;
                case "Brest" :
                    this.voies.elementAt(7).voitures.add(car);break;
                case "Toulon" :
                    this.voies.elementAt(8).voitures.add(car);break;
                case "Monaco" :
                    this.voies.elementAt(9).voitures.add(car);break;
            }
        }

    }




}
