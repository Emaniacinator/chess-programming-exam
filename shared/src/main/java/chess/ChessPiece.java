package chess;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Represents a single chess piece
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessPiece {

    private ChessGame.TeamColor pieceColor;
    private ChessPiece.PieceType type;

    public ChessPiece(ChessGame.TeamColor pieceColor, ChessPiece.PieceType type) {

        this.pieceColor = pieceColor;
        this.type = type;

    }


    /**
     * The various different chess piece options
     */
    public enum PieceType {
        KING,
        QUEEN,
        BISHOP,
        KNIGHT,
        ROOK,
        PAWN
    }


    /**
     * @return Which team this chess piece belongs to
     */
    public ChessGame.TeamColor getTeamColor() {

        return pieceColor;

    }


    /**
     * @return which type of chess piece this piece is
     */
    public PieceType getPieceType() {

        return type;

    }


    /**
     * Calculates all the positions a chess piece can move to
     * Does not take into account moves that are illegal due to leaving the king in
     * danger
     *
     * @return Collection of valid moves
     */
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {

        switch (type){

            case KING:
                return kingMoves(board, myPosition);

            case QUEEN:
                return queenMoves(board, myPosition);

            case BISHOP:
                return bishopMoves(board, myPosition);

            case KNIGHT:
                return knightMoves(board, myPosition);

            case ROOK:
                return rookMoves(board, myPosition);

            case PAWN:
                return pawnMoves(board, myPosition);

        }

        return null;

    }


    public Collection<ChessMove> kingMoves(ChessBoard board, ChessPosition myPosition) {

        Collection<ChessMove> possibleMoves = new ArrayList<ChessMove>();

        int currentCol = myPosition.getColumn() + 1;
        int currentRow = myPosition.getRow() + 1;

        ChessPosition up = new ChessPosition(currentRow + 1, currentCol);
        ChessPosition upRight = new ChessPosition(currentRow + 1, currentCol + 1);
        ChessPosition right = new ChessPosition(currentRow, currentCol + 1);
        ChessPosition downRight = new ChessPosition(currentRow - 1, currentCol + 1);
        ChessPosition down = new ChessPosition(currentRow - 1, currentCol);
        ChessPosition downLeft = new ChessPosition(currentRow - 1, currentCol - 1);
        ChessPosition left = new ChessPosition(currentRow, currentCol - 1);
        ChessPosition upLeft = new ChessPosition(currentRow + 1, currentCol - 1);

        if(up.getRow() < 7) {
            if (board.getPiece(up) == null || board.getPiece(up).getTeamColor() != pieceColor) {

                ChessMove upMove = new ChessMove(myPosition, up, null);
                possibleMoves.add(upMove);

            }
        }

        if (upRight.getRow() < 7 && upRight.getColumn() < 7) {
            if (board.getPiece(upRight) == null || board.getPiece(upRight).getTeamColor() != pieceColor) {

                ChessMove upRightMove = new ChessMove(myPosition, upRight, null);
                possibleMoves.add(upRightMove);

            }
        }

        if(right.getRow() < 7) {
            if (board.getPiece(right) == null || board.getPiece(right).getTeamColor() != pieceColor) {

                ChessMove rightMove = new ChessMove(myPosition, right, null);
                possibleMoves.add(rightMove);

            }
        }

        if(downRight.getRow() > 0 && downRight.getColumn() < 7) {
            if (board.getPiece(downRight) == null || board.getPiece(downRight).getTeamColor() != pieceColor) {

                ChessMove downRightMove = new ChessMove(myPosition, downRight, null);
                possibleMoves.add(downRightMove);

            }
        }

        if (down.getRow() > 0) {
            if (board.getPiece(down) == null || board.getPiece(down).getTeamColor() != pieceColor) {

                ChessMove downMove = new ChessMove(myPosition, down, null);
                possibleMoves.add(downMove);

            }
        }

        if (downLeft.getColumn() > 0 && downLeft.getRow() > 0) {
            if (board.getPiece(downLeft) == null || board.getPiece(downLeft).getTeamColor() != pieceColor) {

                ChessMove downLeftMove = new ChessMove(myPosition, downLeft, null);
                possibleMoves.add(downLeftMove);

            }
        }

        if (left.getColumn() > 0){

            if (board.getPiece(left) == null || board.getPiece(left).getTeamColor() != pieceColor) {

                ChessMove leftMove = new ChessMove(myPosition, left, null);
                possibleMoves.add(leftMove);

            }

        }

        if (upLeft.getColumn() > 0 && upLeft.getRow() < 7) {

            if (board.getPiece(upLeft) == null || board.getPiece(upLeft).getTeamColor() != pieceColor) {

                ChessMove upLeftMove = new ChessMove(myPosition, upLeft, null);
                possibleMoves.add(upLeftMove);

            }

        }

        return possibleMoves;

    }


    public Collection<ChessMove> queenMoves(ChessBoard board, ChessPosition myPosition){

        throw new RuntimeException("Not implemented");

    }


    public Collection<ChessMove> bishopMoves(ChessBoard board, ChessPosition myPosition){

        Collection<ChessMove> possibleMoves = new ArrayList<ChessMove>();

        int currentCol = myPosition.getColumn() + 1;
        int currentRow = myPosition.getRow() + 1;

        int newCol = currentCol;
        int newRow = currentRow;

        for (int i = 1; newCol < 7 && newRow < 7; i++){

            newCol = currentCol + i;
            newRow = currentRow + i;

            ChessPosition upRightPosition = new ChessPosition(newRow, newCol);

            if (board.getPiece(upRightPosition) == null || board.getPiece(upRightPosition).getTeamColor() != pieceColor){

                ChessMove upRightMove = new ChessMove(myPosition, upRightPosition, null);
                possibleMoves.add(upRightMove);

                if (board.getPiece(upRightPosition) != null && board.getPiece(upRightPosition).getTeamColor() != pieceColor){

                    break;

                }

            }

        }

        newCol = currentCol;
        newRow = currentRow;

        for (int i = 1; newCol > 0 && newRow < 7; i++){

            newCol = currentCol - i;
            newRow = currentRow + i;

            ChessPosition upLeftPosition = new ChessPosition(newRow, newCol);

            if (board.getPiece(upLeftPosition) == null || board.getPiece(upLeftPosition).getTeamColor() != pieceColor){

                ChessMove upLeftMove = new ChessMove(myPosition, upLeftPosition, null);
                possibleMoves.add(upLeftMove);

                if (board.getPiece(upLeftPosition) != null && board.getPiece(upLeftPosition).getTeamColor() != pieceColor){

                    break;

                }

            }

        }

        newCol = currentCol;
        newRow = currentRow;

        for (int i = 1; newCol < 7 && newRow > 0; i++){

            newCol = currentCol + i;
            newRow = currentRow + i;

            ChessPosition downRightPosition = new ChessPosition(newRow, newCol);

            if (board.getPiece(downRightPosition) == null || board.getPiece(downRightPosition).getTeamColor() != pieceColor){

                ChessMove downRightMove = new ChessMove(myPosition, downRightPosition, null);
                possibleMoves.add(downRightMove);

                if (board.getPiece(downRightPosition) != null && board.getPiece(downRightPosition).getTeamColor() != pieceColor){

                    break;

                }

            }

        }

        newCol = currentCol;
        newRow = currentRow;

        for (int i = 1; newCol > 1 && newRow > 1; i++){

            newCol = currentCol - i;
            newRow = currentRow - i;

            ChessPosition downLeftPosition = new ChessPosition(newRow, newCol);

            if (board.getPiece(downLeftPosition) == null || board.getPiece(downLeftPosition).getTeamColor() != pieceColor){

                ChessMove downLeftMove = new ChessMove(myPosition, downLeftPosition, null);
                possibleMoves.add(downLeftMove);

                if (board.getPiece(downLeftPosition) != null && board.getPiece(downLeftPosition).getTeamColor() != pieceColor){

                    break;

                }

            }

        }

        return possibleMoves;

    }


    public Collection<ChessMove> knightMoves(ChessBoard board, ChessPosition myPosition){

        throw new RuntimeException("Not implemented");

    }


    public Collection<ChessMove> rookMoves(ChessBoard board, ChessPosition myPosition){

        throw new RuntimeException("Not implemented");

    }


    public Collection<ChessMove> pawnMoves(ChessBoard board, ChessPosition myPosition){

        throw new RuntimeException("Not implemented");

    }

    @Override
    public int hashCode() {

        int typeHashing = 1;

        switch (type){

            case KING:
                typeHashing = 2;
                break;

            case QUEEN:
                typeHashing = 3;
                break;

            case BISHOP:
                typeHashing = 4;
                break;

            case KNIGHT:
                typeHashing = 5;
                break;

            case ROOK:
                typeHashing = 6;
                break;

            case PAWN:
                typeHashing = 7;
                break;

        }

        int colorHashing;

        if (pieceColor == ChessGame.TeamColor.WHITE){

            colorHashing = 7;

        }

        else{

            colorHashing = 13;

        }

        return typeHashing * colorHashing; // This may need to be updated with further variables.

    }


    @Override
    public boolean equals(Object obj) {

        if (obj.getClass() == this.getClass()){

            ChessPiece typeCastObject = (ChessPiece)obj;

            return typeCastObject.getTeamColor() == pieceColor && typeCastObject.getPieceType() == type;

        }

        return false;

    }


    @Override
    public String toString(){

        String pieceRepresentation;

        switch (type){

            case KING:

                if (pieceColor == ChessGame.TeamColor.WHITE){

                    return "K";

                }

                else {

                    return "k";

                }

            case QUEEN:

                if (pieceColor == ChessGame.TeamColor.WHITE){

                    return "Q";

                }

                else {

                    return "q";

                }

            case BISHOP:

                if (pieceColor == ChessGame.TeamColor.WHITE){

                    return "B";

                }

                else {

                    return "b";

                }

            case KNIGHT:

                if (pieceColor == ChessGame.TeamColor.WHITE){

                    return "N";

                }

                else {

                    return "n";

                }

            case ROOK:

                if (pieceColor == ChessGame.TeamColor.WHITE){

                    return "R";

                }

                else {

                    return "r";

                }

            case PAWN:

                if (pieceColor == ChessGame.TeamColor.WHITE){

                    return "P";

                }

                else {

                    return "p";

                }

            default:
                return " ";

        }

    }

}
