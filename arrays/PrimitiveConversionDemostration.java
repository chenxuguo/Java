package arrays;
import java.util.*;

public class PrimitiveConversionDemostration {
    public static void main(String[] args) {
        Integer[] a = Generated.array(Integer.class,
                new CountingGenerator.Integer(), 15);
        int[] b = ConvertTo.primitive(a);
        System.out.println(Arrays.toString(b));
    }
}
