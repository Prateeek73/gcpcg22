package exp.mtdemos;

public class SynchronizeEx {
    public static void main(String args[]) {
        Greeting greeting = new Greeting();
        Thread th1 = new Thread(new GreetingTask(greeting));
        Thread th2 = new Thread(new GreetingTask(greeting));
        Thread th3 = new Thread(new GreetingTask(greeting));
        th1.start();
        th2.start();
        th3.start();
    }
}
