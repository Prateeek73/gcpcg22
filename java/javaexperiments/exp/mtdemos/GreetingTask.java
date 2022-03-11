package exp.mtdemos;

public class GreetingTask implements Runnable {

    private Greeting greeting;

    public GreetingTask(Greeting greeting) {
        this.greeting = greeting;
    }

    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            greeting.greet();
        }
    }
}
