import java.util.Hashtable;
import java.util.Random;


public class SimulationDriver {

	private Random rand;
	private int numberOfStudents;
	private IClickerService service;
	Hashtable<String, Student> students;
	private Question question;
	
	public static void main(String args [])
	{
		SimulationDriver driver = new SimulationDriver();
		driver.rand = new Random();
		driver.question = new Question();
		driver.service = new IClickerService(driver.question.getType());
		driver.students = new Hashtable<String, Student>();
		
		if(driver.question.getType() == 0)
			driver.TrueOrFalse();
		else if(driver.question.getType() == 1)
			driver.MultipleChoice();
		else
			driver.MultipleAnswer();
		
		driver.generateStudents();
		
		System.out.println(driver.question.getQuestion());
		System.out.println(driver.question.getChoices());
		
		driver.submitAnswers();
		
		driver.service.displayResults();
	}
	public void generateStudents()
	{
		numberOfStudents = rand.nextInt(30) + 10;
		System.out.println("Number of Students: " + numberOfStudents + "\n");
		
		for(int i = 0; i < numberOfStudents; i++)
		{
			Student student = new Student(i, service);
			students.put(student.getID(), student);
		}
	}
	public void submitAnswers()
	{	
		for(int i = 0; i < getNumberOfStudents(); i++)
		{
			if(question.getType() == 0)
				students.get(i+"").setAnswer(rand.nextInt(2)+1);
			
			else if(question.getType() == 1)
				students.get(i+"").setAnswer(rand.nextInt(4)+1);
			
			else
			{
				students.get(i+"").setAnswer(rand.nextInt(4)+1);
				students.get(i+"").setAnswer2(rand.nextInt(4)+1);
			}
		}
	}
	public int getNumberOfStudents()
	{
		return numberOfStudents;
	}
	public void TrueOrFalse()
	{
		question.setQuestion("Right or Wrong?: House cats belong to the Canine family.");
		question.setChoices("1) Right		2) Wrong");
		service.setAnswer("2) Wrong");
	}
	public void MultipleChoice()
	{
		question.setQuestion("Which of these does NOT belong?");
		question.setChoices("A) Banana		B) Stapler\nC) Paper		D) Pencil");
		service.setAnswer("A");
	}
	public void MultipleAnswer()
	{
		question.setQuestion("Which of these words are Java keywords?");
		question.setChoices("A) public		B) int\nC) charge		D) pick");
		service.setAnswers("A", "B");
	}
}
