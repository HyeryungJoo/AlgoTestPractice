package test;

import java.util.Scanner;

public class BOJ_9655 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int cnt = 0;

		while (n != 0) {
			if (n >= 3)
				n -= 3;
			else
				n--;
			cnt++;
		}

		if (cnt % 2 == 0)
			System.out.println("CY");
		else
			System.out.println("SK");
	}

}
