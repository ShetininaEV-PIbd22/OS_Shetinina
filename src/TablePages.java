import java.util.ArrayList;

public class TablePages {
	private ArrayList<Page> pages; //список страниц
	
	public TablePages() {
		pages= new ArrayList<Page>();
	}
	//метод поолучения списка страниц
	public ArrayList<Page> getPages() {
			return pages;
		}
		public void setPages(ArrayList<Page> pages) {
			this.pages = pages;
		}
		//метод получения страницы из списка по указанному индексу
		public Page get(int index) {
			return pages.get(index);
		}
		public int size() {
			return pages.size();
		}
		//метод добавления страницы в список
		public void add(Page page) {
			pages.add(page);
		}
}
