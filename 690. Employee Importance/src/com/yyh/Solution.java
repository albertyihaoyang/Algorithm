package com.yyh;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * You are given a data structure of employee information, which includes the employee's unique id, 
 * his importance value and his direct subordinates' id.
 * For example, employee 1 is the leader of employee 2, and employee 2 is the leader of employee 3. 
 * They have importance value 15, 10 and 5, respectively. Then employee 1 has a data structure like [1, 15, [2]], 
 * and employee 2 has [2, 10, [3]], and employee 3 has [3, 5, []]. 
 * Note that although employee 3 is also a subordinate of employee 1, the relationship is not direct.
 * Now given the employee information of a company, and an employee id, 
 * you need to return the total importance value of this employee and all his subordinates.
 */

//Employee info
class Employee {
	// It's the unique id of each node;
	// unique id of this employee
	public int id;
	// the importance value of this employee
	public int importance;
	// the id of direct subordinates
	public List<Integer> subordinates;
};

class Solution {
	public int getImportance(List<Employee> employees, int id) {
		int res = 0;
		Map<Integer, Employee> map = new HashMap<>();
		for (Employee e: employees){
			map.put(e.id, e);
		}
		Employee cur = map.get(id);
		if (cur == null) return res;
		res += cur.importance;
		for (Integer i : cur.subordinates){
			res += helper(map.get(i), map);
		}
		return res;
	}

	private int helper(Employee e, Map<Integer, Employee> map){
		int res = e.importance;
		for (Integer i : e.subordinates){
			res += helper(map.get(i), map);
		}
		return res;
	}
}