package december;

import java.util.Stack;

public class PrefixToInfix
{
	public static void main(String[] args)
	{
		String exp = "/-ab/*cde";// "ABC*+D-";
		Stack<String> values = new Stack<String>();
		char[] expArr = exp.toCharArray();

		for (int i = exp.length() - 1; i >= 0; i--)
		{
			if (expArr[i] == ' ')
			{
				continue;
			} else if (expArr[i] == '+' || expArr[i] == '-' || expArr[i] == '/' || expArr[i] == '*')
			{
				StringBuffer buf = new StringBuffer("");
				String a = values.pop(), b = values.pop();
				buf.append("(" + a + expArr[i] + b + ")");
				values.push(buf.toString());
			}

			else
			{
				values.push(String.valueOf(expArr[i]));
			}

		}
		System.out.println(values.pop());

	}
}
