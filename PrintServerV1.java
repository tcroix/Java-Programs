import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;
/**
 *
 * @author taylorcroix
 */
public class PrintServerV1 implements Runnable {
    private final Queue<String> requests = new LinkedList<String>();
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private int id;
    private String title;
    public PrintServerV1(String s, int n) {
        try{
            while(!requests.isEmpty()){ 
                condition.await();
            }
            this.title = s;
            this.id = n;
            new Thread(this).start(); 
        } 
          catch (InterruptedException exception){
          }
    }
    public String getTitle(){
        return title;
    }
    public int getID(){
        return id;
    }
    public void printRequest(String s) {
        lock.lock();
        try {
            System.out.println("Print request added");
            requests.add(s);
            condition.signalAll();
        }
        finally {
            lock.unlock();
        }
    }
    public void sendRequest() throws InterruptedException{
        lock.lock();
        try{
            while(requests.isEmpty()){
                condition.await();
            }
            System.out.println("Request going to printer");
            for (;;) realPrint(requests.remove());
        }
        finally{
            lock.unlock();
        }
    }
    public void run()
    {
        try{
            sendRequest();
        }
        catch (InterruptedException exception){
        }
    }
    private void realPrint(String s) {
        // do the real work of outputting the string to the screen
        System.out.println("Printing: Title "+this.getTitle()+", ID "+this.getID()+", Class "+ this.getClass()+", Message "+ s);
    }
    public static void main(String[] args) { // for PrintServerV2
        // The following invocations of the constructor,
        // the first argument is title and the second argument is ID
        PrintServerV1 m = new PrintServerV1("manager", 1);
        PrintServerV1 c1 = new PrintServerV1("client1", 2);
        PrintServerV1 c2 = new PrintServerV1("client2", 3);
    }
}
