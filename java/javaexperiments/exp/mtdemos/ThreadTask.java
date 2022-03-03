package exp.mtdemos;

public class ThreadTask extends Thread {

    private String name;

    public ThreadTask(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 3; i++) {
                System.out.println(getName() + "i=" + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
