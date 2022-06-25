import java.util.Scanner;

public class BOJ_10157 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int c = sc.nextInt();
		int r = sc.nextInt();
		int k = sc.nextInt();

		if (r * c < k) {
			System.out.println(0);
			System.exit(0);
		}

		int[][] map = new int[r][c];

		int[] di = { -1, 0, 1, 0 };
		int[] dj = { 0, 1, 0, -1 };

		int nowi = r;
		int nowj = 0;

		int d = 0;
		int cnt = 1;
		while (cnt <= c * r) {
			int ni = nowi + di[d];
			int nj = nowj + dj[d];

			if (ni >= 0 && ni < r && nj >= 0 && nj < c && map[ni][nj] == 0) {
				map[ni][nj] = cnt;
				cnt++;
				nowi = ni;
				nowj = nj;
			} else {
				d++;
				d %= 4;
			}
		}

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] == k)
					System.out.println((j + 1) + " " + (r - i));
			}
		}
	}

}
