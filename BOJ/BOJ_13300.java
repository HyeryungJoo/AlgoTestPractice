import java.util.Scanner;

public class BOJ_13300 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();

		int[] m = new int[7];
		int[] f = new int[7];

		for (int i = 0; i < n; i++) {
			int s = sc.nextInt();

			if (s == 0)
				f[sc.nextInt()]++;
			else
				m[sc.nextInt()]++;
		}

		int cnt = 0;
		for (int i = 1; i <= 6; i++) {
			if (m[i] <= k && m[i] != 0)
				cnt++;
			else {
				cnt += m[i] / k;
				if (m[i] % k > 0)
					cnt++;
			}

			if (f[i] <= k && f[i] != 0)
				cnt++;
			else {
				cnt += f[i] / k;
				if (f[i] % k > 0)
					cnt++;
			}
		}

		System.out.println(cnt);
	}

}
