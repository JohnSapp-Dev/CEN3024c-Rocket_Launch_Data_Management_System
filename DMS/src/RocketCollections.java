/*
* The RocketCollections.java class holds all the logic for the program. This class allows the user
* input data into the RocketDataObject with error handling. This ensures the data being inserted
* will not crash the program.
*/


import javax.swing.*;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.io.*;

public class RocketCollections {
    static Scanner dataInput = new Scanner(System.in);

    /*public static int launchIDInput(){
        //used for command line
        // gets and returns user input
        boolean correctEntry = true;
        int launchID = 0;
        System.out.println("\nEnter Launch ID");
        // Allows the user to reenter data if incorrect
        while (correctEntry) {
            try {
                correctEntry = false;
                String l_ID = dataInput.nextLine();
                launchID = Integer.parseInt(l_ID);
                //checks for only positive number input
                if (launchID < 0 ){
                    System.out.println("Please only enter positive numbers");
                    correctEntry = true;
                }else {
                    // checks if the number entered already exists in arraylist
                    for (RocketDataObject rL : RocketDataObject.launchList) {
                        if (launchID == rL.getLaunch_ID()) {
                            System.out.println("Launch ID already exists");
                            correctEntry = true;
                        }
                    }
                }

                // invalid text entry
            } catch (NumberFormatException e) {
                System.out.println("Please enter only a number");
                correctEntry = true;
            }
        }
        return launchID;
    }*/

    /*public static String launchProviderInput() {
        // gets and returns user input
        System.out.println("Enter Launch Provider");
        return dataInput.nextLine();
    }*/

   /* public static String launchLocationInput() {
        // gets and returns user input
        System.out.println("Enter Launch Location");
        return dataInput.nextLine();
    }*/

   /* public static String launchVehicleInput() {
        // gets and returns user input
        System.out.println("Enter Launch Vehicle");
        return dataInput.nextLine();
    }*/

   /* public static LocalDate launchDateInput() {
        // gets and returns user input
        boolean correctEntry = true;
        LocalDate inputDateType = null;
        System.out.println("Enter Launch Date YYYY-MM-DD");
        // Allows the user to reenter data if incorrect
        while (correctEntry) {
            // date format
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            try {
                correctEntry = false;
                String l_Date = dataInput.nextLine();
                inputDateType = LocalDate.parse(l_Date, dateFormat);

                // catches date format errors
            } catch (DateTimeParseException e) {
                System.out.println("Error with date, make sure the date it formated 'YYYY-MM-DD'");
                correctEntry = true;
            }
        }
        return inputDateType;
    }*/

   /* public static int numberCrewInput() {
        // gets and returns user input
        boolean correctEntry = true;
        int numberCrew = 0;
        System.out.println("Enter Number of Crew");
        // Allows the user to reenter data if incorrect
        while (correctEntry) {
            try {
                correctEntry = false;
                String numCrew = dataInput.nextLine();
                numberCrew = Integer.parseInt(numCrew);
                // checks for positive number input
                if (numberCrew < 0) {
                    System.out.println("Please only enter positive numbers");
                    correctEntry = true;
                }
                //checks if the input is an integer
            } catch (NumberFormatException e) {
                System.out.println("Please enter only numbers");
                correctEntry = true;
            }
        }
        return numberCrew;
    }*/

   /* public static double tonnageOrbitInput() {
        // gets and returns user input
        boolean correctEntry = true;
        double numberTonnage = 0;
        System.out.println("Enter Tonnage to Orbit");
        // Allows the user to reenter data if incorrect
        while (correctEntry) {
            try {
                correctEntry = false;
                String tonnage = dataInput.nextLine();
                numberTonnage = Double.parseDouble(tonnage);
                // only allows positive numbers
                if (numberTonnage < 0) {
                    System.out.println("Please only enter positive numbers");
                    correctEntry = true;
                }
                //checks if the input is an integer
            } catch (NumberFormatException e) {
                System.out.println("Please enter only numbers");
                correctEntry = true;
            }
        }
        return numberTonnage;
    }*/

   /* public static String payloadInput() {
        // gets and returns user input
        System.out.println("Enter Payload");
        return dataInput.nextLine();
    }*/

