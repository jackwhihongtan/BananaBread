

//Jack Tan
package fracCalc;

import java.util.Arrays;
import java.util.Scanner;

public class FracCalc {
	
	public static void main(String[] args) 
  {
      // TODO: Read the Parse from the user and call produceAnswer with an equation
  	boolean run = true;
  	while (run = true) {
  	Scanner sc = new Scanner(System.in);
  	System.out.println("Please input the fractions:");
  	String userInput = sc.nextLine();
  	String answer = produceAnswer(userInput);
  	System.out.println(answer);
  	System.out.println("Are you done yet?");
  	String finish = sc.next();
  	
  	if (finish.equals("quit")) {
  		run = false;
  		System.out.println("Thank you");
  	} else {
  		run = true;
  		}
  	}	
  }
  
  // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
  // This function takes a String 'Parse' and produces the result
  //
  // Parse is a fraction string that needs to be evaluated.  For your program, this will be the user Parse.
  //      e.g. Parse ==> "1/2 + 3/4"
  //        
  // The function should return the result of the fraction after it has been calculated
  //      e.g. return ==> "1_1/4"
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
  
	public static String produceAnswer(String fractions) { 
		int[] fraction1 = toImproperFrac(splitOper(Oper1(Parse((fractions)))));
		int[] fraction2 = toImproperFrac(splitOper(Oper2(Parse((fractions)))));
		String[] operator = Parse(fractions);
		String operatorSign = operator[1];
		int[] answer = new int[3];
		if (operatorSign.equals("+")) {
			answer = addition(fraction1, fraction2);
			String finalanswer = toString(answer);
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
  
  
  public static String[] Parse(String Parse)
  { 
      // TODO: Implement this function to produce the solution to the Parse
  	// Parse Both functions
  	String[] lastValue = Parse.split(" ");
      return lastValue;
  // TODO: Fill in the space below with any helper methods that you think you will need
  }
  public static int[] toImproperFrac (int[] fraction) {
  	if (fraction[0] < 0) {
  		fraction[0] = fraction[0] * -1;
  	fraction[1] = ((fraction[0] * fraction[2]) + fraction[1]);
  	fraction[0] = 0;
  	fraction[1] = fraction[1] * -1;
  	return fraction;
  	} else {
  		fraction[1] = ((fraction[0] * fraction[2]) + fraction[1]);
      	fraction[0] = 0;
      	return fraction;
  	}
  }
  public static int[] addition(int[] fraction1, int[] fraction2) {
  	fraction1[1] = (fraction1[1] * fraction2[2]);
  	fraction2[1] = (fraction2[1] * fraction1[2]);
  	fraction1[2] = (fraction1[2] * fraction2[2]);
  	fraction1[0] = fraction1[1] + fraction2[1];
  	int[] answer = {0,fraction1[0], fraction1[2]};
  	return answer;
  }
  public static int[] multiply(int[] fraction1, int[] fraction2) {
  	fraction1[0] = fraction1[1] * fraction2[1];
  	fraction2[0] = fraction1[2] * fraction2[2];
  	int[] answer = {0,fraction1[0], fraction2[0]};
  	return answer;
  }
  public static String toString(int[] answer) {
  	String u = Arrays.toString(answer);
  	System.out.println(u);
	  if(answer[1] > answer[2] || absoluteValue(answer[1]) > answer[2]) {
  		answer = reduceFraction(answer);
  		String convert = "" + answer[0] +"_"+ answer[1] +"/"+ answer[2] + "";
  		return convert;			
  	} else if (answer[1] == 0) {
  		return "" + answer[0] + "";
  	} else if (answer[2] == 1) {
  		String convert = "" + answer[1] +  "";
  		return convert;
  	}
  	else {
  		answer = reduceFraction(answer);
  		String convert = "" + answer[1]+"/"+answer[2] + "";
  		return convert;
  	} 
  		
  	}
  	
  
  public static int[] reduceFraction(int[] answer) {
	  if (answer[1] < 0) {
		  answer[1] = answer[1] * -1;
		  int gcf = gcf(answer[1], answer[2]);
		  System.out.println(gcf);
	  answer[1] = answer[1] / gcf;
	  String w = Arrays.toString(answer);
	  System.out.println(w);
		answer[2] = answer[2] / gcf;
	  	System.out.println(w);
		answer[0] = answer[1] / answer[2];
		answer[1] = answer[1] % answer[2];
		System.out.println(w);
		return answer;
  	} else {
  		 String w = Arrays.toString(answer);
  		int gcf = gcf(answer[1], answer[2]);
  		System.out.println(gcf);
  	  answer[1] = answer[1] / gcf;
  	System.out.println(w);
  		answer[2] = answer[2] / gcf;
  		System.out.println(w);
  		answer[0] = answer[1] / answer[2];
  		answer[1] = answer[1] % answer[2];
  		System.out.println(w);
  		return answer;
  	}
  }
  	
  public static int absoluteValue (int number) {
  	if (number > 0) {
			return number;
		} else {
			return number * -1;
		}
	}
  public static int gcf (int num1, int num2) {
	  int gcf = 0;
		int numerator = num1;
		int denom = num2;
		num1 = absoluteValue(numerator); //made values positive to make method work
		num2 = absoluteValue(denom);
				while (numerator != 0 && denom !=0 ) { //test for both zero for efficiency of code
					int c = denom;  //declare new variable 
					denom = numerator%denom;
					numerator = c;
				}
				gcf = numerator + denom;
				return gcf;
  }
}
  

  


  
