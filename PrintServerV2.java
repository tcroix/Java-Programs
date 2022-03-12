import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;
//import static java.lang.System.out;

/**
 *
 * @author taylorcroix
 */
public class PrintServerV2 implements Runnable {
    private final Queue<String> requests = new LinkedList<String>();
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private int id;
    private String title;
    public PrintServerV2(String s, int n) {
        try{
            while(!requests.isEmpty()){ 
                condition.wait();
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
    public synchronized void printRequest(String s) {
        lock.lock();
        try {
            System.out.println("Print request added");
            requests.add(s);
            condition.notifyAll();
        }
        finally {
            lock.unlock();
        }
    }
    public synchronized void sendRequest() throws InterruptedException{
        lock.lock();
        try{
            while(requests.isEmpty()){
                condition.wait();
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
        PrintServerV2 m = new PrintServerV2("manager", 1);
        PrintServerV2 c1 = new PrintServerV2("client1", 2);
        PrintServerV2 c2 = new PrintServerV2("client2", 3);
    }
}
