import java.util.*; 
import java.lang.Math;
/**
 * Calculates fractions.
 *
 * Nathan Zhang
 * Nathan Liu
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
        String whole2 = "0";
        String numerator2 = "0";
        String denominator2 =  "1";
        int var1=0;
        // MIXED NUMBER
        if(secondPart.contains("_")==true){
          for(int i=0; i <secondPart.length(); i++){
            if(secondPart.substring(i,i+1).equals("_")){
              var1 = i;
              whole2 = secondPart.substring(0,i);
            }
          }
          for(int j=var1; j<secondPart.length(); j++){
              if(secondPart.substring(j, j+1).equals("/")){
                  numerator2 = secondPart.substring(var1+1, j);
                  denominator2 = secondPart.substring(j+1);
                  }
          }

         
        }
        // JUST FRACTION OR WHOLE NUMBER
        else{
          if(secondPart.contains("/") == true){
              for(int i=0; i<secondPart.length(); i++){
                  if(secondPart.substring(i, i+1).equals("/")){
                      numerator2 = secondPart.substring(0, i);
                      denominator2 = secondPart.substring(i+1);
                   
                  }
                }
            }
          else{
              whole2 = secondPart;
              numerator2 = "0";
              denominator2 = "1";
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
        String whole1 = "0";
        String numerator1 = "0";
        String denominator1 =  "1";
        int var2=0;
        // MIXED NUMBER
        if(firstPart.contains("_")==true){
          for(int i=0; i <firstPart.length(); i++){
            if(firstPart.substring(i,i+1).equals("_")){
              var1 = i;
              whole1 = firstPart.substring(0,i);
            }
          }
          for(int j=var1; j<firstPart.length(); j++){
              if(firstPart.substring(j, j+1).equals("/")){
                  numerator1 = firstPart.substring(var1+1, j);
                  denominator1 = firstPart.substring(j+1);
                  }
          }

         
        }
        // JUST FRACTION OR WHOLE NUMBER
        else{
          if(firstPart.contains("/") == true){
              for(int i=0; i<firstPart.length(); i++){
                  if(firstPart.substring(i, i+1).equals("/")){

                      numerator1 = firstPart.substring(0, i);
                      denominator1 = firstPart.substring(i+1);
                   
                  }
                }
            }
          else{
              whole1 = firstPart;
              numerator1 = "0";
              denominator1 = "1";
            }
        }
        String marcoiscringe = "";
        int numeratorofFirst= Integer.parseInt(numerator1);
        int numeratorofSecond = Integer.parseInt(numerator2);
        String operand = "";
        for(int i=0; i< input.length(); i++){
            if(input.substring(i,i + 1).equals(" ")){
                operand=input.substring(i+1,i+2);
                break;
            }
         
        }
        if(whole1 != "0"){
            numeratorofFirst = improperFraction(whole1, numerator1, denominator1);
        }
        if(whole2 != "0"){
            numeratorofSecond = improperFraction(whole2, numerator2, denominator2);
        }
        if(operand.equals("*")){
            marcoiscringe = multiply(numeratorofFirst, numeratorofSecond, denominator1, denominator2);
        }
        if(operand.equals("/")){
            marcoiscringe = divide(numeratorofFirst, numeratorofSecond, denominator1, denominator2);
        }
        if(operand.equals("+")){
            marcoiscringe = plus(numeratorofFirst, numeratorofSecond, denominator1, denominator2);
        }
        if(operand.equals("-")){
            marcoiscringe = minus(numeratorofFirst, numeratorofSecond, denominator1, denominator2);
        }
        // SPLITS MARCOISCRINGE INTO 2 THINGS
        String numerator3_string = "";
        String denominator3_string = "";
        int numerator3 = 0;
        int denominator3 = 0;
        for(int i=0; i< marcoiscringe.length(); i++){
            if(marcoiscringe.substring(i,i + 1).equals(" ")){
                denominator3_string =marcoiscringe.substring(i+1);
                numerator3_string =marcoiscringe.substring(0, i);
                break;
            }
         
        }
        // TURNS INTO MIXED NUMBER
        numerator3 = Integer.parseInt(numerator3_string);
        denominator3 = Integer.parseInt(denominator3_string);
        int finalWhole = 0;
        if(Math.abs(numerator3) > Math.abs(denominator3)){
            finalWhole = numerator3/denominator3;
            numerator3 = numerator3 % denominator3;
            if(numerator3 <0){
                numerator3 *= -1;
            }
        }
        else if(numerator3 == denominator3){
            return "1";
        }
        // GCF (SIMPLIFYING FRACTIONS)
        int Gcf = gcf(numerator3, denominator3);
        
        if(gcf(numerator3, denominator3) != 1){
            // System.out.println(Gcf + " " + denominator3 + " " +numerator3);
            numerator3 = numerator3 / Gcf;
            denominator3 = denominator3 / Gcf;
            
            // System.out.println(Gcf + " " + denominator3 + " " +numerator3);
        }
        
        // FIXES WHAT THE SIGN IS FOR NEGATIVES AND MULTIPLICATION, SIGNS GEt SCUFFED DURING MULTIPLYING AND DIVIDING
        if(operand.equals("/") || operand.equals("*")){
            numerator3 = Math.abs(numerator3);
            denominator3 = Math.abs(denominator3);
            finalWhole = Math.abs(finalWhole);
            // System.out.println(numerator3 + " " + denominator3 + " " + countNegatives(input) + " " + finalWhole);
            if(countNegatives(input) == 1){
                if(finalWhole != 0){
                    finalWhole *= -1;
                }
                else{
                    numerator3 *= -1;
                }
            }
        }
    
        
        
        
        if(finalWhole != 0){
            if(numerator3 ==0){
                return "" + finalWhole;
            }
            return finalWhole + "_" + numerator3 + "/" + denominator3;
        }
        if(numerator3 == 0){
            return "0";
        }
        if(denominator3 == 1){
            return "" + numerator3;
        }
        
        return numerator3 + "/" + denominator3;
        
        
        
        
    
        

    }

        // TODO: Fill in the space below with any helper methods

    // CHANGE MIXED NUMBER TO IMPROPER FRACTION
    public static int improperFraction(String whole, String numerator, String denominator){
        if(whole.contains("-") == true){
            return Integer.parseInt(whole) * Integer.parseInt(denominator) - Integer.parseInt(numerator);
        }
        int numeratornice = Integer.parseInt(whole) * Integer.parseInt(denominator) + Integer.parseInt(numerator);
        return numeratornice;
    }
    public static String plus(int numeratorofFirst, int numeratorofSecond, String denominator1,String denominator2){
        int Combinednumerator = (numeratorofFirst * Integer.parseInt((denominator2)) + (numeratorofSecond * Integer.parseInt((denominator1))));
        int Combineddenominator = (Integer.parseInt(denominator1) * Integer.parseInt(denominator2));
        return Combinednumerator + " " + Combineddenominator;
    }
    public static String minus(int numeratorofFirst, int numeratorofSecond, String denominator1,String denominator2){
        int Combinednumerator = (numeratorofFirst * Integer.parseInt((denominator2)) - (numeratorofSecond * Integer.parseInt((denominator1))));
        int Combineddenominator = (Integer.parseInt(denominator1) * Integer.parseInt(denominator2));
        return Combinednumerator + " " + Combineddenominator;
    }
    public static String multiply(int numeratorofFirst, int numeratorofSecond, String denominator1,String denominator2){
        int Combinednumerator = numeratorofFirst * numeratorofSecond;
        int Combineddenominator = Integer.parseInt(denominator1) * Integer.parseInt(denominator2);
        // System.out.println(Combinednumerator + " " + Combineddenominator);
        
        return Combinednumerator + " " + Combineddenominator;
        
    }
    public static String divide(int numeratorofFirst, int numeratorofSecond, String denominator1,String denominator2){
        int Combinednumerator = numeratorofFirst * Integer.parseInt(denominator2);
        int Combineddenominator = numeratorofSecond * Integer.parseInt(denominator1);
        return Combinednumerator + " " + Combineddenominator;
    }
    public static int countNegatives(String input){
        int count = 0;
        for(int i=0; i< input.length(); i++){
            if(input.substring(i,i + 1).equals("-")){
                count++;
            }
         
        }
        return count;
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


