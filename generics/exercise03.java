package generics;

public class exercise03<A , B , C , D , E, F> {
    public F sixth;
    public FiveTuple fiveTuple;
    public exercise03(A a, B b, C c, D d, E e, F f){
        fiveTuple = new FiveTuple<A,B,C,D,E>(a,b,c,d,e);
        sixth = f;
    }
    public String toString(){
        return fiveTuple.toString() + sixth;
    }
}
