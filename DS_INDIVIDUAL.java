import java.util.Scanner;
class Account{
        long Account_number;
        String Account_name;
        int Accholder_age;
        int Account_pin;
        String Account_phonenumber;
        double Acconunt_balance;
        String Accounholder_Email;
    public Account(String account_name,long account_number,int accholder_age, double acconunt_balance,int account_pin, String account_phonenumber,String accounholder_Email) {
                Account_number = account_number;
                Account_name = account_name;
                Accholder_age = accholder_age;
                Account_pin = account_pin;
                Account_phonenumber = account_phonenumber;
                Acconunt_balance = acconunt_balance;
                Accounholder_Email = accounholder_Email;
}
}
class User{
     List userlist=new List();
public void login(){
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter your mobile number");
            String User_mobile = sc.next(); 
            System.out.println("Enter your app login pin");
            int User_login = sc.nextInt();                   //enter mobile number linked with account number
            boolean mobilechecker=userlist.numberchecker(User_mobile);
             boolean userchecker=false;
          if(mobilechecker){
             userchecker=userlist.userchecker(User_mobile, User_login);
          }
          else{
            System.out.println("Enter valid number");
          }
          int ch1;
            do{
            if(userchecker){
                System.out.println("\n**************************\n Plese Select Your Choice \n**************************");
                System.out.println("1] See Your Account Details");
                System.out.println("2] Check balance");
                System.out.println("3] Withdraw Amount");
                System.out.println("4] Deposite Amount");
                System.out.println("5] Change PIN");
                System.out.println("6] Go Back");
                System.out.println("7] Exit");
                System.out.println("*******************\n Enter your choice \n*******************");
               ch1 = sc.nextInt();   //user enter choice hear
               switch (ch1) {
                case 1:{
                    System.out.print("Enter Your Pin : ");
                    int Pin = sc.nextInt();    //user enter pin hear
                    boolean found2 = false;    //check user enter pin is link with bank account or not
                    found2=userlist.userchecker(User_mobile,Pin);
    
                if (!found2) {
                     System.out.println("\n\n-------------------!!!\nInvalid Pin..!!\n-------------------!!!\n\n");
                }
                else{
                      userlist.accountdetail(User_mobile,Pin);
                }
                    break;
                }
                case 2:{
                    System.out.print("Enter Your Pin : ");
                    int Pin = sc.nextInt();    //user enter pin hear
                    boolean found2 = false;    //check user enter pin is link with bank account or not
                    found2=userlist.userchecker(User_mobile,Pin);
        
                if (!found2) {
                    System.out.println("\n\n-------------------!!!\nInvalid Pin..!!\n-------------------!!!\n\n");
                }
                else{
                 userlist.balancedisplay(User_mobile,Pin);
                }
                break;
                }
                case 3:{
                    System.out.print("Enter Your Pin : ");
                    int Pin = sc.nextInt();    //user enter pin hear
                    System.out.println("Enter amount You want to Withdraw");
                    double amount=sc.nextDouble();
                    boolean found2 = false;    //check user enter pin is link with bank account or not
                      found2=userlist.userchecker(User_mobile,Pin);
                if (!found2) {
                    System.out.println("\n\n-------------------!!!\nInvalid Pin..!!\n-------------------!!!\n\n");
                }
                else{
                     userlist.withdraw(User_mobile,Pin, amount);
                }
                break;
                }
                case 4:{
                    System.out.print("Enter Your Pin : ");
                    int Pin = sc.nextInt();    //user enter pin hear
                    System.out.println("Enter amount You want to Deposite");
                    double amount=sc.nextDouble();
                    boolean found2 = false;    //check user enter pin is link with bank account or not
                   found2=userlist.userchecker(User_mobile,Pin);
                if (!found2) {
                    System.out.println("\n\n-------------------!!!\nInvalid Pin..!!\n-------------------!!!\n\n");
                }
                else{
                     userlist.Deposite(User_mobile,Pin, amount);
                }
                break;
                }
                case 5:{
                    System.out.print("Enter Your Pin : ");
                    int Pin = sc.nextInt();    //user enter pin hear
                    boolean found2 = false;    //check user enter pin is link with bank account or not
                    found2=userlist.userchecker(User_mobile,Pin);
                if (!found2) {
                    System.out.println("\n\n-------------------!!!\nInvalid Pin..!!\n-------------------!!!\n\n");
                }
                else{
                    userlist.Change_PIN(User_mobile,Pin);
                }
                    break;
                }
                case 6:{
                    break;
                }
                case 7:{
                      System.out.println("Thank you for using our banking services");
                      System.exit(0);
                        break;
                }
                default:{
                    System.out.println("\n\n-------------------!!!\nInvalid Choice..!!\n-------------------!!!\n\n");
                    break;
                }
            } 
            } 
            else{
                    System.out.println("...NO user found...");
                    break; 
                }
               }while(ch1!=6);
            }
            void add(){
                userlist.initialaddaccountdetail();
            }
public void login1(){
    Scanner sc=new Scanner(System.in);
    int Admin_id=1;
    int Admin_password=111101;
            System.out.println("Enter your login id");
            int id = sc.nextInt(); 
            System.out.println("Enter your app login pin");
            int password = sc.nextInt();   
            int initialaccountnumber=1234567810;
            if(Admin_id==id && Admin_password==password){
                int ch1;
             do{
                System.out.println("\n**************************\n Plese Select Your Choice \n**************************");
                System.out.println("1] Show All Acount Details");
                System.out.println("2] Add New Account");
                System.out.println("3] Delete Account");
                System.out.println("4] Go Back");
                System.out.println("5] Exit");
                System.out.println("*******************\n Enter your choice \n*******************");
               ch1 = sc.nextInt();   //user enter choice hear
               sc.nextLine();
               switch (ch1) {
                case 1: {
                    userlist.display();
                    break;
                }
                case 2:{
            System.out.println("Enter account holder name");
            String account_name=sc.nextLine();
            System.out.println("Enter account holder Email");
            String account_Email=sc.next();
            System.out.println("Enter account holder phone number");
            String account_phonenumber;
          //  System.out.print("PLEASE ENTER YOUR PHONE NUMBER :");
            boolean check=true;
        do {
            account_phonenumber = sc.next();
            int j = 0;
            for (int i = 0; i < account_phonenumber.length(); i++) {
                if (account_phonenumber.charAt(i) >= '0' && account_phonenumber.charAt(i) <= '9')
                    j++;
            }
            char c[] = account_phonenumber.toCharArray();
            for (char cc : c) {
                if (Character.isDigit(cc)) {
                    if (j == 10) {
                        check = false;
                    }
                }
            }
            if (check == true) {
                System.out.println("Enter valid number !!");
            }
        }while(check);
            System.out.println("Enter Account Holder Age");
            int age=sc.nextInt();
            boolean C_P_found = false;
            int account_pin=0;
            while (C_P_found == false) {
            System.out.println("Enter Account Pin");
            account_pin=sc.nextInt();
            if (account_pin >= 1000 && account_pin <= 9999) {
                    C_P_found = true;
                    break;
                }       
                else {
                    System.out.println("\n\n-------------------------------------------!!!\nInvalid Combination , Enter valid PIN\n-------------------------------------------!!!\n\n");
                    C_P_found = false;
                }
            }
            double account_balance;
            do{
            System.out.println("Enter Amount you want to Deposite in your Acconunt minimum deposite amount is 1000");
             account_balance=sc.nextDouble();
            }while(account_balance<=1000);
            initialaccountnumber++;
            long account_number=initialaccountnumber;
            //System.out.println(account_number);
            Account account=new Account(account_name, account_number, age, account_balance, account_pin, 
            account_phonenumber, account_Email);
            userlist.insertAtLast(account);
            System.out.println();
            System.out.println("****************************************************************************");
            System.out.println("*                                                                          *");
            System.out.println("*               Your Account has been Successfully created                 *");
            System.out.println("*                                                                          *");
            System.out.println("****************************************************************************");
            System.out.println();
             userlist.accountdetail(account_phonenumber,account_pin);
        break;
                }
                   case 3:{
                     System.out.println("Enter User Account number");
                     long User_accnumber = sc.nextLong(); 
                  //  System.out.print("Enter Your Pin : ");
                  //  int Pin = sc.nextInt();    //user enter pin hear
                    boolean found2 = false;    //check user enter pin is link with bank account or not
                    found2=userlist.checkaccount(User_accnumber);
                if (!found2) {
                    System.out.println("\n\n-------------------!!!\nInvalid Account Number..!!\n-------------------!!!\n\n");
                }
                else{
                   userlist.deleteValue(User_accnumber);
                   System.out.println();
                   System.out.println("****************************************************************************");
                   System.out.println("*                                                                          *");
                   System.out.println("*             Account has been Successfully Deleted                        *");
                   System.out.println("*                                                                          *");
                   System.out.println("****************************************************************************");
                   System.out.println();
                    break;
                }
                    break;
                }
                case 4:{
                    break;
                }
                case 5:{
                       System.out.println("Thank you for using our banking services");
                       System.exit(0);
                }
                default:{
                    System.out.println("\n\n-------------------!!!\nInvalid Choice..!!\n-------------------!!!\n\n");
                    break;
                }
            } 
             }while(ch1!=4);}
            else{
                System.out.println("....No Admin Found....");
            }
}
}
class List{
        class Node{
            Account account;
            Node next;
            Node prev;
                Node(Account account) {
                    this.account = account;
                    this.next = null;
                    this.prev = null;}
                }
                Node First = null;

