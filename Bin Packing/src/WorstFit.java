import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class WorstFit {
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
		
		ArrayList<Disk> disks = new ArrayList<Disk>();
		int index = 0;
		disks.add(new Disk(index));
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(scanner.hasNextLine()) {
			int num = Integer.valueOf(scanner.nextLine());
			Disk currDisk = disks.get(0);
			if(currDisk.diskNotUsed() >= num) {
				currDisk.addValues(num);
			}else {
				index++;
				Disk disk = new Disk(index);
				disk.addValues(num);
				disks.add(disk);
			}
			
			Collections.sort(disks);
		}
		
		
		Collections.sort(disks);
		
		
		System.out.println("Total size = " + (totalSize/1000000.0) + " GB");
		System.out.println("Disks req'd = " + disks.size());
		for(int i = 0; i<disks.size();i++) {
			System.out.println(disks.get(i).toString());
		}
		
		
		
		scanner.close(); 
	}
}
