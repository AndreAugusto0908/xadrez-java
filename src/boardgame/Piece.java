package boardgame;

public abstract class Piece {

    protected Position position;
    private Board board;

    public Piece(Board board) {
        this.board = board;
    }

    public Board getBoard(){
        return board;
    }

    /**
     * Returns a matrix representing the possible movements of the piece.
     * @return A boolean matrix where true indicates a possible movement and false indicates an impossible movement.
     */
    public abstract boolean[][] possibleMovies();

    /**
     * Checks if there is a possible move for the piece at a specific position.
     * @param position The position to be checked
     * @return true if there is a possible move at the specified position, false otherwise
     */
    public boolean possibleMovie(Position position) {
        return possibleMovies()[position.getRow()][position.getColumn()];
    }

    /**
     * Checks if there is any possible move for the piece.
     * @return true if there is at least one possible move, false otherwise
     */
    public boolean isThereAnyPossibleMove() {
        boolean[][] mat = possibleMovies();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if (mat[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
