package generics;
import java.util.*;
public class CountNumber{
    public static void main(String[] args){
        System.out.println(new PrimeNumber().count(20));
    }
}

class PrimeNumber{
    public int count(int n){
        int count = 0;
        for(int i = 1; i < n; i++){
            if(isPrime(i)) {
                System.out.println(i);
                count++;
            }
        }
        return count;
    }
    public Boolean isPrime(int m){
        if(m == 1)
            return false;
        if(m == 2)
            return true;
        for( int i = 2; i < m; i++) {
            if ((m % i) == 0)
                return false;
        }
        return true;
    }
}

class OddNumber{
    public Boolean isOdd(int m){
        if ( (m % 2) == 1)
            return true ;
        else  return false;
    }
}