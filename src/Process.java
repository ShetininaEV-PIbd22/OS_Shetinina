import java.util.ArrayList;
import java.util.Random;

public class Process {
	private String discription ="Процесс ";
	private ArrayList<Potok> potoks;
	private Random rand= new Random();

	public Process(int number, int quant) {
		potoks= new ArrayList<Potok>();
		int countPotok=rand.nextInt(4)+1;
		this.discription += number+", с числом потоков "+countPotok;
		System.out.println(discription);
		
		for (int i=0; i<countPotok; i++) {
			Potok potok= new Potok((i+1), (quant/countPotok));
			potoks.add(potok);
		}
	}
	public ArrayList<Potok> getPotoks(){
		return potoks;
	}
	public String getDiscription() {
		return discription;
	}
	public boolean isEmpty() 
	{
		return (potoks.size() > 0);
	}
}
