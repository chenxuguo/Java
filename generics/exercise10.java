package generics;

public class exercise10 {
    public <A, B> void f(A a, B b, String c){
        System.out.println(a.getClass().getSimpleName());
        System.out.println(b.getClass().getSimpleName());
        System.out.println(c);
    }
    public static void main(String[] args){
        exercise10 ex10 = new exercise10();
        ex10.f("string a", 2, "string  c");
    }
}
