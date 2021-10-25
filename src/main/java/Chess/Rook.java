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
        if (toLine > 7 || toLine < 0 || toColumn < 0 || toColumn > 7){
            return false;
        }else if (line == toLine && column == toColumn){
            return false;
        }
        return (line != toLine && column == toColumn) || (line == toLine && column != toColumn);
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}