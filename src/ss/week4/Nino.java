package ss.week4;

import java.util.Arrays;

public class Nino {

    public static int negatives(int[] integers) {
        int result = 0;
        for (int i = 0; i < integers.length; i++) {
            if (integers[i] < 0) result++;
        }
        return result;
    }

    public static int[] inverse(int[] integers) {
        //@ loop_invariant 0 <= i && i <= integers.length / 2;
        for (int i = 0; i < integers.length / 2; i++) {
            int temp = integers[i];
            integers[i] = integers[integers.length - 1 - i];
            integers[integers.length - 1 - i] = temp;
        }
        return integers;
    }

    public static void main(String[] args) {
        int[] is = new int[]{2, -6, 5, -3, -5, 7};
        System.out.println(negatives(is));
        System.out.println(Arrays.toString(is));
        System.out.println(Arrays.toString(inverse(is)));
    }
}
