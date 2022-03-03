package exp.mtdemos.pcdemo;

public class ProduceConsume {

    private int i;

    private boolean produced;

    public synchronized void produce() {
        try {
            if(produced){
                wait();
            }

            i++;
            System.out.println("produced " + i);
            Thread.sleep(1000);
             produced = true;
             notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void consume() {
        try {
            if(!produced){
                wait();
            }
            System.out.println("consumed " + i);
            Thread.sleep(1000);
            produced=false;
            notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
