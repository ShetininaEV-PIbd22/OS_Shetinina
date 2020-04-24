import java.util.ArrayList;

public class LRU {
	//������� ������� ����������� ������
	private TablePages tableVirtualMemory;
	//������� ���������� ������ ���������� ������
	private ArrayList<Page> tableRealMemory;
	//������������������ ������� ����������� �������
	private ArrayList<Integer> loaning = new ArrayList<>();
		
	public LRU(TablePages tableVirtualMemory, ArrayList<Page> tableRealMemory, ArrayList<Integer> loaning) {
		this.tableVirtualMemory = tableVirtualMemory;
		this.tableRealMemory = tableRealMemory;
		this.loaning = loaning;
	}
	//c����� ������� ������������ �������	
	 public ArrayList<Object> last_used(Page page) {
		 ArrayList<Object> result = new ArrayList<Object>();
		 int index = 0;
		 
		 int[] callsSequences = new int[tableRealMemory.size()];
	    	for (int i = 0; i < callsSequences.length; i++) {
	    		callsSequences[i] = -1;
	    	}
	    	// �������� �� ���� ������� ����������� ���������
		   	for (int i = 0; i < loaning.size(); i++) {
					// �������� �� ���� ��������� ����������� ������
					for (int j = 0; j < tableVirtualMemory.size(); j++) {
						//���� �������� ��������� � ���������� ������, �� �� ����������
						if((tableVirtualMemory.get(j).isExist())
								&& (callsSequences[tableVirtualMemory.get(j).getIndexFisicPage()] == -1)) {
								callsSequences[tableVirtualMemory.get(j).getIndexFisicPage()] = i;
							//���� ��� �������� ����������, ���������� ��������� ��������,
							//������� ������ ����� �������������� 
							if (allLoad(callsSequences)) {
								index = indexMin(callsSequences);
								System.out.println("�������� �������� " + tableVirtualMemory.get(j).getIndexFisicPage());
								break;
							}
						}
					}
				}
		    tableRealMemory.get(index).setExist(false);
		   	tableRealMemory.get(index).setIndexFisicPage(-1);
		   	tableRealMemory.remove(index);
		    tableRealMemory.add(index, page);
	        page.setIndexFisicPage(index);
	        page.setExist(true);

		 return result;
	   }
	 
	 private boolean allLoad(int[] a) {
	    	for (int i = 0; i < a.length; i++) {
	    		if (a[i] == -1) {
	    			return false;
	    		}    		
	    	}
	    	return true;
	    }
	    
	    private int indexMin(int[] a) {
	    	int min = a[0];
	    	int index = 0;
	    	for (int i = 0; i < a.length; i++) {
	    		if (a[i] < min) {
	    			min = a[i];
	    			index = i;
	    		}
	    	}
	    	return index;
	    }
}
