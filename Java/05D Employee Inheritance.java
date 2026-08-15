class Maine {
    public static void main(String[] args) 
	{
		Clerk obj1 = new Clerk();
		Manager obj2 = new Manager();
		obj1.getData("Bob", 50000, 200);
		obj2.getData("Tom", 300000, 3000);
		obj1.putData();
		System.out.println();
		obj2.putData();
    }
}

class Employee
{
	String name;
	int salary;
}

class Clerk extends Employee
{
	int bonus;
	void getData(String n, int s, int b)
	{
		this.name = n;
		this.salary = s;
		this.bonus = b;
	}
	void putData()
	{
		System.out.println("Name: " + name + "\nSalary: " + salary + "\nBonus: " + bonus);
	}
}

class Manager extends Employee
{
	int allowance;
	void getData(String n, int s, int a)
	{
		this.name = n;
		this.salary = s;
		this.allowance = a;
	}
	void putData()
	{
		System.out.println("Name: " + name + "\nSalary: " + salary + "\nAllowance: " + allowance);
	}
}
