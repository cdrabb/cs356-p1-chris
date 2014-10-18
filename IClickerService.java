
public class IClickerService {

	private int numberOfAnswers, a, b, c, d, right, wrong, type, sumOfVotes;
	private String answer, answer2;
	
	public IClickerService(int type) {
		this.type = type;
		
		if(type == 2)
			setNumberOfAnswers(2);
		else
			setNumberOfAnswers(1);
	}
	public void submitAnswer(int answer)
	{
		if(type == 0)
		{
			if(answer == 1)
				right++;
			else if(answer == 2)
				wrong++;
		}
		else
		{
			if(answer == 1)
				a++;
			else if(answer == 2)
				b++;
			else if(answer == 3)
				c++;
			else if(answer == 4)
				d++;
		}
	}
	public void submitAnswer2(int answer)
	{
		if(answer == 1)
			a++;
		else if(answer == 2)
			b++;
		else if(answer == 3)
			c++;
		else if(answer == 4)
			d++;
	}

	public void setAnswer(String string) {
		answer = string;
	}

	public void setAnswers(String string, String string2) {
		answer = string;
		answer2 = string2;
	}
	public void setNumberOfAnswers(int num)
	{
		numberOfAnswers = num;
	}
	public int getNumberOfAnswers()
	{
		return numberOfAnswers;
	}
	public void sum()
	{
		sumOfVotes = a + b + c + d + right + wrong;
	}
	public int getSum()
	{
		if(sumOfVotes > 0)
			return sumOfVotes;
		return 0;
	}
	public void displayResults()
	{
		sum();
		if(type == 0)
			System.out.println("\nYou voted and " + getSum() + " votes were cast...\n1) Right: " + right + "\n2) Wrong: " + wrong);
		else
			System.out.println("\nYou voted and " + getSum() + " votes were cast...\nA: " + a + "\nB: " + b + "\nC: " + c + "\nD: " + d);
		
		if(numberOfAnswers == 1)
			System.out.println("Correct answer: " + answer);
		else
			System.out.println("Correct answers: " + answer + " and " + answer2);
		
		
		
	}
}
