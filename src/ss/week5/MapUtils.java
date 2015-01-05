package ss.week5;

import sun.awt.image.ImageWatched;

import java.util.*;

public class MapUtils {

    public static boolean isOneOnOne(Map map) {
        boolean result = true;
        int i;
        for (Object v : map.values()) {
            i = 0;
            for (Object k : map.keySet()) {
                if (v == map.get(k)) i++;
                if (i > 1) result = false;
            }
        }
        return result;
    }

    public static boolean isSurjectiveOnRange(Map map, Set set) {
        boolean result = true;
        for (Object v : set) {
            if (!map.containsValue(v)) result = false;
        }
        return result;
    }

    public static <K, V> Map<V, Set<K>> inverse(Map<K, V> map) {
        Map<V, Set<K>> result = new HashMap<V, Set<K>>();
        for (V v : map.values()) {
            if (!result.containsKey(v)) {
                HashSet<K> keys = new HashSet<K>();
                for (K k : map.keySet()) {
                    if (v == map.get(k)) {
                        keys.add(k);
                    }
                }
                result.put(v, keys);
            }
        }
        return result;
    }

    public static <K, V> Map<V, K> inverseBijection(Map<K, V> map) {
        Map<V, K> result = null;
        if (isOneOnOne(map)) {
            result = new HashMap<V, K>();
            for (K k : map.keySet()) {
                result.put(map.get(k), k);
            }
        }
        return result;
    }

    public static boolean compatible(Map f, Map g) {
        for (Object f1 : f.values()) {
            boolean inmap = false;
            for (Object g1 : g.keySet()) {
                if (g1 == f1) {
                    inmap = true;
                }
            }
            if (!inmap) {
                return false;
            }
        }
        return true;
    }

    public static Map compose(Map f, Map g) {
        Map result = new HashMap();
        //@ loop_invariant \index >= 0 && \index <= f.values().size();
        for (Object f1 : f.values()) {
            //@ loop_invariant \index >= 0 && \index <= g.keySet().size();
            for (Object g1 : g.keySet()) {
                if (g1 == f1) {
                    result.put(f1, g1);
                }
            }
        }
        return result;
    }

    public static LinkedList<Integer> bubblesort(LinkedList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 1; j < list.size() - i; j++) {
                if (list.get(j - 1) > list.get(j)) {
                    Integer temp = list.get(j);
                    list.set(j, list.get(j - 1));
                    list.set(j - 1, temp);
                }
            }
        }
        return list;
    }

    public static void mergeSort(LinkedList<Integer> list) {
        if (list.size() > 1) {
            // split array into two halves
            LinkedList<Integer> left = subList(list, 0, list.size() / 2);
            LinkedList<Integer> right = subList(list, list.size() / 2, list.size());

            // recursively sort the two halves
            mergeSort(left);
            mergeSort(right);

            // merge the sorted halves into a sorted whole
            merge(list, left, right);
        }
    }

    public static void merge(LinkedList<Integer> result, LinkedList<Integer> left, LinkedList<Integer> right) {
        int i1 = 0;   // index into left array
        int i2 = 0;   // index into right array

        for (int i = 0; i < result.size(); i++) {
            if (i2 >= right.size() || (i1 < left.size() && left.get(i1) <= right.get(i2))) {
                result.set(i, left.get(i1));    // take from left
                i1++;
            } else {
                result.set(i, right.get(i2));   // take from right
                i2++;
            }
        }
    }

    public static <E> LinkedList<E> subList(LinkedList<E> list, int begin, int end) {
        LinkedList<E> result = new LinkedList<E>();
        for (int i = begin; i < end; i++) {
            result.add(list.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(7);
        list.add(2);
        list.add(8);
        list.add(1);
        list.add(4);
        list.add(2);
        list.add(0);
        mergeSort(list);
        System.out.println(list);
    }
}
