package laioffer;

interface Dictionary {
    public Integer get(int index);
}


public class Solution {
	public int search(Dictionary dict, int target) {		
		if (dict == null) return -1;
		int idx = 1;
	    while (dict.get(idx - 1) < target && dict.get(idx-1) != null) idx *= 2;
	    if (dict.get(idx-1) == target) return idx - 1;
	    else{
	    	int start = 0, end = idx - 1;
			while (start <= end){
				int mid = start + (end - start)/2;
				if (dict.get(mid) == target) return mid;
				else if (dict.get(mid) == null || dict.get(mid) > target) end = mid - 1;
				else start = mid + 1;
			}
	    }
	    return -1;
	 }
	
}
