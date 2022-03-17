
public class Champ{

	String name;
	int wins, losses, total;
	int[] kda;
	
	public Champ(String n, int kills, int deaths, int assists, boolean isWin){
		name = n;
		wins = losses = total = 0;
		updateKDA(kills, deaths, assists);
		updateWL(isWin);
	}
	
	public void updateWL(boolean isWin) {
		if(isWin)
			wins++;
		else
			losses++;
		
		total++;
	}
	public void updateKDA(int kills, int deaths, int assists) {
		kda[0] += kills;
		kda[1] += deaths;
		kda[2] += assists;
	}
	
	public int[] getKDA() {
		return kda;
	}
	public float getWinRate() {
		return wins/total;
	}
	public int getWins(){
		return wins;
	}
	public int getLosses() {
		return losses;
	}

	public String toString() {
		return name + ":\t" + kda[0]/total + kda[1]/total + kda[2]/total + 
				"\t" + (kda[0]+kda[2])/total + 
				"\t" + wins + "/" + losses + "\t" + wins/total;
	}
	/*
	@Override
	public int compareTo(Champ o) {
		if(this.name.toLowerCase().equals(o.name.toLowerCase()))
			return 1;
		else
			return 0;
	}
	*/
	
	
}
