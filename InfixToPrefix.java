package december;

import java.util.Stack;

/**
 * Created by Aniket on 2/23/14.
 */
public class InfixToPrefix
{

	public static void main(String args[])
	{
		String exp = "(a-b)/(c*d/e)";// "((a+b)*(y+z+x))";

		// String exp = "(A+B)*C-D";
		Stack<String> preFix = new Stack<String>();
		Stack<Character> operator = new Stack<Character>();
		char[] expArr = exp.toCharArray();
		char topOp;
		for (int i = 0; i < exp.length(); i++)
		{

			if (expArr[i] == ' ')
			{
				continue;
			}

			else if (expArr[i] == '+' || expArr[i] == '-' || expArr[i] == '/' || expArr[i] == '*')
			{
				if (!operator.isEmpty())
				{
					while (!operator.isEmpty() && checkPrecedence(expArr[i], operator.peek()))
					{
						String op2 = preFix.pop(), op1 = preFix.pop();
						preFix.push(String.valueOf(operator.pop()) + op1 + op2);
					}
				}
				operator.push(expArr[i]);
			}

			else if (expArr[i] == '(')
			{
				operator.push(expArr[i]);
			}

			else if (expArr[i] == ')')
			{
				while (operator.peek() != '(')
				{
					String op2 = preFix.pop(), op1 = preFix.pop();
					preFix.push(String.valueOf(operator.pop()) + op1 + op2);
				}
				operator.pop();
			}

			else
			{
				preFix.push(String.valueOf(expArr[i]));
			}

		}

		while (!operator.isEmpty())
		{
			String op2 = preFix.pop(), op1 = preFix.pop();
			preFix.push(String.valueOf(operator.pop()) + op1 + op2);
		}

		while (!preFix.isEmpty())
		{
			System.out.print(preFix.pop());
		}

	}

	public static boolean checkPrecedence(char op1, char op2)
	{
		if (op2 == '(')
			return false;
		else if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
			return false;
		else
			return true;
	}
}
