public class Autoroute extends Voie {
    public Autoroute(String nom){
        this.vitesse=130;
        this.nb_voies=6;
        this.distances=10; // ou random a determiner ji si pa comme on veut
        this.destination = nom;
        this.intersection = 0;
    }
}
