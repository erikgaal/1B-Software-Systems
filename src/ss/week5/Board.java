package ss.week5;

/**
 * Game student for the Tic Tac Toe game. Module 2 lab assignment.
 *
 * @author Theo Ruys en Arend Rensink
 * @version $Revision: 1.4 $
 */
public class Board {

    // -- Constants --------------------------------------------------

    public static final int DIM = 3;
    private static final String[] NUMBERING = {" 0 | 1 | 2 ", "---+---+---",
            " 3 | 4 | 5 ", "---+---+---", " 6 | 7 | 8 "};
    private static final String LINE = NUMBERING[1];
    private static final String DELIM = "     ";

    // -- Instance variables -----------------------------------------

    /*@
       private invariant fields.length == DIM*DIM;
       invariant (\forall int i; 0 <= i & i < DIM*DIM;
           getField(i) == Mark.EMPTY || getField(i) == Mark.XX || getField(i) == Mark.OO);
     */
    /**
     * The DIM by DIM fields of the Tic Tac Toe student. See NUMBERING for the
     * coding of the fields.
     */
    private Mark[] fields;

    // -- Constructors -----------------------------------------------

    /*@
       ensures (\forall int i; 0 <= i & i < DIM * DIM; this.getField(i) == Mark.EMPTY);
     */

    /**
     * Creates an empty student.
     * M = 2
     */
    public Board() {
        fields = new Mark[DIM*DIM];
        for (int i = 0; i < DIM * DIM; i++) {
            setField(i, Mark.EMPTY);
        }
    }

    // -- Queries ----------------------------------------------------

    /*@
       ensures \result != this;
       ensures (\forall int i; 0 <= i & i < DIM * DIM; \result.getField(i) == this.getField(i));
     */

    /**
     * Creates a deep copy of this field.
     * M = 2
     */
    public Board deepCopy() {
        Board result = new Board();
        for (int i = 0; i < DIM * DIM; i++) {
            result.setField(i, this.getField(i));
        }
        return result;
    }


    /*@
       requires 0 <= row & row < DIM;
       requires 0 <= col & col < DIM;
     */

    /**
     * Calculates the index in the linear array of fields from a (row, col)
     * pair.
     * M = 1
     *
     * @return the index belonging to the (row,col)-field
     */
    public int index(int row, int col) {
        return row * DIM + col;
    }


    /*@
       ensures \result == (0 <= ix && ix < DIM * DIM);
     */

    /**
     * Returns true if <code>ix</code> is a valid index of a field on tbe student.
     * M = 1
     *
     * @return <code>true</code> if <code>0 <= ix < DIM*DIM</code>
     */
    /*@pure*/
    public boolean isField(int ix) {
        return 0 <= ix && ix < DIM * DIM;
    }

    /*@
       ensures \result == (0 <= row && row < DIM && 0 <= col && col < DIM);
     */

    /**
     * Returns true of the (row,col) pair refers to a valid field on the student.
     * M = 1
     *
     * @return true if <code>0 <= row < DIM && 0 <= col < DIM</code>
     */
    /*@pure*/
    public boolean isField(int row, int col) {
        return isField(index(row, col));
    }


    /*@
       requires this.isField(i);
       ensures \result == Mark.EMPTY || \result == Mark.XX || \result == Mark.OO;
     */

    /**
     * Returns the content of the field <code>i</code>.
     * M = 1
     *
     * @param i the number of the field (see NUMBERING)
     * @return the mark on the field
     */
    public Mark getField(int i) {
        return fields[i];
    }

    /*@
       requires this.isField(row,col);
       ensures \result == Mark.EMPTY || \result == Mark.XX || \result == Mark.OO;
     */

    /**
     * Returns the content of the field referred to by the (row,col) pair.
     * M = 1
     *
     * @param row the row of the field
     * @param col the column of the field
     * @return the mark on the field
     */
    public Mark getField(int row, int col) {
        return getField(index(row, col));
    }

    /*@
       requires this.isField(i);
       ensures \result == (this.getField(i) == Mark.EMPTY);
     */

    /**
     * Returns true if the field <code>i</code> is empty.
     * M = 1
     *
     * @param i the index of the field (see NUMBERING)
     * @return true if the field is empty
     */
    public boolean isEmptyField(int i) {
        return getField(i) == Mark.EMPTY;
    }

    /*@
       requires this.isField(row,col);
       ensures \result == (this.getField(row,col) == Mark.EMPTY);

     */

    /**
     * Returns true if the field referred to by the (row,col) pair it empty.
     * M = 1
     *
     * @param row the row of the field
     * @param col the column of the field
     * @return true if the field is empty
     */
    /*@pure*/
    public boolean isEmptyField(int row, int col) {
        return getField(index(row, col)) == Mark.EMPTY;
    }

    /*@
       ensures \result == (\forall int i; i <= 0 & i < DIM * DIM; this.getField(i) != Mark.EMPTY);
     */

