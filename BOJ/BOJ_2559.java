import java.util.Scanner;

public class BOJ_2559 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();

		int[] tem = new int[n];
		int[] sum = new int[n + 1];

		for (int i = 0; i < n; i++) {
			tem[i] = sc.nextInt();
			sum[i + 1] = sum[i] + tem[i];
		}

		int ans = Integer.MIN_VALUE;

		for (int i = k; i <= n; i++) {
			ans = Math.max(ans, sum[i] - sum[i - k]);
		}

		System.out.println(ans);
	}

}
