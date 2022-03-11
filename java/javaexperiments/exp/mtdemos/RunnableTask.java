package exp.mtdemos;

public class RunnableTask implements Runnable{


    @Override
    public void run() {
        try {
            for (int i = 0; i < 3; i++) {
                Thread currentThread=Thread.currentThread();
                String name=currentThread.getName();
                System.out.println(name + "i=" + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
