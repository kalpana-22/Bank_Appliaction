import java.util.*;

class User{
	String name;
	String NIC;
	int date;
	String month;
	int year;
	String address;
}
class Account extends User{
	int min_amount = 1000;
	int tot_amount;
	int id;
}
class Bank{
	
	int acc_num = 1;
	int count = 0;
	Account[] accounts = new Account[0];
		
	Scanner scanner = new Scanner(System.in);

	public int amountPolicy(int amount){
		if(amount<1000){
			System.out.print("Deposite Amount should be more than or equal Rs.1000/= ");
			System.out.print("Deposite amount: ");
			int deposite = scanner.nextInt();
			amountPolicy(deposite);
		}
		return amount;
	}

	//create Accout-> option 1:
	public void createAccount(){		
		Account acc = new Account();
		
		System.out.print("Enter name: ");
		
		acc.name = scanner.nextLine();
		
		System.out.print("Enter date: ");
		acc.date = scanner.nextInt();
		System.out.print("Enter month: ");
		scanner.nextLine();
		acc.month = scanner.nextLine();
		System.out.print("Enter year: ");
		acc.year = scanner.nextInt();
		System.out.print("Enter address: ");
		scanner.nextLine();
		acc.address = scanner.nextLine();
		System.out.print("Deposite ammount: ");
		acc.tot_amount = scanner.nextInt();
		acc.tot_amount = amountPolicy(acc.tot_amount);
		System.out.print("Enter NIC number: ");
		scanner.nextLine();
		acc.NIC = scanner.nextLine();
		String[] arrOfStr = acc.NIC.split("v");

		try {
			int value = Integer.parseInt(arrOfStr[0]);
			if(String.valueOf(value).length()==9){
				System.out.println("NIC is valid format");
				
				Account[] array = new Account[accounts.length+1];
				for(int i=0; i<accounts.length; i++){
					array[i] = accounts[i];
				}
				acc.id = acc_num++;
				array[count++] = acc;
				accounts = array;
				System.out.println("Successfully added... "+accounts[accounts.length-1].id);
				
			}else{
				System.out.println("NIC number length is incorrect. Try again..");
			}
		}catch (NumberFormatException e) {
			System.out.println("NIC is not valid format. Try again...");
		}
	
	}
	
	//search account -> ID
	public boolean searchAccountId(int a_id){
		for(Account a1:accounts){
			if(a1.id==a_id){
				return true;
			}
		}
		return false;
	}
	//search account -> NIC
	public boolean searchAccountNIC(String nic){
		for(Account a1:accounts){
			if(nic.equalsIgnoreCase(a1.NIC)){
				return true;
			}
		}
		return false;
	}
	
	//print account numbers-> NIC
	public void  printAccountIds(String nic){
		int[] a = new int[30];
		int b=0;
		for(Account a1:accounts){
			if(nic.equalsIgnoreCase(a1.NIC)){
				a[b]=a1.id;
				System.out.println("Account Number: "+a[b]);
				b++;
			}
		}
	}
	
	//show account ids related to NIC
	public void showAccoutId(Account a1){
		System.out.println("Account Number: "+a1.id);
	}
	
	//show data
	public void showData(Account acc){
		System.out.println("Account Number: "+acc.id);
		System.out.println("Name: "+acc.name);
		System.out.println("NIC : "+acc.NIC);
		System.out.println("Ammount: "+acc.tot_amount);
		System.out.println("Date Of Birth: "+acc.date+"/"+acc.month+"/"+acc.year);
		System.out.println("Address : "+acc.address);	
	}
	
	//check Account related to NIC-> option :
	public void checkAccountUsingNIC(){
		System.out.print("Enter NIC number > ");
		String number = scanner.nextLine();
		if(searchAccountNIC(number)){
			printAccountIds(number);
		}else{
			System.out.println("no account");
		}		
	}
	
