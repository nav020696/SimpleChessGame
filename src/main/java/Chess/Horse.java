package Chess;

public class Horse extends ChessPiece{

    public Horse(String color) {
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
        if (line + 2 == toLine && (column + 1 == toColumn || column -1 == toColumn)){
            return true;
        }else if (line - 2 == toLine && (column + 1 == toColumn || column -1 == toColumn)){
            return true;
        } else if (line + 1 == toLine && (column + 2 == toColumn || column - 2 == toColumn)){
            return true;
        } else return line - 1 == toLine && (column + 2 == toColumn || column - 2 == toColumn);
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}
