package laioffer;

public class Car {
	public static boolean carPool = true;
	private final String brand;
	private final String model;
	private final int year;
	private int milage;
	private String plateNumber;
	private String color;
	private String ownerName;
	public Car(String brand, String model, int year){
		this.brand = brand;
		this.model = model;
		this.year = year;
		this.milage = 0;
	}
	public String getBrand() {
		return brand;
	}
	public String getModel(){
		return model;
	}
	public int getYear(){
		return year;
	}
	public void drive(int newMilage){
		this.milage += newMilage;
	}
	public int getMilage(){
		return milage;
	}
	public String getPlateNumber(){
		return plateNumber;
	}
	public void setColor(String newColor){
		this.color = newColor;
	}
	public String getColor(){
		return color;
	}
	public void changeOwner(String newOwner){
		this.ownerName = newOwner;
	}
	public String getOwner(){
		return ownerName;
	}
}
