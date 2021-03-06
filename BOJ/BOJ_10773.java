import java.util.Scanner;
import java.util.Stack;

public class BOJ_10773 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < n; i++) {
			int now = sc.nextInt();
			if (now == 0)
				stack.pop();
			else
				stack.push(now);
		}

		int sum = 0;
		while (!stack.isEmpty())
			sum += stack.pop();

		System.out.println(sum);
	}

}
