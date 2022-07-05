import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_15686 {

	static int n, m, map[][], ans;
	static boolean[] visit;
	static ArrayList<int[]> house, chicken;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();

		map = new int[n][n];
		house = new ArrayList<>();
		chicken = new ArrayList<>();
		ans = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();

				if (map[i][j] == 1)
					house.add(new int[] { i, j });
				else if (map[i][j] == 2)
					chicken.add(new int[] { i, j });
			}
		}

		visit = new boolean[chicken.size()];

		comb(0, 0);

		System.out.println(ans);

	}

	public static void comb(int idx, int cnt) {

		if (cnt == m) {

			int total = 0;

			for (int i = 0; i < house.size(); i++) {

				int sum = Integer.MAX_VALUE;

				for (int j = 0; j < visit.length; j++) {
					if (visit[j]) {

						sum = Math.min(sum, Math.abs(chicken.get(j)[0] - house.get(i)[0])
								+ Math.abs(chicken.get(j)[1] - house.get(i)[1]));
					}
				}

				total += sum;

			}

			ans = Math.min(ans, total);
			return;
		}

		for (int i = idx; i < chicken.size(); i++) {

			if (!visit[i]) {
				visit[i] = true;
				comb(i + 1, cnt + 1);
				visit[i] = false;
			}

		}

	}

}
