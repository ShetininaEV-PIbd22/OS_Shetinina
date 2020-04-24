
public class Page {
	
	private int id;
	//страница в физической памяти false - отсутствует в памяти, true - присутствует
    private boolean exist;
    // индекс страницы в физической памяти
    private int indexPage=0;
    private String diskription = "";
    //бит обращения
 	public int R = 0;
    
 	public Page(int id, boolean exist){
        this.id=id;
 		this.exist = exist;
    }
 	public boolean isExist() {
        return exist;
    }

    public int getIndexFisicPage() {
        return indexPage;
    }

    public void setIndexFisicPage(int indexRealPage) {
        this.indexPage = indexRealPage;
    }

    public void setExist(boolean exist) {
        this.exist = exist;
    }
    public String getDiskription(){
    	String diskr="";
    	if (isExist()==true)
    		diskr="true ";
    	else
    		diskr="false";
    	diskr+="     |   ";
    	if (getIndexFisicPage()==-1)
    		diskr+=getIndexFisicPage()+"  |";
    	else
    		diskr+=getIndexFisicPage()+"   |";
    	diskription="| "+id+" |     "+diskr;
    	return diskription;
    }
}
