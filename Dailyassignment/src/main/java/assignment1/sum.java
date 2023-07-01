package assignment1;

public class sum {

	public int add(int x, int y) {
		return x + y;

	}

	public static void main(String[] args) {

		sum addnumber = new sum();
		int z = addnumber.add(8, 9);

		System.out.println(z);
	}
}