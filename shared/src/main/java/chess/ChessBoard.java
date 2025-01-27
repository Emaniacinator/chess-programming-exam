package chess;

import java.util.*;
import chess.ChessPiece;

import static chess.ChessGame.TeamColor.*;

/**
 * A chessboard that can hold and rearrange chess pieces.
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessBoard {

    public ChessPiece[][] currentBoard = new ChessPiece[8][8]; // Come back to this in a minute when you're less panicked.


    public ChessBoard() {
        
    }


    /**
     * Adds a chess piece to the chessboard
     *
     * @param position where to add the piece to
     * @param piece    the piece to add
     */
    public void addPiece(ChessPosition position, ChessPiece piece) {

        int currentCol = position.getColumn();
        int currentRow = position.getRow();

        currentBoard[currentRow][currentCol] = piece; // make sure that this isn't accidentally backwards.

    }


    /**
     * Gets a chess piece on the chessboard
     *
     * @param position The position to get the piece from
     * @return Either the piece at the position, or null if no piece is at that
     * position
     */
    public ChessPiece getPiece(ChessPosition position) {

        int getCol = position.getColumn();
        int getRow = position.getRow();

        return currentBoard[getRow][getCol];


    }


    /**
     * Sets the board to the default starting board
     * (How the game of chess normally starts)
     */
    public void resetBoard() { // Something here is causing an indexOutOfBounds error

        currentBoard = new ChessPiece[8][8];

        for(int i = 1; i <= 8 ; i++){ // gets row positions to set

            for (int j = 1; j <= 8; j++){ // gets column positions to set

                ChessPosition positionToAdd = new ChessPosition(i, j);

                switch (i){ // looking to see if it's in the initial heights that need pieces

                    case 1: // black, since black is bottom
                        ChessGame.TeamColor blackColor = WHITE;

                        switch(j){

                            case 1: // Both of these are rooks
                            case 8:

                                ChessPiece blackRook = new ChessPiece(blackColor, ChessPiece.PieceType.ROOK);
                                addPiece(positionToAdd, blackRook);
                                break;

                            case 2: // Both of these are knights
                            case 7:

                                ChessPiece blackKnight = new ChessPiece(blackColor, ChessPiece.PieceType.KNIGHT);
                                addPiece(positionToAdd, blackKnight);
                                break;

                            case 3: // Both of these are bishops
                            case 6:

                                ChessPiece blackBishop = new ChessPiece(blackColor, ChessPiece.PieceType.BISHOP);
                                addPiece(positionToAdd, blackBishop);
                                break;

                            case 4: // I think this is a queen

                                ChessPiece blackQueen = new ChessPiece(blackColor, ChessPiece.PieceType.QUEEN);
                                addPiece(positionToAdd, blackQueen);
                                break;

                            case 5: // I think this is a king

                                ChessPiece blackKing = new ChessPiece(blackColor, ChessPiece.PieceType.KING);
                                addPiece(positionToAdd, blackKing);
                                break;

                        }

                        break;

                    case 2:
                        ChessGame.TeamColor blackPawnColor = WHITE;
                        ChessPiece blackPawn = new ChessPiece(blackPawnColor, ChessPiece.PieceType.PAWN);
                        addPiece(positionToAdd, blackPawn);
                        break;

                    case 7: // white, since white is top
                        ChessGame.TeamColor whitePawnColor = BLACK;
                        ChessPiece whitePawn = new ChessPiece(whitePawnColor, ChessPiece.PieceType.PAWN);
                        addPiece(positionToAdd, whitePawn);
                        break;

                    case 8:
                        ChessGame.TeamColor whiteColor = BLACK;

                        switch(j){

                            case 1: // Both of these are rooks
                            case 8:

                                ChessPiece whiteRook = new ChessPiece(whiteColor, ChessPiece.PieceType.ROOK);
                                addPiece(positionToAdd, whiteRook);
                                break;

                            case 2: // Both of these are knights
                            case 7:

                                ChessPiece whiteKnight = new ChessPiece(whiteColor, ChessPiece.PieceType.KNIGHT);
                                addPiece(positionToAdd, whiteKnight);
                                break;

                            case 3: // Both of these are bishops
                            case 6:

                                ChessPiece whiteBishop = new ChessPiece(whiteColor, ChessPiece.PieceType.BISHOP);
                                addPiece(positionToAdd, whiteBishop);
                                break;

                            case 4: // I think this is a queen

                                ChessPiece whiteQueen = new ChessPiece(whiteColor, ChessPiece.PieceType.QUEEN);
                                addPiece(positionToAdd, whiteQueen);
                                break;

                            case 5: // I think this is a king

                                ChessPiece whiteKing = new ChessPiece(whiteColor, ChessPiece.PieceType.KING);
                                addPiece(positionToAdd, whiteKing);
                                break;

                        }

                        break;

                }

            }

        }

    }


    @Override
    public boolean equals(Object obj) {

        if (obj.getClass() == this.getClass()) {

            ChessBoard typeCastBoard = (ChessBoard) obj;

            String typeCastString = typeCastBoard.toString();
            String originalString = this.toString();

            return typeCastString.equals(originalString);

        }

        return false;

        }



    @Override
    public String toString() {

        String boardStringOutput = "";

        for(int i = 8; i >= 1 ; i--){ // gets row positions to set

            boardStringOutput = boardStringOutput + "|";

            for (int j = 1; j <= 8; j++){ // gets column positions to set

                ChessPosition currentPosition = new ChessPosition(j, i);
                ChessPiece currentPiece = this.getPiece(currentPosition);
                if (currentPiece != null) {


                    ChessPiece.PieceType currentPieceType = currentPiece.getPieceType();

                    switch (currentPieceType) {

                        case KING:

                            if (currentPiece.getTeamColor() == WHITE) {

                                boardStringOutput = boardStringOutput + "K|";

                            } else {

                                boardStringOutput = boardStringOutput + "k|";

                            }

                            break;

                        case QUEEN:

                            if (currentPiece.getTeamColor() == WHITE) {

                                boardStringOutput = boardStringOutput + "Q|";

                            } else {

                                boardStringOutput = boardStringOutput + "q|";

                            }

                            break;

                        case BISHOP:

                            if (currentPiece.getTeamColor() == WHITE) {

                                boardStringOutput = boardStringOutput + "B|";

                            } else {

                                boardStringOutput = boardStringOutput + "b|";

                            }

                            break;

                        case KNIGHT:

                            if (currentPiece.getTeamColor() == WHITE) {

                                boardStringOutput = boardStringOutput + "N|";

                            } else {

                                boardStringOutput = boardStringOutput + "n|";

                            }

                            break;

                        case ROOK:

                            if (currentPiece.getTeamColor() == WHITE) {

                                boardStringOutput = boardStringOutput + "R|";

                            } else {

                                boardStringOutput = boardStringOutput + "r|";

                            }

                            break;

                        case PAWN:

                            if (currentPiece.getTeamColor() == WHITE) {

                                boardStringOutput = boardStringOutput + "P|";

                            } else {

                                boardStringOutput = boardStringOutput + "p|";

                            }

                            break;

                        default:

                            boardStringOutput = boardStringOutput + " |";
                            break;

                    }

                }

                else{

                    boardStringOutput = boardStringOutput + " |";

                }

            }

            boardStringOutput = boardStringOutput + "\n";

        }

        return boardStringOutput;

    }

}
