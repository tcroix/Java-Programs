
/**
 *
 * @author taylorcroix
 */
public class Time {
    int n;
    public String toString(){
        return n + " ";
    }
}
class TimePrinting implements Runnable{
    private Time time;
    public TimePrinting(Time t){
        this.time = t;
    }
    public synchronized void run(){
        while(true){
            try{
                synchronized (time){
                    time.n = time.n+1;
                    time.notifyAll();
                }
                Thread.sleep(DELAY);
                System.out.println(time + " ");
            }
            catch (InterruptedException exception){
            }
        }
        
    }
    private static final int DELAY = 1000;
    
}
class MessagePrinting implements Runnable{
    private Time time;
    private int num;
    public MessagePrinting(Time t, int a){
        this.time = t;
        this.num = a;
    }
    public void run(){
        while(true){
            synchronized(time){
                try{
                    time.wait();
                }
                catch (InterruptedException exception){
                }
                if(time.n %num ==0){
                    System.out.println("\n"+num+" second message");
                }    
            }
        }
    }
}
class mainhold{
    public static void main(String[] args) {
        Time counter = new Time();
        // counter is shared among all three runnables below
        TimePrinting tp = new TimePrinting(counter);
        MessagePrinting mp5 = new MessagePrinting(counter, 5);
        MessagePrinting mp11 = new MessagePrinting(counter, 11);
    }
}

