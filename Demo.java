import java.util.*;

class User{
	
	String name;
	String id;
	int date;
	String month;
	int year;
	String address;
	/*
	public void insertName(){
		System.out.println("Enter name: ");
		this.name = scanner.nextLine();
	}
	public void insertId(){
		System.out.println("Enter id: ");
		this.id = scanner.nextLine();
	}
	public void insertDate(){
		System.out.println("Enter date: ");
		this.date = scanner.nextInt();
	}
	public void insertMonth(){
		System.out.println("Enter month: ");
		this.month = scanner.nextLine();
	}
	public void insertYear(){
		System.out.println("Enter year: ");
		this.year = scanner.nextInt();
	}
	public void insertAddress(){
		System.out.println("Enter address: ");
		this.address = scanner.nextLine();
	}*/
}
class Account_Info extends User{
	//User person;
	int min_amount = 1000;
	int tot_amount;
	int id;
}
class Account{
	
	int count = 0;
	Account_Info[] accounts = new Account_Info[0];
		
	Scanner scanner = new Scanner(System.in);

	/*public void isInteger(String s){
		try {
			int value = Integer.parseInt(s);
			if(String.valueOf(value).length()==9){
				System.out.println("NIC is in valid format");
			}else{
				System.out.println("NIC number length is incorrect");
			}
		}catch (NumberFormatException e) {
			System.out.println("NIC is not valid format");
		}
	}*/
	
	public int amountPolicy(int amount){
		if(amount<=1000){
			System.out.print("Deposite Amount should be more than Rs.1000/= ");
			System.out.print("Deposite amount: ");
			int deposite = scanner.nextInt();
			amountPolicy(deposite);
		}
		return amount;
	}

	public void createAccount(){		
		System.out.print("Enter name: ");
		String name = scanner.nextLine();
		System.out.print("Enter date: ");
		int date = scanner.nextInt();
		System.out.print("Enter month: ");
		scanner.nextLine();
		//System.out.print();
		String month = scanner.nextLine();
		//System.out.println();
		System.out.print("Enter year: ");
		int year = scanner.nextInt();
		System.out.print("Enter address: ");
		String address = scanner.nextLine();
		scanner.nextLine();
		System.out.print("Deposite ammount: ");
		int amount = scanner.nextInt();
		amount = amountPolicy(amount);
		System.out.print("Enter NIC number: ");
		scanner.nextLine();
		String NIC = scanner.nextLine();
		String[] arrOfStr = NIC.split("v");

		try {
			int value = Integer.parseInt(arrOfStr[0]);
			if(String.valueOf(value).length()==9){
				System.out.println("NIC is in valid format");
				
				
				
			}else{
				System.out.println("NIC number length is incorrect. Try again..");
			}
		}catch (NumberFormatException e) {
			System.out.println("NIC is not valid format. Try again...");
		}
	}
}

class Demo{
	public static void main(String args[]){
		Account account1 = new Account();
		account1.createAccount();
	}	
}
