import java.util.Random;

public class Vehicule{
	public float vitesse;
	public String destination;
	public float position;
	public float chaufard;
	public Voie voie;
	Random rand = new Random();
	int randomNumber=(rand.nextInt(21)-21);
	int n = rand.nextInt()*5+1;



	public Vehicule(String destination){
		this.vitesse=1;
		this.position=0;
		Random rand = new Random();
		this.chaufard=(float)(Math.random()*40-20);// generer un entier aleatatoire entre - 20 et 20
		this.destination=destination;
	}



	public void accelerer(Voie voie){
		if(this.vitesse==0){}// peu etre implementer une variable qui renvoie a la route pour savoir instanceof => on sait a cb max elle doit rouler
			if (voie.intersection==0){
				if ((this.vitesse<(voie.vitesse+chaufard))&(this.vitesse+20<voie.vitesse+chaufard))
				{
					this.vitesse += 20; // a determiner!
					this.position+=(this.vitesse/10);
				}
				else if (this.vitesse<(voie.vitesse+chaufard)){
					this.vitesse+=voie.vitesse+chaufard-this.vitesse;
					this.position+=(this.vitesse/10);
				}
				else{
					this.position+=(this.vitesse/10);
				}
			}
			else
			{
				if (voie.intersection==1){
					if ((this.position-voie.intersections.get(0).position)>-40 &((this.position-voie.intersections.get(0).position)<0)) // 64 pour 160km
					{
						if (voie.intersections.get(0) instanceof Feu)
						{
							if((((Feu)voie.intersections.get(0)).etat==0))
							{
								if ((this.vitesse<(voie.vitesse+chaufard))&(this.vitesse+20<voie.vitesse+chaufard))
								{
									this.vitesse -= 40; // a determiner!
									this.position+=(this.vitesse/10);
								}
							}
							else
								{
									if ((this.vitesse<(voie.vitesse+chaufard))&(this.vitesse+20<voie.vitesse+chaufard))
									{
										this.vitesse += 20; // a determiner!
										this.position+=(this.vitesse/10);
									}
								else if (this.vitesse<(voie.vitesse+chaufard)){
									this.vitesse+=voie.vitesse+chaufard-this.vitesse;
									this.position+=(this.vitesse/10);
								}
								else{
									this.position+=(this.vitesse/10);
								}
								}
						}
						else {
								if (this.vitesse-40>0){
								this.vitesse -= 40; // a determiner!
									this.position+=(this.vitesse/10);}

							}
					}
				}
				else
				{
					if (((this.position-voie.intersections.get(0).position)>-3 &((this.position-voie.intersections.get(0).position)<0))|((this.position-voie.intersections.get(1).position)>-3 &((this.position-voie.intersections.get(1).position)<0))){
						this.vitesse-=40;
						this.position+=(vitesse/10);
					}
				else {
					if (this.vitesse<(voie.vitesse+chaufard)) {
						this.vitesse += 20; // a determiner!
						this.position+=(this.vitesse/10);
					}
				}
				}
			}


	}
	public void decelerer(){
		this.vitesse-=40;
		this.position+=(this.vitesse/10);
	}
}