import java.util.Random;

public class Question {
	private String question, choices, answer, answer2;
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
	public void setAnswer(String string) {
		answer = string;
	}

	public void setAnswers(String string, String string2) {
		answer = string;
		answer2 = string2;
	}
	public String getAnswer() {
		return answer;
	}
	public String getAnswer2() {
		return answer2;
	}
}
