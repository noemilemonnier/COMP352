import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class FibonacciTail {

  
    public static void main(String[] args) {
        // TODO code application logic here

    Logger logger = Logger.getLogger("MyLog");  
    FileHandler fh;  

    try {  

        // This block configure the logger with handler and formatter  
        fh = new FileHandler("/Users/artemkhomich/Documents/Project/output.log", true);  
        logger.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();  
        fh.setFormatter(formatter);  

        // the following statement is used to log any messages  
        logger.info("\nTail output\n");  

    } catch (SecurityException e) {  
        e.printStackTrace();  
    } catch (IOException e) {  
        e.printStackTrace();  
    }  
    
    for (int i = 5; i<=50; i+=5){
        long time = System.nanoTime();
        long temp = FibonacciTail(i, 0, null);
        long result = System.nanoTime() - time;
        logger.info("Tail Fib call with " + i + " = " + temp + ", with execution time equal to " + result + " nanoseconds\n"); 
        
    }    

    }

    public static long FibonacciTail(int k, int iterator, long[] array){
        if (iterator == 0 || array == null){
            iterator = 2;
            array = new long[k];
            array[0] = 0;
            array[1] = 1;
        }
        if (k < 0) return 0;
        else if (k == 0 || k == 1) return k;
        if (iterator == k) return array[k-1];
        else{
            array[iterator] = array[iterator-2] + array[iterator-1];
            return FibonacciTail(k, iterator+1, array);

        }
       
    }
}