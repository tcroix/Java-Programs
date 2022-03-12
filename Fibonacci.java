import java.util.Scanner;
/**
 *
 * @author taylorcroix
 */
class SubsetOutputFib {
    static final int MAX_INDEX = 9;
    public static void main(String[] args) {
        int lo = 1;
        int hi = 1;
        Scanner in = new Scanner(System.in);
        int be;
        int en;
        System.out.print("Enter a number: ");
        be = in.nextInt();
        System.out.print("Enter another number: ");
        en = in.nextInt();
        String mark;
        if(be >= en){
            System.out.println("Error: Beginning greater than end");
        }
        else if(be<0 || en<0){
            System.out.println("Error: Negative Numbers");
        }
        else {
            for (int i = 2; i <= MAX_INDEX; i++) {
                if (hi % 2 == 0) {
                    mark = " *";
                }
                else {
                    mark = "";
                }
                if(i >= be && i <= en){
                    System.out.println(i + ": " + hi + mark);
                }
                hi = lo + hi;
                lo = hi - lo;
            }
        }
    }
}
//Rewrite the ImprovedFibonacci program using printf instead of println.
class ImprovedFibonacci {
    static final int MAX_INDEX = 9;
    public static void main(String[] args) {
       int lo = 1;
       int hi = 1;
       String mark;
       System.out.printf("1: " + lo);
       for (int i = 2; i <= MAX_INDEX; i++) {
           if (hi % 2 == 0)
                mark = " *";
           else
                mark = "";
           System.out.printf(i + ": " + hi + mark); 
           hi = lo + hi;
           lo = hi - lo;
        }
    }
}
       