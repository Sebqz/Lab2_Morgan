package ui;
import model.*;
import java.util.Scanner;

public class Menu{
	

	private final static int MAKE_TRIP = 1;
	private final static int SHOW_CLIENTS = 2;
	private final static int EXIT = 3;
	
	private final static int ADD_LOAD = 1;
	private final static int SHOW_WEIGHT = 2;
	private final static int LEAVE = 3;
	private final static int EXIT_LOAD = 4;
	

	private Ship ship;
	

	public Menu() {
		ship = new Ship();
	}
	
	public void showMainMenu(){
		System.out.println("Bienvenido Sr. Morgan, ¿que desea realizar?:"+
		"\n(1) Hacer un viaje"+
		"\n(2) Mostrar la informacion de los clientes"+
		"\n(3) Salir del programa\n");
	}
	
	public void showLoadMenu(){
		System.out.println("Bien, continua con alguna de estas opciones:"+
		"\n(1) Añadir una carga"+
		"\n(2) Mostrar el peso del viaje actual"+
		"\n(3) Zarpar\n");
	}
	
	public int readOption(){
		Scanner reader = new Scanner(System.in);
		int choice = Integer.parseInt(reader.nextLine());
		return choice;
	}
	
	public Load readLoad(){
		Scanner reader = new Scanner(System.in);
		System.out.println("Ingresa la cantidad de cajas");
		int numberBoxes = Integer.parseInt(reader.nextLine());
		
		System.out.println("Ingresa el peso de las caja en gramos:");
		double boxWeight = Integer.parseInt(reader.nextLine())/1000;
		
		int type=0;
		do{
			System.out.println("Ingresa el tipo de carga:"+
			"\n(1) Peligrosa"+
			"\n(2) Perecedera"+ 
			"\n(3) No perecedera");
			type = Integer.parseInt(reader.nextLine());
		} while (type<1||type>3);
		
		int position=0;
		do{
			System.out.println("Escoge uno de los clientes:"+
			"\n(1) Id: 101"+
			"\n(2) Id: 102"+
			"\n(3) Id: 103"+
			"\n(4) Id: 104"+
			"\n(5) Id: 105");
			position = Integer.parseInt(reader.nextLine());
		} while (position<1||position>5);
		
		Client client = ship.searchClientPosition(position);
		Load load = null;
		if(ship.verifyNewLoad(numberBoxes,boxWeight,type)){
			load = new Load(numberBoxes,boxWeight,type,client);
		}
		return load;
	}
	
	public void ShowClientInfo(){
		Scanner reader = new Scanner(System.in);
		int position=0;
		do{
			System.out.println("Escoge uno de los clientes:"+
			"\n(1) Id: 101"+
			"\n(2) Id: 102"+
			"\n(3) Id: 103"+
			"\n(4) Id: 104"+
			"\n(5) Id: 105");
			position = Integer.parseInt(reader.nextLine());
		} while (position<1||position>5);
		System.out.println(ship.getInfoClient(position));
	}
	
	public void doOperationMainMenu(int choice){
		switch(choice){
			case MAKE_TRIP:
				ship.addTrip();
				int option=0;
				do {
					showLoadMenu();
					option = readOption();
					doOperationLoadMenu(option);
				} while(option!=4);
				
			break;
			
			case SHOW_CLIENTS:
				ShowClientInfo();
			break;
			
			case EXIT:
			break;
		}
	}
	
	public void doOperationLoadMenu(int option){
		switch(option){
			case ADD_LOAD:
				Load load = readLoad();
				ship.addLoad(load);
			break;
		
			case SHOW_WEIGHT:
				System.out.println(ship.getTripWeight());
			break;
		
			case LEAVE:
				if(ship.updateClientRange()){
					System.out.println("El viaje se ha realizado!");
					option=4;
				} else {
					System.out.println("Aun no puedes zarpar, necesitas al menos dos cargas o un peso mayor a 12000kg\n");
				}
			break;
			
			case EXIT_LOAD:
				int choice=0;
				do {
					showMainMenu();
					option = readOption();
					doOperationMainMenu(choice);
				}while(choice!=3);
		}
	}
	
	public void startProgram(){
		ship.setClients();
		int choice=0;
		do {
			showMainMenu();
			choice = readOption();
			doOperationMainMenu(choice);
		} while(choice!=3);
	}
	
	
	
	
	
	
	
	
	
}