package test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_16953 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		long a = sc.nextLong();
		long b = sc.nextLong();
		long min = Long.MAX_VALUE;

		Queue<long[]> q = new LinkedList<>();
		q.add(new long[] { a, 0 });

		while (!q.isEmpty()) {

			long[] now = q.poll();

			if (now[0] == b)
				min = Math.min(min, now[1]);
			else if (now[0] < b) {
				q.add(new long[] { now[0] * 2, now[1] + 1 });
				q.add(new long[] { now[0] * 10 + 1, now[1] + 1 });
			}
		}

		if (min == Long.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min + 1);

	}

}
