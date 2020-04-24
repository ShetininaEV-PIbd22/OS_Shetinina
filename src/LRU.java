import java.util.ArrayList;

public class LRU {
	//таблица страниц виртуальной памяти
	private TablePages tableVirtualMemory;
	//таблица страничных блоков физической памяти
	private ArrayList<Page> tableRealMemory;
	
	public LRU(TablePages tableVirtualMemory, ArrayList<Page> tableRealMemory){
		this.tableVirtualMemory = tableVirtualMemory;
		this.tableRealMemory = tableRealMemory;
	}
	public void NFU(int id) {
		Page page = tableVirtualMemory.get(id);
		int minCount = -1;
		int minIndex = -1;
		for (int i = 0; i < tableVirtualMemory.getPages().size(); i++)
			if (tableVirtualMemory.get(i).isExist() && (tableVirtualMemory.get(i).R < minCount || minCount == -1)) {
				minCount = tableVirtualMemory.get(i).R;
				minIndex = i;
			}
		Page minPage = tableVirtualMemory.get(minIndex);
		page.setIndexFisicPage( minPage.getIndexFisicPage());
		page.setExist(true);
		minPage.setExist(false);
		minPage.setIndexFisicPage(-1);
		minPage.R = 0;
	}
}
