package december;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class InfixToPostFix
{
	public static void main(String[] args)
	{
		String exp = "(A+B)*C-D";
		Queue<String> postFix = new LinkedList<String>();
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
					topOp = operator.peek();
					while (!operator.isEmpty() && checkPrecedence(expArr[i], topOp))
					{
						postFix.add(String.valueOf(operator.pop()));
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
					postFix.add(String.valueOf(operator.pop()));
				}
				operator.pop();
			}

			else
			{
				postFix.add(String.valueOf(expArr[i]));
			}

		}

		while (!operator.isEmpty())
		{
			postFix.add(String.valueOf(operator.pop()));
		}

		Iterator<String> it = postFix.iterator();
		while (it.hasNext())
		{
			System.out.print(it.next());
		}
	}

	public static boolean checkPrecedence(char op1, char op2)
	{
		if (op2 == '(' || op2 == ')')
			return false;
		else if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
			return false;
		else
			return true;
	}
}
