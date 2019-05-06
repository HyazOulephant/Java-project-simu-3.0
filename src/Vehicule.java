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



	public void accelerer(Voie voie){
		if(this.vitesse<0){}// peu etre implementer une variable qui renvoie a la route pour savoir instanceof => on sait a cb max elle doit rouler
			if (voie.intersection==0){
				if (this.vitesse<(voie.vitesse+chaufard)) {
					this.vitesse += 1; // a determiner!
				}
	}
			else
			{
				if ((this.position-voie.intersections.get(0).position)>-3 &((this.position-voie.intersections.get(0).position)<0)){}
				else {
					if (this.vitesse<(voie.vitesse+chaufard)) {
						this.vitesse += 1; // a determiner!
					}
				}
			}


}
	public void decelerer(){
		this.vitesse-=1;
	}
}