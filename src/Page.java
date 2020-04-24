//����� ��������
public class Page {
	//�������� � ���������� ������ false - ����������� � ������, true - ������������
    private boolean exist;
    // ������ �������� � ���������� ������
    private int indexPage;
    private String diskription = ""; 
    public Page(boolean exist){
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
    public String getDiskription(int index){
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
    	diskription="| "+index+" |     "+diskr;
    	return diskription;
    }
}
