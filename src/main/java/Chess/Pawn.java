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
        if (checkPos(line) && checkPos(column) && checkPos(toLine) && checkPos(toColumn) && chessBoard.board[line][column] != null) {
            if (column == toColumn) {
                if (color.equals("White") && line == 1) {
                    return (line + 1 == toLine || (line + 2 == toLine && chessBoard.board[line + 1][column] == null))
                            && chessBoard.board[toLine][toColumn] == null;
                } else if (color.equals("Black") && line == 6) {
                    return (line - 1 == toLine || (line - 2 == toLine && chessBoard.board[line - 1][column] == null))
                            && chessBoard.board[toLine][toColumn] == null;
                } else if (color.equals("White")) {
                    return line + 1 == toLine && chessBoard.board[toLine][toColumn] == null;
                } else if (color.equals("Black")) {
                    return line - 1 == toLine && chessBoard.board[toLine][toColumn] == null;
                }
            } else {
                if (chessBoard.board[toLine][toColumn] != null && !chessBoard.board[toLine][toColumn].color.equals(this.color)) {
                    if (color.equals("White")) {
                        return line + 1 == toLine && (column + 1 == toColumn || column - 1 == toColumn);
                    } else if (color.equals("Black")) {
                        return line - 1 == toLine && (column + 1 == toColumn || column - 1 == toColumn);
                    }
                }
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
