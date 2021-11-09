package Chess;

public class Queen extends ChessPiece{
    public Queen(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (checkPos(line) && checkPos(column) && checkPos(toLine) && checkPos(toColumn)) {
            if ((chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].color.equals(this.color))
                    && chessBoard.board[line][column] != null) {
                //идем вертикально как ладья
                if (column == toColumn && line != toLine) {
                    if (toLine > line) { //двигаемся вверх
                        for (int i = 1; i < toLine - line; i++) {
                            if (chessBoard.board[line + i][column] != null) {
                                return false;
                            }
                        }
                        return true;
                    } else { //двигаемся вниз
                        for (int i = 1; i < line - toLine; i++) {
                            if (chessBoard.board[line - i][column] != null) {
                                return false;
                            }
                        }
                        return true;
                    }
                    //идем горизонтально как ладья
                } else if (line == toLine && column != toColumn) {
                    if (toColumn > column) { //двигаемся вправо
                        for (int i = 1; i < toColumn - column; i++) {
                            if (chessBoard.board[line][column + i] != null) {
                                return false;
                            }
                        }
                        return true;
                    } else { //двигаемся влево
                        for (int i = 1; i < column - toColumn; i++) {
                            if (chessBoard.board[line][column - i] != null) {
                                return false;
                            }
                        }
                        return true;
                    }
                    //идём по диагоналям как слон
                } else if (line != toLine && column != toColumn && Math.abs(toColumn - column) == Math.abs(toLine - line)){
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
                } else{
                    return false;
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
        return "Q";
    }
}
