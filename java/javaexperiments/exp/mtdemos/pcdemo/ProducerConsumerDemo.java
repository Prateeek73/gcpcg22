package exp.mtdemos.pcdemo;

public class ProducerConsumerDemo {

    public static void main(String args[]){
        ProduceConsume resource=new ProduceConsume();
        Thread producerThread=new Thread(new ProducerTask(resource));
        Thread consumerThread=new Thread(new ConsumerTask(resource));
        producerThread.start();
        consumerThread.start();
    }
}
