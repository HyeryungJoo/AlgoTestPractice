import java.util.Scanner;

public class SWEA_1289 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {

			char[] origin = sc.next().toCharArray();
			int[] now = new int[origin.length];
			int cnt = 0;

			for (int i = 0; i < now.length; i++) {
				if (origin[i] - '0' != now[i]) {
					for (int j = i; j < now.length; j++) {
						now[j] = origin[i] - '0';
					}
					cnt++;
				}
			}

			System.out.printf("#%d %d\n", tc, cnt);
		}
	}

}
