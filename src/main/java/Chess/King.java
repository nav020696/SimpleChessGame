package Chess;

public class King extends ChessPiece{
    public King(String color) {
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
                return (line == toLine && (column + 1 == toColumn || column - 1 == toColumn)) ||
                        (column == toColumn && (line + 1 == toLine || line - 1 == toLine)) ||
                        (Math.abs(toColumn - column) == 1 && Math.abs(toLine - line) == 1);
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "K";
    }
    public boolean isUnderAttack(ChessBoard board, int line, int column){
        return false;
    }
}