    /*public static void readDataObject(RocketDataObject rL) {
        //prints out object filed to screen
        System.out.println("Launch ID:        " + rL.getLaunch_ID());
        System.out.println("Launch Provider:  " + rL.getLaunch_Provider());
        System.out.println("Launch Location:  " + rL.getLaunch_Location());
        System.out.println("Launch Vehicle:   " + rL.getLaunch_Vehicle());
        System.out.println("Launch date:      " + rL.getLaunch_date());
        System.out.println("Number of Crew:   " + rL.getNumber_of_Crew());
        System.out.println("Payload:          " + rL.getPayload());
        System.out.println("Tonnage to Orbit: " + rL.getTonnage_to_Orbit() + "\n");
    }*/

   /* public static void createData() {
        int optionNumber = 0;
        boolean correctEntry = true;
        Scanner menuInput = new Scanner(System.in);
        // user selection menu
        System.out.println("Select how you are going to Input Rocket Launch data");
        System.out.println("\t1 - Upload File");
        System.out.println("\t2 - Enter Data manually");

        while (correctEntry) {
            try {
                correctEntry = false;
                // gets user input as a string
                String option = menuInput.next();
                // parses string to int
                optionNumber = Integer.parseInt(option);
                // throws invalid message
                if (optionNumber < 0 || optionNumber > 2) {
                    System.out.println("Invalid option");
                    correctEntry = true;
                }
            } catch (NumberFormatException e) { // catch if user enters a non number
                System.out.println("Please enter only numbers");
                correctEntry = true;
            }
        }
        if (optionNumber == 1) {
            System.out.println("upload file");
            //fileDataEntry();
        } else if (optionNumber == 2) {
            System.out.println("Enter Data manually");
            manualDataEntry();
        }
    }*/

   /* public static void manualDataEntry() {
        // creates an object using the "Input" methods
        RocketDataObject launchData = new RocketDataObject
                (launchIDInput(),launchProviderInput(),launchLocationInput(),launchVehicleInput(),
                        launchDateInput(),numberCrewInput(),payloadInput(),tonnageOrbitInput());
        // adds the object to an arraylist
        RocketDataObject.launchList.add(launchData);
        //prints the object
        readDataObject(launchData);
    }*/

    /*public static void readData() {
        // checks if there is data in the arraylist
        if (RocketDataObject.launchList.isEmpty()) {
            System.out.println("No Data");
        } else {
            // displays the data in the arraylist
            for (RocketDataObject rL : RocketDataObject.launchList) {
                readDataObject(rL);
            }
        }
    }*/

   /* public static void updateDeleteData(int optionNumber) {

        int number_ID = 0;
        boolean rowInput = true;
        if (RocketDataObject.launchList.isEmpty()) {
            //checks if there is data in the arraylist
            System.out.println("No Data");
        } else {
            //gets user launch_ID from user
            Scanner dataInput = new Scanner(System.in);
            System.out.println("Select a row, enter the Launch ID");
            while (rowInput) {
                try {
                    rowInput = false;
                    String l_ID = dataInput.nextLine();
                    number_ID = Integer.parseInt(l_ID);
                    if (number_ID < 0) {
                        System.out.println("Enter only positive numbers");
                        rowInput = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please only enter a number");
                    rowInput = true;
                }
            }

            for (int i = 0; i < RocketDataObject.launchList.size(); i++) {
                //loops thought the arraylist
                boolean editing = true;
                boolean correctEntry = true;
                int userInput = 0;
                if (number_ID == RocketDataObject.launchList.get(i).getLaunch_ID()) {
                    //if the launch ID is found in the arraylist the user can update the info
                    switch (optionNumber) {
                        case 1: // edit row
                            while (editing) {
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
                                while (correctEntry) {
                                    try {
                                        //error handling for user input
                                        correctEntry = false;
                                        String input = dataInput.nextLine();
                                        userInput = Integer.parseInt(input);
                                        if (userInput < 1 || userInput > 9) {
                                            System.out.println("Invalid Input");
                                            correctEntry = true;
                                        }
                                    } catch (NumberFormatException e) {
                                        System.out.println("Please enter only numbers");
                                        correctEntry = true;
                                    }
                                }
                                correctEntry = true;
                                switch (userInput) {
                                    // calls correct userInput method and sets the object to the new value
                                    case 1:
                                        //  RocketDataObject.launchList.get(i).setLaunch_ID(launchIDInput());
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
                            if (RocketDataObject.launchList.isEmpty()) {
                                //checks if there is data in the arraylist
                                System.out.println("No Data to delete");
                            } else {
                                //deletes the entry corresponding to the launch ID
                                System.out.println("The data below has been deleted");
                                readDataObject(RocketDataObject.launchList.get(i));
                                RocketDataObject.launchList.remove(RocketDataObject.launchList.get(i));
                            }
                            break;
                    }
                }

                *//*If the loop reaches the end of the arraylist without finding the launch ID
                 * an error message is displayed*//*
                else if (i == RocketDataObject.launchList.size() - 1) {
                    System.out.println("This Launch ID does not exist\n");
                }
            }
        }
    }*/

