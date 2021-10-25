package Chess;

public class Pawn extends ChessPiece {

    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toLine > 7 || toLine < 0 || toColumn < 0 || toColumn > 7) {
            return false;
        } else if (line == toLine && column == toColumn) {
            return false;
        }
        if (color.equals("White") && line == 1) {
            return (line + 1 == toLine || line + 2 == toLine) && column == toColumn;
        }
        if (color.equals("Black") && line == 6) {
            return (line - 1 == toLine || line - 2 == toLine) && column == toColumn;
        }
        if (color.equals("White") && line + 1 == toLine && column == toColumn) {
            return true;
        } else return color.equals("Black") && line - 1 == toLine && column == toColumn;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
