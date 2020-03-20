import java.util.ArrayDeque;
import java.util.Random;

public class Planner {
	ArrayDeque<Process> processes = new ArrayDeque<Process>();
	private static int max_time=10;
	private static Random rand = new Random();
	private static int countProcess;
	
	public Planner() {
		countProcess=rand.nextInt(4)+1;
		for (int i=0; i<countProcess; i++) {
			processes.add(new Process((i+1),max_time));
		}
	}
	public void print() {
		System.out.println("Общее число процессов: "+ countProcess);
		System.out.println("-----------------------1---------------------------");
		for (Process process : processes) {
			process.printProcess();
		}
		System.out.println("-----------------------2---------------------------");
	}
	
	public void run() {
		for (int i=0; i<processes.size();i++) {
			Process process = processes.poll();
			process.Start();
			
			if(!process.ProcessDone()) {//если процесс не выполнен, то ставим его в конец списка
				processes.offer(process);
				System.out.println(process.getId() + " " + " процессу нужно больше времени");
			}
			else {
				System.out.println(process.getId() + " " + " процесс завершен");
			}
			//если все процессы выполнены
			if(processes.isEmpty()) {
				break;
			}
		}
	}
}
