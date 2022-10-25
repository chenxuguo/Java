package generics;

import java.util.Comparator;

public class Algorithm {
    public static <T> Comparator<T> max(Comparator<T> x, Comparator<T> y) {
        return x > y ? x : y;
    }
}
