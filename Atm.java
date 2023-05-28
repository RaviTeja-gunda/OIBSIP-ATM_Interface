import java.util.*;
public class Atm{
	static ArrayList<Bank> b=new ArrayList<>();
	public static void main(String yfj[]){

		//Existing bank users
		System.out.println();
		System.out.println();
		System.out.println("Existing Bank account holders");
		b.add(new Bank("raviteja","123456"));
		b.add(new Bank("rakesh","123456"));
		b.add(new Bank("ramireddy","123456"));
		b.add(new Bank("manikanta","123456"));
		System.out.println(b);
		System.out.println();


		Scanner s=new Scanner(System.in);
		boolean status=true;
		System.out.print("Enter User Name: ");
		String user=s.nextLine();
		System.out.print("Enter User pin: ");
		String pin=s.nextLine();
		for(Bank bank:b){
			if(bank.userid().equals(user) && bank.pin().equals(pin)){
				status=true;
				break;
			}
			else{
				status=false;
			}
		}

		//Creating new account with given credentials for non-existing users
		if(status==false){
			System.out.println();
			System.out.println("Creating your new Account with given credentials......");
			Bank ob=new Bank(user,pin);
			System.out.println("Account created Successfully!!!");
			b.add(ob);
		}
		for(Bank bank:b){
			if(bank.userid().equals(user) && bank.pin().equals(pin)){
				while(true)
				{
					System.out.println();
					System.out.println("=============== WELCOME TO ATM ===============");
					System.out.println("|                                            |");
					System.out.println("|            1: Withdraw Money               |");
					System.out.println("|            2: Deposit Money                |");
					System.out.println("|            3: Transfer                     |");
					System.out.println("|            4: Balance                      |");
					System.out.println("|            5: Transaction History          |");
					System.out.println("|            6: Quit                         |");
					System.out.println("|                                            |");
					System.out.println("==============================================");

					System.out.println("Enter your option");
					int op=s.nextInt();
					switch(op)
					{
						case 1:System.out.println();
								System.out.print("Enter amount to withdraw: ");
								double c=s.nextInt();
								bank.withdraw(c);
								break;
						case 2:System.out.println();
								System.out.print("Enter amount to be deposit: ");
								double am=s.nextInt();
								bank.deposit(am);
								break;
						case 3:System.out.println();
								System.out.print("Enter Recipient Account Number: ");
								s.nextLine();
								String acc=s.nextLine();
								System.out.print("Enter amount to Deposit to Account Number "+acc+": ");
								double amt=s.nextDouble();
								bank.transfer(amt,acc);
								break;
						case 4:System.out.println();
								System.out.println("     Your balance is: "+bank.balance());
								break;
						case 5:System.out.println();
								System.out.println("TRANSACTION HISTORY");
								System.out.println();
								bank.history();break;
						case 6:System.exit(1);
						default:System.out.println();
								System.out.println("Enter valid key");
					}
				}
			}
		}
		s.close();
	}
}    