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
        //FINDING FIRST THINGY
        String XD1 = "";
        for(int i=0; i< input.length(); i++){
            if(input.substring(i,i + 1).equals(" ")){
                XD1=input.substring(0, i);
                break;
            }
         
        }
        // returns each thingy
        String whole2 = "0";
        String numerator2 = "0";
        String denominator2 =  "1";
        int var2=0;
        // MIXED NUMBER
        if(XD1.contains("_")==true){
          for(int i=0; i <XD1.length(); i++){
            if(XD1.substring(i,i+1).equals("_")){
              var1 = i;
              whole2 = XD1.substring(0,i);
            }
          }
          for(int j=var1; j<XD1.length(); j++){
              if(XD1.substring(j, j+1).equals("/")){
                  numerator2 = XD1.substring(var1+1, j);
                  denominator2 = XD1.substring(j+1);
                  }
          }

         
        }
        // JUST FRACTION OR WHOLE NUMBER
        else{
          if(XD.contains("/") == true){
              for(int i=0; i<XD1.length(); i++){
                  if(XD.substring(i, i+1).equals("/")){
                      numerator2 = XD1.substring(0, i);
                      denominator2 = XD1.substring(i+1);
                   
                  }
                }
            }
          else{
              whole2 = XD1;
              numerator2 = "0";
              denominator2 = "1";
            }
        }
        int wholeofAll = 0;
        int numeratorofBoth = 0;
        int denominatorofBoth = 0;
        int numeratorofFirst;
        int denominatorofFirst = 1;
        String operand = "";
        if(whole != "0"){
            
        }
        if(whole2 != "0"){
            
        }
        for(int i=0; i< input.length(); i++){
            if(input.substring(i,i + 1).equals(" ")){
                operand=input.substring(i+1,i+2);
                break;
            }
         
        }
        if(operand.equals("+")){
            
        }
        else if(operand.equals("-")){
            
        }
        else if(operand.equals("*")){
            wholeofAll = Integer.parseInt(whole) * Integer.parseInt(whole2);
            numeratorofBoth = Integer.parseInt(numerator) * Integer.parseInt(numerator2);
            denominatorofBoth = Integer.parseInt(denominator) * Integer.parseInt(denominator2);
            
        }
        else{
            
        }
        if(wholeofAll == 0){
            if(numeratorofBoth == 0){
                return "0";
            }
            return numeratorofBoth + "/" + denominatorofBoth;
        }
        else if(numeratorofBoth == 0){
            return "" + wholeofAll;
        }
        return wholeofAll + "_" + numeratorofBoth + "/" + denominatorofBoth;
        
        
        
        
        
        

        

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


