import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_16236 {

	static int n, map[][], cnt;
	static boolean visit[][];
	static Point now;
	static Queue<Point> small;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();

		map = new int[n][n];
		visit = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();

				if (map[i][j] == 9)
					now = new Point(i, j, 2, 0);

			}
		}

		while (true) {

			small = new LinkedList<>();

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] < now.size && map[i][j] != 0)
						small.add(new Point(i, j, map[i][j], 0));
				}
			}

			if (small.size() == 0)
				break;

			bfs();

		}

		System.out.println(cnt);

	}

	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void bfs() {

		visit[small.peek().x][small.peek().y] = true;

		while (!small.isEmpty()) {

			Point here = small.poll();

			if (here.x == now.x && here.y == now.y) {

				System.out.println(here.cnt);

			}

//			map[here.x][here.y] = 0;
//			now.cnt++;
//
//			if (now.cnt == now.size) {
//				now.cnt = 0;
//				now.size++;
//			}

			for (int k = 0; k < 4; k++) {

				int ni = here.x + di[k];
				int nj = here.y + dj[k];

				if (ni >= 0 && ni < n && nj >= 0 && nj < n && map[ni][nj] <= now.size && !visit[ni][nj]) {
					visit[ni][nj] = true;
					small.add(new Point(ni, nj, map[ni][nj], here.cnt + 1));
				}
			}

		}

	}

	public static class Point {
		int x, y, size, cnt;

		public Point(int x, int y, int size, int cnt) {
			this.x = x;
			this.y = y;
			this.size = size;
			this.cnt = cnt;
		}

	}

}
