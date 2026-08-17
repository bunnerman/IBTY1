// saved in a directory called useful, with file name as useme.java
package useful;

public class useme 
{

    public double area(double r) // Circle
	{
        return Math.PI * r * r;
    }
	public int area(int side)
	{
		return side * side;
	}

    public double salary(int base, double increment, int yrs) 
	{
        return base + (increment * yrs);
    }

    public double percentage(double total, double max) 
	{
        return (total / max) * 100;
    }
}
