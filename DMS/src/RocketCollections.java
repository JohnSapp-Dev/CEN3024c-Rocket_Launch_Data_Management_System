import java.util.Date;
import java.util.Scanner;

public class RocketCollections {
    int Launch_ID;
    String Launch_Provider;
    String Launch_Location;
    String Launch_Vehicle;
    Date Launch_date;
    int Number_of_Crew;
    String Payload;
    int Tonnage_to_Orbit;

    // Object constructor
    public RocketCollections(int Launch_ID,String Launch_Provider,String Launch_Location,
                             String Launch_Vehicle, Date Launch_date, int Number_of_Crew, String Payload,
                             int Tonnage_to_Orbit){
        this.Launch_ID = Launch_ID;
        this.Launch_Provider = Launch_Provider;
        this.Launch_Location = Launch_Location;
        this.Launch_Vehicle = Launch_Vehicle;
        this.Launch_date = Launch_date;
        this.Number_of_Crew = Number_of_Crew;
        this.Payload = Payload;
        this.Tonnage_to_Orbit = Tonnage_to_Orbit;
    }

    public RocketCollections(){
        // default constructor
    }

    public static void createData(){
        int optionNumber=0;
        Scanner menuInput = new Scanner(System.in);

        System.out.println("Select how you are going to Input Rocket Launch data");
        System.out.println("1 - Upload File");
        System.out.println("2 - Enter Data manually");

        try{
            // gets user input as a string
            String option = menuInput.next();
            // parses string to int
            optionNumber = Integer.parseInt(option);
            // throws invalid message
            if (optionNumber < 0 || optionNumber > 2){
                System.out.println("Invalid option");
                createData();
            }
        }catch (NumberFormatException e){ // catch if user enters a non number
            System.out.println("Please enter only numbers");
            createData();
        }
    }

}



