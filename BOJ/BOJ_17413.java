import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_17413 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		char[] input = br.readLine().toCharArray();
		boolean isTag = false;

		for (int i = 0; i < input.length; i++) {

			if (input[i] == '<') {

				System.out.print(sb.reverse());
				sb = new StringBuilder();
				sb.append(input[i]);
				isTag = true;
			} else if (input[i] == '>') {

				isTag = false;
				sb.append(input[i]);
				System.out.print(sb.toString());
				sb = new StringBuilder();
			} else if (input[i] == ' ' && !isTag) {

				System.out.print(sb.reverse() + " ");
				sb = new StringBuilder();
			} else
				sb.append(input[i]);
		}

		System.out.println(sb.reverse());
	}

}
