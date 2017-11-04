package Chess.Models;

import Chess.Models.Cell;
import Chess.Models.Piece;

public class Board{

	private int RemainingPiecesCount;

	private Piece[] Pieces = new Piece[32];

	private Cell[][] Cells = new Cell[9][9]; // Cell[ColumnId][RowId]

	private Color turn;

	private Cell FindIdByLocation(int ColumnId, int RowId){
		return this.Cells[ColumnId][RowId];
	}

	public Color ReturnTurn()
    {
        return this.turn;
    }

	public void changeTurn()
    {
		if(this.turn == Color.WHITE){
			this.turn = Color.BLACK;
		}else{
			this.turn = Color.WHITE;
		}
    }

	public int CountRemainingPieces(){
		return this.RemainingPiecesCount;
	}

	public Board(){
		this.CreateBoard();
	}

	public void CreateBoard(){

		this.RemainingPiecesCount = 32;
		this.turn = Color.WHITE;

		for(int i=0;i<24;i++){
			this.Pieces[i] = new Piece();
			this.Pieces[i].SetLocation( ( (((i+1)%8) == 0) ? 8 : ((i+1)%8) ) , ( (i<8) ? 1 : 8) );
			this.Pieces[i].SetColor( (i<8) ? Color.WHITE : Color.BLACK );

			this.Cells[((i+1)%8)][((i<8) ? 1 : 8)].setPiece(this.Pieces[i]);

			switch (i%8){
				case 0:
				{
					this.Pieces[i].SetType(Type.Rook);
					break;
				}
				case 1:
				case 6:
				{
					this.Pieces[i].SetType(Type.Knight);
					break;
				}
				case 2:
				case 5:
				{
					this.Pieces[i].SetType(Type.Bishop);
					break;
				}
				case 3:
				{
					this.Pieces[i].SetType(Type.Queen);
					break;
				}
				case 4:
				{
					this.Pieces[i].SetType(Type.King);
					break;
				}
				case 7:
				{
					this.Pieces[i].SetType(Type.Rook);
					i += 8;
					break;
				}
			}

		}

		for(int i=8;i<16;i++){
			this.Pieces[i] = new Piece();
			this.Pieces[i].SetLocation( ( (((i+1)%8) == 0) ? 8 : ((i+1)%8) ) , 2 );
			this.Pieces[i].SetColor(Color.WHITE);
			this.Pieces[i].SetType(Type.Pawn);

			this.Cells[((i+1)%8)][2].setPiece(this.Pieces[i]);

		}

		for(int i=24;i<32;i++){
			this.Pieces[i] = new Piece();
			this.Pieces[i].SetLocation(  ( (((i+1)%8) == 0) ? 8 : ((i+1)%8) ) , 7 );
			this.Pieces[i].SetColor(Color.BLACK);
			this.Pieces[i].SetType(Type.Pawn);

			this.Cells[((i+1)%8)][7].setPiece(this.Pieces[i]);

		}
	}

	public Piece[] ReturnPieces(){
		return Pieces;
	}

}