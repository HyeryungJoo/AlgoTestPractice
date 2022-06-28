import java.util.Scanner;

public class BOJ_10250 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int tc = 0; tc < TC; tc++) {

			int h = sc.nextInt();
			int w = sc.nextInt();
			int n = sc.nextInt();

			int[][] map = new int[h][w];

			for (int i = 0; i < h; i++) {
				for (int j = 1; j <= w; j++) {
					map[i][j - 1] = (h - i) * 100 + j;
				}
			}

			int cnt = 0;
			for (int i = 0; i < w; i++) {
				for (int j = h - 1; j >= 0; j--) {
					cnt++;
					if (cnt == n) {
						System.out.println(map[j][i]);
					}
				}
			}
		}

	}

}
