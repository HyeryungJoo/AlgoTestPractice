import java.util.Scanner;

public class BOJ_3052 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[] mod = new int[42];

		for (int i = 0; i < 10; i++) {
			int n = sc.nextInt();

			mod[n % 42]++;
		}

		int ans = 0;
		for (int i = 0; i < 42; i++) {
			if (mod[i] != 0)
				ans++;
		}

		System.out.println(ans);
	}

}
