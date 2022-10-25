package generics;

public class Ex30 {
    public static void main(String[] args){
        Holder<Integer> hi = new Holder<>();
        hi.set(1);
        Holder<Byte> hb = new Holder<>();
        hb.set((byte) 0x10);
        System.out.println(hb.get());
        Holder<Double> hd = new Holder<>();
        hd.set(1.0);
    }
}
