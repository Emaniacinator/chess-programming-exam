package chess;

/**
 * Represents a single square position on a chess board
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessPosition {

    private int row;
    private int col;

    public ChessPosition(int row, int col) {

        this.row = row;
        this.col = col;

    }


    /**
     * @return which row this position is in
     * 1 codes for the bottom row
     */
    public int getRow() {

        return row - 1;

    }


    /**
     * @return which column this position is in
     * 1 codes for the left row
     */
    public int getColumn() {

        return col - 1;

    }


    @Override
    public String toString() {

        String thingToReturn = "";

        switch(col - 1) {

            case 0:
                thingToReturn = thingToReturn + "A";
                break;

            case 1:
                thingToReturn = thingToReturn + "B";
                break;

            case 2:
                thingToReturn = thingToReturn + "C";
                break;

            case 3:
                thingToReturn = thingToReturn + "D";
                break;

            case 4:
                thingToReturn = thingToReturn + "E";
                break;

            case 5:
                thingToReturn = thingToReturn + "F";
                break;

            case 6:
                thingToReturn = thingToReturn + "G";
                break;

            case 7:
                thingToReturn = thingToReturn + "H";
                break;

        }

        switch(row - 1) {

            case 0:
                thingToReturn = thingToReturn + ", 1 \n";
                break;

            case 1:
                thingToReturn = thingToReturn + ", 2 \n";
                break;

            case 2:
                thingToReturn = thingToReturn + ", 3 \n";
                break;

            case 3:
                thingToReturn = thingToReturn + ", 4 \n";
                break;

            case 4:
                thingToReturn = thingToReturn + ", 5 \n";
                break;

            case 5:
                thingToReturn = thingToReturn + ", 6 \n";
                break;

            case 6:
                thingToReturn = thingToReturn + ", 7 \n";
                break;

            case 7:
                thingToReturn = thingToReturn + ", 8 \n";
                break;

        }

        return thingToReturn;

    }


    @Override
    public boolean equals(Object obj) {

        if (obj.getClass() == this.getClass()){

            ChessPosition typeCastObject = (ChessPosition)obj;

            int rowCheck = typeCastObject.getRow() + 1;
            int colCheck = typeCastObject.getColumn() + 1;

            return rowCheck == row && colCheck == col;

        }

        return false;

    }


    @Override
    public int hashCode() {

        int rowHash;

        switch(row) {

            case 0:
                rowHash = 1;
                break;

            case 1:
                rowHash = 2;
                break;

            case 2:
                rowHash = 3;
                break;

            case 3:
                rowHash = 4;
                break;

            case 4:
                rowHash = 5;
                break;

            case 5:
                rowHash = 6;
                break;

            case 6:
                rowHash = 7;
                break;

            case 7:
                rowHash = 8;
                break;

            default:
                rowHash = 1;
                break;

        }

        int colHash;

        switch (col){

            case 0:
                colHash = 3;
                break;

            case 1:
                colHash = 5;
                break;

            case 2:
                colHash = 7;
                break;

            case 3:
                colHash = 9;
                break;

            case 4:
                colHash = 11;
                break;

            case 5:
                colHash = 13;
                break;

            case 6:
                colHash = 17;
                break;

            case 7:
                colHash = 19;
                break;

            default:
                colHash = 23;
                break;

            }

            return rowHash * colHash;

    }
}