            void insertAtLast(Account account) {
                        Node newNode = new Node(account);
                    if (First == null) {
                        First = newNode; } 
                    else {
                        Node temp = First;
                    while (temp.next != null) {
                        temp = temp.next;
                    }
                       temp.next = newNode;
                       newNode.prev = temp; }
                    }


                void display() {
                    if (First == null)
                        {
                        System.out.println("No Account Added");
                        }
                    else
                        {                      
                        Node temp = First;
                    do{
                        System.out.println("\n\n  $$$--------------------------------$$$\n ");
                        System.out.println("Account Number:"+temp.account.Account_number);
                        System.out.println("Account Holder Name:"+temp.account.Account_name);
                        System.out.println("Account Holder Phone number:"+temp.account.Account_phonenumber);
                        //System.out.println("Account Holder Pin:"+temp.account.Account_pin);
                        System.out.println("Account Balance:"+temp.account.Acconunt_balance);
                        System.out.println("\n\n  $$$--------------------------------$$$\n ");
                        temp = temp.next;
                    }while (temp != null);
                    }
                }
                 void initialaddaccountdetail(){
                        Account acc1=new Account("DODIYA MAYURDHVAJSINH PRAVINSINH",1234567801,19,500000.00,1101,"9999999901","dodiyamayurdhvajsinh007");
                        insertAtLast(acc1);
                        Account acc2=new Account("MALL PRINCE MAHENDRAPAL",1234567802, 19, 50000, 1102, "9999999902", "MALLPRINCE23");
                        Account acc3=new Account("PATEL MEET MADHAVLAL",1234567803, 20, 50000, 1103, "9999999903", "meetmadhavlal99");
                        Account acc4=new Account("PATEL RUDRA PANKAJBHAI",1234567804, 21, 50000, 1104, "9999999904", "rudrapatel55");
                        Account acc5=new Account("CHUHAN AJAY JAGDISHBHAI",1234567805, 19, 50000, 1105, "9999999905", "ajayjagdishbhaichauhan81");
                        Account acc6=new Account("GAMI PRANAVKUMAR GHANSHYAMBHAI",1234567806, 22, 50000, 1106, "9999999906", "pranavgami98");
                        Account acc7=new Account("GAMBHAVA BHAVYA JAGDISHBHAI",1234567807, 25, 50000, 1107, "9999999907", "gambhavabhavy456");
                        Account acc8=new Account("THAKKAR HET RAJESHBHAI",1234567808, 20, 50000, 1108, "9999999908", "hetrajeshbhaithakkar121");
                        Account acc9=new Account("PATEL PRIT PRAKASHKUMAR",1234567809, 28, 50000, 1109, "9999999909", "PRITPATEL32");
                        Account acc10=new Account("MALL HELLY VIJAYBHAI",1234567810, 30, 50000, 1110, "9999999910", "mallhelly23");
                        insertAtLast(acc2);
                        insertAtLast(acc3);
                        insertAtLast(acc4);
                        insertAtLast(acc5);
                        insertAtLast(acc6);
                        insertAtLast(acc7);
                        insertAtLast(acc8);
                        insertAtLast(acc9);
                        insertAtLast(acc10);
                }
                  boolean userchecker(String User_mobile,int User_login){
                        Node valueCheck=First;
                        Node temp=null;
                        int flag=0;
                    while (valueCheck != null) {
                    if (valueCheck.account.Account_phonenumber.equals(User_mobile)) {
                        flag = 1;
                        temp=valueCheck;
                    }
                        valueCheck = valueCheck.next;
                    }
                    if (temp.account.Account_pin==User_login) {
                        //     System.out.println("...NO Phonenumber found...");
                        return true;
                    }
                    else{
                        return false;
                    }
                }
                boolean numberchecker(String User_mobile){
                        Node valueCheck=First;
                        int flag = 0;
                    while (valueCheck != null) {
                    if (valueCheck.account.Account_phonenumber.equals(User_mobile)) {
                        flag = 1;
                    }
                        valueCheck = valueCheck.next;
                    }
                    if (flag == 0) {
                        //System.out.println("...NO Pin found...");
                        return false;
                    }
                    else{
                        return true;
                    }
                }
                void accountdetail(String User_mobile,int User_login){
                        Node valueCheck=First;
                        Node temp=null;
                        int flag = 0;
                    while (valueCheck != null) {
                    if (valueCheck.account.Account_phonenumber.equals(User_mobile) && valueCheck.account.Account_pin==User_login) {
                        flag = 1;
                        temp=valueCheck;
                    }   
                        valueCheck = valueCheck.next;
                    }
                    if (flag == 0) {
                        System.out.println("...Invalid Pin found...");
                    }
                    else{
                        System.out.println("\n\n  $$$--------------------------------$$$\n ");
                        System.out.println("Account Number:"+temp.account.Account_number);
                        System.out.println("Account Holder Name:"+temp.account.Account_name);
                        System.out.println("Account Holder Phone number:"+temp.account.Account_phonenumber);
                        System.out.println("Account Holder Pin:"+temp.account.Account_pin);
                        System.out.println("Account Holder Age:"+temp.account.Accholder_age);
                        System.out.println("Account Holder Email:"+temp.account.Accounholder_Email+"@gmail.com");
                        System.out.println("Account Balance:"+temp.account.Acconunt_balance);
                        System.out.println( "\n  $$$--------------------------------$$$\n\n");
                    }
                }

