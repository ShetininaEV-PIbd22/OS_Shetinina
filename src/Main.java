import java.util.Random;

public class Main {

	public static void main(String[] args) {
		OperatingSystem operation = new OperatingSystem (2048, 512);
		Random r = new Random();
		int count= r.nextInt(9)+1;
		System.out.println(" оличество страниц дл€ обращени€: "+count);
		System.out.println("---------------------------------------------------------------");
	    int [] IDpages= new int [count];
	    System.out.println("Ќомера страниц дл€ обращени€: ");
	    for (int i=0; i<IDpages.length; i++){
	    	IDpages[i]=r.nextInt(count);
	    	System.out.printf(IDpages[i]+", ");
	    }
	    System.out.println("\n---------------------------------------------------------------");
		for(int i = 0; i < IDpages.length; i++){
			if (IDpages[i] >= 0 && IDpages[i] < operation.getVirtualTableSize()){
				System.out.println("ƒобавление страницы в физическую пам€ть по индексу: " + IDpages[i]);
			    operation.insertIntoPhysicalMemory(IDpages[i]);
			 }
			else
				System.out.println("Ќет страницы в физической пам€ти по индексу: " + IDpages[i]);
		 }
	}

}