   /* public static void tonnageToOrbit(){
        // calculates the total tonnage to orbit based on the data in the arraylist
        double totalTonnage = 0;
        DecimalFormat round = new DecimalFormat("0.00");
        if (RocketDataObject.launchList.isEmpty()){
            System.out.println("No Data");
        }else{
        for (RocketDataObject rL : RocketDataObject.launchList) {
            totalTonnage += rL.getTonnage_to_Orbit();
            }
        System.out.println("Total Tonnage to Orbit: "+round.format(totalTonnage)+"\n");
        }
    }*/

   /* public static void fileDataEntry(){
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
        RocketDataObject launchData = null;

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
                // sets the values from the array to a variable
                l_ID = Integer.parseInt(splitData[0]);
                l_Provider = splitData[1];
                l_Location = splitData[2];
                l_Vehicle = splitData[3];
                l_Date = LocalDate.parse(splitData[4]);
                crew = Integer.parseInt(splitData[5]);
                payload = splitData[6];
                tonnage = Double.parseDouble(splitData[7]);
                // creates a new object with the values above
                launchData = new RocketDataObject
                        (l_ID,l_Provider,l_Location,l_Vehicle,l_Date,crew,payload,tonnage);
                // adds the object to the arraylist
                RocketDataObject.launchList.add(launchData);
                // reads the object to the screen
                readDataObject(launchData);
             // error input handling
            }catch (NumberFormatException e){
                System.out.println("Invalid integer input on line: " + count + " Row not added\n");
            }catch (DateTimeParseException e){
                System.out.println("Invalid date input on line: " + count + " Row not added\n");
            }

            for (int i = RocketDataObject.launchList.size()-1; i > 0 ; i--) {
                // loops though Arraylist from the end
                if ((count > 0)) {
                    assert launchData != null;
                    if (launchData.getLaunch_ID() == RocketDataObject.launchList.get(i-1).getLaunch_ID()) {
                        // if the current launch ID matches an ID in the arraylist that entry is deleted.
                        System.out.println("Row " + count + " Launch ID matches existing data. please update file\n");
                        RocketDataObject.launchList.remove(launchData);
                    }
                }
            }
        }
    }*/