	//check Account related to Account Id-> option 2:
	public void checkAccountUsingId(){
		System.out.print("Enter accout number > ");
		int number = scanner.nextInt();
		if(searchAccountId(number)){
			int i=0; 
			while(i<accounts.length){
				if(accounts[i].id==number){
					showData(accounts[i]);
					/*System.out.println("Account Number: "+accounts[i].id);
					System.out.println("Name: "+accounts[i].name);
					System.out.println("NIC : "+accounts[i].NIC);
					System.out.println("Ammount: "+accounts[i].tot_amount);
					System.out.println("Date Of Birth: "+accounts[i].date+"/"+accounts[i].month+"/"+accounts[i].year);
					System.out.println("Address : "+accounts[i].address);	*/
				}
				i++;
			}
		}else{
			System.out.println("invalid account number");
		}
		scanner.nextLine();		
	}
	
	//Deposite-> Option - 4:
	public void deposite(){
		System.out.print("Enter accout number > ");
		int number = scanner.nextInt();
		if(searchAccountId(number)){
			System.out.print("Enter deposite amount > ");
			int money = scanner.nextInt();
			int i=0; 
			while(i<accounts.length){
				if(accounts[i].id==number){
					accounts[i].tot_amount+=money;
					System.out.println("Total Balance: "+accounts[i].tot_amount);
				}
				i++;
			}
		}else{
			System.out.println("invalid account number");
		}
		scanner.nextLine();	
	}
	
	//check account balnce withraw ammount
	public void checkAmmount(Account acc){
		int i=0; 
		while(i<accounts.length){
			if(accounts[i].id==acc.id){
				System.out.println("Your Account Balance is Rs.: "+accounts[i].tot_amount);
				System.out.print("How much do you want to withdraw > ");
				int money = scanner.nextInt();
				//scanner.nextLine();
				if((accounts[i].tot_amount-accounts[i].min_amount)>=money){
					accounts[i].tot_amount-=money;
					System.out.println("Withdraw Successfuly.. Now Your Account Balance is Rs."+accounts[i].tot_amount);
				}else{
					System.out.print("Withdrawal Unsuccessfuly.. Try to withdraw again (y/n): ");
					scanner.nextLine();
					String answer = scanner.nextLine();
					switch(answer){
						case "n" :
						case "N" : System.out.print("Welcome!"); break;
						case "y" :
						case "Y" : checkAmmount(acc); break;
					}
				}
				break;
			}
		}
	}
	
	//Withdraw-> Option - 5:
	public void withdaw(){
		System.out.print("Enter accout number > ");
		int number = scanner.nextInt();
		if(searchAccountId(number)){
			int i=0; 
			while(i<accounts.length){
				if(accounts[i].id==number){
					/*System.out.println("Your Account Balance is Rs.: "+accounts[i].tot_amount);
					System.out.print("How much do you want to withdraw > ");
					int money = scanner.nextInt();
					if((accounts[i].tot_amount-accounts[i].min_amount)>=money){
						
					}*/
					checkAmmount(accounts[i]);
				}
				i++;
			}
		}else{
			System.out.println("invalid account number");
		}
		scanner.nextLine();	
	}
	
	public void removeAccount(){
		System.out.print("Enter Account Number :");
		int id = scanner.nextInt();
		if(searchAccountId(id)){
			int i=0; 
			while(i<accounts.length){
				if(accounts[i].id==id){
					System.out.println("Account Number: "+accounts[i].id);
					System.out.println("Name: "+accounts[i].name);
					System.out.println("NIC : "+accounts[i].NIC);
					System.out.println("Ammount: "+accounts[i].tot_amount);
					System.out.println("Date Of Birth: "+accounts[i].date+"/"+accounts[i].month+"/"+accounts[i].year);
					System.out.println("Address : "+accounts[i].address);
					accounts[i].name = "***Closed***";
					accounts[i].NIC = "***Closed***";
					accounts[i].date = -1;
					accounts[i].month = "***Closed***";
					accounts[i].year = -1;
					accounts[i].address = "***Closed***";
					accounts[i].min_amount = -1;
					accounts[i].tot_amount = -1;
				}
				i++;
			}
		}else{
			System.out.println("invalid account number");
		}
		scanner.nextLine();	
	}
}

