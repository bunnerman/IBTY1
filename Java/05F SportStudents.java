class Maine 
{
	public static void main(String[] args)
	{
		SportStudents obj = new SportStudents();
		obj.play("Basketball");
	}
}

class Person
{
	String name;
	int age;
	void walk()
	{
		System.out.println("The person walks.");
	}
}

interface Sport
{
	void play(String spt);
}

class Student extends Person
{
	int rollNo;
}

class SportStudents extends Student implements Sport
{
	@Override
	public void play(String spt)
	{
		System.out.println("The student plays " + spt);
	}
}

