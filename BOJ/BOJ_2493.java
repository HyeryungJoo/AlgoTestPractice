import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2493 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<tower> stack = new Stack<>();

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {

			tower now = new tower(Integer.parseInt(st.nextToken()), i);

			while (!stack.isEmpty() && stack.peek().h < now.h)
				stack.pop();

			if (stack.isEmpty())
				sb.append(0).append(" ");
			else
				sb.append(stack.peek().idx).append(" ");

			stack.push(now);
		}

		System.out.println(sb);
	}

	public static class tower {
		int h;
		int idx;

		tower(int h, int idx) {
			this.h = h;
			this.idx = idx;
		}
	}

}
