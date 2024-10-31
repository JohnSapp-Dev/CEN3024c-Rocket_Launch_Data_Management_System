/*
 * The GUI.java class hold the logic for the Graphical User Interface (GUI).
 */

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class RocketGUI extends JFrame{
    private JTextField IDTF;
    private JTextField ProviderTF;
    private JTextField VehicleTF;
    private JTextField LocationTF;
    private JTextField DateTF;
    private JTextField CrewTF;
    private JTextField PayloadTF;
    private JPanel MainPanel;
    private JTextField TonnageTF;
    private JButton AddButton;
    private JButton fileAddButton;
    private JTable DataTable;
    private JButton TonnagaCal;
    private JButton UpdateDataButton;
    private JButton DeleteButton;
    /*private JLabel IDLabel;
    private JLabel ProviderLabel;
    private JLabel LocationLabel;
    private JLabel VehicleLabel;
    private JLabel DateLabel;
    private JLabel CrewLabel;
    private JLabel PayloadLabel;
    private JLabel TonnageLabel;
    private JPanel AddButtonPanel;
    private JPanel LabelPanel;
    private JPanel TextPanel;
    private JPanel TablePanel;
    private JPanel TableButtonPanel;*/

    //public JList rocketList;

    public RocketGUI() {
        super();
        init();

    }

    public void init() {

        JPanel MainPanel = this.getMainPanel();
        JFrame frame = new JFrame();
        this.createTable();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Rocket Launch Data Management System");
        frame.setContentPane(MainPanel);

        //button action
        this.AddButton.addActionListener(new AddActionListener(this));
        this.fileAddButton.addActionListener(new AddFileActionListener(this));
        this.TonnagaCal.addActionListener(new calculateTonnagaActionListener(this));
        this.DeleteButton.addActionListener(new deleteRowActionListener(this));
        this.UpdateDataButton.addActionListener(new updateRowActionListener(this));


        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

   public void updateTable(){
        ArrayList<RocketDataObject> list = RocketDataObject.launchList;
        DefaultTableModel model = (DefaultTableModel) DataTable.getModel();
        model.setRowCount(0);

        for (RocketDataObject launch : list){
            model.addRow(new Object[]{
                    launch.getLaunch_ID(),
                    launch.getLaunch_Provider(),
                    launch.getLaunch_Location(),
                    launch.getLaunch_Vehicle(),
                    launch.getLaunch_date(),
                    launch.getNumber_of_Crew(),
                    launch.getPayload(),
                    launch.getTonnage_to_Orbit()
            });
        }
    }

    /* Creates a table*/
    private void createTable() {
        //table format
        DataTable.setModel(new DefaultTableModel(
                null,
                new String[]{"ID", "Provider", "Location", "Vehicle","Date", "Crew", "Payload","Tonnage"}
        ));
        TableColumnModel columnModel = DataTable.getColumnModel();
        columnModel.getColumn(0).setMinWidth(25);
        columnModel.getColumn(1).setMinWidth(75);
        columnModel.getColumn(2).setMinWidth(75);
        columnModel.getColumn(3).setMinWidth(75);
        columnModel.getColumn(4).setMinWidth(75);
        columnModel.getColumn(5).setMinWidth(25);
        columnModel.getColumn(6).setMinWidth(150);
        columnModel.getColumn(7).setMinWidth(25);



    }
    public JPanel getMainPanel() {
        return MainPanel;
    }
    // getter methods
    public static void constructGUI(){
        RocketGUI Rocket = new RocketGUI();
    }

    public JTextField getIDTF() {
        return IDTF;
    }
    public JTextField getProviderTF() {
        return ProviderTF;
    }
    public JTextField getVehicleTF() {
        return VehicleTF;
    }
    public JTextField getLocationTF() {
        return LocationTF;
    }
    public JTextField getDateTF() {
        return DateTF;
    }
    public JTextField getCrewTF() {
        return CrewTF;
    }
    public JTextField getPayloadTF() {
        return PayloadTF;
    }
    public JTextField getTonnageTF() {
        return TonnageTF;
    }
    public JTable getTable(){
        return DataTable;
    }
    public JButton getAddButton(){
        return AddButton;
    }

}
// this class holds the logic to add rows to the database
class AddActionListener implements ActionListener {

    RocketGUI GUI;

    public AddActionListener (RocketGUI inputGUI)
    {
        GUI = inputGUI;
    }
    public void actionPerformed (ActionEvent e)
    {
        boolean addToTable = true;
        int IDNumber = 0;
        int NumCrew = 0;
        double NumTonnage = 0;
        //int error handing
        try {
            IDNumber = Integer.parseInt(GUI.getIDTF().getText());
            NumCrew = Integer.parseInt(GUI.getCrewTF().getText());
            NumTonnage = Double.parseDouble(GUI.getTonnageTF().getText());

            if (IDNumber < 0) {
                JOptionPane.showMessageDialog(null, "Please only enter positive" +
                        " numbers to the ID text area");
                addToTable = false;
                GUI.getIDTF().setText("");
            } else {
                // checks if the number entered already exists in arraylist
                for (RocketDataObject rL : RocketDataObject.launchList) {
                    if (IDNumber == rL.getLaunch_ID()) {
                        JOptionPane.showMessageDialog(null, "Launch ID already exists");
                        addToTable = false;
                        GUI.getIDTF().setText("");
                    }
                }
            }
            if (NumCrew < 0) {
                JOptionPane.showMessageDialog(null, "Please only enter positive" +
                        " numbers to the Crew text area");
                addToTable = false;
                GUI.getCrewTF().setText("");
            }
            if (NumTonnage < 0) {
                JOptionPane.showMessageDialog(null, "Please only enter positive" +
                        " numbers to the Tonnage text area");
                addToTable = false;
                GUI.getCrewTF().setText("");
            }


        }catch (NumberFormatException x) {
            JOptionPane.showMessageDialog(null,"Please enter only a number");
            addToTable = false;
        }
        //gets text field data
        String provider = GUI.getProviderTF().getText();
        String location = GUI.getVehicleTF().getText();
        String vehical = GUI.getLocationTF().getText();
        String payload = GUI.getPayloadTF().getText();

        //gets and formats data text field data
        String date = GUI.getDateTF().getText();
        LocalDate formattedDateType = null;
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            formattedDateType = LocalDate.parse(date,dateFormat);

            // catches date format errors
        } catch (DateTimeParseException y) {
            JOptionPane.showMessageDialog(null,
                    "Error with date, make sure the date it formated 'YYYY-MM-DD'");
            addToTable = false;
            GUI.getDateTF().setText("");
        }
        //creates RocketDataObject if no errors
        if (addToTable) {
            RocketDataObject launchData = new RocketDataObject
                    (IDNumber,provider,location,vehical,formattedDateType,NumCrew,payload,NumTonnage);
            RocketDataObject.launchList.add(launchData);
            GUI.updateTable();
            GUI.getIDTF().setText("");
            GUI.getProviderTF().setText("");
            GUI.getLocationTF().setText("");
            GUI.getVehicleTF().setText("");
            GUI.getDateTF().setText("");
            GUI.getCrewTF().setText("");
            GUI.getPayloadTF().setText("");
            GUI.getTonnageTF().setText("");
            GUI.getAddButton().setText("Add");
        }

    }
}

