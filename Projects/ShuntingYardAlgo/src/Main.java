import java.util.Scanner;

import EvalutionExpressions.InfixtoPostfix;
import EvalutionExpressions.PostfixEval;

public class Main {
	
	public static void main(String[] args) {
		
		System.out.print("Enter an Equation separating each operand/operator with a single space "
				+ "\nExample: 2 * 3 + 4\nEquation(Enter \"0\" to quit): ");
		Scanner userInput = new Scanner(System.in);
		String input = userInput.nextLine();
		
		while(input != "0") {	
			String [] infixExp = input.split(" ");
			System.out.println("Result = "+PostfixEval.evaluate(InfixtoPostfix.convert(infixExp)));
			System.out.print("\nEquation(Enter \"0\" to quit): ");
			input = userInput.nextLine();
		}
		userInput.close();
	}
	
}
