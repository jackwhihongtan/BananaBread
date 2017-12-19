package fracCalc;

import java.util.Arrays;

public class Fraction {
	private int numerator;
	private int denominator;
	private int whole;
	private int sign;

	public Fraction(int newWhole, int newNumerator, int newDenominator) {
		numerator = newNumerator;
		denominator = newDenominator;
		whole = newWhole;
	}

	public void toMixedNumber() {
		numerator = (whole * denominator) + numerator;
	}

	public Fraction addition(Fraction Operon2) {
		numerator = (numerator * Operon2.denominator);
		Operon2.numerator = (Operon2.numerator * denominator);
		denominator = (denominator * Operon2.denominator);
		numerator = numerator + Operon2.numerator;
		Fraction additionAns = new Fraction(whole, numerator, denominator);
		System.out.println(whole);
		System.out.println(numerator);
		System.out.println(denominator);
		return additionAns;
	}

	public Fraction subtract(Fraction Operon2) {
		numerator = (numerator * Operon2.denominator);
		Operon2.numerator = (Operon2.numerator * -1 * denominator);
		denominator = (denominator * Operon2.denominator);
		numerator = numerator + Operon2.numerator;
		Fraction subtractAns = new Fraction(whole, numerator, denominator);
		return subtractAns;
	}

	public Fraction multiply(Fraction Operon2) {
		numerator= numerator * Operon2.numerator;
		System.out.println(numerator);
		System.out.println(whole);
		denominator = denominator * Operon2.denominator;
		System.out.println(Operon2.whole);
		whole = 0;
		System.out.println(whole);
		Fraction multiplyAns = new Fraction(whole, numerator, denominator);
		System.out.println(whole);
		System.out.println(multiplyAns);
		return multiplyAns;
	}

	public Fraction divide(Fraction Operon2) {
		int switchNum = Operon2.denominator;
		Operon2.denominator = Operon2.numerator;
		Operon2.numerator = switchNum;
		whole = numerator * Operon2.numerator;
		Operon2.whole = denominator * Operon2.denominator;
		numerator = whole;
		whole = 0;
		denominator = Operon2.whole;
		Fraction divideAns = new Fraction(whole, numerator, denominator);
		return divideAns;
	}

	public String toString(Fraction reduce) {
		if (denominator == 1) {
			String convert = "" + numerator + "";
			return convert;
		} else if (denominator == -1) {
			numerator = numerator * -1;
			String convert = "" + numerator + "";
			return convert;
		} else if (numerator == 0) {
			return "0";
		} else if (numerator % denominator == 0) {
			reduce = reduceFraction(reduce);
			String convert = "" + whole + "";
			return convert;
		} else if (numerator < 0 && denominator < 0) {
			numerator = numerator * -1;
			denominator = denominator * -1;
			reduce = reduceFraction(reduce);
			String convert = "" + whole + "_" + numerator + "/" + denominator + "";
			return convert;
		} else if (numerator > denominator || absoluteValue(numerator) > denominator) {
			reduce = reduceFraction(reduce);
			if (whole == 0) {
				return "" + numerator + "/" + denominator + "";
			}
			String convert = "" + whole + "_" + numerator + "/" + denominator + "";
			return convert;
		} else {
			reduce = reduceFraction(reduce);
			String convert = "" + numerator + "/" + denominator + "";
			return convert;
		}
	}

	public Fraction reduceFraction(Fraction reduce) {
		if (numerator < 0) {
			int gcf = gcf(numerator, denominator);
			if (gcf < 0) {
				gcf *= -1;
			}
			numerator = numerator / gcf;
			denominator = denominator / gcf;
			whole = numerator / denominator;
			if (whole < 0) {
				numerator *= -1;
			}
			if (denominator < 0) {
				denominator *= -1;
			}
			numerator = numerator % denominator;
			return reduce;
		} else {
			int gcf = gcf(numerator, denominator);
			numerator = numerator / gcf;
			denominator = denominator / gcf;
			whole = numerator / denominator;
			if (denominator < 0) {
				denominator *= -1;
			}
			if (whole < 0 && numerator < 0) {
				numerator *= -1;
			}
			numerator = numerator % denominator;
			return reduce;
		}
	}

	public static int gcf(int num1, int num2) {
		int gcf = 0;
		int numerator = num1;
		int denom = num2;
		num1 = absoluteValue(numerator); // made values positive to make method work
		num2 = absoluteValue(denom);
		while (numerator != 0 && denom != 0) { // test for both zero for efficiency of code
			int c = denom; // declare new variable
			denom = numerator % denom;
			numerator = c;
		}
		gcf = numerator + denom;
		return gcf;
	}

	public static int absoluteValue(int number) {
		if (number > 0) {
			return number;
		} else {
			return number * -1;
		}
	}
}