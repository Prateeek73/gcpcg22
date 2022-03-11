package exp.mtdemos.pcdemo;

public class ProducerTask implements Runnable {

    private ProduceConsume resource;

    public ProducerTask(ProduceConsume resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            resource.produce();
        }
    }
}
