package model;
import java.util.*;

public class Load {

	public final static int DANGEROUS = 1;
	public final static double DANGEROUS_PRICE = 390000;
	public final static int PERISHABLE = 2;
	public final static double PERISHABLE_PRICE = 259000;
	public final static int NOT_PERISHABLE = 3;
	public final static double NOT_PERISHABLE_PRICE = 80000;
	
	private int numberBoxes;
	private double boxWeight;
	private double weight;
	
	private int type;
	private double price;

	private Client owner;

	public Load(int numberBoxes, double boxWeight, int type, Client owner) {
		this.numberBoxes = numberBoxes;
		this.boxWeight = boxWeight; 
		this.weight = (boxWeight*numberBoxes);
		
		this.type = type;
		this.owner = owner;
		this.price = price();
	}
	
	public double price() {
		switch(type){
			case DANGEROUS:
				price = weight*DANGEROUS_PRICE;
			case PERISHABLE:
				price = weight*PERISHABLE_PRICE;
			case NOT_PERISHABLE:
				price = weight*NOT_PERISHABLE_PRICE;
		}
		return price-(owner.getDiscount()*price);
	}
	
	public Client getClient(){
		return owner;
	}
	
	public int getNumberBoxes(){
		return numberBoxes;
	}
	
	public double getBoxWeight(){
		return boxWeight;
	}
	
	public double getPrice(){
		return price;
	}
	
	public int getType(){
		return type;
	}
	
	public double getWeight(){
		return weight;
	}
}
