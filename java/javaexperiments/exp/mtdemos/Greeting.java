package exp.mtdemos;

public class Greeting {

    // ( hello)
    public synchronized void greet(){
            try {
                System.out.print("(");
                System.out.print("hello");
                Thread.sleep(500);
                System.out.print(")");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

    }
}
