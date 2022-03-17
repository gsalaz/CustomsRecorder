import java.util.ArrayList;

public class records {

	ArrayList<Player> players;
	
	public records(){
		players = new ArrayList<Player>();
	}
	
	public void addPlayer(String playerName) {
		Player newPlayer = new Player(playerName);
	}
	public boolean deletePlayer(String playerName) {
		for(int i = 0; i < players.size(); i++) {
			if(players.get(i).playerName.toLowerCase()
					.equals(playerName.toLowerCase())) {
				players.remove(i);
				return true;
			}
		}
		return false;
	}
	
	
	
}
