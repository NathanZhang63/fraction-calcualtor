import java.util.*; 

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
        // finds the second operand
        String XD = "";
        for(int i=0; i< input.length(); i++){
            if(input.substring(i,i + 1).equals(" ")){
                XD=input.substring(i+3);
                break;
            }
         
        }
        // returns each thingy
        String whole = "0";
        String numerator = "0";
        String denominator =  "1";
        int var1=0;
        // MIXED NUMBER
        if(XD.contains("_")==true){
          for(int i=0; i <XD.length(); i++){
            if(XD.substring(i,i+1).equals("_")){
              var1 = i;
              whole = XD.substring(0,i);
            }
          }
          for(int j=var1; j<XD.length(); j++){
              if(XD.substring(j, j+1).equals("/")){
                  numerator = XD.substring(var1+1, j);
                  denominator = XD.substring(j+1);
                  }
          }

         
        }
        // JUST FRACTION OR WHOLE NUMBER
        else{
          if(XD.contains("/") == true){
              for(int i=0; i<XD.length(); i++){
                  if(XD.substring(i, i+1).equals("/")){
                      numerator = XD.substring(0, i);
                      denominator = XD.substring(i+1);
                   
                  }
                }
            }
          else{
              whole = XD;
              numerator = "0";
              denominator = "1";
            }
        }
        return "whole:"+whole+" numerator:"+numerator+" denominator:"+denominator;
   
        

        

    }

    // TODO: Fill in the space below with any helper methods

    /**
     * GCF
     * 
     * @param p first int
     * @param q second int
     * @return The GCF
     */
    /* public static int gcf(int p, int q) {
        while (q != 0) {
            int temp = q;
            q = p % q;
            p = temp;
        }
        return p;
    } */

}


