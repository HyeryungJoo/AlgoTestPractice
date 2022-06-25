import java.util.Scanner;

public class BOJ_14696 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		for (int r = 0; r < n; r++) {

			int[] a = new int[5];
			int[] b = new int[5];

			int k1 = sc.nextInt();

			for (int i = 0; i < k1; i++)
				a[sc.nextInt()]++;

			int k2 = sc.nextInt();

			for (int i = 0; i < k2; i++)
				b[sc.nextInt()]++;

			char ans = ' ';
			for (int i = 4; i > 0; i--) {
				if (a[i] > b[i]) {
					ans = 'A';
					break;
				} else if (a[i] < b[i]) {
					ans = 'B';
					break;
				}
			}

			if (ans == ' ')
				ans = 'D';

			System.out.println(ans);
		}
	}

}
