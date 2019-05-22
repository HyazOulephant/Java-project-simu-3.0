package prog;

public class Nationale extends Voie {

    public Nationale(String nom){
        this.vitesse=110;
        this.nb_voies=4;
        this.distances=10; // ou random a determiner ji si pa comme on veut
        this.destination = nom;
        this.intersection = 0;
    }
}
