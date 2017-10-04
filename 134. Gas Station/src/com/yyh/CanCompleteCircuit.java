package com.yyh;
/*
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel 
 * from station i to its next station (i+1). You begin the journey with an empty tank at one 
 * of the gas stations.
 * Return the starting gas station's index if you can travel around the circuit once, 
 * otherwise return -1.
 */
public class CanCompleteCircuit {

	public static void main(String[] args) {
		CanCompleteCircuit my = new CanCompleteCircuit();
		int[] gas = new int[]{2};
		int[] cost = new int[]{2};
		System.out.println(my.canCompleteCircuit(gas, cost));
	}

	public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++){
            boolean flag = true;
            int[] remain = new int[gas.length];
            for (int j = 0; j < gas.length; j++){
                if (remain[j] + gas[(i + j) % gas.length] >= cost[(i + j) % gas.length]){
                    remain[(j + 1) % gas.length] = remain[j] + gas[(i + j) % gas.length] - 
                    		cost[(i + j) % gas.length];
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }
}
