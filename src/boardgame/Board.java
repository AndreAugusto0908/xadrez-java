package boardgame;

public class Board {

    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns) {
        if (rows < 1 || columns < 1) {
            throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
        } else {
            this.rows = rows;
            this.columns = columns;
            pieces = new Piece[rows][columns];
        }
    }

    public int getRows() {
        return rows;
    }

    public int getColumn() {
        return columns;
    }

    /**
     * Get the piece at a specified position on the board.
     * 
     * @param row    The row of the position
     * @param column The column of the position
     * @return The piece at the specified position
     * @throws BoardException If the position is not on the board
     */
    public Piece piece(int row, int column) {
        if (!positionExists(row, column)) {
            throw new BoardException("Position not on the board");
        }
        return pieces[row][column];
    }

    /**
     * Get the piece at a specified position on the board.
     * 
     * @param position The position on the board
     * @return The piece at the specified position
     * @throws BoardException If the position is not on the board
     */
    public Piece piece(Position position) {
        if (!positionExists(position)) {
            throw new BoardException("Position not on the board");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    /**
     * Place a piece at a specified position on the board.
     * 
     * @param piece    The piece to be placed
     * @param position The position where the piece will be placed
     * @throws BoardException If the position is occupied or not on the board
     */
    public void placePiece(Piece piece, Position position) {
        if (thereIsAPiece(position)) {
            throw new BoardException("The position is occupied " + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    /**
     * Check if a position is within the board's limits.
     * 
     * @param row    The row of the position
     * @param column The column of the position
     * @return true if the position is within the board's limits, false otherwise
     */
    private boolean positionExists(int row, int column) {
        return (row >= 0) && (row < rows) && (column >= 0) && (column < columns);
    }

    /**
     * Check if a position is within the board's limits.
     * 
     * @param position The position to be checked
     * @return true if the position is within the board's limits, false otherwise
     */
    public boolean positionExists(Position position) {
        return positionExists(position.getRow(), position.getColumn());
    }

    /**
     * Check if there is a piece at a specified position on the board.
     * 
     * @param position The position to be checked
     * @return true if there is a piece at the specified position, false otherwise
     * @throws BoardException If the position is not on the board
     */
    public boolean thereIsAPiece(Position position) {
        if (!positionExists(position)) {
            throw new BoardException("Position not on the board");
        }
        return piece(position) != null;
    }

    /**
     * Remove a piece from a specified position on the board.
     * 
     * @param position The position of the piece to be removed
     * @return The removed piece, or null if there is no piece at the specified
     *         position
     * @throws BoardException If the position is not on the board
     */
    public Piece removePiece(Position position) {
        if (!positionExists(position)) {
            throw new BoardException("Position not on the board");
        }
        if (piece(position) == null) {
            return null;
        }

        Piece aux = piece(position);
        aux.position = null;
        pieces[position.getRow()][position.getColumn()] = null;
        return aux;
    }

}
