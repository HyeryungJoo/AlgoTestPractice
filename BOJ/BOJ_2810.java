import java.util.Scanner;

public class BOJ_2810 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String input = sc.next();

		String[] holder = { "S", "LL" };
		for (String str : holder) {
			if (input.contains(str))
				input = input.replace(str, "*" + str);
		}

		input += "*";
		char[] seat = input.toCharArray();
		int cnt = 0;
		String output = "";

		for (int i = 0; i < seat.length; i++) {
			if (seat[i] == 'S') {
				if (seat[i - 1] == '*') {
					output += "!";
					seat[i - 1] = 'x';
				} else if (input.charAt(i + 1) == '*') {
					output += "!";
					seat[i + 1] = 'x';
				}
			} else if (seat[i] == 'L') {
				if (seat[i - 1] == '*') {
					output += "!";
					seat[i - 1] = 'x';
				} else if (seat[i + 1] == '*') {
					output += "!";
					seat[i + 1] = 'x';
				}
			} else
				output += seat[i];
		}

		for (int i = 0; i < output.length(); i++) {
			if (output.charAt(i) == '!')
				cnt++;
		}
		System.out.println(cnt);
	}

}
