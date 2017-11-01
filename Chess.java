class Chess {

    public static void main(String[] args) {
        Chess game = new Chess();
        game.start();
    }

    public void start()
    {
        Board MyBoard = new Board();
        Piece[] GamePieces = MyBoard.ReturnPieces();
        for(int i=0;i<32;i++)
            System.out.println(GamePieces[i].ReturnDescription());
    }

    public class Board{

        private int RemainingPieces;

        private int Turn;

        private Piece[] Pieces = new Piece[32];

        private int[][] FilledLocations = new int[9][9]; // FilledLocations[ColumnId][RowId]

        private int FindIdByLocation(int ColumnId, int RowId){
            return this.FilledLocations[ColumnId][RowId];
        }

        public int CountRemainingPieces(){
            return this.RemainingPieces;
        }

        public String ReturnTurn(){
            return (this.Turn == 1 ? "White" : "Black");
        }

        public Board(){
            this.CreateBoard();
        }

        public void CreateBoard(){

            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    this.FilledLocations[i][j] = -1;
                }
            }

            this.RemainingPieces = 32;
            this.Turn = 1;

            for(int i=0;i<24;i++){
                this.Pieces[i] = new Piece();
                this.Pieces[i].SetLocation( ( (((i+1)%8) == 0) ? 8 : ((i+1)%8) ) , ( (i<8) ? 1 : 8) );
                this.Pieces[i].SetColor( (i<8) ? 1 : 0 );

                this.FilledLocations[((i+1)%8)][((i<8) ? 1 : 8)] = i;

                switch (i%8){
                    case 0://rook
                    {
                        this.Pieces[i].SetType(1);
                        break;
                    }
                    case 1://knight
                    case 6://knight
                    {
                        this.Pieces[i].SetType(2);
                        break;
                    }
                    case 2://bishop
                    case 5://bishop
                    {
                        this.Pieces[i].SetType(3);
                        break;
                    }
                    case 3://queen
                    {
                        this.Pieces[i].SetType(4);
                        break;
                    }
                    case 4://king
                    {
                        this.Pieces[i].SetType(5);
                        break;
                    }
                    case 7://rook
                    {
                        this.Pieces[i].SetType(1);
                        i += 8;
                        break;
                    }
                }

            }

            for(int i=8;i<16;i++){
                this.Pieces[i] = new Piece();
                this.Pieces[i].SetLocation( ( (((i+1)%8) == 0) ? 8 : ((i+1)%8) ) , 2 );
                this.Pieces[i].SetColor(1);
                this.Pieces[i].SetType(6);

                this.FilledLocations[((i+1)%8)][2] = i;

            }

            for(int i=24;i<32;i++){
                this.Pieces[i] = new Piece();
                this.Pieces[i].SetLocation(  ( (((i+1)%8) == 0) ? 8 : ((i+1)%8) ) , 7 );
                this.Pieces[i].SetColor(0);
                this.Pieces[i].SetType(6);

                this.FilledLocations[((i+1)%8)][7] = i;

            }
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

        public Piece[] ReturnPieces(){
            return Pieces;
        }

    }

    public class Piece {

        private int col;

        private int row;

        private int type;

        private int color;

        private int captured = 0;

        public void SetLocation(int NewColumn, int NewRow){
            this.col = NewColumn;
            this.row = NewRow;
        }

        public void SetColor(int NewColor){
            this.color = NewColor;
        }

        public void capture(){
            this.col = 0;
            this.row = 0;
            this.captured = 1;
        }

        public int IsCaptured(){
            return captured;
        }

        public void SetType(int NewType){
            this.type = NewType;
        }

        public String ReturnColor(){
            switch(this.color) {
                case 0 :
                    return "Black";
                case 1 :
                    return "White";
                default :
                    return "NotSet";
            }
        }

        public int ReturnColorId(){
            return this.color;
        }

        public int ReturnType(){
            return this.type;
        }

        public int[] ReturnLocation(){
            int[] location = {this.col, this.row};
            return location;
        }

        public String ReturnName(){
            switch(this.type) {
                case 1 :
                    return "Rook";
                case 2 :
                    return "Knight";
                case 3 :
                    return "Bishop";
                case 4 :
                    return "Queen";
                case 5 :
                    return "King";
                case 6 :
                    return "Pawn";
                default :
                    return "NotSet";
            }
        }

        public String ReturnDescription(){
            return ( "'" + ReturnColor() + " " + ReturnName() + "' located in Column : " +  this.col + " , Row : " + this.row + ((this.IsCaptured() == 1) ? " 'Captured'" : " ") );
        }

    }

}
