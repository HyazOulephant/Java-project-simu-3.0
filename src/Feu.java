public class Feu extends Intersection{
	public int etat;
	public int tours;


	public Feu(String etat,int position){
		if(etat=="allume")this.etat=1;
		else this.etat=0;
		this.position=position;
	}
	public void tour(){
		if (this.tours==3){
			this.etat=(this.etat+1)%2;
			this.tours=0;
		}
		else {
			this.tours+=1;
		}
	}
}