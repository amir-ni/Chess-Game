package Chess.Models;

import Chess.Models.Piece;

public class Cell{

    private Piece CurrentPiece = null;

    public void setPiece(Piece NewPiece){
        this.CurrentPiece = NewPiece;
    }

    public void remvoePiece(){
        this.CurrentPiece = null;
    }

    public Piece returnPiece(){
        return this.CurrentPiece;
    }

}