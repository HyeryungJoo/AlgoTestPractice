import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2309 {

	static int[] result, tall;
	static boolean visit[];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		tall = new int[9];
		result = new int[7];
		visit = new boolean[9];

		for (int i = 0; i < 9; i++) {
			tall[i] = sc.nextInt();
		}

		comb(0, 0);
	}

	public static void comb(int start, int cnt) {

		if (cnt == 7) {

			int sum = 0;
			for (int i = 0; i < 7; i++)
				sum += result[i];

			if (sum == 100) {
				Arrays.sort(result);
				for (int n : result) {
					System.out.println(n);
				}
				System.exit(0);
			}
			return;
		}

		for (int i = 0; i < 9; i++) {
			if (!visit[i]) {
				visit[i] = true;
				result[cnt] = tall[i];
				comb(i + 1, cnt + 1);
				visit[i] = false;
			}
		}
	}

}
