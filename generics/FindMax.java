package generics;
import java.util.*;

public final class FindMax {
    public static  <T extends Comparable<? super T>> T findmax(List<? extends T> t, int begin, int end){
        T max = t.get(begin);
        for(int i = begin + 1; i < end; i++){
            if((max.compareTo(t.get(i))) < 0 ) max = t.get(begin);
        }
        return max;
    }
}
