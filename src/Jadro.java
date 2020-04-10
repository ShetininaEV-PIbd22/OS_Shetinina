import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Random;

public class Jadro {
	private int quant=10; //����� ������� 
	private ArrayList<Process> processes; //������ ���������
	private ArrayDeque<Potok> potoks; //������ �������
	private Random rand= new Random();
	
	public Jadro() {
		processes= new ArrayList<Process>();
		potoks= new ArrayDeque<Potok>();
		int countProcess= rand.nextInt(4)+1;
		
		System.out.println("����� ����� ���������: "+countProcess);
		System.out.println("----------------------------------------------");
		for (int i=0; i<countProcess; i++) {
			Process process= new Process((i+1), quant);
			processes.add(process);
			potoks.addAll(process.getPotoks());
		}
		System.out.println("----------------------------------------------");
		
	}
	//���� ������������
	public void ImplementsPlan() {
		//���� ���� �������� � ������
		//for (int i=0; i<processes.size(); i++)
		int size=processes.size();
		int i=0;
		while(size>0)
		{
			Process process= processes.get(i);
			System.out.println("-"+processes.get(i).getDiscription());
			i++;
			//��� ���������� ������� �������
			if (process.isEmpty()) 
			{
				//���� � ������ ������ ���� ������
				for (int j=0; j<process.getPotoks().size();j++) 
				{
					Potok potok= potoks.poll();
					if (potok.needTime())
					{
						potok.implementPotok();
						System.out.println();
					}
					//���� ��� ������� �� ���������� ������
					else if (!potok.needTime()) {
						System.out.println(potok.getDiscription() + " ��������");
						potoks.addLast(potok);
					}
				}
			}
			System.out.println("��� ������ "+process.getDiscription()+" ����������.");
			size--;
			System.out.println();
		}
		System.out.println("��� �������� ����������.");
	}
}
