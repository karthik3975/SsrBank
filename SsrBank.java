import java.util.*;

class SsrBankEntity {
	private String accountNum; // creating a string for account number
	private String accHolName; // creating a string for account holder
	private long accBal; // creating a long integer for account balance
	Scanner scanDetails = new Scanner(System.in);

	void openAccount()// This is the method to open the account
	{
		System.out.print("Enter Account Number: ");
		accountNum = scanDetails.next();
		System.out.print("Enter Account Holder Name: ");
		accHolName = scanDetails.next();
		System.out.print("Enter Account balance: ");
		accBal = scanDetails.nextLong();
	}

	void showAccount() // This is the method to display
	{
		System.out.println("Account Number: " + accountNum);
		System.out.println("Account Holder Name: " + accHolName);
		System.out.println("Account current Balance: " + accBal);
	}

	void deposit() // This the method to deposit
	{
		long amt;
		System.out.println("Enter amount that you want to deposit funds : ");
		amt = scanDetails.nextLong();
		accBal = accBal + amt;
	}

	void withdrawal() // This is the method to withdrawal
	{
		long amt;
		System.out.println("Enter Amount that you Want to withdraw your funds : ");
		amt = scanDetails.nextLong();
		if (accBal >= amt) {
			accBal = accBal - amt;
		} else {
			System.out.println("Insufficient Balance...Transaction Failed...");
		}
	}

	boolean search(String san)// This is the method to search a given account number
	{
		if (accountNum.equals(san)) {
			showAccount();
			return (true);
		}
		return (false);
	}
}

public class SsrBank // main class
{
	public static void main(String arg[]) {
		Scanner scanDetails = new Scanner(System.in);
		// This is the place where create our account
		System.out.print("Number of accounts do you want to open : ");
		int n = scanDetails.nextInt();
		SsrBankEntity ssrBankObj[] = new SsrBankEntity[n];
		for (int i = 0; i < ssrBankObj.length; i++) {
			ssrBankObj[i] = new SsrBankEntity();
			ssrBankObj[i].openAccount();
		}
		// Here we are running the loop until the number 5 is entered by the user
		int enterYourChoice;
		do {
			System.out.println(
					"Main Menu\n1. Display All\n2. Search By Account\n3. Deposit Funds \n4. Withdrawal Fund \n5. Exit ");
			System.out.println("Enter your Choice :");
			enterYourChoice = scanDetails.nextInt();
			switch (enterYourChoice) {
			case 1: // case 1 to Display all
				for (int i = 0; i < ssrBankObj.length; i++) {
					ssrBankObj[i].showAccount();
				}
				break;

			case 2: // case 2 search by account
				System.out.print("Enter Account No U Want to Search...: ");
				String san = scanDetails.next();
				boolean found = false;
				for (int i = 0; i < ssrBankObj.length; i++) {
					found = ssrBankObj[i].search(san);
					if (found) {
						break;
					}
				}
				if (!found) {
					System.out.println("Search Failed..Account Not Exist..");
				}
				break;

			case 3: // case 3 Deposit funds
				System.out.print("Enter Account No : ");
				san = scanDetails.next();
				found = false;
				for (int i = 0; i < ssrBankObj.length; i++) {
					found = ssrBankObj[i].search(san);
					if (found) {
						ssrBankObj[i].deposit();
						break;
					}
				}
				if (!found) {
					System.out.println("Search Failed..Account Not Exist..");
				}
				break;

			case 4: // case 4 withdraw funds
				System.out.print("Enter Account No : ");
				san = scanDetails.next();
				found = false;
				for (int i = 0; i < ssrBankObj.length; i++) {
					found = ssrBankObj[i].search(san);
					if (found) {
						ssrBankObj[i].withdrawal();
						break;
					}
				}
				if (!found) {
					System.out.println("Search Failed..Account Not Exist..");
				}
				break;

			case 5: // case 5 exit
				System.out.println("Thank You for choosing SSR Bank :)");
				break;
			}
		} while (enterYourChoice != 5);
		scanDetails.close();
	}
} // End of the program