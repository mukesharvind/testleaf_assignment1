package assignment1;

public class SqrtRoot3 {

	public int sqrt(int x) {
		return x;

	}

	public static void main(String[] args) {

		SqrtRoot3 root = new SqrtRoot3();
		{
			int i = root.sqrt(5);
			int d = (int) Math.pow(i, 0.5);
			System.out.println(d);

		}
	}
}
