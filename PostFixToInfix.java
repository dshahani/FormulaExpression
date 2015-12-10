package december;

import java.util.Stack;

public class PostFixToInfix
{
	public static void main(String[] args)
	{
		String exp = "AB+C*D-";// "ABC*+D-";
		Stack<String> values = new Stack<String>();
		char[] expArr = exp.toCharArray();

		for (int i = 0; i < expArr.length; i++)
		{

			if (expArr[i] == ' ')
			{
				continue;
			}

			else if (expArr[i] == '+' || expArr[i] == '-' || expArr[i] == '/' || expArr[i] == '*')
			{
				StringBuffer buf = new StringBuffer("");
				String b = values.pop(), a = values.pop();
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
