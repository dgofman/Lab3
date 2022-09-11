package lab3;


public class Queue {

	private static int MAX = 8;
	private static int rows[];
	private static int MAX_COMBINATIONS;
	private static int combinations = 0;
	
	public static void main(String[] args) {
		rows = new int[MAX];
		MAX_COMBINATIONS = -1; // -1 - show ALL possible combinations
		validate(0);
	}

	private static void validate(int row)
	{
		if (MAX_COMBINATIONS == -1 || combinations < MAX_COMBINATIONS) {
			for (rows[row] = 0; rows[row] < MAX; rows[row]++)
			{
				if (isEmpty(row))
				{
					if (row == (MAX - 1)) {
						System.out.println("\ncombination: " + ++combinations);
						for (int i = 0; i < MAX; i++)
							System.out.println("   " + (i + 1) + " x " + (rows[i] + 1));
					} else {
						validate(row + 1);
					}
				}
			}
		}
	}
	
	private static Boolean isEmpty(int i) {
		int j = 0;
		while (rows[i] != rows[j] && Math.abs(rows[i] - rows[j]) != (i - j)) {
			j++;
		}
		return ((i == j) ? true : false);
	}
}
