package ss.week7;

import java.net.Socket;

public class QuickSort {

    public static void qsort(int[] a) {
        qsort(a, 0, a.length - 1);
    }

    public static void qsort(int[] a, int first, int last) {
        if (first < last) {
            int position = partition(a, first, last);
            Thread threadA = new SortThread(a, first, position - 1);
            Thread threadB = new SortThread(a, position + 1, last);
            threadA.start();
            threadB.start();

            try {
                threadA.join();
                threadB.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static int partition(int[] a, int first, int last) {
        int mid = (first + last) / 2;
        int pivot = a[mid];
        swap(a, mid, last);
        int pi = first;
        int i = first;
        while (i != last) {
            if (a[i] < pivot) {
                swap(a, pi, i);
                pi++;
            }
            i++;
        }
        swap(a, pi, last);
        return pi;
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}

class SortThread extends Thread {
    private int[] a;
    private int first;
    private int last;

    public SortThread(int[] a, int first, int last) {
        this.a = a;
        this.first = first;
        this.last = last;
    }

    public void run() {
        QuickSort.qsort(a, first, last);
    }

    public static void main(String[] args) {
        int[] as = new int[]{6,3,8,5,4,7,6,1,8,4,2};

        QuickSort.qsort(as);

        for (int a : as) {
            System.out.print(a + ", ");
        }
    }
}
