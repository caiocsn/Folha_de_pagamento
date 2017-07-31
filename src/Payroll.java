import java.util.ArrayList;

public class Payroll {
	ArrayList<Employer> employers;
	int id_count;

	public Payroll(){
		employers = new ArrayList();
		this.id_count = 1;

	}

	public void add_employer(){
		Employer new_employer =  new Employer(id_count);
		this.employers.add(new_employer);
		this.id_count ++;
	}

	public Employer remove_employer(int id){
		Employer to_remove = new Employer(0);
		for(int i = 0; i < this.employers.size(); i++){
			if(this.employers.get(i).get_id() == id){
				to_remove =this.employers.get(i);
				break;
			}
		}
			return to_remove;
	}
}
