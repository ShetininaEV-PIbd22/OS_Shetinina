
public class Potok {
	int Id;
	private int maxTime;//������������ ����� ���������� ������
	int needTime;//�����, ������� ���� ��� ���������� 
	boolean Done = false;//����� �������� �� ������ �����
	String discription="����� ";
	
	public Potok(int id, int maxTime) {
		this.Id = id;
		this.discription+=id+"";
		this.maxTime =maxTime;		
	}
	public void DoIt() {
		System.out.println(discription + " �������� ");
		Done = true;
	}
	public boolean MaybeWork(int Time) {
		System.out.println(" ����������� ����� ����������:" +needTime + ", " + " ������������ ����� ����������: " + Time + " ��������� ����� �� ����������:" + maxTime );
		if(needTime <= Time) {
			return true;
		}
		return false;
	}
	public boolean Status() {	
		return Done;
	}
	public String PrintInfo() {
		return discription + " " + maxTime;
	}
	public String EndWithError() {
		Done = true;
		return discription + "  �������� � �������";
	}
	public boolean ErrorTime(int time) {
		if(time < needTime) {
			Done = true;
			System.out.println(discription + " ������������ ��������� �������");
			return true;
		}
		return false;
	}
}
