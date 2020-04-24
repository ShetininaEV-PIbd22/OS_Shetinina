import java.util.ArrayList;

//����� ������������ �������
public class OperatingSystem {
	 //������� ������� ����������� ������
    private TablePages tableVM;
    //������ ���������� ������ � ���������� ������
    private ArrayList<Page> tableRM;
    // ����������� ���������� ������
    private int vmestimost;
    private ArrayList<Integer> loaning = new ArrayList<>();    

    public OperatingSystem (int RAM_size, int Page_size){
    	tableVM = new TablePages();
        tableRM = new ArrayList<Page>();
        // ����������� ���������� ������
        vmestimost = RAM_size / Page_size;
        //������ ����������� ������� � 2 ���� ������ ���������� ������
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
    	//��������� ��������� � ������������ ��������� ������������ �������� � ������� pageIndex
    	Page page = tableVM.get(pageIndex);
        if(!page.isExist()){
        	/* ���� ���� ����� � ���������� ������
        	�� �������� �������� ������ ����������� � ���������� ������,
        	��������� ��� �������� � ����� ���������� ������, 
        	� ������ �������� ������� ������ ������������ ������, ���� ��������
        	*/
        	if(tableRM.size() < vmestimost){
        		page.setExist(true);
        		tableRM.add(page);
        		// ���������� ������ � ���������� ������
        		int indexPage = tableRM.indexOf(page);
                page.setIndexFisicPage(indexPage);
               loaning.add(pageIndex);
            } 
        	// ���� ����������� ����� � ���������� ������
        	else if(tableRM.size() == vmestimost){
        		//���� ���������
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
    	System.out.println("���������� ������");
    	System.out.println("-----------------------------");
    	for (int i=0; i<tableRM.size(); i++) {
            Page page =tableRM.get(i);
        	System.out.println(page.getDiskription(i));
        }
    	System.out.println("================================================");
        System.out.println("���������� ������");
        System.out.println("-----------------------------");
    	System.out.println("| i |���-�����������| ����� |");
    	for (int i=0; i<tableVM.size(); i++) {
        	Page page=tableVM.get(i);
        	System.out.println(page.getDiskription(i));
        }
        System.out.println("---------------------------------------------------------------");
    }
}
