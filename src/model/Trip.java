package model;
import java.util.*;

public class Trip {

	public final static double MAXIMUM_KILOS = 28000;
	private double weight;
	private double price;
	

	private ArrayList<Load> loads;
	

	public Trip(){
		weight=0; 
		price=0;
		loads = new ArrayList<Load>();
	}
	

	public int getNumberBoxes(){
		return loads.get(loads.size()-1).getNumberBoxes();
	}
	
	public double getBoxWeight(){
		return loads.get(loads.size()-1).getBoxWeight();
	}

	public void addLoad(Load load){
		loads.add(load);
	}
	

	public void updateWeight(){
		this.weight+=loads.get(loads.size()-1).getWeight();
	}
	
	public void updatePrice(){
		this.price+=loads.get(loads.size()-1).getPrice();
	}
	

	public double getWeight(){
		return weight;
	}
	

	public boolean doTrip(){
		boolean result=false;
		if(loads.size()>=2||weight>12000){
			result=true;
		}
		return result;
	}
	

	public double getPriceLoad(){
		return loads.get(loads.size()-1).getPrice();
	}
	

	public boolean verifyTypes(int type){
		boolean answer = true;
		
		if(type==1){
			for(int i=0;i<loads.size();i++){
				if(loads.get(i).getType()==2)
					answer=false;
			}
		} else if(type==2){
			for(int i=0;i<loads.size();i++){
				if(loads.get(i).getType()==1)
					answer=false;
			}
		} else {
			answer=true;
		}
		return answer;
	}

	public boolean verifyWeight(int numberBoxes, double boxWeight){
		boolean answer = false;
		double weight = numberBoxes*boxWeight;
		double weightLoads = 0;
		
		for(int i=0;i<loads.size();i++){
				weightLoads+=loads.get(i).getWeight();
		}
		
		if(weight>28000){
			answer=false;
		} else if(weightLoads+weight>28000){
			answer=false;
		} else {
			answer=true;
		}
		return answer;
	}
}