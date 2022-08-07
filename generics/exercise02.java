package generics;

public class exercise02<T> {
    T item1,item2, item3;
    public exercise02(T a, T b, T c){
        item1 = a;
        item2 = b;
        item3 = c;
    }
    T getItem1(){ return item1; }
    T getItem2() { return item2; }
    T getItem3() { return item3; }
}
