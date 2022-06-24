import java.util.Scanner;

public class BOJ_2999 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String str = sc.next();
		int r = 0;
		int c = 0;

		for (int i = 1; i <= str.length(); i++) {
			for (int j = 1; j <= str.length(); j++) {
				if (i * j == str.length() && i <= j) {
					r = i;
					c = j;
				}
			}
		}

		char[][] secret = new char[c][r];
		int k = 0;

		for (int i = 0; i < c; i++) {
			for (int j = 0; j < r; j++) {
				secret[i][j] = str.charAt(k);
				k++;
			}
		}

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(secret[j][i]);
			}
		}
	}

}
