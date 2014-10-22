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
		/*All of the classes are initialized and readied for use*/
		SimulationDriver driver = new SimulationDriver();
		driver.rand = new Random();
		driver.question = new Question();
		driver.service = new IClickerService(driver.question);
		driver.students = new Hashtable<String, Student>();
		
		/*Question type is set*/
		if(driver.question.getType() == 0)
			driver.TrueOrFalse();
		else if(driver.question.getType() == 1)
			driver.MultipleChoice();
		else
			driver.MultipleAnswer();
		
		/*The hashtable is filled with student objects*/
		driver.generateStudents();
		
		/*Question and choices are written to the screen*/
		System.out.println(driver.question.getQuestion());
		System.out.println(driver.question.getChoices());
		
		/*Student answers are set, submitted, and displayed*/
		driver.setAnswers();
		driver.submitAnswers();
		driver.service.displayResults();
	}
	/*Random number of students are generated and entered into 
	  a hashtable with their unique ID as a key.*/
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
	/*Student answers are randomly set, but are not yet submitted to the iClicker service*/
	public void setAnswers()
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
	/*Student answers are submitted to the iClicker service*/
	public void submitAnswers()
	{	
		for(int i = 0; i < getNumberOfStudents(); i++)
		{
			if(question.getType() == 0)
				students.get(i+"").submitAnswer(rand.nextInt(2)+1);
			
			else if(question.getType() == 1)
				students.get(i+"").submitAnswer(rand.nextInt(4)+1);
			
			else
			{
				students.get(i+"").submitAnswer(rand.nextInt(4)+1);
				students.get(i+"").submitAnswer2(rand.nextInt(4)+1);
			}
		}
	}

	public int getNumberOfStudents()
	{
		return numberOfStudents;
	}
	
	/*Question types, choices, and answers*/
	public void TrueOrFalse()
	{
		question.setQuestion("Right or Wrong?: House cats belong to the Canine family.");
		question.setChoices("1) Right		2) Wrong");
		question.setAnswer("2) Wrong");
	}
	public void MultipleChoice()
	{
		question.setQuestion("Which of these does NOT belong?");
		question.setChoices("A) Banana		B) Stapler\nC) Paper		D) Pencil");
		question.setAnswer("A");
	}
	public void MultipleAnswer()
	{
		question.setQuestion("Which of these words are Java keywords?");
		question.setChoices("A) public		B) int\nC) charge		D) pick");
		question.setAnswers("A", "B");
	}
}
