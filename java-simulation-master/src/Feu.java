public class Feu{
	public int etat;
	public int tours;

	public Feu(String etat){
	if(etat=="allume")this.etat=1;
	else this.etat=0;
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