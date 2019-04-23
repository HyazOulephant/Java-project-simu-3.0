import java.util.Random;

public class Vehicule{
	public int vitesse;
	public String destination;
	public int position;
	public int chaufard;
	Random rand = new Random();
	int randomNumber=(rand.nextInt(21)-21);
	int n = rand.nextInt()*5+1;



	public Vehicule(String destination){
		this.vitesse=0;
		this.position=0;
		this.chaufard=0; // generer un entier aleatatoire entre - 20 et 20
		this.destination=destination;
	}

	public void doubler(){
		// tester avec toutes les voitures sur la route si yen a ala meme distance quelle ou 1 decart etc

	}

	public void accelerer(){
		if(this.vitesse<"max route"+chaufard)// peu etre implementer une variable qui renvoie a la route pour savoir instanceof => on sait a cb max elle doit rouler
		vitesse+=10; // a determiner!

	}

	public void stop(){
		this.vitesse=0;
	}



}