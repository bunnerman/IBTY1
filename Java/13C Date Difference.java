import java.util.Scanner;
// import org.joda.time.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

class Maine
{
    public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter DOB (dd-mm-YYYY): ");
		String s = sc.nextLine();
		
		DateTimeFormatter frmtr = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate dob = LocalDate.parse(s, frmtr);

		Period age = Period.between(dob, LocalDate.now());

		System.out.print("Current Age: " + age.getYears() + " years " + age.getMonths() + " months " + age.getDays() + " days ");
    }
}