                void balancedisplay(String User_mobile,int User_login){
                        Node valueCheck=First;
                        Node temp=null;
                        int flag = 0;
                    while (valueCheck != null) {
                    if (valueCheck.account.Account_phonenumber.equals(User_mobile) && valueCheck.account.Account_pin==User_login) {
                        flag = 1;
                        temp=valueCheck;
                    }
            
                        valueCheck = valueCheck.next;
                    }
                    if (flag == 0) {
                        System.out.println("...NO Phonenumber found...");
                    }
                    else{
                        System.out.println("\n\n  $$$--------------------------------$$$\n  Balance :" + temp.account.Acconunt_balance + "\n  $$$--------------------------------$$$\n\n");
                    }
                }

                void withdraw(String User_mobile,int User_login,double amount){
                        Node valueCheck=First;
                        Node temp=null;
                        int flag = 0;
                    while (valueCheck != null) {
                    if (valueCheck.account.Account_phonenumber.equals(User_mobile) && valueCheck.account.Account_pin==User_login) {
                        flag = 1;
                        temp=valueCheck;
                    }
                        valueCheck = valueCheck.next;
                    }
                    if (flag == 0) {
                        System.out.println("...NO Phonenumber found...");
                    }
                    else{
                    if(temp.account.Acconunt_balance>amount){
                        System.out.println("--------------Withdrawal Susuccessfully------------");
                        temp.account.Acconunt_balance=temp.account.Acconunt_balance-amount;
                        System.out.println("Your Remaining balance is:");
                        System.out.println("\n\n  $$$--------------------------------$$$\n  Balance :" + temp.account.Acconunt_balance + "\n  $$$--------------------------------$$$\n\n");
                    }
                    else{
                        System.out.println("Not Enough Balance");
                    }
                    }
                }
                void Deposite(String User_mobile,int User_login,double amount){
                        Node valueCheck=First;
                        Node temp=null;
                        int flag = 0;
                    while (valueCheck != null) {
                    if (valueCheck.account.Account_phonenumber.equals(User_mobile) && valueCheck.account.Account_pin==User_login) {
                        flag = 1;
                        temp=valueCheck;
                    }
                        valueCheck = valueCheck.next;
                    }
                    if (flag == 0) {
                        System.out.println("...NO Phonenumber found...");
                    }
                    else{
                    if(temp.account.Acconunt_balance>amount){
                        System.out.println("--------------Deposite Susuccessfully------------");
                        temp.account.Acconunt_balance=temp.account.Acconunt_balance+amount;
                        System.out.println("Your Updated balance is:");
                        System.out.println("\n\n  $$$--------------------------------$$$\n  Balance :" + temp.account.Acconunt_balance + "\n  $$$--------------------------------$$$\n\n");
                    }
                    }
                }
                boolean checkaccount(long User_accnumber){
                      Node valueCheck=First;
                        Node temp=null;
                        int flag = 0;
                    while (valueCheck != null) {
                    if (valueCheck.account.Account_number==User_accnumber) {
                        flag = 1;
                        temp=valueCheck;
                    }
                        valueCheck = valueCheck.next;
                    }
                    if (temp!=null) {
                    return true;
                    }
                    else{
                        return false;
                    }
                }
            void deleteValue(long User_accnumber)
               {
                    if(First== null)
                    {
                         System.out.println("Empty");
                    }
        else if(First.account.Account_number ==User_accnumber)
        {
            First=First.next;
            if(First!=null)
            First.prev = null;
        }
        else
        {
            Node temp = First;
            while(temp!=null &&  temp.account.Account_number!=User_accnumber)
            {
                temp = temp.next;
            }
            if(temp!= null)
            {
                temp.prev.next = temp.next;
                if(temp.next!=null)
                temp.next.prev= temp.prev;
                else 
                {
                temp.prev = null;
                }
            }
            else
            {
                System.out.println("Account not found");
            }

        }
            }   

