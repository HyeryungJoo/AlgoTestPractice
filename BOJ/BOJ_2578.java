package test;

import java.util.Scanner;

public class BOJ_2578 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int map[][] = new int[5][5];

		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 5; j++)
				map[i][j] = sc.nextInt();

		for (int k = 1; k <= 25; k++) {

			int bingo = 0;

			int now = sc.nextInt();
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (map[i][j] == now)
						map[i][j] = 0;
				}
			}

			for (int i = 0; i < 5; i++) {
				int zero = 0;
				for (int j = 0; j < 5; j++) {
					if (map[i][j] == 0)
						zero++;
				}
				if (zero == 5)
					bingo++;
			}

			for (int i = 0; i < 5; i++) {
				int zero = 0;
				for (int j = 0; j < 5; j++) {
					if (map[j][i] == 0)
						zero++;
				}
				if (zero == 5)
					bingo++;
			}

			int zero = 0;
			for (int i = 0; i < 5; i++) {
				if (map[i][4 - i] == 0)
					zero++;
				if (zero == 5)
					bingo++;
			}

			zero = 0;
			for (int i = 0; i < 5; i++) {
				if (map[i][i] == 0)
					zero++;
				if (zero == 5)
					bingo++;
			}

			if (bingo >= 3) {
				System.out.println(k);
				break;
			}
		}

	}

}
