import java.util.ArrayList;

//класс операционной системы
public class OperatingSystem {
	 //таблица страниц виртуальной памяти
    private TablePages tableVM;
    //список страничных блоков в физической памяти
    private ArrayList<Page> tableRM;
    // вместимость физической памяти
    private int vmestimost;
    private ArrayList<Integer> loaning = new ArrayList<>();    

    public OperatingSystem (int RAM_size, int Page_size){
    	tableVM = new TablePages();
        tableRM = new ArrayList<Page>();
        // вместимость физической памяти
        vmestimost = RAM_size / Page_size;
        //размер виртуальной страниц в 2 раза больше физической памяти
        int virtual_size= (RAM_size*2)/Page_size;
        for(int i = 0; i < virtual_size; i++){
        	Page page = new Page(false);
            page.setIndexFisicPage(-1);
            tableVM.add(page);
        }
    }

    public void insertIntoPhysicalMemory(int pageIndex){
    	ArrayList<Object> result;
    	LRU algorithm = new LRU(tableVM, tableRM, loaning);
    	//произошло обращение к виртуальному адресному пространству страницы с номером pageIndex
    	Page page = tableVM.get(pageIndex);
        if(!page.isExist()){
        	/* если есть место в физической памяти
        	то помечаем страницу меткой присутствия в физической памяти,
        	добавляем эту страницу в конец физической памяти, 
        	в список индексов занесли индекс виртуального адреса, куда добавили
        	*/
        	if(tableRM.size() < vmestimost){
        		page.setExist(true);
        		tableRM.add(page);
        		// запоминаем индекс в физической памяти
        		int indexPage = tableRM.indexOf(page);
                page.setIndexFisicPage(indexPage);
               loaning.add(pageIndex);
            } 
        	// если закончилось место в физической памяти
        	else if(tableRM.size() == vmestimost){
        		//идет замещение
                result = algorithm.last_used(page);
                loaning.add(pageIndex);
            }
        }
        print();
    }   

    public int getVirtualTableSize(){
        return tableVM.size();
    }

    public void print(){
    	System.out.println("---------------------------------------------------------------");
    	System.out.println("Физическая память");
    	System.out.println("-----------------------------");
    	for (int i=0; i<tableRM.size(); i++) {
            Page page =tableRM.get(i);
        	System.out.println(page.getDiskription(i));
        }
    	System.out.println("================================================");
        System.out.println("Виртувльня память");
        System.out.println("-----------------------------");
    	System.out.println("| i |Бит-присутствия| Номер |");
    	for (int i=0; i<tableVM.size(); i++) {
        	Page page=tableVM.get(i);
        	System.out.println(page.getDiskription(i));
        }
        System.out.println("---------------------------------------------------------------");
    }
}
