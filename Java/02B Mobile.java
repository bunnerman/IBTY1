class Mobile
{
	String companyName;
	String screenSize;

	void putData()
	{
		System.out.println("Company Name: " + companyName);
		System.out.println("Screen Size: " + screenSize);
		System.out.println();
	}
	public Mobile(String name, String scrnsz)
	{
		companyName = name;
		screenSize = scrnsz;
		putData();
	}
	
	public static void main(String[] args) 
	{
		Mobile a = new Mobile("Apple", "580 x 520");
		Mobile b = new Mobile("Samsung", "800 x 340");
		Mobile c = new Mobile("Redmi", "450 x 200");
		Mobile d = new Mobile("1+", "100 x 650");
		Mobile e = new Mobile("Vivo", "399 x 775");
	}
}
