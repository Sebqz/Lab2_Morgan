package model;
import java.util.*;

public class Ship {

	public final static int CLIENTS=5;
	private String name;
	private String pilot;
	

	private Client[] clients;
	private ArrayList<Trip> trips;
	

	public Ship (){
		name = "El pirata";
		pilot = "Morgan";
		clients = new Client[CLIENTS];
		trips = new ArrayList<Trip>();
	}
	

	public void addTrip(){
		Trip newTrip = new Trip();
		trips.add(newTrip);
	}
	

	public boolean verifyNewLoad(int numberBoxes, double boxWeight, int type){
		Trip trip = trips.get(trips.size()-1);
		boolean types = trip.verifyTypes(type);
		boolean tripsWeight = trip.verifyWeight(numberBoxes,boxWeight);
		if(!types)
			System.out.println("El tipo de carga no se puede agregar.");
		if(!tripsWeight)
			System.out.println("El peso supera el limite del viaje.");
		return types&&tripsWeight;
	}
	

	public void addLoad(Load load){
		if(load!=null){
			Trip trip = trips.get(trips.size()-1);
		
			trip.addLoad(load);
		
			Client client = load.getClient();
		
			client.updateKilosTransported(trip.getBoxWeight()*trip.getNumberBoxes());
			client.updateAmountPaid(trip.getPriceLoad());

			System.out.println(trip.getPriceLoad());

			trip.updatePrice();
			trip.updateWeight();
		}
	}
	
	public boolean updateClientRange(){
		boolean result = false;
		Trip trip = trips.get(trips.size()-1);
		if(trip.doTrip()){
			for(int i=0; i<CLIENTS;i++){
				clients[i].updateType();
			}
			result = true;
		}
		return result;
	}
	

	public double getTripWeight(){
		Trip trip = trips.get(trips.size()-1);
		return trip.getWeight();
	}
	

	public void setClients(){
		String name="";
		int id=0;
		String idIssue="";
		
		for (int i=0;i<CLIENTS;i++){
			name="Cliente"+Integer.toString(i+1);
			id=100+(i+1);
			idIssue="5 de enero del 202"+(i+1);
			clients[i] = new Client(name,id,idIssue);
		}
	}
	

	public Client searchClient(int id){
		Client result = null;
		for(int i=0; i<CLIENTS;i++){
			if(clients[i].getId()==id){
				result = clients[i];
			}
		}
		return result;
	}
	
	public Client searchClientPosition(int position){
		Client result = clients[position-1];
		return result;
	}
	
	
	public String getInfoClient(int position){
		Client selectClient = searchClientPosition(position);
		String result = "\nNombre: "+selectClient.getName()+"\n"+
		"Id: "+selectClient.getId()+"\n"+
		"Fecha de expiracion del Id: "+selectClient.getIdIssue()+"\n"+
		"Kilos transportados: "+selectClient.getKilosTransported()+"\n"+
		"Cantidad pagada: "+selectClient.getAmountPaid()+"\n"+
		"Tipo: "+selectClient.getType()+"\n"+
		"Descuento: "+selectClient.getDiscount()+"\n";
		return result;
	}
	
	
}
