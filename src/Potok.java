
public class Potok {
	private int currentTime = 0;//������� ����� ���������� ������
	private int maxTime;
	private String discription="����� ";
	
	public Potok (int number, int quant) {
		this.discription+=number;
		this.maxTime=quant;
	}
	
	public void implementPotok() {
		System.out.println(discription+ ", � ������������ �������� "+maxTime + " �����������");
		while (maxTime > currentTime)
		{
			currentTime++;
			//��� ���� ����� �� ����������
			System.out.println(discription+" � �������� ����������: "+currentTime);
			maxTime--;
			if (maxTime==0) {
				System.out.println("����� �� " + discription + " �����");
				break;
			}
		}
		//���� ��� ����� �� ���������� ������, �� �����������
			System.out.println(discription + " ��������");
	}
	public String getDiscription()
	{
		return discription;
	}
	// ���� �� ��� ����� �� ����������
	public boolean needTime() 
	{
		return (maxTime > currentTime);
	}
}
