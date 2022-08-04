package generics;

public class ArrayOfGeneric {
    static final int SIZE = 100;
    static Generic<Integer>[] gia;
    public static void main(String[] args) {
        //gia = (Generic<Integer>[])new Object[SIZE];
        gia = (Generic<Integer>[])new Generic[SIZE];
        System.out.println(gia.getClass().getSimpleName());
        gia[0] = new Generic<Integer>();
        //Error:(11, 18) java: 不兼容的类型: java.lang.Object无法转换为generics.Generic<java.lang.Integer>
        //gia[1] = new Object();
        //Error:(12, 18) java: 不兼容的类型: generics.Generic<java.lang.Double>无法转换为generics.Generic<java.lang.Integer>
        //gia[2] = new Generic<Double>();
    }
}
