/*
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold 
additional elements from nums2. The number of elements initialized in nums1 and nums2 are m 
and n respectively.
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] n1 = {1,3,5,0,0};
		int[] n2 = {2,4};
		int m = 3, n = 2;
		merge(n1,m,n2,n);
		for (int i : n1) System.out.print(i+" ");
	}
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] n1 = new int [m];
        for (int i = 0; i < m; i++){
            n1[i] = nums1[i];
        }
        int i = 0, j = 0;
        while ((i < m) || (j < n)) {
        	if (i == m) {
        		nums1[i+j] = nums2[j];
            	j++;
        	}
        	else if (j == n){
        		nums1[i+j] = n1[i];
            	i++;
        	}
        	else if (n1[i] < nums2[j]){
            	nums1[i+j] = n1[i];
            	i++;
            }
            else {
            	nums1[i+j] = nums2[j];
            	j++;
            }
        }
    }
}
