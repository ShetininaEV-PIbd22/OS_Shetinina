
public class Potok {
	private int currentTime = 0;//текужее время выполнения потока
	private int maxTime;
	private String discription="Поток ";
	
	public Potok (int number, int quant) {
		this.discription+=number;
		this.maxTime=quant;
	}
	
	public void implementPotok() {
		System.out.println(discription+ ", с максимальным временем "+maxTime + " выполняется");
		while (maxTime > currentTime)
		{
			currentTime++;
			//ока есть время на выполнение
			System.out.println(discription+" с временем выполнения: "+currentTime);
			maxTime--;
			if (maxTime==0) {
				System.out.println("Квант на " + discription + " истек");
				break;
			}
		}
		//если нет время на выполнение потока, то завершается
			System.out.println(discription + " завершен");
	}
	public String getDiscription()
	{
		return discription;
	}
	// есть ли еще время на выполнение
	public boolean needTime() 
	{
		return (maxTime > currentTime);
	}
}
