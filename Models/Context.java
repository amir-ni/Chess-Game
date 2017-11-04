package Chess.Models;

import Chess.Models.Board;
import Chess.Models.Player;

class Context {
	
	public Board CurrentBoard;
		
	public ArrayList<Player> CurrentPlayers;
	
	public void Context()
   	{
		this.CurrentBoard = new Board();
	}
	
}
