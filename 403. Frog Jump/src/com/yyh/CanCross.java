package com.yyh;
/*
 * A frog is crossing a river. The river is divided into x units and at each unit there may or may 
 * 	not exist a stone. The frog can jump on a stone, but it must not jump into the water.
 * Given a list of stones' positions (in units) in sorted ascending order, determine if the 
 * 	frog is able to cross the river by landing on the last stone. Initially, the frog is on 
 * 	the first stone and assume the first jump must be 1 unit.
 * If the frog's last jump was k units, then its next jump must be either k - 1, k, or k + 1 
 * 	units. Note that the frog can only jump in the forward direction.
 */

public class CanCross {

	public static void main(String[] args) {
		CanCross my = new CanCross();
		int[] stones = new int[]{0,1,3,5,6,8,12,17};
		System.out.println(my.canCross(stones));
		stones = new int[]{0,1,2,3,4,8,9,11};
		System.out.println(my.canCross(stones));
	}

	public boolean canCross(int[] stones) {
        if (stones.length <= 1){
        	return true;
        }
        int[] jump = new int[stones.length];
        jump[0] = 0;
        for (int i = 1; i < stones.length; i++){
        	int gap = stones[i] - stones[i - 1];
        	if (gap >= jump[i - 1] - 1 && gap <= jump[i - 1] + 1){
        		jump[i] = gap;
        	} else {
        		return false;
        	}
        }
        return true;
    }
}
