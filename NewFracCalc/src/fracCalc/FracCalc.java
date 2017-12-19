package fracCalc;

import java.util.Scanner;

public class FracCalc {

	public static void main(String[] args) {
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

	public static String[] Parse(String Parse) {
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
			operon[0] = Integer.parseInt(input.substring(0, input.indexOf("_")));
			if (input.indexOf('/') != -1) {
				operon[1] = Integer.parseInt(input.substring(input.indexOf("_") + 1, input.indexOf("/")));
				operon[2] = Integer.parseInt(input.substring(input.indexOf("/") + 1));
			}
			return operon;
		} else if (input.indexOf('/') != -1) {
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
	public static int[] toImproperFrac(int[] fraction) {
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
	public static String produceAnswer(String input) {
		int[] fraction = toImproperFrac(splitOper(Oper1(Parse(input))));
		int[] fraction2 = toImproperFrac(splitOper(Oper2(Parse(input))));
		String[] operator = Parse(input);
		String operatorSign = operator[1];
		Fraction Operon1 = new Fraction(fraction[0], fraction[1], fraction[2]);
		Fraction Operon2 = new Fraction(fraction2[0], fraction2[1], fraction2[2]);
		if (operatorSign.equals("+")) {
			Fraction additionAns = Operon1.addition(Operon2);
			String answer = additionAns.toString(additionAns);
			return answer;
		} else if (operatorSign.equals("-")) {
			Fraction subtractAns = Operon1.subtract(Operon2);
			String answer = subtractAns.toString(subtractAns);
			return answer;
		} else if (operatorSign.equals("/")) {
			Fraction divideAns = Operon1.divide(Operon2);
			String answer = divideAns.toString(divideAns);
			return answer;
		} else {
			Fraction multiplyAns = Operon1.multiply(Operon2);
			String answer = multiplyAns.toString(multiplyAns);
			return answer;
		}
	}
}
