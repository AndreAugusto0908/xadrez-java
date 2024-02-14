package chess;

import boardgame.Position;

/**
 * Represents a position on a chess board using chess notation.
 */
public class ChessPosition {

    private char column;
    private int row;

    /**
     * Constructor for the ChessPosition class.
     * @param column The column of the chess position (from 'a' to 'h')
     * @param row The row of the chess position (from 1 to 8)
     * @throws ChessException if the specified column or row is invalid
     */
    public ChessPosition(char column, int row) {
        if (column < 'a' || column > 'h' || row < 1 || row > 8) {
            throw new ChessException("Error instantiating ChessPosition. Valid values are from a1 to h8");
        }
        this.column = column;
        this.row = row;
    }

    /**
     * Converts a standard Position object used in the board to a ChessPosition object.
     * @param position The Position object to be converted
     * @return The ChessPosition object corresponding to the Position object
     */
    protected Position toPosition() {
        return new Position(8 - row, column - 'a');
    }

    protected static ChessPosition fromPosition(Position position) {
        return new ChessPosition((char) ('a' + position.getColumn()), 8 - position.getRow());
    }

    /**
     * Returns a string representation of the chess position.
     * @return A string representing the chess position in the format "column + row"
     */
    @Override
    public String toString() {
        return "" + column + row;
    }

}
