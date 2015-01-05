package ss.week5;

public interface Strategy {
    public String getName();
    public int determineMove(Board board, Mark mark);
}
