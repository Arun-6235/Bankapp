import java.util.Scanner;


class Bank {
    private String accno;
    private String name;
    private long balance;
    private String CustId;
    private double Phno;





    Scanner KB = new Scanner(System.in);


    void openAccount() {
        System.out.print("Enter Account No: ");
        accno = KB.next();
        System.out.print("Enter Name: ");
        name = KB.next();
        System.out.print("Enter Balance: ");
        balance = KB.nextLong();
    }

    void showAccount() {
        System.out.println("Customer Account No :  "+ accno + "\n Customer Name : " + name + "\n Customer Account Balance : " + balance);
    }

    void deposit() {
        long amt;
        System.out.println("Enter Amount U Want to Deposit : ");
        amt = KB.nextLong();
        balance = balance + amt;
        System.out.println("\n Balance Updated \n \n Current Balance : "+balance);


    }

    void withdrawal() {
        long amt;
        System.out.println("Enter Amount U Want to withdraw : ");
        amt = KB.nextLong();
        if (balance >= amt) {
            balance = balance - amt;
            System.out.println("\n Balance Updated \n \n Current Balance : "+balance);



        } else {
            System.out.println("Less Balance..Transaction Failed..");
        }
    }

    boolean search(String acn) {
        if (accno.equals(acn)) {
            showAccount();
            return (true);
        }
        return (false);
    }
}

 class ExBank {
    public static void main(String arg[]) {
        Scanner KB = new Scanner(System.in);

        //create initial accounts
        System.out.print("How Many Customer U Want to Input : ");
        int n = KB.nextInt();
        Bank C[] = new Bank[n];
        for (int i = 0; i < C.length; i++) {
            C[i] = new Bank();
            C[i].openAccount();
        }

        //run loop until menu 5 is not pressed
        int ch;
        do {

            System.out.println("\t Main Menu\n 1. Display All\n 2. Search By Account\n 3. Deposit\n 4. Withdrawal\n 5.Exit ");
            System.out.println("Ur Choice :"); ch = KB.nextInt();
            switch (ch) {
                case 1:
                    for (int i = 0; i < C.length; i++) {
                        C[i].showAccount();
                    }
                    break;

                case 2:
                    System.out.print("Enter Account No U Want to Search...: ");
                    String acn = KB.next();
                    boolean found = false;
                    for (int i = 0; i < C.length; i++) {
                        found = C[i].search(acn);
                        if (found) {
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Search Failed..Account Not Exist..");
                    }
                    break;

                case 3:
                    System.out.print("Enter Account No : ");
                    acn = KB.next();
                    found = false;
                    for (int i = 0; i < C.length; i++) {
                        found = C[i].search(acn);
                        if (found) {
                            C[i].deposit();
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Search Failed..Account Not Exist..");
                    }
                    break;

                case 4:
                    System.out.print("Enter Account No : ");
                    acn = KB.next();
                    found = false;
                    for (int i = 0; i < C.length; i++) {
                        found = C[i].search(acn);
                        if (found) {
                            C[i].withdrawal();
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Search Failed..Account Doesn't Exist...");
                    }
                    break;

                case 5:
                    System.out.println("Good Bye..");
                    break;
            }
        }
        while (ch != 5);
    }
}