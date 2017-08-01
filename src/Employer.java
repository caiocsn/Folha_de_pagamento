import java.util.Scanner;
import java.util.Hashtable;

public class Employer {
	
	private Hashtable<Integer, History> history;
	private String name;
	private String address;
	private int type; //1- hourly, 2- salaried, 3-commissioned
	private String type_name;
	private int id;
	private String payment_type;
	private double salary;
	public String payment_method;
	private int sindicated;
	private double sind_tax;
	public int next_payment;
	private int day_created;
	
	public Employer(int id, String name, String address, int type, double salary, int today) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.type = type;
		this.salary = salary;
		this.payment_method = "bank";
		this.sindicated = 0;
		this.day_created = today;
		this.generate_type_name();
		this.history = new Hashtable<Integer,History>();
		System.out.printf("%s employer created!\n name:%s \n address:%s \n id:%d \n",this.type_name, this.name,this.address,this.id);		

	}

	private  void generate_type_name() {
		switch(this.type){
		case 1:
			this.type_name = "Hourly";
			this.payment_type = "weekly";
			break;
		case 2:
			this.type_name = "Salaried";
			this.payment_type = "monthly";
			break;
		case 3:
			this.type_name = "Comissioned";
			this.payment_type = "biweekly";
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
		
		this.history.get(day).tax += value;
		
		System.out.printf("The total value of tax for the day %d is: $%.2f \n ",day, this.history.get(day).tax);
	}
	
	public void set_hour(double value, int day) {
		if(this.history.get(day) == null)
			this.history.put(day, new History());
		
		if(value > 8.0) 
			value += (value-8)*0.5;
		this.history.get(day).hours += value;
		
		System.out.printf("The total value of hours for the day %d is: $%.2f \n ",day,this.history.get(day).hours);

	}
	
	public void set_comission(double value, int day) {
		if(this.history.get(day) == null)
			this.history.put(day, new History());
		
		this.history.get(day).sales += value;
		
		System.out.printf("The total value of comission for the day %d is: $%.2f \n ",day,this.history.get(day).sales);

	}

	public void set_payment_method(String method) {
		this.payment_method = method;
	}
	
	public void set_name(String name) {
		this.name = name;
	}
	
	public void set_address(String address) {
		this.address = address;
	}

	public void set_sind(int sind) {
		this.sindicated = sind;
	}
	
	public void set_sind_tax(double tax) {
		this.sind_tax = tax;
	}
	
	public void set_payment_type(String type) {
		this.payment_type = type;
	}
}

