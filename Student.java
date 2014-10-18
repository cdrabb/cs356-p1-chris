import java.util.Random;


public class Student {
	private String id, answer, answer2;
	private IClickerService service;
	Random rand;
	
	public Student(int id, IClickerService service)
	{
		this.id = id + "";
		this.service = service;
	}
	public void setID(String id)
	{
		this.id = id;
	}
	public String getID()
	{
		return id;
	}
	public void setAnswer(int answer)
	{
		service.submitAnswer(answer);
		this.answer = answer + "";
	}
	public String getAnswer()
	{
		return answer;
	}
	public void setAnswer2(int answer)
	{
		if(!getAnswer().equalsIgnoreCase(answer+""))
		{
			service.submitAnswer2(answer);
			this.answer2 = answer + "";
		}
	}
	public String getAnswer2()
	{
		return answer2;
	}
}
