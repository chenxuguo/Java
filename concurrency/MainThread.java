package concurrency;
public class MainThread {
    public static void main(String[] args) {
        LiftOff launch = new LiftOff();
        launch.run();
        System.out.println("Waiting for Liftoff");
    }
}
