import java.util.Scanner;
import java.util.Hashtable;

public class Employer {
	
	private Hashtable<Integer, History> history;
	private String name;
	private String address;
	private int type; //1- hourly, 2- salaried, 3-commissioned
	private String type_name;
	private int id;


	public Employer(int id){
		this.history = new Hashtable<Integer,History>();
		this.id = id;
		create_employer();				
		System.out.printf("%s employer created!\n name:%s \n address:%s \n id:%d \n",this.type_name, this.name,this.address,this.id);		
	}
	
	public Employer(int id, String name, String address, int type) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.type = type;
		this.generate_type_name();
		this.history = new Hashtable<Integer,History>();
		System.out.printf("%s employer created!\n name:%s \n address:%s \n id:%d \n",this.type_name, this.name,this.address,this.id);		

	}

	private void create_employer(){

		Scanner scan = new Scanner(System.in);

		System.out.println("Please, type the employer name");
		this.name = scan.nextLine();

		System.out.println("Now type the address");
		this.address = scan.nextLine();

		System.out.println("What is the employers type? Press: 1- hourly, 2- salaried, 3-commissioned");

		int type_input = 0;

		while(true){
			type_input = scan.nextInt();
			if(type_input > 0 && type_input < 4) {
				this.type = type_input;
				this.generate_type_name();
				break;
			}
				System.out.println("Please, enter a valid type ...");
			}
		}
	
	private  void generate_type_name() {
		switch(this.type){
		case 1:
			this.type_name = "Hourly";
			break;
		case 2:
			this.type_name = "Salaried";
			break;
		case 3:
			this.type_name = "Comissioned";
			break;
		}
	}

	public int get_id(){
		return this.id;
	}
	
	public String get_name() {
		return this.name;
	}
	
	public void set_tax(double value, int day) {
		if(!this.history.containsKey(day))
			this.history.put(day, new History());
		
		this.history.get(day).synd_tax += value;
		
		System.out.printf("The total value of tax for the day %d is: $%.2f \n ",day, this.history.get(day).synd_tax);
	}
	
	public void set_hour(double value, int day) {
		if(this.history.get(day) == null)
			this.history.put(day, new History());
		
		this.history.get(day).hours += value;
		
		System.out.printf("The total value of hours for the day %d is: $%.2f \n ",day,this.history.get(day).hours);

	}
	
	public void set_comission(double value, int day) {
		if(this.history.get(day) == null)
			this.history.put(day, new History());
		
		this.history.get(day).sales += value;
		
		System.out.printf("The total value of comission for the day %d is: $%.2f \n ",day,this.history.get(day).sales);

	}
}