    public static void fileDataEntryGUI(String Path) {
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
        RocketDataObject launchData = null;

        /*System.out.println("Enter the absolute path to your text (.txt) file");
        //allows the user to reenter path if error*/

        File dataFile = new File(Path);
        try {
            readData = new Scanner(dataFile);
        } catch (FileNotFoundException e) {
            System.out.println("File not found, try again");
        }

        while (readData.hasNext()) { // loops through all lines in file

            dataRow = readData.nextLine(); //reads in the next line from file
            splitData = dataRow.split(","); // splits and stores strings to array
            count++;

            try {
                // sets the values from the array to a variable
                l_ID = Integer.parseInt(splitData[0]);
                l_Provider = splitData[1];
                l_Location = splitData[2];
                l_Vehicle = splitData[3];
                l_Date = LocalDate.parse(splitData[4]);
                crew = Integer.parseInt(splitData[5]);
                payload = splitData[6];
                tonnage = Double.parseDouble(splitData[7]);
                // creates a new object with the values above
                launchData = new RocketDataObject
                        (l_ID, l_Provider, l_Location, l_Vehicle, l_Date, crew, payload, tonnage);
                // adds the object to the arraylist
                RocketDataObject.launchList.add(launchData);
                // adds data to the database
                if(MySQLHandler.connected) {
                    loginActionListener.MySQL.MySQLAdd(l_ID, l_Provider, l_Location, l_Vehicle, l_Date, crew, payload, tonnage);
                }else{
                    JOptionPane.showMessageDialog(null,"Not connected to database. Row updated locally");
                }
                // error input handling
            } catch (NumberFormatException e) {
                //System.out.println("Invalid integer input on line: " + count + " Row not added\n");
                JOptionPane.showMessageDialog(null, "Invalid integer input on line: "
                        + count + " Row not added\n");
            } catch (DateTimeParseException e) {
                // System.out.println("Invalid date input on line: " + count + " Row not added\n");
                JOptionPane.showMessageDialog(null, "Invalid date input on line: "
                        + count + " Row not added\n");
            }

            for (int i = RocketDataObject.launchList.size() - 1; i > 0; i--) {
                // loops though Arraylist from the end
                if ((count > 0)) {
                    assert launchData != null;
                    if (launchData.getLaunch_ID() == RocketDataObject.launchList.get(i - 1).getLaunch_ID()) {
                        // if the current launch ID matches an ID in the arraylist that entry is deleted.
                        System.out.println("Row " + count + " Launch ID matches existing data. please update file\n");
                        JOptionPane.showMessageDialog(null, "Row " + count +
                                " Launch ID matches existing data. please update file\n");
                        RocketDataObject.launchList.remove(launchData);
                    }
                }
            }
        }
    }

    public static void tonnageToOrbitGUI() {
        // calculates the total tonnage to orbit based on the data in the arraylist
        double totalTonnage = 0;
        DecimalFormat round = new DecimalFormat("0.00");
        if (RocketDataObject.launchList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No Data");
        } else {
            for (RocketDataObject rL : RocketDataObject.launchList) {
                totalTonnage += rL.getTonnage_to_Orbit();
            }
            //System.out.println("Total Tonnage to Orbit: "+round.format(totalTonnage)+"\n");
            JOptionPane.showMessageDialog(null, "Total Tonnage to Orbit: "
                    + round.format(totalTonnage) + "\n");
        }
    }

    public static void deleteRowGUI(int rowValue, int rowNumber) {

        if (rowValue == RocketDataObject.launchList.get(rowNumber).getLaunch_ID()){
            //deletes the entry corresponding to the launch ID
            System.out.println("The data below has been deleted");
            RocketDataObject.launchList.remove(RocketDataObject.launchList.get(rowNumber));

        }
    }

    public static void UpdateRowGUI (int rowValue, int rowNumber, RocketGUI GUI){


        if (rowValue == RocketDataObject.launchList.get(rowNumber).getLaunch_ID()){
            //deletes the entry corresponding to the launch ID
            System.out.println("The data below has been deleted");
            GUI.getAddButton().setText("Update");

            GUI.getIDTF().setText(String.valueOf(RocketDataObject.launchList.get(rowNumber).getLaunch_ID()));
            GUI.getProviderTF().setText(RocketDataObject.launchList.get(rowNumber).getLaunch_Provider());
            GUI.getLocationTF().setText(RocketDataObject.launchList.get(rowNumber).getLaunch_Location());
            GUI.getVehicleTF().setText(RocketDataObject.launchList.get(rowNumber).getLaunch_Vehicle());
            GUI.getDateTF().setText(String.valueOf(RocketDataObject.launchList.get(rowNumber).getLaunch_date()));
            GUI.getCrewTF().setText(String.valueOf(RocketDataObject.launchList.get(rowNumber).getNumber_of_Crew()));
            GUI.getPayloadTF().setText(RocketDataObject.launchList.get(rowNumber).getPayload());
            GUI.getTonnageTF().setText(String.valueOf(RocketDataObject.launchList.get(rowNumber).getTonnage_to_Orbit()));

        }
        deleteRowGUI(rowValue,rowNumber);
    }
}