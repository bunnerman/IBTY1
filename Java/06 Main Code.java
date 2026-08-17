import useful.useme;

public class Maine 
{
    public static void main(String[] args) 
  {
        useme obj = new useme();

        System.out.println("Area of Circle: " + obj.area(5.7) + " units²");
		    System.out.println("Area of Square: " + obj.area(7) + " units²");
        System.out.println("Total Salary: $" + obj.salary(80000, 155.5, 7));
        System.out.println("Percentage: " + obj.percentage(534, 600) + "%");
    }
}
