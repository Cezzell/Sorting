import java.util.*;

public class MergeSortDriver
{

	public static void main(String[] args)
	{
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(4, 7, 17, 5, 1, 4, 2, 10, 5, 9, 13, 12, 5 ));
		
		MergeSort sorter = new MergeSort(list);

		sorter.sort(0, list.size());
	}
}