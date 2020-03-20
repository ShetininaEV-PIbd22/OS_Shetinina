import java.util.ArrayList;
import java.util.Random;

public class Process {
	private int Id; //����� ��������
	private int currentTime=0; //����� �� ����������
	private ArrayList<Potok> potoks;//������ �������
	private int maxTime;//������������ ����� �� ���������� ��������
	private String discription="������� ";
	private Random rand = new Random();
	
	public Process(int id,int Time) {
		this.maxTime = Time;
		this.Id=id;
		this.discription+=id+" ";
		
		potoks = new ArrayList<Potok>();
		for (int i = 0; i < rand.nextInt(4)+1; i++) {
			potoks.add(new Potok((i+1),rand.nextInt(9)+1));
		}
	}
	public void Start() {
		System.out.println(discription + " �����.");
		for (int i = 0; i < potoks.size(); i++) {
			if(potoks.get(i).Status()) {
				currentTime++;
				continue;
			}
			if(potoks.get(i).MaybeWork(maxTime - currentTime)) {
				potoks.get(i).DoIt();
			}
			if(!potoks.get(i).ErrorTime(maxTime)) {
				continue;
			}
			//else {
				//continue;
			//}
		}
	}
	public boolean ProcessDone() {
		for (int i=0; i<potoks.size(); i++){
			if(!potoks.get(i).Status()) {
				return false;
			}
		}
		return true;
	}
	public int getId() {
		return Id;
	}
	public void printProcess() {
		System.out.println(discription + ": �������: " + potoks.size());
		for (int i=0; i<potoks.size(); i++){
			System.out.println("\t" + potoks.get(i).PrintInfo());
		}
	}
}
