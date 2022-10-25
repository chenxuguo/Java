package generics;

public class WarningDemo {
    public static void main(String[] args){
        Box rawBox = new Box();
        Box<Integer> intBox = rawBox;
    }
}

