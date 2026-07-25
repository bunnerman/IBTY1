class Shape
{
	int l = 0;
	int b = 0;
	double r = 0;
	double area = 0;

	public void putData()
	{
		if (b == 0 && r == 0)
			System.out.println("Square has area " + area);
		else if (r == 0)
			System.out.println("Rectangle has area " + area);
		else
			System.out.println("Circle has area " + area);
	}
	public Shape(double n)
	{
		r = n;
		area = n * n * 3.14;
		putData();
	}
	public Shape(int n)
	{
		l = n;
		area = l * l;
		putData();
	}
	public Shape(int x, int y)
	{
		l = x;
		b = y;
		area = l * b;
		putData();
	}
	public Shape(Shape obj)
	{
		l = obj.l;
		b = obj.b;
		r = obj.r;
		area = obj.area;
		putData();
	}

	public static void main(String[] args)
	{
		Shape obj1 = new Shape(5.0);
		Shape obj2 = new Shape(3);
		Shape obj3 = new Shape(4, 6);
		Shape obj4 = new Shape(obj3);
	}
}