                void Change_PIN(String User_mobile,int User_login){
                        Node valueCheck=First;
                        Node temp=null;
                        int flag = 0;
                    while (valueCheck != null) {
                    if (valueCheck.account.Account_phonenumber.equals(User_mobile) && valueCheck.account.Account_pin==User_login) {
                        flag = 1;
                        temp=valueCheck;
                    }
                        valueCheck = valueCheck.next;
                    }
                    if (flag == 0) {
                        System.out.println("...NO Phonenumber found...");
                    }
                    else{
                        Scanner sc=new Scanner(System.in);
                        System.out.println("\n============= Change PIN =============\n");
                        boolean C_P_found = false;
                    while (C_P_found == false) {
                        System.out.println("Enter New PIN :");
                        int PIN1 = sc.nextInt();
                        System.out.println("Conform New PIN :");
                        int PIN2 = sc.nextInt();
                    if (PIN1 == PIN2 && PIN1 >= 1000 && PIN1 <= 9999) {
                        User_login= PIN1;
                        C_P_found = true;
                        System.out.println("\n\n $$$------------------------------$$$\n     PIN Successfully Change...\n $$$------------------------------$$$\n\n");
                        temp.account.Account_pin=PIN1;
                        break;
                    }       
                    else {
                        System.out.println("\n\n-------------------------------------------!!!\nInvalid Combination , Enter valid PIN\n-------------------------------------------!!!\n\n");
                        C_P_found = false;
                    }
                    }
                    }
                }
            }
public class DS_INDIVIDUAL {
    public static void main(String[] args) {
         Scanner sc=new Scanner(System.in);
        System.out.println();
        System.out.println();
        System.out.println("****************************************************");
        System.out.println("*         Welcome Bank Account Application         *");
        System.out.println("****************************************************");
        System.out.println();
        User u=new User();
        u.userlist.initialaddaccountdetail();
        while(true){
            System.out.println();
            System.out.println("****************************");
            System.out.println("* Please Select Your Choice *");
            System.out.println("****************************");
            System.out.println();
            System.out.println("1] User login");
            System.out.println("2] Admin login");
            System.out.println("3] Exit");
            System.out.println();
            int ch = sc.nextInt();       //user enter choice hear
            switch (ch) {
        case 1:{
            u.login();
            break;
        }
        case 2:{
            u.login1();
            break;
        }
        case 3:{
            System.out.println("Thank you for using our banking services");
            System.exit(0);
        }
        default:{
            System.out.println("\n\n-------------------!!!\nInvalid Choice..!!\n-------------------!!!\n\n");
            break;
        }
    }
    }
}
}