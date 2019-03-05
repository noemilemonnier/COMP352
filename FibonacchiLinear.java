import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author Artem Khomich
 */
public class FibonacchiLinear {

  
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
        logger.info("\nLinear output\n");  

    } catch (SecurityException e) {  
        e.printStackTrace();  
    } catch (IOException e) {  
        e.printStackTrace();  
    }  
    
    for (int i = 5; i<=50; i+=5){
        long time = System.nanoTime();
        long temp[] = LinearFibonacci(i);
        long result = System.nanoTime() - time;
        logger.info("Linear Fib call with " + i + " = " + temp[0] + ", with execution time equal to " + result + " nanoseconds\n"); 
        
    }    

    }

    public static long[] LinearFibonacci(int k){
        if (k < 0) return new long[] {-1, -1};
        else if (k == 0 || k == 1) return new long[] { 1, 0 };
        else{
            long[] array = LinearFibonacci(k - 1);
            long temp1 = array[0];
            long temp2 = array[0] + array[1];
            return new long[] { temp2, temp1};
        }
    }
}