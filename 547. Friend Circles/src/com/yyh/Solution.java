package com.yyh;

import java.util.LinkedList;
import java.util.Queue;

/*
 * There are N students in a class. Some of them are friends, while some are not. 
 * Their friendship is transitive in nature. For example, if A is a direct friend of B, and B is a direct friend of C, 
 * then A is an indirect friend of C. And we defined a friend circle is a group of students who are direct or indirect friends.
 * Given a N*N matrix M representing the friend relationship between students in the class. 
 * If M[i][j] = 1, then the ith and jth students are direct friends with each other, otherwise not. 
 * And you have to output the total number of friend circles among all the students.
 */
public class Solution {
	public int findCircleNum(int[][] M) {
		if (M.length == 0 || M.length != M[0].length){
			return 0;
		}
		int group = 0;
		boolean[] visited = new boolean[M.length];
		for (int i = 0; i < M.length; i++){
			if (visited[i]){
				continue;
			}
			Queue<Integer> queue = new LinkedList<>();
			queue.offer(i);
			while (!queue.isEmpty()){
				int cur = queue.poll();
				visited[cur] = true;
				for (int j = 0; j < M.length; j++){
					if (visited[j] || M[cur][j] == 0) continue;
					queue.offer(j);
				}
			}
			group++;
		}
		return group;
	}
}
