class Maine {
    public static void main(String[] args) 
	{
		Document obj = new Document();
		obj.draw();
		obj.print();
    }
}

interface Drawable
{
	void draw();
}

interface Printable
{
	void print();
}

class Document implements Drawable, Printable
{
	@Override
	public void draw() {
		System.out.println("An image is drawn");
	}
	@Override
	public void print() {
		System.out.println("The document is printed");
	}
}
