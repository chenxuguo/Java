package concurrency;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i < 5; i++)
            exec.execute(new LiftOff());
    }
}
