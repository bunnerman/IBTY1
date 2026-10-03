class Maine
{
    public static void main(String[] args)
    {
        int[] ary1 = {8, 2, 4, 1, 3, 5, 6, 7, 8};
		int[] ary2 = {5, 2, 8, 2, 8, 3, 7, 3};

		Sumthat obj1 = new Sumthat(); obj1.giveArray(ary1);
		Sumthat obj2 = new Sumthat(); obj2.giveArray(ary2);
		obj1.run(); obj2.run();
    }
}

class Sumthat implements Runnable
{
	int[] array;

	void giveArray(int[] ary)
	{
		this.array = ary;
	}

	@Override 
	public void run()
	{
		int sum = 0;
		for (int i : array)
			sum += i;
		System.out.println("Sum is " + sum);
	}

}
