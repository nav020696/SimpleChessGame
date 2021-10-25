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
        if (toLine > 7 || toLine < 0 || toColumn < 0 || toColumn > 7){
            return false;
        }else if (line == toLine && column == toColumn){
            return false;
        }
        return (line == toLine && (column + 1 == toColumn || column - 1 == toColumn)) ||
                (column == toColumn && (line + 1 == toLine || line - 1 == toLine)) ||
                (Math.abs(toColumn - column) == 1 && Math.abs(toLine - line) == 1);
    }

    @Override
    public String getSymbol() {
        return "K";
    }
    public boolean isUnderAttack(ChessBoard board, int line, int column){
        return false;
    }
}
