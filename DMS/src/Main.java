import java.util.Scanner;

public class Main {
    private int userOption;

    public static void main(String[] args) {
        Main main = new Main();
        main.WelcomeMessage();
        main.menu();
    }

    public Main(int userOption){
        this.userOption = userOption;
    }
    public Main(){
        // default constructor
        this.userOption = 0;
    }
    public void setUserOption(int userOption){
        this.userOption = userOption;
    }
    public int getUserOption(){
        return this.userOption;
   }

    public void menu(){
        int optionNumber=0;
        //creates user input object
        Scanner menuSelection = new Scanner(System.in);
        //prints the menu to the terminal
        System.out.println("Select an option below by entering 1,2,3,4,5");
        System.out.println("1 - Enter Data");
        System.out.println("2 - Print Data");
        System.out.println("3 - Update Data");
        System.out.println("4 - Delete Data");
        System.out.println("5 - Exit");

        try{
            // gets user input as a string
            String option = menuSelection.next();
            // parses string to int
            optionNumber = Integer.parseInt(option);
            // throws invalid message
            if (optionNumber < 0 || optionNumber > 5){
                System.out.println("Invalid option");
                menu();
            }
        }catch (NumberFormatException e){ // catch if user enters a non number
            System.out.println("Please enter only numbers");
            menu();
        }
        setUserOption(optionNumber);
        callOption();
    }

    public void WelcomeMessage(){
        System.out.println("Welcome to the Rocket Launch Data Management System");
    }

    public void callOption(){
        // calls the method to support the user's selection
        switch (getUserOption()){
            case 1:
                System.out.println("Option 1");
                RocketCollections.createData();
                break;
            case 2:
                System.out.println("Option 2");
                menu();
                break;
            case 3:
                System.out.println("Option 3");
                menu();
                break;
            case 4:
                System.out.println("Option 4");
                menu();
                break;
            case 5:
                System.out.println("Option 5");
                break;
        }

    }

}