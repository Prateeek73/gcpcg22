package exp.mtdemos.pcdemo;

public class ConsumerTask implements Runnable{

    private ProduceConsume resource;

    public ConsumerTask(ProduceConsume resource){
        this.resource = resource;
    }

    @Override
    public void run() {
      for(int i=0;i<10;i++){
          resource.consume();
        }
    }
}
