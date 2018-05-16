package com.yyh;
/*
 * We have jobs: difficulty[i] is the difficulty of the ith job, and profit[i] is the profit of the ith job. 

Now we have some workers. worker[i] is the ability of the ith worker, which means that this worker can only complete a job with difficulty at most worker[i]. 

Every worker can be assigned at most one job, but one job can be completed multiple times.

For example, if 3 people attempt the same job that pays $1, then the total profit will be $3.  If a worker cannot complete any job, his profit is $0.

What is the most profit we can make?
 */
public class SolutionLTE {
	public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int max = 0;
        for (int i: worker) max = Math.max(i, max);
        int[] m = new int[max + 1];
        for (int i = 0; i < difficulty.length; i++){
            for (int j = max; j >= difficulty[i]; j--){
                m[j] = Math.max(m[j], profit[i]);
            }
        }
        int res = 0;
        for (int i: worker) res += m[i];
        return res;
    }
}
