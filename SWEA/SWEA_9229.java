import java.util.Scanner;

public class SWEA_9229 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {

			int n = sc.nextInt();
			int m = sc.nextInt();

			int[] w = new int[n];
			int max = -1;
			for (int i = 0; i < n; i++) {
				w[i] = sc.nextInt();
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (i != j && w[i] + w[j] <= m)
						max = Math.max(max, w[i] + w[j]);
				}
			}

			System.out.printf("#%d %d\n", tc, max);
		}
	}

}
