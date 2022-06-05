import java.util.*; 
import java.lang.Math;
/**
 * Calculates fractions.
 *
 * Nathan Zhang
 * 9/1
 */
public class FracCalc {

    /**
     * Runs a fraction calculator.
     * 
     * @param args Not used
     */
    public static void main(String[] args) 
    {
        Scanner inputScanner = new Scanner(System.in);
        String inputLine = inputScanner.nextLine();
        System.out.println(produceAnswer(inputLine));
    }

    public static String produceAnswer(String input)
    { 
        return "";
    }
    /**
     * GCF
     * 
     * @param p first int
     * @param q second int
     * @return The GCF
     */
    public static int gcf(int p, int q) {
        while (q != 0) {
            int temp = q;
            q = p % q;
            p = temp;
        }
        return p;
    }

}


