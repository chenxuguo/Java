package generics;
import java.util.ArrayList;

public class ExchangeElement {
    public static <T> void exchange(T[] t,int i, int j) {
        T temp = t[j];
        t[j] = t[i];
        t[i] = t[j];
    }
}

