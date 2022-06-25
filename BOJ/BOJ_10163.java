import java.util.Scanner;

public class BOJ_10163 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[][] map = new int[1002][1002];

		for (int i = 1; i <= n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int w = sc.nextInt();
			int h = sc.nextInt();

			for (int k = 1002 - y - h; k < 1002 - y; k++) {
				for (int l = x; l < x + w; l++) {
					map[k][l] = i;
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			int cnt = 0;
			for (int k = 0; k < 1002; k++) {
				for (int l = 0; l < 1002; l++) {
					if (map[k][l] == i)
						cnt++;
				}
			}
			System.out.println(cnt);
		}
	}

}
