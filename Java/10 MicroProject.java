// import java.io.IOException; // development remnant
import java.text.NumberFormat;
import java.util.*;

public class McProj 
{
	public static Scanner sc = new Scanner(System.in); // global variables essentially
	public static String input;
	public static int obtainedMarks = 0;
	public static int totalMarks = 0;

	public static void main(String[] args)
	{
		ArrayList<Question> test = new ArrayList<>();
		Question obj;
		
		// 1
		obj = new MCQ(
			"How much storage does a short int take in C?", 
			2, 
			List.of("4 bits", "1 byte", "3 bytes", "16 bits"), 
			4
		); test.add(obj);

		// 2
		obj = new MRQ(
			"\nWhat were often used as previous names for the current day city of Istanbul?", 
			5, 
			List.of("Byzantine", "Bosphorus", "Constantinople", "Marmara"), 
			new ArrayList<>(List.of(1, 3))); test.add(obj);

		// 3
		obj = new MRQ(
			"\nWhich of the following cities are present in Germany?",
			4,
			List.of("Utrecht", "Bremen", "Berlin", "Dinsmark"),
			new ArrayList<>(List.of(2, 3))
		); test.add(obj);

		// 4
		obj = new TextBased(
			"\nPi upto 5 decimal places",
			3,
			"3.14159"
		); test.add(obj);
		
		// 5
		obj = new TextBased(
			"\nChemical Formula of Hydrogen Peroxide",
			2,
			"H2O2"
		); test.add(obj);

		// 6
		obj = new MRQ(
			"\nWhich of the following are linear data structures?",
			2,
			List.of("Hashmap", "Tree", "Stack", "Graph"),
			new ArrayList<>(List.of(3))
		); test.add(obj);



		for (int i = 0; i < test.size(); i++)
			test.get(i).methodChainer();

		System.out.print(obtainedMarks + "/" + totalMarks + " marks");

		sc.close();
	}
}

abstract class Question 
{
	String qstn;
	int marks;

	public Question(String q, int m)
	{
		this.qstn = q;
		this.marks = m;
	}

	abstract public void display();
	abstract public boolean checkAnswer(String userAnswer);
	abstract public void methodChainer();

	public void evaluate(String attempt)
	{
		McProj.totalMarks += marks;
		if (checkAnswer(attempt))
		{
			System.out.println("CORRECT");
			McProj.obtainedMarks += marks;
		}
		else
			System.out.println("WRONG");
	}

}

abstract class Multiple extends Question
{
	List<String> optns;

	public Multiple(String q, int m, List<String> o)
	{
		super(q, m);
		this.optns = o;
	}

	@Override
	public void display()
	{
		System.out.println(qstn + " (" + marks + " marks)");
		for (int i = 0; i < optns.size(); i++)
			System.out.println((i + 1) + ") " + optns.get(i));
	}

	@Override
	public void methodChainer() {
		this.display();
		McProj.input = McProj.sc.nextLine();
		this.evaluate(McProj.input);
	}
}

class MCQ extends Multiple 
{
	int correctAnswer;
	public MCQ(String q, int m, List<String> o, int c)
	{
		super(q, m, o);
		this.correctAnswer = c;
	}

	@Override
	public boolean checkAnswer(String attempt) 
	{
		attempt = attempt.trim();
		try
		{
			int a = Integer.parseInt(attempt);
			if (a <= 0 || a > optns.size())
				throw new InvalidAnswerException("Invalid Range");

			if (a == correctAnswer)
				return true;
			else
				return false;
		}
		catch (NumberFormatException e)
		{
			throw new InvalidAnswerException("Please enter a number");
		}
	}
}

// unforgiving, no partial marks unless all correct (reason: lowk dont wanna bother)
// sorted, comma, separated, values
class MRQ extends Multiple 
{
	ArrayList<Integer> correctAnswers;
	public MRQ(String q, int m, List<String> o, ArrayList<Integer> c)
	{
		super(q, m, o);
		this.correctAnswers = c;
	}

	@Override
	public boolean checkAnswer(String attempt)
	{
		ArrayList<Integer> attemptList = new ArrayList<>();
		
		String[] attemptsAryLst = attempt.trim().split(",");

		try
		{
			for (String i : attemptsAryLst)
				attemptList.add(Integer.parseInt(i.trim()));
			for (Integer i : attemptList)
				if (i <= 0 || i > optns.size())
					throw new InvalidAnswerException("Invalid Range");
		
			if (attemptList.equals(correctAnswers))
				return true;
			else
				return false;
		}
		catch (NumberFormatException e)
		{
			throw new InvalidAnswerException("Please enter a number");
		}
	}
}

// EXACT answer required, impractical but realistic implementation too complex for an assessment assignment
// handles numbers too, no annoying floating point errors
class TextBased extends Question
{
	String answer;
	
	public TextBased(String q, int m, String c)
	{
		super(q, m);
		this.answer = c;
	}

	@Override
	public void display()
	{
		System.out.print(qstn + " (" + marks + " marks): ");
	}

	@Override 
	public boolean checkAnswer(String attempt)
	{
		if (attempt.length() == 0)
			throw new InvalidAnswerException("No Answer Entered");
		if (attempt.equalsIgnoreCase(answer))
			return true;
		else
			return false;
	}

	@Override
	public void methodChainer() {
		this.display();
		McProj.input = McProj.sc.nextLine();
		this.evaluate(McProj.input);
	}
}	

class InvalidAnswerException extends RuntimeException
{
	public InvalidAnswerException() {
		super();
	}
	public InvalidAnswerException(String msg) {
		super(msg);
	}
}
