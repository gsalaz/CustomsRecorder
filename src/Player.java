import java.util.ArrayList;

public class Player {

	String playerName;
	int wins, losses;
	ArrayList<Champ> champs;

	public Player(String name) {
		playerName = name;
		wins = 0;
		losses = 0;
		champs = new ArrayList<Champ>();
	}
	
	public void updateWL(boolean isWin) {
		if(isWin)
			wins++;
		else
			losses++;
	}
	
	public void updateChamp(String name, int k, int d, int a, boolean isWin) {
		int i = getChampIndex(name);
		
		if(i >= 0) {
			champs.get(i).updateKDA(k, d, a);
			champs.get(i).updateWL(isWin);
		}
		else {
			Champ newChamp = new Champ(name, k, d, a, isWin);
			champs.add(newChamp);
		}
	}
	
	public float getWinrate() {
		return wins/(wins+losses);
	}
	public int getWins() {
		return wins;
	}
	public int getLosses() {
		return losses;
	}
	
	//gets index of champ or -1 if not there
	int getChampIndex(String name) {
		for(int i = 0; i < champs.size(); i++) {
			if(champs.get(i).name.toLowerCase()
					.equals(name.toLowerCase()))
				return i;
		}
		return -1;
	}
	
	public String toString() {
		String allChamps = "";
		
		for(int i = 0; i < champs.size(); i++) {
			allChamps += champs.get(i).toString() + "\n\n";
		}
		
		String playerString = "\nWinRate: " + getWinrate() + "\t" + wins + "/" + losses;
		
		return allChamps + playerString;
		
		
	}
	
}
