package ss.week4;

// fancy hierarchy thingy http://puu.sh/dhkIA/2719b2d86e.png

public interface Function {
    double apply(double argument);

    Function derivative();

    String toString();
}
