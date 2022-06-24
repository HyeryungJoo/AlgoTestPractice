import java.util.Scanner;

public class BOJ_1592 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int l = sc.nextInt();
		int cnt = 0;
		int turn = 0;
		boolean isEnd = false;

		int[] count = new int[n];
		while (true) {

			count[turn]++;
			cnt++;
			if (count[turn] % 2 == 1) {
				turn += l;
				turn %= n;
			} else if (count[turn] % 2 == 0) {
				if (turn < l)
					turn = n - l + turn;
				else
					turn -= l;
			}

			for (int i = 0; i < count.length; i++) {
				if (count[i] == m)
					isEnd = true;
			}

			if (isEnd)
				break;

		}

		System.out.println(cnt - 1);
	}

}
