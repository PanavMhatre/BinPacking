import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class WorstFitDecreasing {
	public static void main(String[] args) {
		Scanner scanner = null;
		File file = null;
		try { 
			  
			file = new File("input20.txt");
			scanner = new Scanner(file);
	        
	    } 
	    catch (Exception e) { 
	        System.out.println("Exception thrown: " + e); 
	    } 
				
		ArrayList<Integer> sizes = new ArrayList<Integer>();
		
		while(scanner.hasNextLine()) {
			int number = Integer.valueOf(scanner.nextLine().strip());
			sizes.add(number);
		}
		
		int totalSize = 0;
		for(int i = 0; i < sizes.size(); i++) {   
		    totalSize += sizes.get(i);
		}
		Collections.sort(sizes, Collections.reverseOrder());
		System.out.println(sizes);
		
		PriorityQueue<Disk> disks = new PriorityQueue<Disk>();
		int index = 0;
		disks.offer(new Disk(index));
		
		
		for(int i = 0; i < sizes.size(); i++) {
			int num = sizes.get(i);
			Disk currDisk = disks.poll();
			if(currDisk.diskNotUsed() >= num) {
				currDisk.addValues(num);
				
			}else {
				index++;
				Disk disk = new Disk(index);
				disk.addValues(num);
				disks.offer(disk);
			}
			disks.offer(currDisk);
			
		}
		
		
		System.out.println("Total size = " + (totalSize/1000000.0) + " GB");
		System.out.println("Disks req'd = " + disks.size());
		while(!disks.isEmpty()) {
			System.out.println(disks.poll().toString());
		}
		
		
		
		scanner.close();
	}
}
