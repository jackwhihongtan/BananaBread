package fracCalc;

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
	
}