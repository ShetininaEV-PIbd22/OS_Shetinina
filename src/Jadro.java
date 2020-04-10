import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Random;

public class Jadro {
	private int quant=10; //квант времени 
	private ArrayList<Process> processes; //список процессов
	private ArrayDeque<Potok> potoks; //список потоков
	private Random rand= new Random();
	
	public Jadro() {
		processes= new ArrayList<Process>();
		potoks= new ArrayDeque<Potok>();
		int countProcess= rand.nextInt(4)+1;
		
		System.out.println("ќбщее число процессов: "+countProcess);
		System.out.println("----------------------------------------------");
		for (int i=0; i<countProcess; i++) {
			Process process= new Process((i+1), quant);
			processes.add(process);
			potoks.addAll(process.getPotoks());
		}
		System.out.println("----------------------------------------------");
		
	}
	//идет планирование
	public void ImplementsPlan() {
		//пока есть процессы в списке
		//for (int i=0; i<processes.size(); i++)
		int size=processes.size();
		int i=0;
		while(size>0)
		{
			Process process= processes.get(i);
			System.out.println("-"+processes.get(i).getDiscription());
			i++;
			//сли существует массива потоков
			if (process.isEmpty()) 
			{
				//пока в данном списке есть потоки
				for (int j=0; j<process.getPotoks().size();j++) 
				{
					Potok potok= potoks.poll();
					if (potok.needTime())
					{
						potok.implementPotok();
						System.out.println();
					}
					//если нет времени на выполнение потока
					else if (!potok.needTime()) {
						System.out.println(potok.getDiscription() + " завершен");
						potoks.addLast(potok);
					}
				}
			}
			System.out.println("¬се потоки "+process.getDiscription()+" выполненны.");
			size--;
			System.out.println();
		}
		System.out.println("¬се процессы выполненны.");
	}
}
