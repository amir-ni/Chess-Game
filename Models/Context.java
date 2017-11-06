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
		this.CurrentPlayers.add(new Player);
		this.CurrentPlayers.add(new Player);
	}
	
}
