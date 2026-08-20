import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

class Maine 
{
    public static void main(String[] args)
	 {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Joining Date (dd-MM-yyyy): ");
        String inputDate = sc.nextLine();

        DateTimeFormatter frmtr = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDate joinDate = LocalDate.parse(inputDate, frmtr);
        LocalDate rn = LocalDate.now();

        Period experience = Period.between(joinDate, rn);

        System.out.println("\nName: " + name + "\nJoining Date: " + joinDate.format(frmtr));
        System.out.println("Total Work Experience: " 
						   	+ experience.getYears() + " Years " 
                           	+ experience.getMonths() + " Months " 
                           	+ experience.getDays() + " Days");
    }
}
