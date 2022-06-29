import java.util.Scanner;

public class BOJ_10974 {

	static int n, num[], result[];
	static boolean visit[];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();

		num = new int[n];
		result = new int[n];
		visit = new boolean[n];

		for (int i = 1; i <= n; i++)
			num[i - 1] = i;

		perm(0);
	}

	public static void perm(int cnt) {

		if (cnt == n) {
			for (int r : result)
				System.out.print(r + " ");
			System.out.println();
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!visit[i]) {
				visit[i] = true;
				result[cnt] = num[i];
				perm(cnt + 1);
				visit[i] = false;
			}
		}
	}
}
