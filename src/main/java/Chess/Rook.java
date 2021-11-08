package Chess;

public class Rook extends ChessPiece
{
    public Rook(String color) {
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
                return (line != toLine && column == toColumn) || (line == toLine && column != toColumn);
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}
