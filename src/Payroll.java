import java.util.ArrayList;

public class Payroll {
	ArrayList<Employer> employers;
	int id_count;
	int today;

	public Payroll(){
		employers = new ArrayList();
		this.id_count = 1;
		this.today = 1;
	}

	public void add_employer(){
		Employer new_employer =  new Employer(id_count);
		this.employers.add(new_employer);
		this.id_count ++;
	}

	public void add_employer(String name, String address, int type) {
		if(type > 0 && type < 4) {
			Employer new_employer = new Employer(id_count,name,address,type);
			this.employers.add(new_employer);
			this.id_count ++;
		}
		else
			System.out.println("Invalid employe s type.");
	}
	
	public void remove_employer(int id){
		int i = employer_search(id);
		
		if(i >= 0) {
			this.employers.remove(i);
			System.out.printf("Employer id = %d removed.\n", id);
		}
		else
			System.out.print("Please, enter a valid ID.");
	}
	
	private int employer_search(int id) {
		for(int i = 0; i < this.employers.size(); i++){
			if(this.employers.get(i).get_id() == id)
				return i;
		}
		return -1;
	}
	
	public void set_tax(int id, int day, double value) {
		int i = this.employer_search(id);
		this.employers.get(i).set_tax(value, day);
	}
	
	public void set_comission(int id, int day, double value) {
		int i = this.employer_search(id);
		this.employers.get(i).set_comission(value, day);
	}
	
	public void set_hour(int id, int day, double value) {
		int i = this.employer_search(id);
		this.employers.get(i).set_hour(value, day);
	}
	
}
