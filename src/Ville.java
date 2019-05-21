import java.util.ArrayList;


public class Ville {

    public String nom;
    public int nbVehicules;
    public ArrayList<Voie> voies = new ArrayList<Voie>();


    public Ville(String nom,int nbVehicule){
        this.nbVehicules=nbVehicule;
        this.nom=nom;
    }

    void Generer_vehicule (ArrayList<Ville> villes,Ville j){


        for ( int i = 0;i<this.nbVehicules;i++){
            //System.out.println("for nbvehicules");
            Vehicule car = new Vehicule("destination");
            this.voies.get(1).voitures.add(car);  // TEST A NE PAS LAISSER
            int valeur=(int)(Math.random()*6);                          // a modifier en fct de nbville=6
            while((car.destination=villes.get(valeur).nom)==j.nom){
                valeur=(int)(Math.random()*6);
            }

            switch(car.destination){
                case "Versailles" :
                    this.voies.get(1).voitures.add(car);break; // cas pour chaque ville dans lordre du tableau de nom de ville
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
