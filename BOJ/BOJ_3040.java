import java.util.Scanner;

public class BOJ_3040 {

	static int num[] = new int[9];
	static int result[] = new int[7];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 9; i++) {
			num[i] = sc.nextInt();
		}

		choose(0, 0);
	}

	public static void choose(int start, int cnt) {

		if (cnt == 7) {

			int sum = 0;
			for (int i = 0; i < 7; i++) {
				sum += result[i];
			}

			if (sum == 100) {
				for (int i = 0; i < 7; i++) {
					System.out.println(result[i]);
				}
			}

			return;
		}

		for (int i = start; i < 9; i++) {
			result[cnt] = num[i];
			choose(i + 1, cnt + 1);
		}

	}

}
