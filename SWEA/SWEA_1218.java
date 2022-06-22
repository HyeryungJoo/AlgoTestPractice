import java.util.Scanner;
import java.util.Stack;

public class SWEA_1218 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {

			Stack<Character> stack = new Stack<>();

			int n = sc.nextInt();
			String input = sc.next();
			int ans = 1;

			for (int i = 0; i < n; i++) {
				if (ans == 0)
					break;

				if (input.charAt(i) == '(' || input.charAt(i) == '[' || input.charAt(i) == '{'
						|| input.charAt(i) == '<')
					stack.push(input.charAt(i));
				else {
					if (input.charAt(i) == ')' && stack.peek() == '(' || input.charAt(i) == ']' && stack.peek() == '['
							|| input.charAt(i) == '}' && stack.peek() == '{'
							|| input.charAt(i) == '>' && stack.peek() == '<')
						stack.pop();
					else
						ans = 0;
				}
			}

			if (!stack.isEmpty())
				ans = 0;

			System.out.printf("#%d %d\n", tc, ans);
		}

	}

}
