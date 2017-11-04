package Chess.Models;

import Chess.Models.Board;
import Chess.Models.Player;

class Context {
	
	private Board CurrentBoard;
		
	private ArrayList<Player> CurrentPlayers;
	
	public void Context(Player player1, Player player2)
   	{
		this.CurrentBoard = new Board();
		this.CurrentPlayers.add(player1);
		this.CurrentPlayers.add(player2);
	}
	
}
