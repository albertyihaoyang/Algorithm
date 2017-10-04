package com.yyh;
import java.util.*;
public class FindRestaurant {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindRestaurant myFR = new FindRestaurant();
		String[] list1 = new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"};
		String[] list2 = new String[]{"KFC", "Shogun", "Burger King"};
		System.out.println(Arrays.toString(myFR.findRestaurant(list1, list2)));
	}

	public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> result = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list1.length; i++){
            for (int j = 0; j < list2.length; j++){
                if (list1[i].equals(list2[j])){
                    if (i + j < min) {
                        result = new ArrayList<String>();
                        result.add(list1[i]);
                        min = i + j;
                    } else if (i + j == min){
                        result.add(list1[i]);
                    }
                }
            }
        }
        String[] myResult = new String[result.size()];
        for (int i = 0; i < myResult.length; i++){
        	myResult[i] = result.get(i);
        }
        return myResult;
    }
}
