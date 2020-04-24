import java.util.Random;

public class Main {

	public static void main(String[] args) {
		OperatingSystem operation = new OperatingSystem (2048, 512);
		Random r = new Random();
		int count= r.nextInt(9)+1;
		System.out.println("���������� ������� ��� ���������: "+count);
		System.out.println("---------------------------------------------------------------");
	    int [] IDpages= new int [count];
	    System.out.println("������ ������� ��� ���������: ");
	    for (int i=0; i<IDpages.length; i++){
	    	IDpages[i]=r.nextInt(count);
	    	System.out.printf(IDpages[i]+", ");
	    }
	    System.out.println("\n---------------------------------------------------------------");
		for(int i = 0; i < IDpages.length; i++){
			if (IDpages[i] >= 0 && IDpages[i] < operation.getVirtualTableSize()){
				System.out.println("���������� �������� � ���������� ������ �� �������: " + IDpages[i]);
			    operation.insertIntoPhysicalMemory(IDpages[i]);
			 }
			else
				System.out.println("��� �������� � ���������� ������ �� �������: " + IDpages[i]);
		 }
	}

}
