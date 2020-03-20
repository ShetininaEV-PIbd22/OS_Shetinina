
public class Potok {
	int Id;
	private int maxTime;//максимальное время выполнения потока
	int needTime;//время, которое надо для выполнения 
	boolean Done = false;//метка выполнен ли данный поток
	String discription="Поток ";
	
	public Potok(int id, int maxTime) {
		this.Id = id;
		this.discription+=id+"";
		this.maxTime =maxTime;		
	}
	public void DoIt() {
		System.out.println(discription + " выполнен ");
		Done = true;
	}
	public boolean MaybeWork(int Time) {
		System.out.println(" Затраченное время выполнения:" +needTime + ", " + " Максимальное время выполнения: " + Time + " Возможное время на выполнение:" + maxTime );
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
		return discription + "  закончен с ошибкой";
	}
	public boolean ErrorTime(int time) {
		if(time < needTime) {
			Done = true;
			System.out.println(discription + " недостаточно основного времени");
			return true;
		}
		return false;
	}
}
