package december;

import java.util.Stack;

public class PrefixToPostFix
{
	public static void main(String[] args)
	{
		String exp = "+-*$4233//84+11";// "42$3*3-84/11+/+";
		Stack<String> values = new Stack<String>();
		char[] expArr = exp.toCharArray();
		char op;
		String a, b;
		for (int i = expArr.length - 1; i >= 0; i--)
		{
			if (expArr[i] >= '0' && expArr[i] <= '9')
			{
				values.push(String.valueOf(expArr[i]));
			} else
			{
				op = expArr[i];
				a = values.pop();
				b = values.pop();
				values.push(a + b + op);
			}
		}

		System.out.println(values.pop());
	}
}
