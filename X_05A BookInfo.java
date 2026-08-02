class Example
{
	public static void main (String[] args)
	{
		BookInfo obj1 = new BookInfo("Arnold Frenken", "History of Mercenaries", "Cascadian Historical Institute", 300, 21237);
		obj1.show();
		BookInfo obj2 = new BookInfo("Hal Emmerich", "A Guide to Humanoid Robotics", "Benedict Publications", 500, 65463);
		obj2.show();
		BookInfo obj3 = new BookInfo("Dr. Lakewell", "Pathology & Viruses", "Mercury-2 Publishers", 200, 32444);
		obj3.show();
	}
}

class Book
{
	String author;
	String title;
	String publisher;
}
class BookInfo extends Book
{
	int price;
	int stockPosition;
	BookInfo(String a, String b, String c, int d, int e)
	{
		this.author = a;
		this.title = b;
		this.publisher = c;
		this.price = d;
		this.stockPosition = e;
	}
	void show()
	{
		System.out.println("Author: " + this.author + "\n" + "Title: " + this.title + "\n" + "Publisher: " + 
		this.publisher + "\n" + "Price: " + this.price + "\n" + "Stock Position: " + this.stockPosition + "\n");
	}
}
