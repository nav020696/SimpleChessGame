package Chess;

public class Horse extends ChessPiece {

    public Horse(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (checkPos(line) && checkPos(column) && checkPos(toLine) && checkPos(toColumn)) {
            if (line != toLine && column != toColumn &&
                    (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].color.equals(this.color))
                    && chessBoard.board[line][column] != null) {
                if (line + 2 == toLine && (column + 1 == toColumn || column - 1 == toColumn)) {
                    return true;
                } else if (line - 2 == toLine && (column + 1 == toColumn || column - 1 == toColumn)) {
                    return true;
                } else if (line + 1 == toLine && (column + 2 == toColumn || column - 2 == toColumn)) {
                    return true;
                } else return line - 1 == toLine && (column + 2 == toColumn || column - 2 == toColumn);
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}
