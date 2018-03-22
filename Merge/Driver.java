package Merge;
import java.util.*;


public class Driver
{
	// Simple starting test to get the code running

	public static void main(String [] args)
	{
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(4, 7, 17, 5, 1, 4, 2, 10, 5, 9, 13, 12, 5 ));
		// Desired Output [1, 2, 4, 4, 5, 5, 5, 7, 9, 10, 12, 13, 17]
		
		MergeSort sorter = new MergeSort(list);

		sorter.sort(0, list.size() - 1); // For Now the sorting class does the printing, will fix.
	}
}