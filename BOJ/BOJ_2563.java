import java.util.Scanner;

public class BOJ_2563 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[][] map = new int[101][101];

		for (int i = 0; i < n; i++) {

			int y = sc.nextInt();
			int x = sc.nextInt();

			for (int p_x = 90 - x; p_x < 100 - x; p_x++) {
				for (int p_y = y; p_y < y + 10; p_y++) {
					map[p_x][p_y] = 1;
				}
			}
		}

		int result = 0;
		for (int[] num : map) {
			for (int ans : num) {
				result += ans;
			}
		}

		System.out.println(result);
	}

}
