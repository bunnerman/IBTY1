// import java.io.IOException; // development remnant
import java.text.NumberFormat;
import java.util.*;
import javax.swing.JOptionPane;


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
		
		System.out.println(TextStyle.purple + "----INSTRUCTIONS FOR TEST----");
		System.out.println("a. Enter numbers for MCQs and MRQs");
		System.out.println("b. Enter exact answer, not less not more (strict checking)");
		System.out.println("c. For MRQs, comma separate the values. eg: a, d" + "\n-----------------------------\n" + TextStyle.RESET);


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

		// 7
		obj = new MCQ(
			"\nWhat keyword is used to prevent inheritance of classes in Java?",
			2,
			List.of("static", "abstract", "private", "final"),
			4
		); test.add(obj);

		for (int i = 0; i < test.size(); i++)
		{
			try {
				System.out.print("[Q" + (i + 1) + "] ");
				test.get(i).methodChainer();
			}
			catch (InvalidAnswerException e)
			{
				System.out.println(TextStyle.yellow + "\nERROR: Please enter invalid answer format\n" + TextStyle.RESET);
				i--;
				continue;
			}
			
		}
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
		String temp;
		temp = TextStyle.BOLD + TextStyle.ULINE + q + TextStyle.RESET;
		this.qstn = temp;
		this.marks = m;
	}

	abstract public void display();
	abstract public boolean checkAnswer(String userAnswer);
	abstract public void methodChainer();

	public void evaluate(String attempt)
	{
		if (checkAnswer(attempt))
		{
			System.out.println(TextStyle.green + "CORRECT\n" + TextStyle.RESET);
			McProj.totalMarks += marks;
			McProj.obtainedMarks += marks;
		}
		else
		{	
			McProj.totalMarks += marks;
			System.out.println(TextStyle.red + "WRONG\n" + TextStyle.RESET);
		}
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

// ANSI Color Codes
class TextStyle 
{
    public static final String RESET = "\u001B[0m";
    public static final String red = "\u001B[31m";
    public static final String green = "\u001B[32m";
	public static final String BOLD = "\u001B[1m";
	public static final String ULINE = "\u001B[4m";
	public static final String yellow = "\u001B[33m";
	public static final String purple = "\u001B[35m";
}
