package ss.week2;

public class Rectangle {

    private int length;
    private int width;

    /*@requires length > 0 && width > 0; */
    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    /*@ensures \result == getLength() * getWidth() */
    public int area() {
        return length * width;
    }

    /*@ensures \result == 2*getLength() + 2*getWidth() */
    public int perimeter() {
        return 2 * length + 2 * width;
    }
}
