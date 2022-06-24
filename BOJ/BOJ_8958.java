import java.util.Scanner;

public class BOJ_8958 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			char[] input = sc.next().toCharArray();

			int score = 0;
			int cnt = 0;

			for (int j = 0; j < input.length; j++) {
				if (input[j] == 'O') {
					score += cnt + 1;
					cnt++;
				} else
					cnt = 0;
			}

			System.out.println(score);
		}
	}

}
