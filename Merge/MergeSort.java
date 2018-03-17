//Clayton Ezzell
//Saturday March 17th, 2018
package Merge;
import java.util.*;


public class MergeSort
{
	private ArrayList<Integer> workingList;

	public MergeSort(ArrayList<Integer> inputList)
	{
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

		if (upper - lower > 1)
		{
			// Checks if the sublist is greater than size 1, any list of size 1 is sorted

			mid = (lower + upper) / 2;

			// Recursively sort the left and right side
			sort(lower, mid);
			sort(mid + 1, upper);

			// Merge the two sorted halves
			System.out.println(lower + " " + mid + " " + upper);
			merge(lower, mid, upper);
		}
		System.out.println(Arrays.toString(workingList.toArray()));
	}

	public void merge(int lower, int mid, int upper)
	{
		int leftPosition = lower;
		int rightPosition = mid + 1;
		List<Integer> temp = new ArrayList();

		while((leftPosition<=mid) && (rightPosition <= upper-1))
		{
			if (workingList.get(leftPosition) < workingList.get(rightPosition))
			{
				temp.add(workingList.get(leftPosition));

				leftPosition++;
			}

			else
			{
				temp.add(workingList.get(rightPosition));

				rightPosition++;
			} 
		}

		while(leftPosition <= mid)
		{
			temp.add(workingList.get(leftPosition));

			leftPosition++;
		}

		while(rightPosition <= upper)
		{
			temp.add(workingList.get(rightPosition));

			rightPosition++;
		}

		for(int i = 0;	i <= upper-lower+1; i++)
		{
			workingList.set(lower, temp.get(i));

			lower++;
		}
	}
}
