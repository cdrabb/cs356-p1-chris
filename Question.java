import java.util.Random;

public class Question {
	private String question, choices;
	private int type;
	public Random rand;
	
	public Question()
	{
		rand = new Random();
		type = rand.nextInt(3);
	}
	public void setQuestion(String question)
	{
		this.question = question;
	}
	public String getQuestion()
	{
		return question;
	}
	public void setChoices(String choices)
	{
		this.choices = choices;
	}
	public String getChoices()
	{
		return choices;
	}
	public int getType()
	{
		return type;
	}
}
