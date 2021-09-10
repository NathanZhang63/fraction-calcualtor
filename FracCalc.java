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
        String secondPart = "";
        for(int i=0; i< input.length(); i++){
            if(input.substring(i,i + 1).equals(" ")){
                secondPart=input.substring(i+3);
                break;
            }
         
        }
        // returns each thingy
        String whole = "0";
        String numerator = "0";
        String denominator =  "1";
        int var1=0;
        // MIXED NUMBER
        if(secondPart.contains("_")==true){
          for(int i=0; i <secondPart.length(); i++){
            if(secondPart.substring(i,i+1).equals("_")){
              var1 = i;
              whole = secondPart.substring(0,i);
            }
          }
          for(int j=var1; j<secondPart.length(); j++){
              if(secondPart.substring(j, j+1).equals("/")){
                  numerator = secondPart.substring(var1+1, j);
                  denominator = secondPart.substring(j+1);
                  }
          }

         
        }
        // JUST FRACTION OR WHOLE NUMBER
        else{
          if(secondPart.contains("/") == true){
              for(int i=0; i<secondPart.length(); i++){
                  if(secondPart.substring(i, i+1).equals("/")){
                      numerator = secondPart.substring(0, i);
                      denominator = secondPart.substring(i+1);
                   
                  }
                }
            }
          else{
              whole = secondPart;
              numerator = "0";
              denominator = "1";
            }
        }
        //FINDING FIRST PART I.e 1/2 + 2/3, returns 1/2
        String firstPart = "";
        for(int i=0; i< input.length(); i++){
            if(input.substring(i,i + 1).equals(" ")){
                firstPart=input.substring(0, i);
                break;
            }
         
        }
        // returns each part of the first part ie 1/2 : 1, 2
        String whole2 = "0";
        String numerator2 = "0";
        String denominator2 =  "1";
        int var2=0;
        // MIXED NUMBER
        if(firstPart.contains("_")==true){
          for(int i=0; i <firstPart.length(); i++){
            if(firstPart.substring(i,i+1).equals("_")){
              var1 = i;
              whole2 = firstPart.substring(0,i);
            }
          }
          for(int j=var1; j<firstPart.length(); j++){
              if(firstPart.substring(j, j+1).equals("/")){
                  numerator2 = firstPart.substring(var1+1, j);
                  denominator2 = firstPart.substring(j+1);
                  }
          }

         
        }
        // JUST FRACTION OR WHOLE NUMBER
        else{
          if(firstPart.contains("/") == true){
              for(int i=0; i<firstPart.length(); i++){
                  if(firstPart.substring(i, i+1).equals("/")){

                      numerator2 = firstPart.substring(0, i);
                      denominator2 = firstPart.substring(i+1);
                   
                  }
                }
            }
          else{
              whole2 = firstPart;
              numerator2 = "0";
              denominator2 = "1";
            }
        }
        String marcoiscringe = "";
        int numeratorofFirst= Integer.parseInt(numerator);
        int numeratorofSecond = Integer.parseInt(numerator2);
        String operand = "";
        for(int i=0; i< input.length(); i++){
            if(input.substring(i,i + 1).equals(" ")){
                operand=input.substring(i+1,i+2);
                break;
            }
         
        }
        if(whole != "0"){
            numeratorofFirst = improperFraction(whole, numerator, denominator);
        }
        if(whole2 != "0"){
            numeratorofSecond = improperFraction(whole2, numerator2, denominator2);
        }
        if(operand.equals("*")){
            marcoiscringe = multiply(numeratorofFirst, numeratorofSecond, denominator, denominator2);
        }
        if(operand.equals("/")){
            marcoiscringe = divide(numeratorofFirst, numeratorofSecond, denominator, denominator2);
        }
        return marcoiscringe;
        
        
        
        
        

        

    }
    // CHANGE MIXED NUMBER TO IMPROPER FRACTION
    public static int improperFraction(String whole, String numerator, String denominator){
        int numeratornice = Integer.parseInt(whole) * Integer.parseInt(denominator) + Integer.parseInt(numerator);
        return numeratornice;
    }
    public static String plus(String numerator, String denominator, String numerator2,String denominator2){
        return "";
    }
    public static String minus(String numerator, String denominator, String numerator2,String denominator2){
        return "";
    }
    public static String multiply(int numeratorofFirst, int numeratorofSecond, String denominator,String denominator2){
        int Combinednumerator = numeratorofFirst * numeratorofSecond;
        int Combineddenominator = Integer.parseInt(denominator) * Integer.parseInt(denominator2);
        return Combinednumerator + " / " + Combineddenominator;
        
    }
    public static String divide(int numeratorofFirst, int numeratorofSecond, String denominator,String denominator2){
        int Combinednumerator = numeratorofFirst / numeratorofSecond;
        int Combineddenominator = Integer.parseInt(denominator) / Integer.parseInt(denominator2);
        return Combinednumerator + " / " + Combineddenominator;
    }

    // TODO: Fill in the space below with any helper methods

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


