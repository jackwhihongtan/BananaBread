package fracCalc;

import java.util.Arrays;

public class Fraction {
 private int numerator;
 private int denominator;
 private int whole;
 private int sign;
	public Fraction(int newNumerator, int newDenominator, int newWhole) {
		numerator = newNumerator;
		denominator = newDenominator;
		whole = newWhole;
	}
	public String toString() {
		return ("whole:"+ whole +" numerator:"+ numerator + " denominator:"+ denominator +"");
	}
	public void toMixedNumber() {
		numerator = (whole * denominator) + numerator;
	}
	public void toImproperFrac() {
		whole = numerator / denominator;
		numerator = numerator % denominator;
	}
	public Fraction addition(Fraction Operon2) {
		numerator = (numerator * Operon2.denominator);
		Operon2.numerator = (Operon2.numerator * denominator);
	  	denominator = (denominator * Operon2.denominator);
	  	whole = numerator + Operon2.numerator;
	  	Fraction additionAns = new Fraction(whole, numerator, denominator);
	  	return additionAns;
	}
	public void multiply(int[] fraction2) {
		whole = numerator * fraction2[1];
	  	fraction2[0] = denominator * fraction2[2];
	  	numerator = whole;
	  	whole = 0;
	  	denominator = fraction2[0];
	}
	public String toString(Fraction reduce) {
		 if(numerator > denominator || absoluteValue(numerator) > denominator) {
		  		reduce = reduceFraction(reduce);
		  		String convert = "" + whole +"_"+ numerator +"/"+ denominator + "";
		  		return convert;			
		  	} else if (numerator == 0) {
		  		return "" + whole + "";
		  	} else if (denominator == 1) {
		  		String convert = "" + numerator +  "";
		  		return convert;
		  	}
		  	else {
		  		reduce = reduceFraction(reduce);
		  		String convert = "" + numerator +"/"+denominator+ "";
		  		return convert;
		  	}
		  } 
		 public Fraction reduceFraction(Fraction reduce) {
			  if (numerator < 0) {
				  numerator = numerator * -1;
				  int gcf = gcf(numerator, denominator);
				  numerator = numerator / gcf;
				denominator = denominator / gcf;
				whole = numerator / denominator;
				numerator = numerator % denominator;
				return answer;
		  	} else {
		  		int gcf = gcf(numerator, denominator);
		  		System.out.println(gcf);
		  	  numerator = numerator / gcf;
		
		  		denominator = denominator / gcf;
		  	
		  		whole = numerator / denominator;
		  		numerator = numerator % denominator;
		  		
		  		return answer;
		  	}
	}
	
}