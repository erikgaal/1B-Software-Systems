package ss.week5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class NaiveStrategy implements Strategy {

    private String name;
    private Random random;

    public NaiveStrategy() {
        name = "Naive";
        random = new Random();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int determineMove(Board board, Mark mark) {
        ArrayList<Integer> fields = new ArrayList<Integer>();
        for (int i = 0; i < Board.DIM * Board.DIM; i++) {
            if (board.isEmptyField(i)) {
                fields.add(i);
            }
        }
        return fields.get(random.nextInt(fields.size() - 1));
    }
}
