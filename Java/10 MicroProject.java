import java.util.*;

public class McProj 
{
	public static void main(String[] args)
	{

	}
}

abstract class Question 
{
	String question;
	int marks;
	abstract public boolean checkAnswer(String userAnswer);
}

abstract class Multiple extends Question
{
	int n; // number of options
	ArrayList<String> optns;
}

class MCQ extends Multiple 
{

}

class MRQ extends Multiple
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

class InvalidAnswerException extends RuntimeException
{
	public InvalidAnswerException() {
		super();
	}
	public InvalidAnswerException(String msg) {
		super(msg);
	}
}
