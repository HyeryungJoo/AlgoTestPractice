import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11399 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[] time = new int[n];

		for (int i = 0; i < n; i++) {
			time[i] = sc.nextInt();
		}

		Arrays.sort(time);
		int ans = 0;

		for (int i = 1; i < n; i++) {
			time[i] += time[i - 1];
		}

		for (int i = 0; i < n; i++) {
			ans += time[i];
		}

		System.out.println(ans);
	}

}
