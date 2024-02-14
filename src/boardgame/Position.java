package boardgame;

/**
 * Class representing a position on a board.
 */
public class Position {
    private int row;
    private int column;

    /**
     * Constructor for the Position class.
     * @param row The row of the position
     * @param column The column of the position
     */
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }

    public void setRow(int row){
        this.row = row;
    }

    public void setColumn(int column){
        this.column = column;
    }

    public void changePosition(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public void setValues(int row, int column){
        this.row = row;
        this.column = column;
    }

    @Override
    public String toString() {
        return row + ", " + column;
    }
}
