import java.util.Calendar;
import java.util.Scanner;

class OnlineFoodOrderSystem {
    static RegisterLL rll = new RegisterLL();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        initializeData();
        System.out.println("\t\t\t\t      -------------------------------------------------");
        System.out.println("\t\t\t\t      |    ======================================     |");
        System.out.println("\t\t\t\t      |    ||      Welcome to FOOD ZONE!!      ||     |");
        System.out.println("\t\t\t\t      |    ======================================     |");
        System.out.println("\t\t\t\t      -------------------------------------------------");

        int loginregisterchoice;
        // for(;;)
        // {
        do {
            System.out.println();
            System.out.println("Your Choices : ");
            System.out.println();
            System.out.println("\t\t\t\t\t\t      ===================");
            System.out.println("\t\t\t\t\t\t     |     Main Menu     |");
            System.out.println("\t\t\t\t\t\t      ===================");
            System.out.println("\t\t\t\t\t\t     | 1> to Register    |");
            System.out.println("\t\t\t\t\t\t     | 2> to Login       |");
            System.out.println("\t\t\t\t\t\t     | 3> to Exit        |");
            System.out.println("\t\t\t\t\t\t      ===================");
            System.out.println();
            System.out.print("Enter Your Choice : ");
            loginregisterchoice = sc.nextInt();
            sc.nextLine();
            System.out.println();
            switch (loginregisterchoice) {
                case 1: {
                    System.out.println();
                    System.out.print("Enter Your Name : ");
                    String name = sc.nextLine();
                    System.out.println();
                    boolean flag = false;
                    long mobilenum;
                    do {
                        System.out.print("Enter Your Mobile Number :");
                        mobilenum = sc.nextLong();
                        sc.nextLine();
                        String phoneno = String.valueOf(mobilenum);
                        if (phoneno.length() == 10) {
                            for (int j = 0; j < phoneno.length(); j++) {
                                if (phoneno.charAt(j) >= '0' && phoneno.charAt(j) <= '9') {
                                    flag = true;
                                    System.out.println("Done...");
                                    break;
                                } else {
                                    System.out.println();
                                    System.out.println("Invalid Format OF MobileNO :");
                                    System.out.println("Enter Again :");
                                    System.out.println();
                                    flag = false;
                                }
                            }
                        } else {
                            System.out.println();
                            System.out.println("Invalid Format OF MobileNO :");
                            System.out.print("Enter Again :");
                            flag = false;
                        }
                    } while (flag == false);
                    System.out.println();
                    String password;
                    for (;;) {
                        System.out.println();
                        System.out.print("Set Your Password :");
                        password = sc.nextLine();
                        if (password.length() >= 8) {
                            break;
                        } else {
                            System.out.println("--> Password length should be greater than or equal to 8");
                        }
                    }
                    System.out.println("Enter your Address: ");
                    String address = sc.nextLine();
                    Register reg = new Register(name, mobilenum, address, password);
                    rll.insertAtLast(reg);
                }
                case 2: {
                    System.out.println();
                    System.out.println("\t\t\t\t\t\t -----------------------");
                    System.out.println("\t\t\t\t\t\t  Login to Your Account ");
                    System.out.println("\t\t\t\t\t\t -----------------------");
                    System.out.println();
                    for (int i = 1; i <= 3; i++) {
                        System.out.print("Enter Your Mobile Number : ");
                        long mno = sc.nextLong();
                        System.out.println();
                        System.out.print("Enter Your Password : ");
                        sc.nextLine();
                        String password = sc.nextLine();
                        System.out.println();
                        boolean check = rll.isThere(mno, password);
                        if (check) {
                            System.out.println();
                            System.out.println("\t\t\t\t\t\t ---------------------------");
                            System.out.println("\t\t\t\t\t\t   SuccessFully Logged in    ");
                            System.out.println("\t\t\t\t\t\t ---------------------------");
                            System.out.println();
                            Register r = rll.getUser(mno, password);
                            manage(mno, r.address);
                            break;
                        } else {
                            System.out.println("  --> Entered Mobile Number or Password is Invalid");
                            System.out.println();
                        }
                    }
                    break;
                }
                case 3: {
                    System.out.println();
                    System.out.println("\t\t\t\t\t\t        -----------");
                    System.out.println("\t\t\t\t\t\t         THANK YOU ");
                    System.out.println("\t\t\t\t\t\t        -----------");
                    System.out.println();
                    break;
                }
                default: {
                    System.out.println();
                    System.out.print("Enter Valid Choice : ");
                    System.out.println();
                    break;
                }
            }
        } while (loginregisterchoice != 3);
    }

    static void initializeData() {
        Register reg = new Register("Prince", 6352451341l, "B-120,Shanti Villa,Ahmedabad,380058", "Prince123");
        rll.insertAtLast(reg);
        rll.insertAtLast(new Register("User1", 9876543211l, "B-120,Shanti Villa,Ahmedabad,380058", "123456789"));
        rll.insertAtLast(new Register("User2", 9876543212l, "B-120,Shanti Villa,Ahmedabad,380058", "123456789"));
        rll.insertAtLast(new Register("User3", 9876543213l, "B-120,Shanti Villa,Ahmedabad,380058", "123456789"));
    }

    static String[] menu = { "Pizza", "Burger", "Sandwich", "Thali", "Biryani",
            "Cake", "Chicken", "Rolls", "Dosa", "Panner", "Paratha",
            "Noodles" }; // add various thali like gujarati, punjabi etc.
    static String[] pizza = { "Cheezy-7 Pizza", "Margherita Pizza", "Double Cheese Margherita Pizza ",
            "Sweet Corns Pizza",
            "Farm Villa Pizza", "Panner Tikka Butter Masala Pizza", "Tandoori Panner Pizza" };
    static double[] pizzaPrice = { 255.00, 150.00, 190.00, 100.00, 195.00, 255.00, 255.00 };
    static String[] cake = { "Cassata Cake", "Oreo Chocolate Cake", "Pineapple Cake", "Chocolate Truffle Cake",
            "Black Forest Cake", "Eggless Kitkat Oreo Cake", "Eggless Chocolate Light Cake" };
    static double[] cakePrice = { 250.00, 295.00, 240.00, 350.00, 270.00, 350.00, 280.00 };
    static String[] burger = { "McSpicy Premium Veg Burger", "Chicken Big Mac Burger", "McVeggie Burger",
            " Veg Maharaja Burger", "McAloo Tikki Burger", "Corn & Cheese Burger", "Mexican McAloo Tikki Burger" };
    static double[] burgerPrice = { 249.00, 235.00, 145.00, 220.00, 58.00, 145.00, 100.00 };
    static String[] sandwich = { "Grilled Cheese sandwich", "Nutella Sandwich", "Olive Sandwich", "Vegetable Sandwich",
            "Bread Sandwich", "Bombay Roadside Sandwich", "Pesto Caprese Grilled Cheese Sandwich" };
    static double[] sandwichPrice = { 120.00, 150.00, 200.00, 119.00, 200.00, 350.00, 350.00 };
    static String[] thali = { "Veg Jaipuri Thali", "Veg Kolhapuri Thali", "Mix Veg Thali", "Sev Tomato Thali",
            "Paneer Lawabdar Thali", "Panner Tikka Thali", "Paneer Jaipuri Thali" };
    static double[] thaliPrice = { 279.00, 279.00, 279.00, 279.00, 279.00, 279.00, 279.00 };
    static String[] biryani = { "Chicken Biryani(Bone)", "Chicken Dum Hyderabadi Biryani", "Veg Dum Biryani",
            "Panner Dum Biryani", "Boneless Chicken Biryani", "Veg Biryani", "Chicken Dum Nawabi Biryani" };
    static double[] biryaniPrice = { 299.00, 399.00, 299.00, 319.00, 319.00, 399.00, 419.00 };
    static String[] chicken = { "Chicken Lollipop", "Tandoori Chicken", "Deshi Style chicken", "Chicken Masala",
            "Chicken Rara", "Butter Chicken Bone", "Chicken Tikka" };
    static double[] chickenPrice = { 279.00, 199.00, 369.00, 369.00, 389.00, 399.00, 399.00 };
    static String[] rolls = { "Tandoori Panner Frankie", "Hl Special Panner Frankie", "Manchurian Noodles Frankie",
            "Hl Special Chinese Frankie", "Vegetable Frankie", "Spicy Peri Peri Cheese Frankie",
            "Panner Manchurian Frankie" };
    static double[] rollsPrice = { 169.00, 179.00, 139.00, 159.00, 109.00, 169.00, 149.00 };
    static String[] panner = { "Cheese Butter Masala", "Panner Tawa Masala", "Panner Tikka Masala", "Panner Kadai",
            "Panner Chilly", "Manchurian Special Panner", "Palak Panner" };
    static double[] pannerPrice = { 280.00, 280.00, 280.00, 280.00, 260.00, 295.00, 265.00 };
    static String[] dosa = { "Masala Dosa", "Mysore Special Dosa", "Rava Plain Dosa", "Rava Masala Dosa",
            "Gwalia Cheese Dosa",
            "Spring Cheese Dosa", " Plain Cheese Dosa" };
    static double[] dosaPrice = { 80.00, 170.00, 100.00, 110.00, 120.00, 150.00, 90.00 };
    static String[] paratha = { "Aloo Paratha", "Stuffed Paratha", "Panner Paratha", "Butter Paratha", "Methi Paratha",
            "Amritsari Paratha", "All In One Cheese Paratha" };
    static double[] parathaPrice = { 150.00, 130.00, 160.00, 65.00, 85.00, 285.00, 305.00 };
    static String[] noodle = { "Veg Hakka Noodles", "Pad Thai Noodles", "Veg Schezwan Noodles", "Manchurian Noodles",
            "Chicken Singpore Noodles", " Chicken Tikka Noodles", "Mirza Special Noodles" };
    static double[] noodlePrice = { 229.00, 259.00, 249.00, 239.00, 369.00, 349.00, 259.00 };
    static OrderLL oll;

    static void printMenu() {
        System.out.println("\t\t\t\t\t\t  ==============");
        System.out.println("\t\t\t\t\t\t | 1) Pizza     |");
        System.out.println("\t\t\t\t\t\t | 2) Burger    |");
        System.out.println("\t\t\t\t\t\t | 3) Sandwich  |");
        System.out.println("\t\t\t\t\t\t | 4) Thali     |");
        System.out.println("\t\t\t\t\t\t | 5) Biryani   |");
        System.out.println("\t\t\t\t\t\t | 6) Cake      |");
        System.out.println("\t\t\t\t\t\t | 7) Chicken   |");
        System.out.println("\t\t\t\t\t\t | 8) Rolls     |");
        System.out.println("\t\t\t\t\t\t | 9) Dosa      |");
        System.out.println("\t\t\t\t\t\t | 10) Paneer   |");
        System.out.println("\t\t\t\t\t\t | 11) Paratha  |");
        System.out.println("\t\t\t\t\t\t | 12) Noodle   |");
        System.out.println("\t\t\t\t\t\t  ==============");

    }

    static void manage(long mno, String address) {
        oll = new OrderLL();
        double sum = 0;
        System.out.println();
        System.out.println("\t\t\t\t\t\t ---------------------------");
        System.out.println("\t\t\t\t\t\t  What do you want to eat : ");
        System.out.println("\t\t\t\t\t\t ---------------------------");
        System.out.println();

        while (true) {
            printMenu();
            System.out.print("   Enter your choice : ");
            int choice = -1;
            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Please enter Only digit from above");
            }

            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("\t\t\t\t\t ------------------------------------------------------");
                    for (int i = 0; i < pizza.length; i++) {
                        System.out.println("\t\t\t\t\t  " + (i + 1) + ".. " + pizza[i] + " price : " + pizzaPrice[i]);
                        System.out.println("\t\t\t\t\t ------------------------------------------------------");
                    }
                    System.out.println();
                    System.out.print("Enter No Of PIZZA Type You Want to Order  : ");
                    int fopizza = -1;
                    try {
                        fopizza = sc.nextInt();
                    } catch (Exception e) {
                        System.out.println("Please enter Only digit from above");
                    }
                    System.out.println();
                    for (int j = 0; j < pizza.length; j++) {
                        if (fopizza == (j + 1)) {
                            Order o = new Order(mno, pizza[j], pizzaPrice[j]);
                            sum = sum + pizzaPrice[j];
                            oll.insertAtLast(o);
                            break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("\t\t\t\t\t ------------------------------------------------------");
                    for (int i = 0; i < burger.length; i++) {
                        System.out.println("\t\t\t\t\t  " + (i + 1) + ".. " + burger[i] + " price : " + burgerPrice[i]);
                        System.out.println("\t\t\t\t\t ------------------------------------------------------");
                    }
                    System.out.println();
                    System.out.print("Enter No Of Burger Type You Want to Order  : ");
                    int foburger = -1;
                    try {
                        foburger = sc.nextInt();
                    } catch (Exception e) {
                        System.out.println("Please enter Only digit from above");
                    }
                    System.out.println();
                    for (int j = 0; j < burger.length; j++) {
                        if (foburger == (j + 1)) {
                            Order o = new Order(mno, burger[j], burgerPrice[j]);
                            sum = sum + burgerPrice[j];
                            oll.insertAtLast(o);
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.println("\t\t\t\t\t ------------------------------------------------------");
                    for (int i = 0; i < sandwich.length; i++) {
                        System.out.println(
                                "\t\t\t\t\t  " + (i + 1) + ".. " + sandwich[i] + " price : " + sandwichPrice[i]);
                        System.out.println("\t\t\t\t\t ------------------------------------------------------");
                    }
                    System.out.println();
                    System.out.print("Enter No Of SandWich Type You Want to Order  : ");

                    int fosandwich = -1;
                    try {
                        fosandwich = sc.nextInt();
                    } catch (Exception e) {
                        System.out.println("Please enter Only digit from above");
                    }
                    System.out.println();
                    for (int j = 0; j < sandwich.length; j++) {
                        if (fosandwich == (j + 1)) {
                            Order o = new Order(mno, sandwich[j], sandwichPrice[j]);
                            sum = sum + sandwichPrice[j];
                            oll.insertAtLast(o);
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.println("\t\t\t\t\t ------------------------------------------------------");
                    for (int i = 0; i < thali.length; i++) {
                        System.out.println("\t\t\t\t\t  " + (i + 1) + ".. " + thali[i] + " price : " + thaliPrice[i]);
                        System.out.println("\t\t\t\t\t ------------------------------------------------------");
                    }
                    System.out.println();
                    System.out.print("Enter No Of Thali Type You Want to Order  : ");
                    int fothali = -1;
                    try {
                        fothali = sc.nextInt();
                    } catch (Exception e) {
                        System.out.println("Please enter Only digit from above");
                    }
                    System.out.println();
                    for (int j = 0; j < thali.length; j++) {
                        if (fothali == (j + 1)) {
                            Order o = new Order(mno, thali[j], thaliPrice[j]);
                            sum = sum + thaliPrice[j];
                            oll.insertAtLast(o);
                            break;
                        }
                    }
                    break;
                case 5:
                    System.out.println("\t\t\t\t\t------------------------------------------------------");
                    for (int i = 0; i < biryani.length; i++) {
                        System.out
                                .println("\t\t\t\t\t  " + (i + 1) + ".. " + biryani[i] + " price : " + biryaniPrice[i]);
                        System.out.println("\t\t\t\t\t ------------------------------------------------------");
                    }
                    System.out.println();
                    System.out.print("Enter No Of Birani Type You Want to Order  : ");
                    int fobiryani = -1;
                    try {
                        fobiryani = sc.nextInt();
                    } catch (Exception e) {
                        System.out.println("Please enter Only digit from above");
                    }
                    System.out.println();
                    for (int j = 0; j < biryani.length; j++) {
                        if (fobiryani == (j + 1)) {
                            Order o = new Order(mno, biryani[j], biryaniPrice[j]);
                            sum = sum + biryaniPrice[j];
                            oll.insertAtLast(o);
                            break;
                        }
                    }
                    break;
                case 6:
                    System.out.println("\t\t\t\t\t ------------------------------------------------------");
                    for (int i = 0; i < cake.length; i++) {
                        System.out.println("\t\t\t\t\t  " + (i + 1) + ".. " + cake[i] + " price : " + cakePrice[i]);
                        System.out.println("\t\t\t\t\t ------------------------------------------------------");

                    }
                    System.out.println();
                    System.out.print("Enter No Of Cake Type You Want to Order  : ");
                    int focake = -1;
                    try {
                        focake = sc.nextInt();
                    } catch (Exception e) {
                        System.out.println("Please enter Only digit from above");
                    }
                    System.out.println();
                    for (int j = 0; j < cake.length; j++) {
                        if (focake == (j + 1)) {
                            Order o = new Order(mno, cake[j], cakePrice[j]);
                            sum = sum + cakePrice[j];
                            oll.insertAtLast(o);
                            break;
                        }
                    }
                    break;
                case 7:
                    System.out.println("\t\t\t\t\t ------------------------------------------------------");
                    for (int i = 0; i < chicken.length; i++) {
                        System.out
                                .println("\t\t\t\t\t  " + (i + 1) + ".. " + chicken[i] + " price : " + chickenPrice[i]);
                        System.out.println("\t\t\t\t\t ------------------------------------------------------");
                    }
                    System.out.println();
                    System.out.print("Enter No Of Chicken Type You Want to Order  : ");

                    int fochicken = -1;
                    try {
                        fochicken = sc.nextInt();
                    } catch (Exception e) {
                        System.out.println("Please enter Only digit from above");
                    }
                    System.out.println();
                    for (int j = 0; j < chicken.length; j++) {
                        if (fochicken == (j + 1)) {
                            Order o = new Order(mno, chicken[j], chickenPrice[j]);
                            sum = sum + chickenPrice[j];
                            oll.insertAtLast(o);
                            break;
                        }
                    }
                    break;
                case 8:
                    System.out.println("\t\t\t\t\t ------------------------------------------------------");
                    for (int i = 0; i < rolls.length; i++) {
                        System.out.println("\t\t\t\t\t  " + (i + 1) + ".. " + rolls[i] + " price : " + rollsPrice[i]);
                        System.out.println("\t\t\t\t\t ------------------------------------------------------");
                    }
                    System.out.println();
                    System.out.print("Enter No Of Rolls Type You Want to Order  : ");
                    int forolls = -1;
                    try {
                        forolls = sc.nextInt();
                    } catch (Exception e) {
                        System.out.println("Please enter Only digit from above");
                    }
                    System.out.println();
                    for (int j = 0; j < rolls.length; j++) {
                        if (forolls == (j + 1)) {
                            Order o = new Order(mno, rolls[j], rollsPrice[j]);
                            sum = sum + rollsPrice[j];
                            oll.insertAtLast(o);
                            break;
                        }
                    }
                    break;
                case 9:
                    System.out.println("\t\t\t\t\t ------------------------------------------------------");
                    for (int i = 0; i < dosa.length; i++) {
                        System.out.println("\t\t\t\t\t  " + (i + 1) + ".. " + dosa[i] + " price : " + dosaPrice[i]);
                        System.out.println("\t\t\t\t\t ------------------------------------------------------");
                    }
                    System.out.println();
                    System.out.print("Enter No Of Dosa Type You Want to Order  : ");

                    int fodosa = -1;
                    try {
                        fodosa = sc.nextInt();
                    } catch (Exception e) {
                        System.out.println("Please enter Only digit from above");
                    }
                    System.out.println();
                    for (int j = 0; j < dosa.length; j++) {
                        if (fodosa == (j + 1)) {
                            Order o = new Order(mno, dosa[j], dosaPrice[j]);
                            sum = sum + dosaPrice[j];
                            oll.insertAtLast(o);
                            break;
                        }
                    }
                    break;
                case 10:
                    System.out.println("\t\t\t\t\t ------------------------------------------------------");
                    for (int i = 0; i < panner.length; i++) {
                        System.out.println("\t\t\t\t\t  " + (i + 1) + ".. " + panner[i] + " price : " + pannerPrice[i]);
                        System.out.println("\t\t\t\t\t ------------------------------------------------------");
                    }
                    System.out.println();
                    System.out.print("Enter No Of Paneer Type You Want to Order  : ");

                    int fopanner = -1;
                    try {
                        fopanner = sc.nextInt();
                    } catch (Exception e) {
                        System.out.println("Please enter Only digit from above");
                    }
                    System.out.println();
                    for (int j = 0; j < panner.length; j++) {
                        if (fopanner == (j + 1)) {
                            Order o = new Order(mno, panner[j], pannerPrice[j]);
                            sum = sum + pannerPrice[j];
                            oll.insertAtLast(o);
                            break;
                        }
                    }
                    break;
                case 11:
                    System.out.println("\t\t\t\t\t ------------------------------------------------------");
                    for (int i = 0; i < paratha.length; i++) {
                        System.out
                                .println("\t\t\t\t\t  " + (i + 1) + ".. " + paratha[i] + " price : " + parathaPrice[i]);
                        System.out.println("\t\t\t\t\t ------------------------------------------------------");
                    }
                    System.out.println();
                    System.out.print("Enter No Of Paratha Type You Want to Order  : ");

                    int foparatha = -1;
                    try {
                        foparatha = sc.nextInt();
                    } catch (Exception e) {
                        System.out.println("Please enter Only digit from above");
                    }
                    System.out.println();
                    for (int j = 0; j < burger.length; j++) {
                        if (foparatha == (j + 1)) {
                            Order o = new Order(mno, paratha[j], parathaPrice[j]);
                            sum = sum + parathaPrice[j];
                            oll.insertAtLast(o);
                            break;
                        }
                    }
                    break;
                case 12:
                    System.out.println("\t\t\t\t\t ------------------------------------------------------");
                    for (int i = 0; i < noodle.length; i++) {
                        System.out.println("\t\t\t\t\t  " + (i + 1) + ".. " + noodle[i] + " price : " + noodlePrice[i]);
                        System.out.println("\t\t\t\t\t ------------------------------------------------------");
                    }
                    System.out.println();
                    System.out.print("Enter No Of Noodles Type You Want to Order  : ");

                    int fonoodle = -1;
                    try {
                        fonoodle = sc.nextInt();
                    } catch (Exception e) {
                        System.out.println("Please enter Only digit from above");
                    }
                    System.out.println();
                    for (int j = 0; j < noodle.length; j++) {
                        if (fonoodle == (j + 1)) {
                            Order o = new Order(mno, noodle[j], noodlePrice[j]);
                            sum = sum + noodlePrice[j];
                            oll.insertAtLast(o);
                            break;
                        }
                    }
                    break;

                default:
                    System.out.println();
                    System.out.println("PLZ... Enter from the above list");
                    System.out.println();
                    break;
            }
            System.out.println();
            // System.out.println("------------------------------------------");
            System.out.print("Do you want to order more Enter (y/n) : ");
            String yesno;
            boolean exit = false;
            while (true) {
                yesno = sc.nextLine();
                // System.out.println("---------------------------------------------");
                if (yesno.equalsIgnoreCase("y")) {
                    System.out.println();
                    break;
                } else if (yesno.equalsIgnoreCase("n")) {
                    System.out.println();
                    System.out.println("\t\t\t\t\t\t\t -----------");
                    System.out.println("\t\t\t\t\t\t\t  THANK YOU");
                    System.out.println("\t\t\t\t\t\t\t -----------");
                    System.out.println();
                    exit = true;
                    break;
                } else {
                    System.out.print("---> Enter 'y' for yes or 'n' for no only : ");
                }
            }
            if (exit) {
                System.out.println();
                System.out.println("\t\t\t\t\t\t\t ---------------");
                System.out.println("\t\t\t\t\t\t\t    your cart   ");
                System.out.println("\t\t\t\t\t\t\t ---------------");
                System.out.println();
                oll.display();
                System.out.println("Want to confirm order (y/n):");
                String confirmOrder = sc.next();
                if (confirmOrder.equalsIgnoreCase("y")) {
                    System.out.println();
                    System.out.println("\t\t\t\t\t -----------------------------------------------------------");
                    System.out.println("\t\t\t\t\t   Total Bill is :                                 " + sum);
                    System.out.println("\t\t\t\t\t -----------------------------------------------------------");
                    System.out.println();
                    paymentInterface(sum, address);
                } else {
                    System.out.println("Returning to Main Menu............");
                }
                break;
            }
        }

    }

    static void paymentInterface(double totalBill, String address) {
        Payment p = new Payment();
        p.pay(Double.toString(totalBill), address);
    }

}

class Register {
    String name;
    long mobilenum;
    String address;
    String password;

    Register(String name, long mobilenum, String address, String password) {
        this.name = name;
        this.mobilenum = mobilenum;
        this.password = password;
        this.address = address;
    }
}

class Order {
    long mno;
    String food;
    double price;

    Order(long mno, String food, double price) {
        this.mno = mno;
        this.food = food;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order [mno=" + mno + ", food=" + food + ", price=" + price + "]";
    }

}

class RegisterLL {
    class node {
        Register data;
        node next;

        node(Register data) {
            this.data = data;
            this.next = null;
        }
    }

    node first = null;

    void insertAtLast(Register data) {
        node n = new node(data);
        if (first == null) {
            first = n;
        } else {
            node temp = first;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = n;
        }
        System.out.println(n.data.name + " You Register Successfully");
    }

    boolean isThere(long value, String passwordvalue) {
        if (first == null) {
            return false;
        } else {
            int flag = 0;
            node valuecheck = first;
            do {
                if (valuecheck.data.mobilenum == value && valuecheck.data.password.equals(passwordvalue)) {
                    flag = 1;
                    break;
                }
                valuecheck = valuecheck.next;
            } while (valuecheck != null);
            if (flag == 0) {
                return false;
            } else {
                return true;
            }
        }
    }

    Register getUser(long value, String passwordvalue) {
        if (first == null) {
            return null;
        } else {
            node valuecheck = first;
            do {
                if (valuecheck.data.mobilenum == value && valuecheck.data.password.equals(passwordvalue)) {
                    return valuecheck.data;
                }
                valuecheck = valuecheck.next;
            } while (valuecheck != null);

        }
        return null;
    }
}

class OrderLL {
    class node1 {
        Order data;
        node1 next;

        node1(Order data) {
            this.data = data;
            this.next = null;
        }
    }

    node1 first = null;

    void insertAtLast(Order data) {
        node1 n = new node1(data);
        if (first == null) {
            first = n;
        } else {
            node1 temp = first;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = n;
        }
        System.out.println(n.data.food + " is added to your cart");
    }

    void display() {
        if (first == null) {
            System.out.println("no order");
        } else {
            node1 temp = first;
            System.out.println("\t\t\t\t\t\t ------------------------------------------------------");
            System.out.println("\t\t\t\t\t\t    ITEM                   :                PRICE($)   ");
            System.out.println("\t\t\t\t\t\t ------------------------------------------------------");
            while (temp != null) {
                System.out.print("\t\t\t\t\t\t  " + temp.data.food);
                System.out.print("                              " + temp.data.price);
                System.out.println();
                temp = temp.next;
            }
            System.out.println("\t\t\t\t\t\t =======================================================");
        }
    }
}

class Payment {
    static Scanner scan = new Scanner(System.in);

    void pay(String totalBill, String address) {
        boolean isContinue = true;
        while (isContinue) {
            System.out.println();
            System.out.println("\t\t\t\t --------------------------------");
            System.out.println("\t\t\t\t   Available mode of Payment:    ");
            System.out.println("\t\t\t\t --------------------------------");
            System.out.println("\t\t\t\t    1) UPI                       ");
            System.out.println("\t\t\t\t    2) Credit or debit card:     ");
            System.out.println("\t\t\t\t    3) Pay on delivery           ");
            System.out.println("\t\t\t\t --------------------------------");
            System.out.println();
            System.out.println("Enter your choice: ");
            int payment = scan.nextInt();
            scan.nextLine();
            switch (payment) {
                case 1:
                    boolean isVarified = false;
                    while (true) {
                        System.out.println("Enter upi id: ");
                        String upi = scan.nextLine();
                        isVarified = varifyUPI(upi);
                        if (isVarified) {
                            isVarified = true;
                            break;
                        } else {
                            System.out.println("Invalid upi Id.");
                            System.out.println("Want to try again:(y/n)");
                            String want = scan.nextLine();
                            if (want.equalsIgnoreCase("n")) {
                                break;
                            }
                        }
                    }
                    if (isVarified) {
                        System.out.println("Entered upi id is Correct.");
                        System.out.println("redirecting to app.....");
                        boolean isPaymentDone = paymentAppInterface(totalBill);
                        if (isPaymentDone) {
                            System.out.println("Payment of $" + totalBill + " has been received.");
                            System.out.println("Delivering you Food to your address: " + address);
                            isContinue = false;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Enter CardHolder Name");
                    String name = scan.nextLine();
                    System.out.println("Enter card no: ");
                    String cardno = scan.nextLine();
                    if (cardno.length() != 16 || containsAnyLetter(cardno)) {
                        System.out.println("Invalid Card no");
                        break;
                    }
                    System.out.println("Enter Card expiry date:(MM/YYYY)");
                    String expirydate = scan.nextLine();
                    Boolean isValid = varifyExpiryDate(expirydate);
                    if (!isValid) {
                        System.out.println("Your card is Expired.");
                    } else {
                        System.out.println("redirecting to payments website.....");
                        boolean isPaymentDone = paymentAppInterface(totalBill);
                        if (isPaymentDone) {
                            System.out.println("Payment of $" + totalBill + " has been received.");
                            System.out.println("Delivering you Food to your address: " + address);
                            isContinue = false;
                        }
                    }
                    break;
                case 3:
                    System.out.println("Payment of $" + totalBill + " to be paid On delivery.");
                    System.out.println("Delivering you Food to your address: " + address);
                    isContinue = false;
                    break;
                default:
                    System.out.println("Enter valid mode of Payment.");
                    break;
            }
        }
    }

    static boolean containsAnyLetter(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isAlphabetic(c)) {
                return true;
            } else if (Character.isSpaceChar(c)) {
                return false;
            } else if (Character.isDigit(c)) {
                continue;
            } else {
                return false;
            }
        }
        return false;
    }

    static Boolean varifyExpiryDate(String expirydate) {
        String currentDate = getCurrentDate();
        int cardMonth = Integer.parseInt(expirydate.substring(0, 2));
        int cardYear = Integer.parseInt(expirydate.substring(3, 7));
        int currentMonth = Integer.parseInt(currentDate.substring(5, 6));
        int currentYear = Integer.parseInt(currentDate.substring(0, 4));
        if (cardYear - currentYear > 0) {
            return true;
        }
        if (cardYear - currentYear == 0) {
            if (cardMonth - currentMonth >= 0) {
                return true;
            }
        }
        return false;
    }

    static boolean paymentAppInterface(String totalBill) {
        System.out.println("\t\t\t\t  --------------------------------- ");
        System.out.println("\t\t\t\t | Requested amount: " + totalBill + "   | ");
        System.out.print("\t\t\t\t | confirm(y/n): ");
        String isConfirmed = scan.next();
        if (isConfirmed.equalsIgnoreCase("n")) {
            System.out.println("\t\t\t\t  --------------------------------- ");
            return false;
        }
        System.out.print("\t\t\t\t | Enter pin: ");
        String pin = scan.next();
        System.out.println("\t\t\t\t | Bill Paid Successfully             |");
        System.out.println("\t\t\t\t  --------------------------------- ");
        return true;
    }

    static boolean varifyUPI(String upi) {
        int atTheRate = 0, no = 0;
        if (Character.isDigit(upi.charAt(0))) {
            for (int i = 0; i < upi.length(); i++) {
                char c = upi.charAt(i);
                if (c == '@') {
                    atTheRate++;
                }
                if (Character.isDigit(c)) {
                    no++;
                }
                if (Character.isSpaceChar(c)) {
                    return false;
                }
            }
            if (no != 10) {
                return false;
            } else {
                return true;
            }
        }
        for (int i = 0; i < upi.length(); i++) {
            char c = upi.charAt(i);
            if (c == '@') {
                atTheRate++;
            }
            if (Character.isSpaceChar(c)) {
                return false;
            }
        }
        if (atTheRate != 1) {
            return false;
        }
        return true;
    }

    static String getCurrentDate() {
        Calendar cal = Calendar.getInstance();
        String Year = Integer.toString(cal.get(Calendar.YEAR));
        String Month = Integer.toString(cal.get(Calendar.MONTH) + 1);
        String Date = Integer.toString(cal.get(Calendar.DATE));
        return Year + "-" + Month + "-" + Date;
    }

}