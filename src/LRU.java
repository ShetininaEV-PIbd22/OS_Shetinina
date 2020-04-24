import java.util.ArrayList;

public class LRU {
	//таблица страниц виртуальной памяти
	private TablePages tableVirtualMemory;
	//таблица страничных блоков физической памяти
	private ArrayList<Page> tableRealMemory;
	//последовательность недавно загруженных страниц
	private ArrayList<Integer> loaning = new ArrayList<>();
		
	public LRU(TablePages tableVirtualMemory, ArrayList<Page> tableRealMemory, ArrayList<Integer> loaning) {
		this.tableVirtualMemory = tableVirtualMemory;
		this.tableRealMemory = tableRealMemory;
		this.loaning = loaning;
	}
	//cписок недавно используемых страниц	
	 public ArrayList<Object> last_used(Page page) {
		 ArrayList<Object> result = new ArrayList<Object>();
		 int index = 0;
		 
		 int[] callsSequences = new int[tableRealMemory.size()];
	    	for (int i = 0; i < callsSequences.length; i++) {
	    		callsSequences[i] = -1;
	    	}
	    	// проходим по всем недавно загруженным страницам
		   	for (int i = 0; i < loaning.size(); i++) {
					// проходим по всем страницам виртуальной памяти
					for (int j = 0; j < tableVirtualMemory.size(); j++) {
						//если страница находится в физической памяти, но не загруженна
						if((tableVirtualMemory.get(j).isExist())
								&& (callsSequences[tableVirtualMemory.get(j).getIndexFisicPage()] == -1)) {
								callsSequences[tableVirtualMemory.get(j).getIndexFisicPage()] = i;
							//если все страницы загруженны, происходит замещение страницы,
							//которая раньше всего использовалась 
							if (allLoad(callsSequences)) {
								index = indexMin(callsSequences);
								System.out.println("Замещаем страницу " + tableVirtualMemory.get(j).getIndexFisicPage());
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
