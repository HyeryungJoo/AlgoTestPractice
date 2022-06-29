import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1759 {

	static int l, c;
	static char[] input, result;
	static boolean visit[];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		l = sc.nextInt();
		c = sc.nextInt();

		input = new char[c];
		result = new char[l];
		visit = new boolean[c];

		for (int i = 0; i < c; i++) {
			input[i] = sc.next().charAt(0);
		}

		Arrays.sort(input);
		choose(0, 0);

	}

	public static void choose(int start, int cnt) {

		if (cnt == l) {

			int aeiou = 0;
			int other = 0;
			for (int i = 0; i < l; i++) {
				if (result[i] == 'a' || result[i] == 'e' || result[i] == 'i' || result[i] == 'o' || result[i] == 'u') {
					aeiou++;
				} else
					other++;
			}

			if (aeiou >= 1 && other >= 2) {
				for (int i = 0; i < l; i++)
					System.out.print(result[i]);
				System.out.println();
			}
			return;
		}

		for (int i = start; i < c; i++) {
			if (!visit[i]) {
				visit[i] = true;
				result[cnt] = input[i];
				choose(i + 1, cnt + 1);
				visit[i] = false;
			}
		}
	}
}
