package Chess.Models;

class Context {
	
	private Board CurrentBoard;
		
	private Player[] CurrentPlayers;
	
	public void Context(Player[] players)
   	{
		this.CurrentBoard = new Board();
		this.CurrentPlayers = players;
	}
	
}