class Demo{
	
	//clear code
	public final static void clearConsole() { 
		try {
			final String os = System.getProperty("os.name"); 
			if (os.contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
				System.out.print("\033[H\033[2J"); 
				System.out.flush();
			}
		} catch (final Exception e) {
			e.printStackTrace();
			// Handle any exceptions.
		}
	}
	
	public static void main(String args[]){
		Bank bank1 = new Bank();
		//bank1.createAccount();
		
		
		Scanner input = new Scanner(System.in);
		
		String option;
		do{
			clearConsole();
			System.out.println("-----------------------------------------------------------------------------------------------------------------");
			System.out.println("|					WELCOME TO BANK SYSTEM					|");
			System.out.println("-----------------------------------------------------------------------------------------------------------------");
			
			System.out.println("[1]  Create Account			[2]  View Account");
			System.out.println("[3]  View Account Using NIC		[4]  Deposite");
			System.out.println("[5]  Withdrow				[6]  Remove Account");
			
			System.out.print("Enter an option to continue >");
			option = input.nextLine();
			
			switch(option){
				case "1": System.out.println("Your Option is [1]"); try{Thread.sleep(2000);}catch(Exception ex){} clearConsole(); 
				System.out.println("-----------------------------------------------------------------------------------------------------------------");
				System.out.println("|							CREATE NEW ACCOUNT						|");
				System.out.println("-----------------------------------------------------------------------------------------------------------------");
				bank1.createAccount(); try{Thread.sleep(2000);}catch(Exception ex){} break;
				
				case "2": System.out.println("Your Option is [2]"); try{Thread.sleep(2000);}catch(Exception ex){} clearConsole(); 
				System.out.println("-----------------------------------------------------------------------------------------------------------------");
				System.out.println("|						VIEW ACCOUNT					|");
				System.out.println("-----------------------------------------------------------------------------------------------------------------");
				bank1.checkAccountUsingId(); try{Thread.sleep(2000);}catch(Exception ex){} break;
				
				case "3": System.out.println("Your Option is [3]"); try{Thread.sleep(2000);}catch(Exception ex){} clearConsole(); 
				System.out.println("-----------------------------------------------------------------------------------------------------------------");
				System.out.println("|							VIEW ACCOUNTS -> NIC						|");
				System.out.println("-----------------------------------------------------------------------------------------------------------------");
				bank1.checkAccountUsingNIC(); try{Thread.sleep(2000);}catch(Exception ex){} break;
				
				case "4": System.out.println("Your Option is [4]"); try{Thread.sleep(2000);}catch(Exception ex){} clearConsole(); 
				System.out.println("-----------------------------------------------------------------------------------------------------------------");
				System.out.println("|						DEPOSITE						|");
				System.out.println("-----------------------------------------------------------------------------------------------------------------");
				bank1.deposite(); try{Thread.sleep(2000);}catch(Exception ex){} break;
				
				case "5": System.out.println("Your Option is [5]"); try{Thread.sleep(2000);}catch(Exception ex){} clearConsole();
				System.out.println("-----------------------------------------------------------------------------------------------------------------");
				System.out.println("|						WITHDRAW						|");
				System.out.println("-----------------------------------------------------------------------------------------------------------------");
				bank1.withdaw(); try{Thread.sleep(2000);}catch(Exception ex){} break;
				
				case "6": System.out.println("Your Option is [6]"); try{Thread.sleep(2000);}catch(Exception ex){} clearConsole(); 
				System.out.println("-----------------------------------------------------------------------------------------------------------------");
				System.out.println("|						RMOVE ACCOUNT					|");
				System.out.println("-----------------------------------------------------------------------------------------------------------------");		
				bank1.removeAccount(); try{Thread.sleep(2000);}catch(Exception ex){} break;
				
				case "y": ; 
				case "Y": return;
				}
			
			}
		while(true);
		
		}

}	
