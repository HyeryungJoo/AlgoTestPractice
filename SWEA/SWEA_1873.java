import java.util.Scanner;

public class SWEA_1873 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {

			int h = sc.nextInt();
			int w = sc.nextInt();

			char[][] map = new char[h][w];
			int nowi = 0;
			int nowj = 0;

			for (int i = 0; i < h; i++) {
				String input = sc.next();
				for (int j = 0; j < w; j++) {
					map[i][j] = input.charAt(j);
					if (map[i][j] == '<' || map[i][j] == '>' || map[i][j] == '^' || map[i][j] == 'v') {
						nowi = i;
						nowj = j;
					}
				}
			}

			int n = sc.nextInt();
			char[] orders = sc.next().toCharArray();

			for (int i = 0; i < n; i++) {
				if (orders[i] == 'U') {
					map[nowi][nowj] = '^';
					if (nowi - 1 >= 0 && map[nowi - 1][nowj] == '.') {
						map[nowi - 1][nowj] = map[nowi][nowj];
						map[nowi][nowj] = '.';
						nowi -= 1;
					}
				} else if (orders[i] == 'D') {
					map[nowi][nowj] = 'v';
					if (nowi + 1 < h && map[nowi + 1][nowj] == '.') {
						map[nowi + 1][nowj] = map[nowi][nowj];
						map[nowi][nowj] = '.';
						nowi += 1;
					}
				} else if (orders[i] == 'L') {
					map[nowi][nowj] = '<';
					if (nowj - 1 >= 0 && map[nowi][nowj - 1] == '.') {
						map[nowi][nowj - 1] = map[nowi][nowj];
						map[nowi][nowj] = '.';
						nowj -= 1;
					}
				} else if (orders[i] == 'R') {
					map[nowi][nowj] = '>';
					if (nowj + 1 < w && map[nowi][nowj + 1] == '.') {
						map[nowi][nowj + 1] = map[nowi][nowj];
						map[nowi][nowj] = '.';
						nowj += 1;
					}
				} else if (orders[i] == 'S') {
					if (map[nowi][nowj] == '<') {
						for (int j = nowj; j >= 0; j--) {
							if (map[nowi][j] == '*') {
								map[nowi][j] = '.';
								break;
							} else if (map[nowi][j] == '#')
								break;
						}
					} else if (map[nowi][nowj] == '>') {
						for (int j = nowj; j < w; j++) {
							if (map[nowi][j] == '*') {
								map[nowi][j] = '.';
								break;
							} else if (map[nowi][j] == '#')
								break;
						}
					} else if (map[nowi][nowj] == '^') {
						for (int j = nowi; j >= 0; j--) {
							if (map[j][nowj] == '*') {
								map[j][nowj] = '.';
								break;
							} else if (map[j][nowj] == '#')
								break;
						}
					} else if (map[nowi][nowj] == 'v') {
						for (int j = nowi; j < h; j++) {
							if (map[j][nowj] == '*') {
								map[j][nowj] = '.';
								break;
							} else if (map[j][nowj] == '#')
								break;
						}
					}
				}
			}

			System.out.printf("#%d ", tc);
			for (char[] ch : map) {
				for (char c : ch) {
					System.out.print(c);
				}
				System.out.println();
			}
		}

	}

}
