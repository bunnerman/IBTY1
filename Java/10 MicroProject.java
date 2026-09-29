// import java.io.IOException; // development remnant
import java.text.NumberFormat;
import java.util.*;

public class McProj 
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		List<String> op = List.of("Athens", "Ibirsh", "Cairo", "Rabat");
		MCQ obj = new MCQ("What is the capital of Morocco?", 5, op, 4);
		obj.display();
		String n = sc.next();
		obj.evaluate(n);

		List<String> op2 = List.of("Byzantine", "Bosphorus", "Constantinople", "Alendal");
		ArrayList<Integer> corOp2 = new ArrayList<>(List.of(1, 3));
		MRQ obj2 = new MRQ("\nWhat were often used as previous names for the current day city of Istanbul?", 10, op2, corOp2);
		obj2.display();
		n = sc.next();
		obj2.evaluate(n);

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

	public void evaluate(String attempt)
	{
		if (checkAnswer(attempt))
			System.out.println("CORRECT");
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
		int a = Integer.parseInt(attempt);
		if (a <= 0 || a > optns.size())
			throw new InvalidAnswerException("Invalid Range");
		try
		{
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
// comma,separated,no-space,values
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
