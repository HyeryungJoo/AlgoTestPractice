import java.util.Scanner;

public class SWEA_6808 {

	static int g_card[], i_card[], game[], g_win, g_lose;
	static boolean visit[], card[];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {

			g_card = new int[9];
			i_card = new int[9];
			game = new int[9];
			g_win = 0;
			g_lose = 0;
			visit = new boolean[9];
			card = new boolean[19];

			for (int i = 0; i < 9; i++) {
				int num = sc.nextInt();
				g_card[i] = num;
				card[num] = true;
			}

			int idx = 0;
			for (int i = 1; i < 19; i++) {
				if (!card[i]) {
					i_card[idx] = i;
					idx++;
				}
			}

			perm(0);

			System.out.printf("#%d %d %d\n", tc, g_win, g_lose);
		}
	}

	public static void perm(int cnt) {

		if (cnt == 9) {
			int g_score = 0;
			int i_score = 0;

			for (int i = 0; i < 9; i++) {
				if (g_card[i] > game[i])
					g_score += g_card[i] + game[i];
				else if (g_card[i] < game[i])
					i_score += g_card[i] + game[i];
			}

			if (g_score >= i_score)
				g_win++;
			else
				g_lose++;
			return;
		}

		for (int i = 0; i < 9; i++) {
			if (!visit[i]) {
				visit[i] = true;
				game[cnt] = i_card[i];
				perm(cnt + 1);
				visit[i] = false;
			}
		}

	}
}
