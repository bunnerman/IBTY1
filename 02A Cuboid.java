import java.util.Scanner;

public class Cuboid 
{
  int l, b, h;
  int vol;
}

public void displayVol()
{
  int vol = l * b * h;
  System.out.println("Volume is " + vol);

  Cuboid()
  {
    l = 10;
    b = 10;
    h = 10;
    displayVol();
  }

  Cuboid(int n)
  {
    l = n;
    b = n;
    h = n;
    displayVol();
  }

  Cuboid(int x, int y, int z)
  {
    l = x; 
    b = y;
    h = z;
    displayVol();
  }

  public static void main(String[] args)
  {
    System.out.println("Enter 3 integers: ");
    Scanner sc = new Scanner(System.in);
    int l = sc.nextInt();
    int b = sc.nextInt();
    int h = sc.nextInt();
    Cuboid obj1 = new Cuboid();
    Cuboid obj2 = new Cuboid(l);
    Cuboid obj3 = new Cuboid(l, b, h);
    sc.close();
  }
}

  
  
