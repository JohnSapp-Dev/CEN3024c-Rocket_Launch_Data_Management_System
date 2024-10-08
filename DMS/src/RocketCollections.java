import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class RocketCollections {
    static Scanner dataInput = new Scanner(System.in);

    public static int launchIDInput(){
        boolean correctEntry = true;
        int launchID = 0;
        System.out.println("\nEnter Launch ID");
        // Allows the user to reenter data if incorrect
        while (correctEntry) {
            try {
                correctEntry = false;
                String l_ID = dataInput.nextLine();
                launchID = Integer.parseInt(l_ID);
                for (RocketDataObject rL : RocketDataObject.launchList) {
                    if (launchID == rL.getLaunch_ID()){
                        System.out.println("Launch ID already exists");
                        correctEntry = true;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter only a number");
                correctEntry = true;
            }
        }
        return launchID;
    }

    public static String launchProviderInput(){
        System.out.println("Enter Launch Provider");
        return dataInput.nextLine();
    }

    public static String launchLocationInput(){
        System.out.println("Enter Launch Location");
        return dataInput.nextLine();
    }

    public static String launchVehicleInput(){
        System.out.println("Enter Launch Vehicle");
        return dataInput.nextLine();
    }

    public static LocalDate launchDateInput(){
        boolean correctEntry = true;
        LocalDate inputDateType = null;
        System.out.println("Enter Launch Date YYYY-MM-DD");
        // Allows the user to reenter data if incorrect
        while(correctEntry) {
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            try {
                correctEntry = false;
                String l_Date = dataInput.nextLine();
                inputDateType = LocalDate.parse(l_Date,dateFormat);
            } catch (DateTimeParseException e) {
                System.out.println("Error with date, make sure the date it formated 'yyyy-MM-dd'");
                correctEntry = true;
            }
        }
        return inputDateType;
    }

    public static int numberCrewInput(){
        boolean correctEntry = true;
        int numberCrew = 0;
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
        return numberCrew;
    }

    public static double tonnageOrbitInput(){
        boolean correctEntry = true;
        double numberTonnage = 0;
        System.out.println("Enter Tonnage to Orbit");
        // Allows the user to reenter data if incorrect
        while (correctEntry) {
            try {
                correctEntry = false;
                String tonnage = dataInput.nextLine();
                numberTonnage = Double.parseDouble(tonnage);
            } catch (NumberFormatException e) {
                System.out.println("Please enter only numbers");
                correctEntry = true;
            }
        }
        return numberTonnage;
    }

    public static String payloadInput(){
        System.out.println("Enter Payload");
        return dataInput.nextLine();
    }

    public static void readDataObject(RocketDataObject rL){
        System.out.println("Launch ID:        "+rL.getLaunch_ID());
        System.out.println("Launch Provider:  "+rL.getLaunch_Provider());
        System.out.println("Launch Location:  "+rL.getLaunch_Location());
        System.out.println("Launch Vehicle:   "+rL.getLaunch_Vehicle());
        System.out.println("Launch date:      "+rL.getLaunch_date());
        System.out.println("Number of Crew:   "+rL.getNumber_of_Crew());
        System.out.println("Payload:          "+rL.getPayload());
        System.out.println("Tonnage to Orbit: "+rL.getTonnage_to_Orbit()+"\n");
    }

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

        RocketDataObject launchData = new RocketDataObject
                (launchIDInput(),launchProviderInput(),launchLocationInput(),launchVehicleInput(),
                        launchDateInput(),numberCrewInput(),payloadInput(),tonnageOrbitInput());

        RocketDataObject.launchList.add(launchData);
        readDataObject(launchData);
    }

    public static void readData(){
        for (RocketDataObject rL : RocketDataObject.launchList) {
            readDataObject(rL);
        }
    }

    public static void updateDeleteData(int optionNumber){

        if(RocketDataObject.launchList.isEmpty()){
            //checks if there is data in the arraylist
            System.out.println("No Data");
        }else{
            Scanner dataInput = new Scanner(System.in);
                System.out.println("Select a row, enter the Launch ID");
            String l_ID = dataInput.nextLine();
            int number_ID = Integer.parseInt(l_ID);

            for(RocketDataObject rL : RocketDataObject.launchList){
                boolean editing = true;
                int userInput = 0;
                if (number_ID == rL.getLaunch_ID()){
                    switch(optionNumber){
                        case 1:
                            while(editing){
                                //prints the current data for the selected launch
                                System.out.println("\nCurrent Data of this launch\n");
                                readDataObject(rL);
                                System.out.println("Select a data point to update or exit");
                                System.out.println("\t1 - Launch ID");
                                System.out.println("\t2 - Launch Provider");
                                System.out.println("\t3 - Launch Location");
                                System.out.println("\t4 - Launch Vehicle");
                                System.out.println("\t5 - Launch date");
                                System.out.println("\t6 - Number of Crew");
                                System.out.println("\t7 - Payload");
                                System.out.println("\t8 - Tonnage to Orbit");
                                System.out.println("\t9 - Return to main menu");

                                // gets user selection number
                                String input = dataInput.nextLine();
                                try {
                                    userInput = Integer.parseInt(input);
                                }catch (NumberFormatException e){
                                    System.out.println("Please enter only numbers");
                                    editing = true;
                                }
                                switch (userInput){
                                    // calls correct userInput method and sets the object to the new value
                                    case 1:
                                        rL.setLaunch_ID(launchIDInput());
                                        break;

                                    case 2:
                                        rL.setLaunch_Provider(launchProviderInput());
                                        break;

                                    case 3:
                                        rL.setLaunch_Location(launchLocationInput());
                                        break;

                                    case 4:
                                        rL.setLaunch_Vehicle(launchVehicleInput());
                                        break;

                                    case 5:
                                        rL.setLaunch_date(launchDateInput());
                                        break;

                                    case 6:
                                        rL.setNumber_of_Crew(numberCrewInput());
                                        break;

                                    case 7:
                                        rL.setPayload(payloadInput());
                                        break;

                                    case 8:
                                        rL.setTonnage_to_Orbit(tonnageOrbitInput());
                                        break;

                                    case 9:
                                        System.out.println("finished editing this entry");
                                        editing = false;
                                        break;
                                }
                            }
                            break;
                        case 2:
                            System.out.println("The data below has been deleted");
                            readDataObject(rL);
                            RocketDataObject.launchList.remove(rL);
                            break;
                    }
                }
                else{
                    System.out.println("This Launch ID does not exist");
                }
            }
        }
    }

    public static void tonnageToOrbit(){
        double totalTonnage = 0;
        for (RocketDataObject rL : RocketDataObject.launchList) {
            totalTonnage += rL.getTonnage_to_Orbit();
        }
        System.out.println("Total Tonnage: "+totalTonnage+"\n");
    }


}



