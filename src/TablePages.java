import java.util.ArrayList;

public class TablePages {
	private ArrayList<Page> pages; //������ �������
	
	public TablePages() {
		pages= new ArrayList<Page>();
	}
	//����� ���������� ������ �������
	public ArrayList<Page> getPages() {
			return pages;
		}
		public void setPages(ArrayList<Page> pages) {
			this.pages = pages;
		}
		//����� ��������� �������� �� ������ �� ���������� �������
		public Page get(int index) {
			return pages.get(index);
		}
		public int size() {
			return pages.size();
		}
		//����� ���������� �������� � ������
		public void add(Page page) {
			pages.add(page);
		}
}
