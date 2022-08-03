package arrays;

//Test the tools that use generators to fill arrays.
import java.util.*;

public class TestArrayGeneration {
    public static void main(String[] args) {
        int size = 6;
        boolean[] a1 = ConvertTo.primitive(Generated.array(
                Boolean.class, new RandomGenerator.Boolean(), size));
        System.out.println("a1 = " + Arrays.toString(a1));
    }
}
