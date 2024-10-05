import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class RocketCollections {

    public static void createData(){
        int optionNumber=0;
        boolean correctEntry = true;
        Scanner menuInput = new Scanner(System.in);

        System.out.println("Select how you are going to Input Rocket Launch data");
        System.out.println("\t1 - Upload File");
        System.out.println("\t2 - Enter Data manually");

        while(correctEntry) {
            try {
                correctEntry = false;
                // gets user input as a string
                String option = menuInput.next();
                // parses string to int
                optionNumber = Integer.parseInt(option);
                // throws invalid message
                if (optionNumber < 0 || optionNumber > 2) {
                    System.out.println("Invalid option");
                }
            } catch (NumberFormatException e) { // catch if user enters a non number
                System.out.println("Please enter only numbers");
                correctEntry = true;
            }
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
        int numberTonnage = 0;
        boolean correctEntry = true;
       // Date date = null;
        LocalDate inputDateType = null;
       // String formatedDate = null;
        Scanner dataInput = new Scanner(System.in);
        System.out.println("Follow the prompts to enter launch data manually");

        System.out.println("\nEnter Launch ID");
        // Allows the user to reenter data if incorrect
        while (correctEntry) {
            try {
                correctEntry = false;
                String l_ID = dataInput.nextLine();
                launchID = Integer.parseInt(l_ID);
            } catch (NumberFormatException e) {
                System.out.println("Please enter only a number");
                correctEntry = true;
            }
        }
        correctEntry = true;
        System.out.println("Enter Launch Provider");
        String l_Provider = dataInput.nextLine();

        System.out.println("Enter Launch Location");
        String l_Location = dataInput.nextLine();

        System.out.println("Enter Launch Vehicle");
        String l_Vehicle = dataInput.nextLine();

        System.out.println("Enter Launch Date YYYY-MM-DD");

        // Allows the user to reenter data if incorrect
        while(correctEntry) {
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            try {
                correctEntry = false;
                String l_Date = dataInput.nextLine();
                inputDateType = LocalDate.parse(l_Date,dateFormat);
                //LocalDate inputDateFormat = LocalDate.format(dateFormat);

            } catch (DateTimeParseException e) {
                System.out.println("Error with date, make sure the date it formated 'yyyy-MM-dd'");
                correctEntry = true;
            }
        }
        correctEntry = true;

        System.out.println("Enter Number of Crew");
        // Allows the user to reenter data if incorrect
        while (correctEntry) {
            try {
                correctEntry = false;
                String numCrew = dataInput.nextLine();
                numberCrew = Integer.parseInt(numCrew);
            } catch (NumberFormatException e) {
                System.out.println("Please enter only numbers");
                correctEntry = true;
            }
        }
        correctEntry = true;
        System.out.println("Enter Payload");
        String payload = dataInput.nextLine();

        System.out.println("Enter Tonnage to Orbit");
        // Allows the user to reenter data if incorrect
        while (correctEntry) {
            try {
                correctEntry = false;
                String tonnage = dataInput.nextLine();
                numberTonnage = Integer.parseInt(tonnage);
            } catch (NumberFormatException e) {
                System.out.println("Please enter only numbers");
                correctEntry = true;
            }
        }

        RocketDataObject launchData = new RocketDataObject
                (launchID,l_Provider,l_Location,l_Vehicle,inputDateType,numberCrew,payload,numberTonnage);

        RocketDataObject.launchList.add(launchData);

        System.out.println("\nLaunch ID:        "+ launchID);
        System.out.println("Launch Provider:  "+ l_Provider);
        System.out.println("Launch Location:  "+ l_Location);
        System.out.println("Launch Vehicle:   "+ l_Vehicle);
        System.out.println("Launch date:      "+ inputDateType);
        System.out.println("Number of Crew:   "+ numberCrew);
        System.out.println("Payload:          "+ payload);
        System.out.println("Tonnage to Orbit: "+ numberTonnage);
        System.out.println("\nThe Information above was added to the array\n");
    }

    public static void readData(){
        for (RocketDataObject rL : RocketDataObject.launchList) {
            System.out.println("Launch ID:        "+rL.getLaunch_ID());
            System.out.println("Launch Provider:  "+rL.getLaunch_Provider());
            System.out.println("Launch Location:  "+rL.getLaunch_Location());
            System.out.println("Launch Vehicle:   "+rL.getLaunch_Vehicle());
            System.out.println("Launch date:      "+rL.getLaunch_date());
            System.out.println("Number of Crew:   "+rL.getNumber_of_Crew());
            System.out.println("Payload:          "+rL.getPayload());
            System.out.println("Tonnage to Orbit: "+rL.getTonnage_to_Orbit()+"\n");
        }
    }

}



