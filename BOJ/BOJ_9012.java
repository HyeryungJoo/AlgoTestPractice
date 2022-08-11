package test;

import java.util.Scanner;
import java.util.Stack;

public class BOJ_9012 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();
		StringBuilder sb = new StringBuilder();

		for (int tc = 0; tc < TC; tc++) {

			Stack<Character> stack = new Stack<>();
			char[] input = sc.next().toCharArray();
			boolean end = false;

			for (int i = 0; i < input.length; i++) {
				if (input[i] == '(')
					stack.add(input[i]);
				else {
					if (stack.isEmpty()) {
						sb.append("NO\n");
						end = true;
						break;
					}
					stack.pop();
				}
			}

			if (!end && stack.isEmpty())
				sb.append("YES\n");
			else if (!end)
				sb.append("NO\n");

		}

		System.out.println(sb.toString());
	}

}
