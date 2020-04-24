import java.util.Random;

//Алгоритм LRU
public class Main {

	public static void main(String[] args) {
		OperatingSystem operation = new OperatingSystem(2048, 512);
		Random r = new Random();
		int count= r.nextInt(9)+1;
		System.out.println("Количество страниц для обращения: "+count);
		System.out.println("---------------------------------------------------------------");
	    int [] IDpages= new int [count];
	    System.out.println("Номера страниц для обращения: ");
	    for (int i=0; i<IDpages.length; i++){
	    	IDpages[i]=r.nextInt(count);
	    	System.out.printf(IDpages[i]+", ");
	    }
	    System.out.println("\n---------------------------------------------------------------");
		for(int i = 0; i < IDpages.length; i++){
			if (IDpages[i] >= 0 && IDpages[i] < operation.getVirtualTableSize()){
				System.out.println("Добавление страницы в физическую память по индексу: " + IDpages[i]);
			    operation.insertIntoPhysicalMemory(IDpages[i]);
			 }
			else
				System.out.println("Нет страницы в физической памяти по индексу: " + IDpages[i]);
		 }
	}

}
