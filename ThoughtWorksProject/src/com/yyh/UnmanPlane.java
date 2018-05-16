package com.yyh;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class UnmanPlane {
	public static void main(String[] args){
		int[] res = analysis2(args[0]);
		System.out.println(res[0] + " " + res[1] + " " + res[2]);
	}
	
	public static int record(String fileName){
		return analysis1(fileName);
	}
	
	private static List<String> analysis(String fileName){
		List<String> res = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))){
			String line;
			int ind = 0;
			String plane = "";
			boolean flag = true;
			int[] pos = new int[3];
			while ((line = br.readLine()) != null) {
				if (!flag){
					res.add("Error: " + ind++);
					continue;
				}
				String[] arr = line.split(" ");
				if (ind == 0){//Initial pos 
					if (arr.length != 4){
						flag = false;
						res.add("Error: " + ind++);
						continue;
					}
					plane = arr[0];
					for (int i = 0; i < 3; i++){
						try {
							pos[i] = Integer.parseInt(arr[i + 1]);
						} catch (NumberFormatException e){
							flag = false;
							break;
						}
					}
				} else { // following inputs
					if (arr.length != 7 || !arr[0].equals(plane)){
						flag = false;
						res.add("Error: " + ind++);
						continue;
					}
					for (int i = 0; i < 3; i++){
						try {
							int curPos = Integer.parseInt(arr[i + 1]);
							if (curPos != pos[i]) {
								flag = false;
								res.add("Error: " + ind++);
								continue;
							}
						} catch (NumberFormatException e){
							flag = false;
							break;
						}
					}
					for (int i = 0; i < 3; i++){
						try {
							int delPos = Integer.parseInt(arr[i + 4]);
							pos[i] += delPos;
						} catch (NumberFormatException e){
							flag = false;
							break;
						}
					}
				}
				res.add(plane + " " + ind++ + " " + pos[0] + " " + pos[1] + " " + pos[2]);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	private static int analysis1(String fileName){
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))){
			String line;
			int ind = 0;
			String plane = "";
			int[] pos = new int[3];
			while ((line = br.readLine()) != null) {
				String[] arr = line.split(" ");
				if (ind == 0){//Initial pos 
					if (arr.length != 4){
						return 0;
					}
					plane = arr[0];
					for (int i = 0; i < 3; i++){
						try {
							pos[i] = Integer.parseInt(arr[i + 1]);
						} catch (NumberFormatException e){
							return 0;
						}
					}
				} else { // following inputs
					if (arr.length != 7 || !arr[0].equals(plane)){
						return ind;
					}
					for (int i = 0; i < 3; i++){
						try {
							int curPos = Integer.parseInt(arr[i + 1]);
							if (curPos != pos[i]) {
								return ind;
							}
						} catch (NumberFormatException e){
							return ind;
						}
					}
					for (int i = 0; i < 3; i++){
						try {
							int delPos = Integer.parseInt(arr[i + 4]);
							pos[i] += delPos;
						} catch (NumberFormatException e){
							return ind;
						}
					}
				}
				ind++;
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	private static int[] analysis2(String fileName){
		int[] res = new int[3];
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))){
			String line;
			int ind = 0;
			String plane = "";
			int[] pos = new int[3];
			while ((line = br.readLine()) != null) {
				String[] arr = line.split(" ");
				if (ind == 0){//Initial pos 
					if (arr.length != 4){
						return res;
					}
					plane = arr[0];
					for (int i = 0; i < 3; i++){
						try {
							pos[i] = Integer.parseInt(arr[i + 1]);
						} catch (NumberFormatException e){
							return res;
						}
					}
				} else { // following inputs
					if (arr.length != 7 || !arr[0].equals(plane)){
						return res;
					}
					for (int i = 0; i < 3; i++){
						try {
							int curPos = Integer.parseInt(arr[i + 1]);
							if (curPos != pos[i]) {
								return res;
							}
						} catch (NumberFormatException e){
							return res;
						}
					}
					for (int i = 0; i < 3; i++){
						try {
							int delPos = Integer.parseInt(arr[i + 4]);
							pos[i] += delPos;
							res[i] += Math.abs(delPos);
						} catch (NumberFormatException e){
							return res;
						}
					}
				}
				ind++;
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	
}
