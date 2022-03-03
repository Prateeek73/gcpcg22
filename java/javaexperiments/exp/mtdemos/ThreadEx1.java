package exp.mtdemos;

public class ThreadEx1 {

    public static void main(String args[]) {
        ThreadTask thread1 = new ThreadTask("thread1");
        ThreadTask thread2 = new ThreadTask("thread2");
        ThreadTask thread3 = new ThreadTask("thread3");
        thread1.start();
        thread2.start();
        thread3.start();

        System.out.println("bye, main thread exiting ");
    }
}
