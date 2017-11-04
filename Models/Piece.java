package Chess.Models;

public class Piece {
	
	private int col;

	private int row;

	private Color color;

	private Type type;

	private State state = State.NotCaptured;

	public void SetLocation(int NewColumn, int NewRow){
		this.col = NewColumn;
		this.row = NewRow;
	}

	public int[] ReturnLocation(){
		int[] location = {this.col, this.row};
		return location;
	}

	public void capture(){
		this.col = 0;
		this.row = 0;
		this.state = State.Captured;
	}

	public State IsCaptured(){
		return this.state;
	}

	public void SetType(Type NewType){
		this.type = NewType;
	}

	public Type ReturnType(){
		return this.type;
	}

	public void SetColor(Color NewColor){
		this.color = NewColor;
	}

	public Color ReturnColor(){
		return this.color;
	}

}