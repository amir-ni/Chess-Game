package Chess.Models;

import Chess.Models.Board;
import Chess.Models.Player;

class Context {
	
	public Board CurrentBoard;
		
	public ArrayList<Player> CurrentPlayers;
	
	public void Context()
   	{
		this.Seed();
	}
	
	public void Seed(){
		
		this.CurrentBoard = new Board();
		
		Player firstPlayer = new Player;
		firstPlayer.SetColor(Color.WHITE);
		this.CurrentPlayers.add(firstPlayer);
		
		Player secondPlayer = new Player;
		secondPlayer.SetColor(Color.BLACK);
		this.CurrentPlayers.add(secondPlayer);
		
	}
	
}