// This class holds the logic to add a file to the database
class AddFileActionListener implements ActionListener{
    RocketGUI GUI;

    public AddFileActionListener (RocketGUI inputGUI)
    {
        GUI = inputGUI;
    }

    public void actionPerformed (ActionEvent e){
        //calls the function to open a file via a gui window
        RocketCollections.fileDataEntryGUI(OpenFileExplorer());
        //updates the table after the file is added
        GUI.updateTable();
    }

    public String OpenFileExplorer(){

            JFileChooser FileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files","txt");
            FileChooser.setFileFilter(filter);
            int result = FileChooser.showOpenDialog(null);

            if(result == JFileChooser.APPROVE_OPTION){
                File selectFile = new File(FileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(selectFile);
                return String.valueOf(selectFile);
            }
        return ".";
    }
}


// This class hold the logic to calculate the total tonnage stored in the database
class calculateTonnagaActionListener implements ActionListener{

    public calculateTonnagaActionListener (RocketGUI inputGUI)
    {
    }

    public void actionPerformed (ActionEvent e){
        //calls the function to calculate the total
        RocketCollections.tonnageToOrbitGUI();
    }
}

// This class holds the logic to delete a selected row in the database
class deleteRowActionListener implements ActionListener{
    RocketGUI GUI;

    public deleteRowActionListener (RocketGUI inputGUI)
    {
        GUI = inputGUI;
    }

    public void actionPerformed (ActionEvent e){

        try {
            if (RocketDataObject.launchList.isEmpty()) {
                // gives error if the database is empty
                JOptionPane.showMessageDialog(null, "No Data to delete");
            } else {
                // gets the value and row number for the selected row
                Integer IDValue = (Integer) GUI.getTable().getValueAt
                        (GUI.getTable().getSelectedRow(), GUI.getTable().getSelectedColumn());
                int RowNumber = GUI.getTable().getSelectedRow();
                //calls the delete method
                RocketCollections.deleteRowGUI(IDValue, RowNumber);
                GUI.updateTable();
            }
        // error handling
        }catch (ArrayIndexOutOfBoundsException q){
            JOptionPane.showMessageDialog(null, "No row selected");
        }catch (ClassCastException w){
            JOptionPane.showMessageDialog(null, "Please select the ID number");
        }
    }
}

// This class holds the logic to update a row in the database
class updateRowActionListener implements  ActionListener{

    RocketGUI GUI;

    public updateRowActionListener (RocketGUI inputGUI)
    {
        GUI = inputGUI;
    }
    public void actionPerformed (ActionEvent e){

        try {
            if (RocketDataObject.launchList.isEmpty()) {
                // gives error if the database is empty
                JOptionPane.showMessageDialog(null, "No Data to Update");
            } else {
                // gets the value and row number for the selected row
                Integer IDValue = (Integer) GUI.getTable().getValueAt
                        (GUI.getTable().getSelectedRow(), GUI.getTable().getSelectedColumn());
                int RowNumber = GUI.getTable().getSelectedRow();
                //calls the update method
                RocketCollections.UpdateRowGUI(IDValue, RowNumber,GUI);
                GUI.updateTable();
            }
        // error handling
        }catch (ArrayIndexOutOfBoundsException q){
            JOptionPane.showMessageDialog(null, "No row selected");
        }catch (ClassCastException w){
            JOptionPane.showMessageDialog(null, "Please select the ID number");
        }
    }
}
