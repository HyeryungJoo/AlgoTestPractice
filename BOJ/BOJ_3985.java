import java.util.Scanner;

public class BOJ_3985 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int l = sc.nextInt();
		int n = sc.nextInt();

		int[] cake = new int[l + 1];
		int[] result = new int[n + 1];

		int before = 0;
		int after = 0;
		int minus = 0;

		for (int i = 1; i <= n; i++) {
			int from = sc.nextInt();
			int piece = sc.nextInt();

			for (int j = from; j <= piece; j++) {
				if (cake[j] == 0) {
					cake[j] = i;
				}
			}

			if (minus < piece - from) {
				minus = piece - from;
				before = i;
			}
		}

		for (int i = 1; i <= l; i++) {
			result[cake[i]]++;
		}

		int max = 0;
		for (int i = 1; i <= n; i++) {
			if (max < result[i]) {
				after = i;
				max = result[i];
			}
		}

		System.out.println(before + "\n" + after);

	}

}
