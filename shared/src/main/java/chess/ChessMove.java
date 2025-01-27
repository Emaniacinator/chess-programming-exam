package chess;

import java.util.Objects;

/**
 * Represents moving a chess piece on a chessboard
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessMove {

    private ChessPosition startPosition;
    private ChessPosition endPosition;
    private ChessPiece.PieceType promotionPiece;

    public ChessMove(ChessPosition startPosition, ChessPosition endPosition,
                     ChessPiece.PieceType promotionPiece) {

        this.startPosition = startPosition;
        this.endPosition = endPosition;
        this.promotionPiece = promotionPiece;

    }


    /**
     * @return ChessPosition of starting location
     */
    public ChessPosition getStartPosition() {

        return startPosition;

    }


    /**
     * @return ChessPosition of ending location
     */
    public ChessPosition getEndPosition() {

        return endPosition;

    }


    /**
     * Gets the type of piece to promote a pawn to if pawn promotion is part of this
     * chess move
     *
     * @return Type of piece to promote a pawn to, or null if no promotion
     */
    public ChessPiece.PieceType getPromotionPiece() {

        return promotionPiece;

    }


    @Override
    public int hashCode() {

        if (promotionPiece == null){

            return startPosition.hashCode() * endPosition.hashCode() * 13;

        }

        else {

            return startPosition.hashCode() * endPosition.hashCode() * promotionPiece.hashCode();

        }

    }


    @Override
    public boolean equals(Object obj) { // I'm not sure why this isn't returning true sometimes


        if (obj.getClass() == this.getClass()){

            ChessMove typeCastObject = (ChessMove)obj;

            return Objects.equals(typeCastObject.toString(), this.toString());

        }

        return false;

    }


    @Override
    public String toString() {

        if (promotionPiece == null){

            return "Start Position: " + startPosition.toString() + "    End Position: " + endPosition.toString() + "    Promote To: No Promotion";

        }

        else {

            return "Start Position: " + startPosition.toString() + "    End Position: " + endPosition.toString() + "    Promote To: " + promotionPiece.toString();

        }
    }
}
