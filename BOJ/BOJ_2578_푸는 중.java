import java.util.Scanner;

public class BOJ_2578 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[][] map = new int[5][5];
		boolean isEnd = false;

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		int ans = 0;
		for (int k = 0; k < 25; k++) {
			int target = sc.nextInt();
			ans++;

			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (map[i][j] == target)
						map[i][j] = 0;
				}
			}

			int cnt = 0;

			for (int i = 0; i < 5; i++) {

				boolean bingo1, bingo2, bingo3, bingo4;
				bingo1 = bingo2 = bingo3 = bingo4 = false;

				for (int j = 0; j < 5; j++) {
					if ((bingo1 && map[i][j] == 0) || (map[i][j] == 0 && j == 0))
						bingo1 = true;
					else
						bingo1 = false;

					if ((bingo2 && map[j][i] == 0) || (map[j][i] == 0 && j == 0))
						bingo2 = true;
					else
						bingo2 = false;

					if (i == j && ((map[i][j] == 0 && bingo3) || (map[i][j] == 0 && i == 0)))
						bingo3 = true;
					else
						bingo3 = false;
					if (i + j == 4 && ((map[i][j] == 0 && bingo4) || (map[i][j] == 0 && i == 0)))
						bingo4 = true;
					else
						bingo4 = false;
				}

				if (bingo1)
					cnt++;
				if (bingo2)
					cnt++;
				if (bingo3)
					cnt++;
				if (bingo4)
					cnt++;

				if (cnt >= 3)
					isEnd = true;
			}

			if (isEnd)
				break;
		}

		System.out.println(ans);
	}

}
