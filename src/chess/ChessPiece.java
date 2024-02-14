package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

/**
 * Abstract class representing a chess piece.
 */
public abstract class ChessPiece extends Piece {

    private Color color;
    private int moveCount;

    /**
     * Constructor for the ChessPiece class.
     * @param board The board where the chess piece will be placed
     * @param color The color of the chess piece (Black or White)
     */
    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public int getMoveCount(){
        return moveCount;
    }

    public void increaseMoveCount(){
        moveCount++;
    }

    public void decreaseMoveCount(){
        moveCount--;
    }

    public ChessPosition getChessPosition(){
        return ChessPosition.fromPosition(position);
    }

    /**
     * Checks if there is an opponent piece at the specified position.
     * @param position The position to be checked
     * @return true if there is an opponent piece at the specified position, false otherwise
     */
    protected boolean isThereOpponentPiece(Position position){
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p != null && p.getColor() != color;
    }

}