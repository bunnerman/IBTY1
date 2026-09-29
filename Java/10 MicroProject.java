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
			"What is the capital of Morocco?", 
			5, 
			List.of("Athens", "Ibirsh", "Cairo", "Rabat"), 
			4
		);
		test.add(obj);

		// 2
		obj = new MRQ(
			"\nWhat were often used as previous names for the current day city of Istanbul?", 
			10, 
			List.of("Byzantine", "Bosphorus", "Constantinople", "Alendal"), 
			new ArrayList<>(List.of(1, 3)));
		test.add(obj);

		// 3
		obj = new MRQ(
			"\nWhich of the following cities are present in Germany?",
			4,
			List.of("Utrecht", "Bremen", "Berlin", "Dinsmark"),
			new ArrayList<>(List.of(2, 3))
		);
		test.add(obj);

		// 4
		

		for (int i = 0; i < test.size(); i++)
		{
			test.get(i).methodChainer();
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
		McProj.input = McProj.sc.next();
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

class MRQ extends Multiple 
// unforgiving, no partial marks unless all correct (reason: lowk dont wanna bother)
// sorted,comma,separated,no-space,values
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

/*
abstract class TextBased
{
	
}

class Numerical extends TextBased
{

}

class TextAnswer extends TextBased
{

}
*/

class InvalidAnswerException extends RuntimeException
{
	public InvalidAnswerException() {
		super();
	}
	public InvalidAnswerException(String msg) {
		super(msg);
	}
}
