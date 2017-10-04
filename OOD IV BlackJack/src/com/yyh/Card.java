package com.yyh;

public class Card {
	private int faceValue;
	private Suit suit;
	
	public Card(int c, Suit s){
		faceValue = c;
		suit = s;
	}
	
	public int value(){
		return faceValue;
	}
	
	public Suit suit(){
		return suit;
	}
}
