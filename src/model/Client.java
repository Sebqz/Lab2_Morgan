package model;
import java.util.*;

public class Client {

	public final static int SILVER = 1;
	public final static double SILVER_DISCOUNT = 0.015;
	public final static int GOLD = 2;
	public final static double GOLD_DISCOUNT = 0.03;
	public final static int PLATINUM = 3;
	public final static double PLATINUM_DISCOUNT = 0.05;
	
	public final static double SILVER_UP_KILOGRAM = 35000;
	public final static double GOLD_UP_KILOGRAM = 55000;
	public final static double GOLD_UP_PAID = 2000000;
	public final static double PLATINUM_UP_PAID = 5000000;
	
	private String name;
	private int id;
	private String idIssue;
	private double kilosTransported;
	private double amountPaid;
	private int type;
	private double discount;
	

	public Client(String name, int id, String idIssue) {
		this.name = name;
		this.id = id;
		this.idIssue = idIssue;
		
		this.kilosTransported = 0;
		this.amountPaid = 0;
		
		this.type = 0;
		this.discount = 0;
	}
	

	public void updateKilosTransported(double kilosLoad){
		kilosTransported+=kilosLoad;
	}
	
	public void updateAmountPaid(double paidLoad){
		amountPaid+=paidLoad;
	}
	
	public void updateType() {
		if (amountPaid>=5000000){
			type=PLATINUM;
			discount=PLATINUM_DISCOUNT;
		}else if (kilosTransported>=55000||amountPaid>=2000000){
			type=GOLD;
			discount=GOLD_DISCOUNT;
		} else if (kilosTransported>=35000){
			type=SILVER;
			discount=SILVER_DISCOUNT;
		} else {
			type=0;
			discount=0;
		}
	}
	
	
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
	public String getIdIssue(){
		return idIssue;
	}
	public double getKilosTransported(){
		return kilosTransported;
	}
	public double getAmountPaid(){
		return amountPaid;
	}
	public int getType(){
		return type;
	}
	public double getDiscount(){
		return discount;
	}
	

}