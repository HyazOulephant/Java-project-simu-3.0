package prog;

public class Route extends Voie {
    public Route(String nom) {
        this.vitesse = 90;
        this.nb_voies = 2;
        this.distances = 200; // ou random a determiner ji si pa comme on veut
        this.destination = nom;
        this.intersection = 0;
        // ? bug compilation voie pas initialisé
    }
}
