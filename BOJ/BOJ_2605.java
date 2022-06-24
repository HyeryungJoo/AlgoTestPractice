import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BOJ2605 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		List<Integer> num = new LinkedList<>();
		num.add(0, 0);
		for (int i = 1; i <= n; i++) {
			num.add(i - sc.nextInt(), i);
		}

		for (int i = 1; i <= n; i++) {

			System.out.print(num.get(i) + " ");
		}

	}

}
