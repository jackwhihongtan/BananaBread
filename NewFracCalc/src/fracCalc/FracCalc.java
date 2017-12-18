package fracCalc;

import java.util.Scanner;

public class FracCalc {

    public static void main(String[] args) 
    {
    	boolean run = true;
      	while (run = true) {
      	Scanner sc = new Scanner(System.in);
      	System.out.println("Please input the fractions:");
      	String userInput = sc.nextLine();
      	String answer = produceAnswer(userInput);
      	System.out.println(answer);
      	System.out.println("Are you done yet?");
      	String finish = sc.next();
    }
    }
      	public static String[] Parse(String Parse)
        { 
        	String[] lastValue = Parse.split(" ");
            return lastValue;
        }
      	 public static String Oper1(String[] lastvalue) {
      	  	String oper1 = lastvalue[0];
      	  	return oper1;
      	  }
      	  
      	  public static String Oper2(String[] lastvalue) {
      	  	int arrlen = lastvalue.length;
      	  	String oper2 = lastvalue[arrlen - 1];
      	  	return oper2;
      	  }
      	  
      	  public static int[] splitOper(String input) {
      	  	
      	   	int[] operon = new int[3];
      	   	
      	   	if (input.indexOf('_') != -1) {
      	   		operon[0] = Integer.parseInt(input.substring(0,input.indexOf("_")));
      	   			if(input.indexOf('/') != -1) {
      	   				operon[1] = Integer.parseInt(input.substring(input.indexOf("_") + 1, input.indexOf("/")));
      	   				operon[2] = Integer.parseInt(input.substring(input.indexOf("/") + 1));
      	   		}
      	   		return operon;
      	   	}
      	   	else if(input.indexOf('/') != -1) {
      	   		operon[0] = 0;
      	   		operon[1] = Integer.parseInt(input.substring(0, input.indexOf("/")));
      	   		operon[2] = Integer.parseInt(input.substring(input.indexOf("/") + 1));
      	   		return operon;
      	   	} else {
      	   		operon[0] = Integer.parseInt(input.substring(0));
      	   		operon[1] = 0;
      	   		operon[2] = 1;
      	   		return operon;
      	   	}
      	   }
    public static String produceAnswer(String input){ 
        int[] fraction = splitOper(Oper1(Parse(input)));
        int[] fraction2 = splitOper(Oper2(Parse(input)));
        String[] operator = Parse(input);
		String operatorSign = operator[1];
        Fraction Operon1 = new Fraction(fraction[1], fraction[2], fraction[0]);
        Fraction Operon2 = new Fraction(fraction2[1], fraction2[2], fraction2[0]);
		if (operatorSign.equals("+")) {
			Fraction additionAns = Operon1.addition(Operon2);
			
			return finalanswer;
		} else if(operatorSign.equals("-")) {
			fraction2[1] = fraction2[1] * -1;
			answer = addition(fraction1, fraction2);
			String finalanswer = toString(answer);
			return finalanswer;
			} else if(operatorSign.equals("/")) {
				int switchNum = fraction2[2];
		    	fraction2[2] = fraction2[1];
		    	fraction2[1] = switchNum;
		    	answer = multiply(fraction1, fraction2);
		    	String finalanswer = toString(answer);
		    	return finalanswer;
			} else {
				answer = multiply(fraction1, fraction2);
				String finalanswer = toString(answer);
				return finalanswer;
			}
		}
  
        return "";
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    
}
