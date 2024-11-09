/*
 * The GUI.java class hold the logic for the Graphical User Interface (GUI).
 */

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    private JPanel AddToDBPanel;
    private JTextField TonnageTF;
    private JButton AddButton;
    private JButton fileAddButton;
    private JTable DataTable;
    private JButton TonnageCal;
    private JButton UpdateDataButton;
    private JButton DeleteButton;
    private JLabel IDLabel;
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
    private JPanel TableButtonPanel;
    private JLabel userNameLabel;
    private JLabel PassWordLabel;
    private JTextField UserNameTF;
    private JPasswordField passwordTF;
    private JButton logInButton;
    private JLabel DBConnectedImageLabel;
    private JTabbedPane MainPanel;
    private JPanel DBLoginPanel;
    private JLabel DBName;
    private JTextField DBNameTF;
    private JLabel DBSetUp;
    private JRadioButton FormatDBButton;
    private JCheckBox FormatColumnsCB;
    private JPanel formatOptionsPanel;
    private JButton FormatSelectionButton;
    private JTextField TableNameTF;
    private JComboBox sortCombo;
    private JPanel optionPanel;
    private JPanel TableTab;
    private JScrollPane DataScrollPane;
    private boolean connectedToDB = false;

    //public JList rocketList;

    public RocketGUI() {
        super();
        init();

    }

    public void init() {

        JTabbedPane MainPanel = this.getMainPanel();
        JFrame frame = new JFrame();
        this.createTable();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Rocket Launch Data Management System");
        frame.setContentPane(MainPanel);
        connectedStatus(false);
        tableTabEnable(false);
        createSortComboBox();

        //button action
        this.AddButton.addActionListener(new AddActionListener(this));
        this.fileAddButton.addActionListener(new AddFileActionListener(this));
        this.TonnageCal.addActionListener(new calculateTonnagaActionListener(this));
        this.DeleteButton.addActionListener(new deleteRowActionListener(this));
        this.UpdateDataButton.addActionListener(new updateRowActionListener(this));
        this.logInButton.addActionListener(new loginActionListener(this));
        this.FormatDBButton.addActionListener(new formatDataSelection(this));
        this.FormatSelectionButton.addActionListener(new formatDatabase(this));
        this.sortCombo.addActionListener(new sortTable(this));

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

        //sets default column width
        TableColumnModel columnModel = DataTable.getColumnModel();
        columnModel.getColumn(0).setMinWidth(25);
       // columnModel.getColumn(0)
        columnModel.getColumn(1).setMinWidth(75);
        columnModel.getColumn(2).setMinWidth(75);
        columnModel.getColumn(3).setMinWidth(75);
        columnModel.getColumn(4).setMinWidth(75);
        columnModel.getColumn(5).setMinWidth(25);
        columnModel.getColumn(6).setMinWidth(150);
        columnModel.getColumn(7).setMinWidth(25);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        columnModel.getColumn(0).setCellRenderer(centerRenderer);
        columnModel.getColumn(4).setCellRenderer(centerRenderer);
        columnModel.getColumn(5).setCellRenderer(centerRenderer);
        columnModel.getColumn(7).setCellRenderer(centerRenderer);

    }


    private void createSortComboBox(){
        sortCombo.setModel(new DefaultComboBoxModel(new String[]{"Sort ID number","Sort Location A-Z", "Sort Location Z-A",
                "Sort Date oldest first", "Sort Date Newest first"}));

    }

    // getter methods
    public static void constructGUI(){
        RocketGUI Rocket = new RocketGUI();
    }
    public JTabbedPane getMainPanel() {
        return MainPanel;
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
    public JTextField getDatabaseNameTF() {return DBNameTF;}
    public JTextField getUserNameTF() {return UserNameTF;}
    public JTextField getPasswordTF(){return passwordTF;}
    public JTable getTable(){
        return DataTable;
    }
    public JButton getAddButton(){
        return AddButton;
    }
    public JButton getLogInButton(){return logInButton;}
    public JCheckBox getFormatColumnsCB() {return FormatColumnsCB;}
    public boolean getConnectedToDB() {return connectedToDB;}
    public JRadioButton getFormatDBButton() {return FormatDBButton;}
    public JButton getFormatSelectionButton() {return FormatSelectionButton;}
    public JTextField getTableNameTF() {return TableNameTF;}
    public JButton getFileAddButton() {return fileAddButton;}
    public JPanel getAddButtonPanel() {return AddButtonPanel;}
    public JPanel getTextPanel() {return TextPanel;}
    public JPanel getTableButtonPanel() {return TableButtonPanel;}
    public JButton getTonnageCal() {return TonnageCal;}
    public JButton getUpdateDataButton() {return UpdateDataButton;}
    public JButton getDeleteButton() {return DeleteButton;}
    public JComboBox getSortCombo() {return sortCombo;}
    public JPanel getOptionPanel() {return optionPanel;}
    public JTable getDataTable() {return DataTable;}
    public JScrollPane getDataScrollPane() {return DataScrollPane;}
    public JPanel getTablePanel() {return TablePanel;}

    public void connectedStatus(boolean connection){
        String connectedPath = "assets/smallConnected.png";
        String notConnectedPath = "assets/smallNotConnected.png";
        String imagePath;
        if (connection){
            imagePath = connectedPath;
        }else{
            imagePath = notConnectedPath;
        }
        ImageIcon icon = new ImageIcon(imagePath);
        DBConnectedImageLabel.setIcon(icon);
        connectedToDB = connection;
    }

    // blocks the table panel from input till the database is logged into
    public void tableTabEnable(boolean setVale) {
        //addButtonPanel
        getAddButtonPanel().setEnabled(setVale);
        getAddButton().setEnabled(setVale);
        getFileAddButton().setEnabled(setVale);
        //TextPanel
        getTextPanel().setEnabled(setVale);
        getIDTF().setEnabled(setVale);
        getProviderTF().setEnabled(setVale);
        getLocationTF().setEnabled(setVale);
        getVehicleTF().setEnabled(setVale);
        getDateTF().setEnabled(setVale);
        getCrewTF().setEnabled(setVale);
        getPayloadTF().setEnabled(setVale);
        getTonnageTF().setEnabled(setVale);
        //TableButtonPanel
        getTableButtonPanel().setEnabled(setVale);
        getTonnageCal().setEnabled(setVale);
        getUpdateDataButton().setEnabled(setVale);
        getDeleteButton().setEnabled(setVale);
        //Table
        getTablePanel().setEnabled(setVale);
        getDataScrollPane().setEnabled(setVale);
        getDataTable().setEnabled(setVale);
        //OptionPanel
        getOptionPanel().setEnabled(setVale);
        getSortCombo().setEnabled(setVale);
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
            GUI.getIDTF().setText("");
            GUI.getCrewTF().setText("");
        }
        //gets text field data
        String provider = GUI.getProviderTF().getText();
        String location = GUI.getLocationTF().getText();
        String vehicle = GUI.getVehicleTF().getText();
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
                    (IDNumber,provider,location,vehicle,formattedDateType,NumCrew,payload,NumTonnage);
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

            // adds row to database if connected
            if(MySQLHandler.connected) {
                loginActionListener.MySQL.MySQLAdd(IDNumber,provider,location,
                        vehicle,formattedDateType,NumCrew,payload,NumTonnage);
            }else{
                JOptionPane.showMessageDialog(null,"Not connected to database. Row updated locally");
            }
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
        try {
            RocketCollections.fileDataEntryGUI(OpenFileExplorer());
        }catch(NullPointerException x) {
            JOptionPane.showMessageDialog(null, "No file selected");
        }
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
            if(result ==JFileChooser.CANCEL_OPTION){
                System.out.println("Cancelled");
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
                // updates the database if connected
                if(MySQLHandler.connected) {
                    loginActionListener.MySQL.MySQLRemove(IDValue);
                }else{
                    JOptionPane.showMessageDialog(null,"Not connected to database. Row updated locally");
                }
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
                // updates the database if connected
                if(MySQLHandler.connected) {
                    loginActionListener.MySQL.MySQLRemove(IDValue);
                }else{
                    JOptionPane.showMessageDialog(null,"Not connected to database. Row updated locally");
                }
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

// This class holds the logic to log into/out of the users database
class loginActionListener implements  ActionListener{
    RocketGUI GUI;
    static String userName = null;
    static String password = null;
    static String DBName = null;
    static String tableName = null;
    static MySQLHandler MySQL;

    public loginActionListener (RocketGUI inputGUI)
    {
        GUI = inputGUI;
        MySQL = null;
    }

    public void actionPerformed (ActionEvent e) {
        userName = GUI.getUserNameTF().getText();
        password = GUI.getPasswordTF().getText();
        DBName = GUI.getDatabaseNameTF().getText();
        tableName = GUI.getTableNameTF().getText();
        //creates the mysql object that holds all info dealing with the database
        MySQL = new MySQLHandler(userName, password, DBName,tableName);

        if(GUI.getLogInButton().getText().equals("Login")) {
            //runs if not logged into the database
            if (MySQL.getConnectionError()) {
                //error handling
                JOptionPane.showMessageDialog(null, "Could not connect to the database");
                GUI.connectedStatus(false);
            }else{
                //changes the connected image and button text
                GUI.connectedStatus(true);
                GUI.getFormatDBButton().setEnabled(true);
                GUI.getFormatDBButton().setToolTipText("Select to format the database");
                GUI.getLogInButton().setText("Log Out");
                // enables the table tab upon login
                GUI.tableTabEnable(true);
                // adds the database to the table upon login
                importDatabase.importData(1);
                GUI.updateTable();
            }
            // runs if already signed in to the database
        }else if (GUI.getLogInButton().getText().equals("Log Out")){
            MySQL.closeConnection();
            //changes the image and button text
            GUI.getFormatDBButton().setToolTipText("Login to format database");
            GUI.getFormatDBButton().setEnabled(false);
            GUI.connectedStatus(false);
            GUI.tableTabEnable(false);
            GUI.getLogInButton().setText("Login");
        }
    }

    public String getTableName() {
        return tableName;
    }
}

// This class holds the logic to let the user select format options
class formatDataSelection implements  ActionListener{
    RocketGUI GUI;

    public formatDataSelection (RocketGUI inputGUI)
    {
        GUI = inputGUI;
    }

    public void actionPerformed (ActionEvent e){
        if(GUI.getConnectedToDB()) {
            //toggles if the format options are grayed out
            GUI.getFormatColumnsCB().setEnabled(!GUI.getFormatColumnsCB().isEnabled());
            GUI.getFormatSelectionButton().setEnabled(!GUI.getFormatSelectionButton().isEnabled());
        }
    }
}

// This class hold the logic to format the selected database to match program needs
class formatDatabase implements ActionListener{
    RocketGUI GUI;

    public formatDatabase (RocketGUI inputGUI)
    {
        GUI = inputGUI;
    }

    public void actionPerformed (ActionEvent e){
        if(GUI.getFormatColumnsCB().isSelected()) {
            loginActionListener.MySQL.formatTable();
            int size = RocketDataObject.launchList.size();
            if (!RocketDataObject.launchList.isEmpty()) {
                RocketDataObject.launchList.subList(0, RocketDataObject.launchList.size()).clear();
            }
            GUI.updateTable();

        }
    }
}

//This class holds the logic to sort the table as chosen by the user
class sortTable implements ActionListener{
    RocketGUI GUI;

    public sortTable (RocketGUI inputGUI)
    {
        GUI = inputGUI;
    }

    public void actionPerformed (ActionEvent e){
        int CBSelection = GUI.getSortCombo().getSelectedIndex();
        //deletes all values in the arraylist
        if (!RocketDataObject.launchList.isEmpty()) {
            RocketDataObject.launchList.subList(0, RocketDataObject.launchList.size()).clear();
        }
        //reloads values into arraylist
        importDatabase.importData(CBSelection+1);
        GUI.updateTable();
    }

}

//This class holds the logic to import data from the database into the program
class importDatabase implements ActionListener{
    RocketGUI GUI;

    public importDatabase (RocketGUI inputGUI)
    {
        GUI = inputGUI;
    }

    public void actionPerformed (ActionEvent e){
       importData(1);
    }
    public static void importData(int selection){
        int l_ID = 0;
        String l_Provider = null;
        String l_Location = null;
        String l_Vehicle = null;
        LocalDate l_Date = null;
        int crew = 0;
        String payload = null;
        double tonnage = 0;
        RocketDataObject launchData = null;

        ResultSet results = loginActionListener.MySQL.importDatabase(selection);

        try {
            while(results.next()) {
                l_ID = results.getInt("Launch_ID");
                l_Provider = results.getString("Launch_Provider");
                l_Location = results.getString("Launch_Location");
                l_Vehicle = results.getString("Launch_Vehicle");
                l_Date = LocalDate.parse(String.valueOf(results.getDate("Launch_Date")));
                crew = results.getInt("Number_of_Crew");
                payload = results.getString("Payload");
                tonnage = results.getDouble("Tonnage_to_Orbit");
                launchData = new RocketDataObject
                        (l_ID, l_Provider, l_Location, l_Vehicle, l_Date, crew, payload, tonnage);
                // adds the object to the arraylist
                RocketDataObject.launchList.add(launchData);
            }
        }catch(SQLException E){
            JOptionPane.showMessageDialog(null,"Error with sync");
        }


    }
}

