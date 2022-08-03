package arrays;

import generics.Generator;

import java.util.*;

public class RandomGenerator {
    private static  Random r = new Random(47);
    public static class
    Boolean implements Generator<java.lang.Boolean> {
        public java.lang.Boolean next() {
            return r.nextBoolean();
        }
    }
    public static class
    Byte implements Generator<java.lang.Byte> {
        public java.lang.Byte next() {
            return (byte)r.nextInt();
        }
    }
    public static class
    Character implements Generator<java.lang.Character> {
        public java.lang.Character next() {
            return CountingGenerator.chars[
                    r.nextInt(CountingGenerator.chars.length)];
        }
    }
    public static class
    String extends CountingGenerator.String {
        // Plug in random Character generator:
        { cg = new Character(); }   // Instance initializer
        public String() {}
        public String(int length) { super(length); }
    }
    public static class
    Integer implements Generator<java.lang.Integer> {
        private int mod = 10000;
        public Integer() {};
        public Integer(int modulo) { mod = modulo ; }
        public java.lang.Integer next() {
            return r.nextInt(mod);
        }
    }
}
