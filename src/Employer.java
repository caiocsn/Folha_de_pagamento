import java.util.Scanner;

public class Employer {
	History history;
	String name;
	String address;
	int type; //1- hourly, 2- salaried, 3-commissioned
	int id;

	public Employer(int id){
		history = new History();
		this.id = id;
		create_employer();
	}

	private void create_employer(){

		Scanner scan = new Scanner(System.in);

		System.out.println("Please, type the employer name");
		this.name = scan.nextLine();

		System.out.println("Now type the address");
		this.address = scan.nextLine();

		System.out.println("What is the employers type? Press: 1- hourly, 2- salaried, 3-commissioned");

		int type_input = scan.nextInt();

		while(type_input!= 1 && type_input!= 2 && type_input != 3){
			switch(type_input){
			case 1:
				this.type = 1;
				break;
			case 2:
				this.type = 2;
				break;
			case 3:
				this.type = 3;
				break;
			default:
				System.out.println("Please, enter a valid type ...");
				type_input = scan.nextInt();
			}
		}
	}

	public int get_id(){
		return this.id;
	}
}
