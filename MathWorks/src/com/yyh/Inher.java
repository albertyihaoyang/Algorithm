package com.yyh;

class Vehicle{

	public void getName(){
		System.out.println("Vehicle!");
	}
}

class Car extends Vehicle{
	public void getName(){
		System.out.println("Car!");
	}

	public void hh(){
		System.out.println("hh!");
	}
}





public class Inher{
	public static void main(String[] args){
		Vehicle obj = new Car();
		obj.getName();
		((Car)obj).getName();
		((Car)obj).hh();
		//obj.hh();
	}
}

