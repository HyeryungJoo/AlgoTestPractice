import java.util.Scanner;

public class BOJ_2941 {

	public static void main(String[] args) {

		String[] cro = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };

		Scanner sc = new Scanner(System.in);
		String str = sc.next();

		int ans = 0;
		for (String c : cro) {
			if (str.contains(c)) {
				str = str.replace(c, "!");
			}
		}

		System.out.println(str.length());
	}

}
