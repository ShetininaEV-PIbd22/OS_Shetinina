import java.util.ArrayList;

public class PhysicalMemory {
	
	private ArrayList<Boolean> blocks;
	private int RAM_size;
	private int Page_size;
	private int index = -1;

	public PhysicalMemory(int RAM_size, int Page_size) {
		this.RAM_size = RAM_size;
		this.Page_size = Page_size;
		blocks = new ArrayList<Boolean>(RAM_size / Page_size);
		for (int i = 0; i < RAM_size / Page_size; i++) {
			blocks.add(false);
		}
	}

	public void writePage() {
		index++;
		blocks.set(index, true);
	}
	
	public int getLastIndex() {
		return index;
	}

	public int getCountPages() {
		return blocks.size();
	}
	//смещение 
	public int getAddress(int indexPage, int shift) {
		return indexPage * Page_size + shift;
	}
}
