import java.io.IOException;
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
			System.out.println("Correct Answer!");
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
		System.out.println(this.qstn + " (" + this.marks + " marks)");
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
		try
		{
			if (Integer.parseInt(attempt) == correctAnswer)
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
class MRQ extends Multiple // unforgiving, no partial marks unless all correct (reason: lowk dont wanna bother)
{

}

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
