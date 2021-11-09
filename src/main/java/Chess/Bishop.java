package Chess;

public class Bishop extends ChessPiece {
    public Bishop(String color) {
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
                    && chessBoard.board[line][column] != null && Math.abs(toColumn - column) == Math.abs(toLine - line)) {
                //проверяем, что по пути никого нет
                if (toLine - line > 0 && toColumn - column > 0) { //двигаемся вправо вверх
                    for (int i = 1; i < toLine - line; i++) {
                        if (chessBoard.board[line + i][column + i] != null) {
                            return false;
                        }
                    }
                    return true;
                } else if (toLine - line > 0 && toColumn - column < 0) { //двигаемся влево вверх
                    for (int i = 1; i < toLine - line; i++) {
                        if (chessBoard.board[line + i][column - i] != null) {
                            return false;
                        }
                    }
                    return true;
                } else if (toLine - line < 0 && toColumn - column < 0) { //двигаемся влево вниз
                    for (int i = 1; i < line - toLine; i++) {
                        if (chessBoard.board[line - i][column - i] != null) {
                            return false;
                        }
                    }
                    return true;
                } else if (toLine - line < 0 && toColumn - column > 0) { //двигаемся вправо вниз
                    for (int i = 1; i < line - toLine; i++) {
                        if (chessBoard.board[line - i][column + i] != null) {
                            return false;
                        }
                    }
                    return true;
                } else {
                    return true;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}
