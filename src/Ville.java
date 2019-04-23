import java.util.ArrayList;

public class Ville {

    public String nom;
    public int nbVehicules;
    public ArrayList<Voie> voies = new ArrayList<Voie>();

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
                    this.voies.get(1).voitures.add(car);break; // cas pour chaque ville dans lordre du tableau de nom de ville
                // voir implementation de voies[] en java
                case "Paris" :
                    this.voies.get(0).voitures.add(car);break;
                case "Lille" :
                    this.voies.get(2).voitures.add(car);break;
                case "Marseilles" :
                    this.voies.get(3).voitures.add(car);break;
                case "Lyon" :
                    this.voies.get(4).voitures.add(car);break;
                case "Perpignan" :
                    this.voies.get(5).voitures.add(car);break;
                case "Strabourg" :
                    this.voies.get(6).voitures.add(car);break;
                case "Brest" :
                    this.voies.get(7).voitures.add(car);break;
                case "Toulon" :
                    this.voies.get(8).voitures.add(car);break;
                case "Monaco" :
                    this.voies.get(9).voitures.add(car);break;
            }
        }

    }




}
