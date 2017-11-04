package Chess.Controllers;

public class PlayController{
	
	public PlayController(){
		
	}
	/*
	private Color turn;
	
	public Color ReturnTurn(){
		return (this.turn);
	}
	
	public void MovePiece(int PieceId, int NewColumn, int NewRow){

		boolean IsAttacking = false;

		if (!(0<=PieceId && PieceId<32))
			throw new ArithmeticException("illegal PieceId value: " + PieceId);

		if (!(0<NewColumn && NewColumn<9))
			throw new ArithmeticException("illegal NewColumn value: " + NewColumn);

		if (!(0<NewRow && NewRow<9))
			throw new ArithmeticException("illegal NewRow value: " + NewRow);

		if (this.FilledLocations[NewColumn][NewRow] != -1 ){
			if( this.Pieces[this.FindIdByLocation(NewColumn,NewRow)].ReturnColorId() == this.Pieces[PieceId].ReturnColorId() ){
				throw new ArithmeticException("illegal Move : Destination is full");
			}else{
				IsAttacking = true;
				this.Pieces[this.FindIdByLocation(NewColumn,NewRow)].capture();
				this.RemainingPieces--;
			}
		}

		int[] CurrentLocation = this.Pieces[PieceId].ReturnLocation();

		switch (this.Pieces[PieceId].ReturnType()){
			case 1://rook
			{
				if(CurrentLocation[0] == NewColumn){
					for(int i= (CurrentLocation[1] + ((CurrentLocation[1] < NewRow) ? 1 : -1) );i != NewRow;i+= (CurrentLocation[1] < NewRow) ? 1 : -1){
						if(FilledLocations[NewColumn][i] == 1){
							throw new ArithmeticException("illegal Move by rook");
						}
					}
				}else if(CurrentLocation[1] == NewRow){
					for(int i= (CurrentLocation[0] + ((CurrentLocation[0] < NewColumn) ? 1 : -1) );i != NewColumn;i+= (CurrentLocation[0] < NewColumn) ? 1 : -1){
						if(FilledLocations[NewRow][i] == 1){
							throw new ArithmeticException("illegal Move by rook");
						}
					}
				}else{
					throw new ArithmeticException("illegal Move by rook");
				}
				break;
			}
			case 2://knight
			{
				if( !( ( (Math.abs(CurrentLocation[0] - NewColumn) == 2) && (Math.abs(CurrentLocation[1] - NewRow) == 1) ) ||
						(  (Math.abs(CurrentLocation[0] - NewColumn) == 1) && (Math.abs(CurrentLocation[1] - NewRow) == 2) ) ) ){
					throw new ArithmeticException("illegal Move by knight");
				}
				break;
			}
			case 3://bishop
			{
				if ( Math.abs(CurrentLocation[0] - NewColumn) != Math.abs(CurrentLocation[1] - NewRow) ){
					throw new ArithmeticException("illegal Move by bishop");
				}
				break;
			}
			case 4://queen
			{
				if( ( Math.abs(CurrentLocation[0] - NewColumn) != Math.abs(CurrentLocation[1] - NewRow) ) || (CurrentLocation[0] != NewColumn && CurrentLocation[1] != NewRow) ){
					throw new ArithmeticException("illegal Move by queen");
				}
				break;
			}
			case 5://king
			{
				if ( ( Math.abs(CurrentLocation[0] - NewColumn) > 1 ) || ( Math.abs(CurrentLocation[1] - NewRow) > 1 ) ){
					throw new ArithmeticException("illegal Move by king");
				}
				break;
			}
			case 6://Pawn
			{
				if(this.Pieces[PieceId].ReturnColorId() == 0){ //black
					if ( (CurrentLocation[1] == 7 && NewRow != 6 && NewRow != 5) || (CurrentLocation[1] != 7 && CurrentLocation[1]-1 != NewRow) ){
						throw new ArithmeticException("illegal Move by Pawn");
					}
				} else {
					if ( (CurrentLocation[1] == 2 && NewRow != 3 && NewRow != 4) || (CurrentLocation[1] != 2 && CurrentLocation[1]+1 != NewRow) ){
						throw new ArithmeticException("illegal Move by Pawn");
					}
				}

				if ( ( (IsAttacking) && ( Math.abs(NewColumn - CurrentLocation[0]) != 1 ) ) || ( (!(IsAttacking)) && (NewColumn != CurrentLocation[0]) ) || ( ( Math.abs(NewColumn - CurrentLocation[0]) == 1 ) && ( Math.abs(NewRow - CurrentLocation[1]) == 2 ) ) ) {
					throw new ArithmeticException("illegal Move by Pawn");
				}

				if(NewRow == 1 || NewRow == 8){
					this.Pieces[PieceId].SetType(4);
				}

				break;
			}
		}


		this.FilledLocations[this.Pieces[PieceId].col][this.Pieces[PieceId].row] = -1;

		this.Pieces[PieceId].col = NewColumn;
		this.Pieces[PieceId].row = NewRow;

		this.FilledLocations[NewColumn][NewRow] = 1;

		this.Turn = 1 - this.Turn;

	}
	*/
}
