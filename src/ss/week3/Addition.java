package ss.week3;

public class Addition implements OperatorWithIdentity {
    @Override
    public int operate(int left, int right) {
        return left + right;
    }

    @Override
    public int identity() {
        return 0;
    }
}
