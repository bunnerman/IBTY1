import java.util.Scanner;
// import org.joda.time.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

class Maine
{
    public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Date (dd-mm-YYYY): ");
		String s = sc.nextLine();
		
		DateTimeFormatter frmtr = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate date = LocalDate.parse(s, frmtr);

		System.out.print("Year: " + date.getYear() + "\nMonth: " + date.getMonth() + "\nDate: " + date.getDayOfMonth() + "\nDay: " + date.getDayOfWeek());
	}
}
		
