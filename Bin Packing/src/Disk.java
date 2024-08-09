import java.util.ArrayList;
import java.util.Arrays;

public class Disk implements Comparable<Disk>{
	
	private int diskSize;
	private ArrayList<Integer> values;
	private int notUsed;
	private int indexCreated;
	
	public Disk(int index) {
		diskSize = 1000000;
		values = new ArrayList<>();
		notUsed = 0;
		indexCreated = index;
	}
	public int getIndexCreated() {
		return indexCreated;
	}
	public void addValues(int i) {
		values.add(i);
	}
	
	public ArrayList<Integer> getValues() {
		return values;
	}
	
	public int totalDiskUsed() {
		int size = 0;
		for(int i = 0; i< values.size(); i++) {
			size += values.get(i);
		}
		return size;
	}
	
	public int diskNotUsed() {
		notUsed = diskSize - totalDiskUsed();
		return notUsed;
	}
	
	public int getDiskSize() {
		return diskSize;
	}

	@Override
	public int compareTo(Disk disk) {
		notUsed = diskNotUsed();
		return disk.notUsed - this.notUsed;
	}
	
	@Override
	public String toString() {
		return indexCreated + " " + diskNotUsed() + ": " + Arrays.toString(values.toArray()); 
	}

}