    /**
     * Tests if the whole student is full.
     * M = 3
     *
     * @return true if all fields are occupied
     */
    /*@pure*/
    public boolean isFull() {
        for (int i = 0; i < DIM * DIM; i++) {
            if (isEmptyField(i)) {
                return false;
            }
        }
        return true;
    }

    /*@
       ensures \result == this.isFull() || this.hasWinner();

     */

    /**
     * Returns true if the game is over. The game is over when there is a winner
     * or the whole student is full.
     * M = 1
     *
     * @return true if the game is over
     */
    /*@pure*/
    public boolean gameOver() {
        return isFull() || hasWinner();
    }

    /**
     * Checks whether there is a row which is full and only contains the mark
     * <code>m</code>.
     * M = 5
     *
     * @param m the mark of interest
     * @return true if there is a row controlled by <code>m</code>
     */
    public boolean hasRow(Mark m) {
        for (int i = 0; i < DIM; i++) {
            int count = 0;
            for (int j = 0; j < DIM; j++) {
                if (getField(i, j) == m) count++;
            }
            if (count >= 3) return true;
        }
        return false;
    }

    /**
     * Checks whether there is a column which is full and only contains the mark
     * <code>m</code>.
     * M = 5
     *
     * @param m the mark of interest
     * @return true if there is a column controlled by <code>m</code>
     */
    public boolean hasColumn(Mark m) {
        for (int i = 0; i < DIM; i++) {
            int count = 0;
            for (int j = 0; j < DIM; j++) {
                if (getField(j, i) == m) count++;
            }
            if (count >= 3) return true;
        }
        return false;
    }

    /**
     * Checks whether there is a diagonal which is full and only contains the
     * mark <code>m</code>.
     * M = 7
     *
     * @param m the mark of interest
     * @return true if there is a diagonal controlled by <code>m</code>
     */
    public boolean hasDiagonal(Mark m) {
        int count = 0;
        for (int j = 0; j < DIM; j++) {
            if (getField(j, j) == m) count++;
        }
        if (count >= 3) return true;

        count = 0;
        for (int j = 0; j < DIM; j++) {
            if (getField(j, DIM - 1 - j) == m) count++;
        }
        if (count >= 3) return true;

        return false;
    }

    /*@
       requires m == Mark.XX | m == Mark.OO;
       ensures \result == this.hasRow(m) ||
                                this.hasColumn(m) |
                                this.hasDiagonal(m);
     */

    /**
     * Checks if the mark <code>m</code> has won. A mark wins if it controls at
     * least one row, column or diagonal.
     * M = 1
     *
     * @param m the mark of interest
     * @return true if the mark has won
     */
    /*@pure*/
    public boolean isWinner(Mark m) {
        return hasColumn(m) || hasRow(m) || hasDiagonal(m);
    }

    /*@
       ensures \result == isWinner(Mark.XX) | \result == isWinner(Mark.OO);

     */

    /**
     * Returns true if the game has a winner. This is the case when one of the
     * marks controls at least one row, column or diagonal.
     * M = 1
     *
     * @return true if the student has a winner.
     */
    /*@pure*/
    public boolean hasWinner() {
        return isWinner(Mark.XX) || isWinner(Mark.OO);
    }

    /**
     * Returns a String representation of this student. In addition to the current
     * situation, the String also shows the numbering of the fields.
     * M = 5
     *
     * @return the game situation as String
     */
    public String toString() {
        String s = "";
        for (int i = 0; i < DIM; i++) {
            String row = "";
            for (int j = 0; j < DIM; j++) {
                row = row + " " + getField(i, j).toString() + " ";
                if (j < DIM - 1) {
                    row = row + "|";
                }
            }
            s = s + row + DELIM + NUMBERING[i * 2];
            if (i < DIM - 1) {
                s = s + "\n" + LINE + DELIM + NUMBERING[i * 2 + 1] + "\n";
            }
        }
        return s;
    }

    // -- Commands ---------------------------------------------------

    /*@
       ensures (\forall int i; 0 <= i & i < DIM * DIM; this.getField(i) == Mark.EMPTY);
     */

    /**
     * Empties all fields of this student (i.e., let them refer to the value
     * Mark.EMPTY).
     * M = 2
     */
    public void reset() {
        for (int i = 0; i < DIM * DIM; i++) {
            setField(i, Mark.EMPTY);
        }
    }

    /*@
       requires this.isField(i);
       ensures this.getField(i) == m;
     */

    /**
     * Sets the content of field <code>i</code> to the mark <code>m</code>.
     * M == 1
     *
     * @param i the field number (see NUMBERING)
     * @param m the mark to be placed
     */
    public void setField(int i, Mark m) {
        this.fields[i] = m;
    }

    /*@
       requires this.isField(row,col);
       ensures this.getField(row,col) == m;

     */

    /**
     * Sets the content of the field represented by the (row,col) pair to the
     * mark <code>m</code>.
     * M = 1
     *
     * @param row the field's row
     * @param col the field's column
     * @param m   the mark to be placed
     */
    public void setField(int row, int col, Mark m) {
        setField(index(row, col), m);
    }

}
