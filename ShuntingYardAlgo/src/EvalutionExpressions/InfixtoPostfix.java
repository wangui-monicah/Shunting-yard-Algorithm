package EvalutionExpressions;

import MyQueue.MyQueue;
import MyStack.MyStack;

public class InfixtoPostfix {
	
	static MyStack<String> stack = new MyStack<String>();
	static MyQueue<String> outputQueue = new MyQueue<String>();
	
	public static MyQueue<String> convert(String [] eqn) {
		for(String s : eqn) {
			try {
				//Operands: Send to Queue
				Double.parseDouble(s);
				outputQueue.enqueue(s);
			} catch (NumberFormatException e) {
				int ch = s.charAt(0);
				
				//Close parenthesis: Pop stack & send to queue until you find an open parenthesis
				if(ch == 41) {
					while(stack.peek().charAt(0) != 40)
						outputQueue.enqueue(stack.pop());
					stack.pop();
				}
				
				//Operators:
				/*
				 * 1. Pop all stack symbols and send to queue until a symbol of lower precedence (or a right-associative
				 * 	  symbol of equal precedence) appears
				 * 2. Push operator
				 */
				else {
					if(!stack.isEmpty()) {
						//2. Push operator
						if(s.equals("(") || stack.peek().equals("(") || ofHigherPrecedence(s))
							stack.push(s);
						// 1. Pop all stack ...
						else {
							while(!stack.peek().equals("(") && !ofHigherPrecedence(s)) {
								outputQueue.enqueue(stack.pop());
								if(stack.isEmpty())
									break;
							}
							stack.push(s);
						}
					}else {
						stack.push(s);
					}
				}
			}
		}
		while(!stack.isEmpty()) 
			outputQueue.enqueue(stack.pop());
		
		return outputQueue;
	}
	public static boolean ofHigherPrecedence(String str) {
		int str1 = str.charAt(0);
		int str2 = stack.peek().charAt(0);
		if(str1 == 94)
			return true;
		else if ((str1 == 42 || str1 == 47) && (str2 == 43 || str2 == 45))
			return true;
		else if ((str2 == 43 || str2 == 45 ) && (str1 != 43 && str1 != 45))
			return true;
		return false;
	}
}
