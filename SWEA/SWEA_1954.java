import java.util.Scanner;

public class SWEA_1954 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {

			int n = sc.nextInt();
			int[][] map = new int[n][n];

			int[] ki = { 0, 1, 0, -1 };
			int[] kj = { 1, 0, -1, 0 };

			int num = 1;
			int nowi = 0;
			int nowj = 0;
			int k = 0;

			while (true) {

				map[nowi][nowj] = num;

				if (num == n * n)
					break;

				int nexti = nowi + ki[k];
				int nextj = nowj + kj[k];
				if (nexti < 0 || nexti >= n || nextj < 0 || nextj >= n || map[nexti][nextj] != 0) {
					k++;
					k %= 4;
					continue;
				}

				nowi = nexti;
				nowj = nextj;
				num++;
			}

			System.out.println("#" + tc);
			for (int[] nums : map) {
				for (int ans : nums) {
					System.out.print(ans + " ");
				}
				System.out.println();
			}

		}
	}

}
