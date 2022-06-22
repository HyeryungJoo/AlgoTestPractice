import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1208 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {

			int[] box = new int[100];
			int n = sc.nextInt();

			for (int i = 0; i < 100; i++) {
				box[i] = sc.nextInt();
			}

			for (int i = 0; i < n; i++) {
				Arrays.sort(box);
				box[99]--;
				box[0]++;
				if (box[99] == box[0])
					break;
			}

			Arrays.sort(box);
			int ans = box[99] - box[0];

			System.out.printf("#%d %d\n", tc, ans);
		}
	}

}
