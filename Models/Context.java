package Chess.Models;

import Chess.Models.Board;
import Chess.Models.Player;

class Context {
	
	private Board CurrentBoard;
		
	private ArrayList<Player> CurrentPlayers;
	
	public void Context(Player WhitePiecesPlayer, Player BlackPiecesPlayer)
   	{
		this.CurrentBoard = new Board();
		this.CurrentPlayers.add(WhitePiecesPlayer);
		this.CurrentPlayers.add(BlackPiecesPlayer);
	}
	
}
