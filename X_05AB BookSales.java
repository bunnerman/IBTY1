class Example
{
	public static void main (String[] args)
	{
		BookSales obj1 = new BookSales("Arnold Frenken", "History of Mercenaries", "Cascadian Historical Institute", 300, 21237, 600000);
		obj1.allShow();
		BookSales obj2 = new BookSales("Hal Emmerich", "A Guide to Humanoid Robotics", "Benedict Publications", 500, 65463, 53000);
		obj2.allShow();
		BookSales obj3 = new BookSales("Dr. Lakewell", "Pathology & Viruses", "Mercury-2 Publishers", 200, 32444, 7300000);
		obj3.allShow();
	}
}

class Book
{
	String athr;
	String ttl;
	String pblhsr;
}
class BookInfo extends Book
{
	int price;
	int stockPos;
}
class BookSales extends BookInfo
{
	int cpys;
	BookSales(String a, String b, String c, int d, int e, int f)
	{
		this.athr = a;
		this.ttl = b;
		this.pblhsr = c;
		this.price = d;
		this.stockPos = e;
		this.cpys = f;
	}
	void allShow()
	{
		System.out.println("Author: " + this.athr + "\n" + "Title: " + this.ttl + "\n" + "Publisher: " + 
		this.pblhsr + "\n" + "Price: " + this.price + "\n" + "Stock Position: " + this.stockPos + "\n" + 
		"Copies Sold: " + this.cpys + "\n" + "Revenue Generated: " + this.revenueGenerated() + "\n");
	}
	int revenueGenerated()
	{
		return this.cpys * this.price;
	}
}
