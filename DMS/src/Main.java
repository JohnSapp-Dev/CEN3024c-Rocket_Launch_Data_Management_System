import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Main main = new Main();
        main.WelcomeMessage();
        main.menu();
    }

    public Main(){
        // default constructor
    }

    public void menu(){

        boolean exit = true;
        //creates user input object
        Scanner menuSelection = new Scanner(System.in);
        //prints the menu to the terminal
        while(exit) {
            int optionNumber=0;
            boolean correctEntry = true;
            System.out.println("Select an option below by entering 1,2,3,4,5");
            System.out.println("\t1 - Enter Data");
            System.out.println("\t2 - Read Data");
            System.out.println("\t3 - Update Data");
            System.out.println("\t4 - Delete Data");
            System.out.println("\t5 - Exit");

            while (correctEntry) {
                try {
                    correctEntry = false;
                    // gets user input as a string
                    String option = menuSelection.next();
                    // parses string to int
                    optionNumber = Integer.parseInt(option);
                    // throws invalid message
                    if (optionNumber < 0 || optionNumber > 5) {
                        System.out.println("Invalid option");
                        correctEntry = true;
                    }
                } catch (NumberFormatException e) { // catch if user enters a non number
                    System.out.println("Please enter only numbers");
                    correctEntry = true;
                }
            }

            switch (optionNumber) {
                case 1:
                    //System.out.println("Option 1");
                    RocketCollections.createData();
                    break;
                case 2:
                    System.out.println("Option 2");
                    RocketCollections.readData();
                    break;
                case 3:
                    System.out.println("Option 3");
                    //menu();
                    break;
                case 4:
                    System.out.println("Option 4");
                    // menu();
                    break;
                case 5:
                    System.out.println("Thank you for using the program");
                    exit = false;
                    break;
            }
        }
    }

    public void WelcomeMessage(){
        System.out.println("Welcome to the Rocket Launch Data Management System\n");
    }
}