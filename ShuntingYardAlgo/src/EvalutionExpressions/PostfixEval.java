package EvalutionExpressions;

import java.util.Arrays;

import MyQueue.MyQueue;
import MyStack.MyStack;

public class PostfixEval {
	
	static MyStack<Double> stack = new MyStack<Double>();
	
	public static double evaluate(String [] eqn) {
		for(String s : eqn) {
			double val =0;
			try {
				val = Double.parseDouble(s);
			} catch (NumberFormatException e) {
				val = operate(stack.pop(), stack.pop(), s);
			}
			stack.push(val);
		}
		return stack.pop();
	}
	
	public static double evaluate(MyQueue<String> queue) {
		String strEqn = "";
		while(!queue.isEmpty()) 
			strEqn += (queue.dequeue()+" ");
		
		String [] eqn = strEqn.split(" ");
		System.out.println("Postfix eqn: "+ Arrays.toString(eqn));
		
		return evaluate(eqn);
	}
	public static double operate(double y, double x, String z) {
		switch (z) {
		case "*":
			return x * y;
		case "+":
			return x + y;
		case "-":
			return (x - y);
		case "^":
			return Math.pow(x, y);
		case "/":
			return x / y;
		default:
			break;
		}
		return 0;
	}

}
