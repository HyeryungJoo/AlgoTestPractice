import java.util.Arrays;
import java.util.Scanner;

public class JO_1828 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int cnt = 1;
		Fri[] virus = new Fri[n];

		for (int i = 0; i < n; i++)
			virus[i] = new Fri(sc.nextInt(), sc.nextInt());

		Arrays.sort(virus);

		int now = virus[0].high;

		for (int i = 0; i < n; i++) {

			if (virus[i].low > now) {
				cnt++;
				now = virus[i].high;
			}
		}

		System.out.println(cnt);

	}

	static class Fri implements Comparable<Fri> {
		int low, high;

		public Fri(int low, int high) {
			this.low = low;
			this.high = high;
		}

		@Override
		public int compareTo(Fri o) {
			return this.high - o.high;
		}
	}
}
