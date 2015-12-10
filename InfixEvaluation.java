package december;

import java.util.Stack;

public class InfixEvaluation
{
	public static void main(String[] arg) throws Exception
	{
		String expression = "100 * ( 2 + 12 ) / 14";
		Stack<Integer> values = new Stack<Integer>();
		Stack<Character> operator = new Stack<Character>();

		char[] expArr = expression.toCharArray();
		char topOp;
		for (int i = 0; i < expArr.length; i++)
		{
			if (expArr[i] == ' ')
				continue;

			if (expArr[i] >= '0' && expArr[i] <= '9')
			{
				StringBuffer num = new StringBuffer("");
				while (i < expArr.length && expArr[i] >= '0' && expArr[i] <= '9')
				{
					num.append(expArr[i++]);
				}
				values.push(Integer.parseInt(num.toString()));
				i--;
			}

			else if (expArr[i] == '(')
			{
				operator.push(expArr[i]);
			}

			else if (expArr[i] == '+' || expArr[i] == '-' || expArr[i] == '/' || expArr[i] == '*')
			{
				if (!operator.isEmpty())
				{
					topOp = operator.peek();
					while (!operator.isEmpty() && checkPrecedence(expArr[i], topOp))
					{
						int val = evalOp(values.pop(), values.pop(), operator.pop());
						values.push(val);
					}
				}
				operator.push(expArr[i]);
			}

			else if (expArr[i] == ')')
			{
				while (operator.peek() != '(')
				{
					int val = evalOp(values.pop(), values.pop(), operator.pop());
					values.push(val);
				}
				operator.pop();
			}

		}

		while (!operator.isEmpty())
		{
			int val = evalOp(values.pop(), values.pop(), operator.pop());
			values.push(val);
		}

		System.out.println("Answer is :: " + values.pop());
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

	public static int evalOp(int v2, int v1, char op) throws Exception
	{
		switch (op)
		{
			case '+':
				return v1 + v2;
			case '-':
				return v1 - v2;
			case '*':
				return v1 * v2;
			case '/':
				if (v2 == 0)
					throw new Exception("cannot divide by 0");
				else
					return v1 / v2;
			default:
				return 0;

		}
	}

}
