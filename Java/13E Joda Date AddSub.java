import java.util.Scanner;
import org.joda.time.*;
import org.joda.time.format.*;
// import java.time.*;
// import java.time.format.DateTimeFormatter;

class Maine
{
    public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter frmtr = DateTimeFormat.forPattern("dd-MM-yyyy");
		System.out.print("Enter Date (dd-mm-YYYY): ");
		String s = sc.nextLine();
		LocalDate date = LocalDate.parse(s, frmtr);
		
		System.out.print("Enter Days, Months and Years to add/subtract: ");
		int dd = sc.nextInt();
		int mnth = sc.nextInt();
		int yr = sc.nextInt();

		
		LocalDate add = date.plusDays(dd).plusMonths(mnth).plusYears(yr);
		LocalDate sub = date.minusDays(dd).minusMonths(mnth).minusYears(yr);
		
		System.out.println("Addition: " + add.toString(frmtr));
		System.out.println("Subtraction: " + sub.toString(frmtr));

	}
}
		
