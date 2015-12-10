package december;

import java.util.Stack;

public class PostFixToPreFix
{

	public static void main(String[] args)
	{
		String exp = "42$3*3-84/11+/+";// "ABC*+D-";
		Stack<String> values = new Stack<String>();
		char[] expArr = exp.toCharArray();
		char op;
		String a, b;
		for (int i = 0; i < expArr.length; i++)
		{
			if (expArr[i] >= '0' && expArr[i] <= '9')
			{
				values.push(String.valueOf(expArr[i]));
			} else
			{
				op = expArr[i];
				b = values.pop();
				a = values.pop();
				values.push(op + a + b);
			}
		}

		System.out.println(values.pop());
	}
}
