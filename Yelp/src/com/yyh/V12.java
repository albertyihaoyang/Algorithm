package com.yyh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class V12 {
	public static void main(String[] args){
		List<String> list = new ArrayList<>();
		list.add("Whole Food - Austin - 103");
		list.add("Whole Food - LA - 102");
		list.add("Whole Food - Austin - 103");
		list.add("Ralphs - Austin - 101");
		list.add("KFC - Austin - 104");
		list.add("Whole Food - Austin - 101");
		list.add("McDonald - LA - 107");
		List<String> res = sol(list, "LA");
		for (String s: res){
			System.out.println(s);
		}
	}
	
	static class Res{
		String name;
		int num;
		public Res(String name, int num){
			this.name = name;
			this.num = num;
		}
	}
	
	public static List<String> sol(List<String> list, String location){
		List<String> result = new ArrayList<>();
		if (list == null){
			return result;
		}
		Map<String, Map<String, Set<String>>> locMap = new HashMap<>();
		for (String s: list){
			String[] arr = s.split(" - ");
			String name = arr[0];
			String loc = arr[1];
			String ID = arr[2];
			Map<String, Set<String>> nameMap = locMap.get(loc);
			if (nameMap == null){
				nameMap = new HashMap<>();
				locMap.put(loc, nameMap);
			}
			Set<String> IDSet = nameMap.get(name);
			if (IDSet == null){
				IDSet = new HashSet<>();
				nameMap.put(name, IDSet);
			}
			IDSet.add(ID);
		}
		
		Map<String, Set<String>> nameMap = locMap.get(location);
		if (nameMap == null){
			return result;
		}
		Res[] resArr = new Res[nameMap.size()];
		int ind = 0;
		for (String name : nameMap.keySet()){
			resArr[ind++] = new Res(name, nameMap.get(name).size());
		}
		
		Arrays.sort(resArr, (a, b) -> a.num > b.num ? -1: 1);
		
		for (Res cur: resArr){
			StringBuilder sb = new StringBuilder();
			sb.append(cur.name);
			sb.append(" - ");
			sb.append(cur.num);
			result.add(sb.toString());
		}
		
		return result;
		
	}
}
