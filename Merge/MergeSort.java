//Clayton Ezzell
//Saturday March 21st, 2018
package Merge;
import java.util.*;


public class MergeSort
{
	private ArrayList<Integer> workingList;


	public MergeSort(ArrayList<Integer> inputList)
	{
		/*
			Simple Constructor requiring an input ArrayList
		*/
		workingList = inputList;
	}


	public void sort(int lower, int upper)
	{
		/*
			Controls the sorting algorithm by dividing the List and managing base cases
			param lower: The smallest index of segment to be sorted
			param upper: The largest index of segment to be sorted
			return: The sorted list of integers
		*/

		int mid;

		if (upper > lower)
		{
			// Checks if the sublist is greater than size 1, any list of size 1 is sorted

			mid = (lower + upper) / 2;

			// Recursively sort the left and right side
			sort(lower, mid);
			sort(mid + 1, upper);

			// Merge the two sorted halves
			merge(lower, mid + 1, upper);
		}
		System.out.println(Arrays.toString(workingList.toArray()));
	}

	public void merge(int lower, int mid, int upper)
	{
		// Control center of merging two sorted lists
		// param lower: the lowest index of the two sorted lists
		// param mid: the middle point that seperates the two lists (i.e. first
		// point)
		// param upper: the highest index of the two sorted lists

		// leftPos and rightPos act as iterators
		int leftPosition = lower;
		int rightPosition = mid;

		// For holding onto the correct order temporarily
		List<Integer> temp = new ArrayList();

		// While still iterating...
		while((leftPosition <= mid - 1) && (rightPosition <= upper))
		{
			// add the losest value....
			if (workingList.get(leftPosition) < workingList.get(rightPosition))
			{
				// (left)
				temp.add(workingList.get(leftPosition));

				leftPosition++;
			}

			else
			{
				// (right)
				temp.add(workingList.get(rightPosition));
				// and increment the right iterator.
				rightPosition++;
			} 
		}

		// When an iterator has reached the end of a list add the remainder 
		// of the other list

		// either the left...
		while(leftPosition <= mid-1)
		{
			temp.add(workingList.get(leftPosition));

			leftPosition++;
		}

		// or the right.
		while(rightPosition <= upper)
		{
			temp.add(workingList.get(rightPosition));

			rightPosition++;
		}
		
		// Reuse an iterrator to ...
		leftPosition = lower;
		for(int i = 0; i < upper-lower+1; i++)
		{
			// rearrange the original list to look like the temp we sorted.
			workingList.set(leftPosition, temp.get(i));
			// Don't forget to increase the iterator.
			leftPosition++;
		}
	}
}
