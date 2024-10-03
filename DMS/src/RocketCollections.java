import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class RocketCollections {
    static ArrayList<RocketCollections> launchList = new ArrayList<>();
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
        if (optionNumber == 1){
            System.out.println("upload file");
        }
        else if (optionNumber == 2){
            System.out.println("Enter Data manually");
            manualDataEntry();
        }
    }

    public static void manualDataEntry(){
        int launchID = 0;
        int numberCrew = 0;
        int numbertonnage = 0;
        Date date = null;
        Scanner dataInput = new Scanner(System.in);
        System.out.println("Follow the prompts to enter launch data manually");

        System.out.println("Enter Launch ID");
        try {
            String l_ID = dataInput.next();
            launchID = Integer.parseInt(l_ID);
        }catch (NumberFormatException e){
            System.out.println("Please enter only numbers i.e. 0001");
            manualDataEntry();
        }
        System.out.println("Enter Launch Provider");
        String l_Provider = dataInput.next();

        System.out.println("Enter Launch Location");
        String l_Location = dataInput.next();

        System.out.println("Enter Launch Vehicle");
        String l_Vehicle = dataInput.next();

        System.out.println("Enter Launch Date YYYY-MM-DD");
        String l_Date = dataInput.next();
        // formats l_Date string to a Date type
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = formatDate.parse(l_Date);
        } catch (ParseException e) {
            System.out.println("Error with date, make sure the date it formated 'yyyy-MM-dd'");
            manualDataEntry();
        }

        System.out.println("Enter Number of Crew");
        try {
            String numCrew = dataInput.next();
            numberCrew = Integer.parseInt(numCrew);
        }catch (NumberFormatException e){
            System.out.println("Please enter only numbers");
            manualDataEntry();
        }
        System.out.println("Enter Payload");
        String payload = dataInput.next();

        System.out.println("Enter Tonnage to Orbit");
        try {
            String tonnage = dataInput.next();
            numbertonnage = Integer.parseInt(tonnage);
        }catch (NumberFormatException e){
            System.out.println("Please enter only numbers");
            manualDataEntry();
        }

        RocketCollections launchData = new RocketCollections
                (launchID,l_Provider,l_Location,l_Vehicle,date,numberCrew,payload,numbertonnage);

        launchList.add(launchData);

    }
}



