package generics;

import generics.qe1.Algorithm;

import java.util.*;


class OddPredicate implements UnaryPredicate<Integer> {
    public boolean test(Integer i) { return i % 2 != 0; }
}

public class Test {
    public static void main(String[] args) {
        java.util.Collection<Integer> ci = Arrays.asList(1,2,3,4);
        int count = Algorithm.countIf(ci, new OddPredicate());
        System.out.println("Number of odd integers = " + count);
    }
}
