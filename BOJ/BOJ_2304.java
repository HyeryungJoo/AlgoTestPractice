import java.util.Scanner;

public class BOJ_2304 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] map = new int[1001];
		int max = 0;
		int max_idx = 1000;
		int sum = 0;

		for (int i = 0; i < n; i++) {
			int idx = sc.nextInt();
			map[idx] = sc.nextInt();

			if (max <= map[idx]) {
				max = map[idx];
				max_idx = idx;
			}
		}

		// 고점까지 합하기
		int now = 0;
		for (int i = 1; i <= max_idx; i++) {
			if (map[i] > now)
				now = map[i];
			else
				map[i] = now;

			sum += map[i];
		}

		// 내려가기
		now = 0;
		for (int i = 1000; i > max_idx; i--) {
			if (map[i] > now)
				now = map[i];
			else
				map[i] = now;

			sum += map[i];
		}

		System.out.println(sum);
	}

}
