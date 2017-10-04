package yyh;

import java.util.Comparator;
import java.util.PriorityQueue;

class Entry {
	// The row number
	int x;
	// The column number
	int y;
	// The corresponding value
	int value;
	Entry(int x, int y, int value){
		this.x = x;
		this.y = y;
		this.value = value;
	}
}
public class Merge {
	public int[] merge(int[][] arrayOfArrays) {
	    //Assumptions: arrayOfArrays is not null, none of the array is null either
		PriorityQueue<Entry> minHeap = new PriorityQueue<>(11, new MyComparator());
		int length = 0;
		for (int i = 0; i < arrayOfArrays.length; i++){
			int[] array = arrayOfArrays[i];
			length += array.length;
			if (array.length != 0){
				// We use two index to record the position of each element:
				// the index of the array in the arrayOfArrays,
				// the index of the element in the array.
				minHeap.offer(new Entry(i, 0, array[0]));
			}
		}
		int[] result = new int[length];
		int cur = 0;
		while (!minHeap.isEmpty()){
			Entry tmp = minHeap.poll();
			result[cur++] = tmp.value;
			if (tmp.y + 1 < arrayOfArrays[tmp.x].length){
				tmp.y++;
				tmp.value = arrayOfArrays[tmp.x][tmp.y];
				minHeap.offer(tmp);
			}
		}
		return result;
	  }
}

class MyComparator implements Comparator<Entry>{
	@Override
	public int compare(Entry e1, Entry e2){
		if (e1.value == e2.value){
			return 0;
		}
		return e1.value < e2.value ? -1: 1;
	}
}
