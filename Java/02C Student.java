public class Student
{
	int rollNo;
	String name;
	String department;

	public void displayData()
	{
		System.out.println("Roll No: " + rollNo);
		System.out.println("Name: " + name);
		System.out.println("Department: " + department);
		System.out.println();
	}
	public Student()
	{
		rollNo = 0;
		name = "Not Assigned";
		department = "Not Assigned";
		displayData();
	}
	public Student(int a, String b, String c)
	{
		rollNo = a;
		name = b;
		department = c;
		displayData();
	}
	public Student(Student obj)
	{
		rollNo = obj.rollNo;
		name = obj.name;
		department = obj.department;
		displayData();
	}
	public static void main(String[] args) 
	{
		Student obj1 = new Student();
		Student obj2 = new Student(4, "John Doe", "CSE");
		Student obj3 = new Student(obj2);
	}
}
