package ss.week5;

public class SmartStrategy extends NaiveStrategy {

    private String name;

    public SmartStrategy() {
        this.name = "Smart";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int determineMove(Board board, Mark mark) {
        if (board.isEmptyField(Board.DIM*Board.DIM/2)) return Board.DIM*Board.DIM/2;

        for (int i = 0; i < Board.DIM * Board.DIM; i++) {
            if (board.isEmptyField(i)) {
                Board copy = board.deepCopy();
                copy.setField(i, mark);
                if (copy.isWinner(mark)) return i;
            }
        }

        for (int i = 0; i < Board.DIM * Board.DIM; i++) {
            if (board.isEmptyField(i)) {
                Board copy = board.deepCopy();
                copy.setField(i, mark.other());
                if (copy.isWinner(mark.other())) return i;
            }
        }

        return super.determineMove(board, mark);
    }
}
