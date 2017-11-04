package Chess.Models;

public class Player {

	private String name;
	
	private Color color;
	
	public void SetName(String Name){
		this.name = Name;
	}
	
	public String ReturnName(){
		return this.name;
	}
	
	public void SetColor(Color color){
		this.color = color;
	}
	
	public Color ReturnColor(){
		return this.color;
	}
	
}