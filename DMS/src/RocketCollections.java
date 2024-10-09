import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.io.*;

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
                System.out.println("Error with date, make sure the date it formated 'YYYY-MM-DD'");
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
            fileDataEntry();
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

            for (int i = 0 ; i < RocketDataObject.launchList.size(); i++){
                boolean editing = true;
                boolean correctEntry = true;
                int userInput = 0;
                if (number_ID == RocketDataObject.launchList.get(i).getLaunch_ID()){
                    switch(optionNumber){
                        case 1: // edit row
                            while(editing){
                                //prints the current data for the selected launch
                                System.out.println("\nCurrent Data for this launch\n");
                                readDataObject(RocketDataObject.launchList.get(i));
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
                                while(correctEntry){
                                    try {
                                        correctEntry = false;
                                        String input = dataInput.nextLine();
                                        userInput = Integer.parseInt(input);
                                        if(userInput < 1 || userInput > 9){
                                            System.out.println("Invalid Input");
                                            correctEntry = true;
                                        }
                                    }catch (NumberFormatException e){
                                        System.out.println("Please enter only numbers");
                                        correctEntry = true;
                                    }
                                }
                                correctEntry = true;
                                switch (userInput){
                                    // calls correct userInput method and sets the object to the new value
                                    case 1:
                                        RocketDataObject.launchList.get(i).setLaunch_ID(launchIDInput());
                                        userInput = 0;
                                        break;
                                    case 2:
                                        RocketDataObject.launchList.get(i).setLaunch_Provider(launchProviderInput());
                                        userInput = 0;
                                        break;
                                    case 3:
                                        RocketDataObject.launchList.get(i).setLaunch_Location(launchLocationInput());
                                        userInput = 0;
                                        break;
                                    case 4:
                                        RocketDataObject.launchList.get(i).setLaunch_Vehicle(launchVehicleInput());
                                        userInput = 0;
                                        break;
                                    case 5:
                                        RocketDataObject.launchList.get(i).setLaunch_date(launchDateInput());
                                        userInput = 0;
                                        break;
                                    case 6:
                                        RocketDataObject.launchList.get(i).setNumber_of_Crew(numberCrewInput());
                                        userInput = 0;
                                        break;
                                    case 7:
                                        RocketDataObject.launchList.get(i).setPayload(payloadInput());
                                        userInput = 0;
                                        break;
                                    case 8:
                                        RocketDataObject.launchList.get(i).setTonnage_to_Orbit(tonnageOrbitInput());
                                        userInput = 0;
                                        break;
                                    case 9:
                                        System.out.println("finished editing this entry");
                                        editing = false;
                                        break;
                                }
                            }
                            break;
                        case 2: // delete row
                            if(RocketDataObject.launchList.isEmpty()){
                                System.out.println("No Data to delete");
                            }else {
                                System.out.println("The data below has been deleted");
                                readDataObject(RocketDataObject.launchList.get(i));
                                RocketDataObject.launchList.remove(RocketDataObject.launchList.get(i));
                            }
                            break;
                    }
                }
                else if(i == RocketDataObject.launchList.size()){
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
        System.out.println("Total Tonnage to Orbit: "+totalTonnage+"\n");
    }

    public static void fileDataEntry(){
        boolean correctFile = true;
        Scanner readData = null;
        String dataRow;
        String[] splitData;
        int count = 0;
        int l_ID = 0;
        String l_Provider = null;
        String l_Location = null;
        String l_Vehicle = null;
        LocalDate l_Date = null;
        int crew = 0;
        String payload = null;
        double tonnage = 0;
        //RocketDataObject launchData = null;

        System.out.println("Enter the absolute path to your text (.txt) file");
        //allows the user to reenter path if error
        while (correctFile) {
            correctFile = false;
            String filePath = dataInput.nextLine();
            File dataFile = new File(filePath);
            try {
                readData = new Scanner(dataFile);
            } catch (FileNotFoundException e) {
                System.out.println("File not found, try again");
                correctFile = true;
            }
        }
        while(readData.hasNext()){ // loops through all lines in file
            dataRow = readData.nextLine(); //reads in the next line from file
            splitData = dataRow.split(","); // splits and stores strings to array
            count++;

            try {

                l_ID = Integer.parseInt(splitData[0]);
                l_Provider = splitData[1];
                l_Location = splitData[2];
                l_Vehicle = splitData[3];
                l_Date = LocalDate.parse(splitData[4]);
                crew = Integer.parseInt(splitData[5]);
                payload = splitData[6];
                tonnage = Double.parseDouble(splitData[7]);

            }catch (NumberFormatException e){
                System.out.println("Invalid integer input on line: " + count);
            }catch (DateTimeParseException e){
                System.out.println("Invalid date input on line: " + count);
            }

            RocketDataObject launchData = new RocketDataObject
                    (l_ID,l_Provider,l_Location,l_Vehicle,l_Date,crew,payload,tonnage);

            RocketDataObject.launchList.add(launchData);
            readDataObject(launchData);
        }
    }


}



