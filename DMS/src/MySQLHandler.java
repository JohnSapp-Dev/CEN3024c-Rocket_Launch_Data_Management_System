import javax.swing.*;
import java.time.LocalDate;
import java.sql.*;

/**
 *  The MySQLHandler.java class holds the logic that interacts with the MySQL database.
 *  This class holds the user's info to login in to the database along with the methods to make
 *  database queries.
 */
public class MySQLHandler {
    //fields
    private String UserName;
    private String Password;
    private String databaseName;
    private String MySQLUrl;
    private boolean connectionError;
    private Connection MySQLSever;
    private String tableName;
    public static boolean connected = false;

    public MySQLHandler(String UserName, String Password, String databaseName,String tableName) {
        this.UserName = UserName;
        this.Password = Password;
        this.databaseName = databaseName;
        this.MySQLUrl = "jdbc:mysql://localhost:3306/" + databaseName;
        this.connectionError = false;
        this.MySQLSever = null;
        this.tableName = tableName;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.MySQLSever = DriverManager.getConnection(this.getMySQLUrl(),
                    this.getUserName(), this.getPassword());
            connected = true;
        }catch(SQLException | ClassNotFoundException e){
            this.connectionError = true;
            connected = false;
        }
    }

    //GETTERS & SETTERS
    public String getUserName() {return UserName;}
    public String getPassword() {return Password;}
    public String getDatabaseName() {return databaseName;}
    public String getMySQLUrl() {return MySQLUrl;}
    public Boolean getConnectionError() {return connectionError;}
    public void setUserName(String UserName) {this.UserName = UserName;}
    public void setPassword(String Password) {this.Password = Password;}
    public void setDatabaseName(String databaseName) {this.databaseName = databaseName;}
    public void setMySQLUrl(String MySQLUrl) {this.MySQLUrl = MySQLUrl;}

    /**
     * Closes the connection to the database when called
     * */
    public void closeConnection() {
        try {
            this.MySQLSever.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Deletes the table in the selected database.
     * Creates a new table with the proper column names and data types.
     * Also removes any data in the ArrayList*/
    public void formatTable (){
        try{
            // deletes all information from the table
            String clearDB = "DROP TABLE " + tableName;
            String formatColumns = "CREATE TABLE "+tableName+
                    " (Launch_ID int PRIMARY KEY," +
                    " Launch_Provider VARCHAR(100)," +
                    " Launch_Location VARCHAR(100)," +
                    " Launch_Vehicle VARCHAR(100)," +
                    " Launch_Date DATE," +
                    " Number_of_Crew int," +
                    " Payload VARCHAR(100)," +
                    " Tonnage_to_Orbit DOUBLE);";
            PreparedStatement deleteStatement = this.MySQLSever.prepareStatement(clearDB);
            PreparedStatement insertStatement = this.MySQLSever.prepareStatement(formatColumns);
            int selection = JOptionPane.showOptionDialog(null,
                    "This will delete all information in the selected table!","WARNING"
                    ,JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE,null,null,-1);
            if(selection == 0){
                //removes and formats database
                deleteStatement.executeUpdate();
                insertStatement.executeUpdate();
                //removes items from local arraylist
                if (!RocketDataObject.launchList.isEmpty()) {
                    RocketDataObject.launchList.subList(0, RocketDataObject.launchList.size()).clear();
                }

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Updates the database when user adds a row of data manually or via a file.
    */
    public void MySQLAdd(int ID, String provider, String location, String vehicle, LocalDate date, int crew,
                         String payload, double tonnage){
        String MySQLManualAdd = "INSERT IGNORE INTO "+tableName+" (Launch_ID, Launch_Provider, Launch_Location, " +
                "Launch_Vehicle, Launch_Date, Number_of_Crew, Payload, Tonnage_to_Orbit)"+
                "VALUES (?,?,?,?,?,?,?,?);";

        try {
            PreparedStatement ManualAddStatement = this.MySQLSever.prepareStatement(MySQLManualAdd);
            ManualAddStatement.setInt(1, ID);
            ManualAddStatement.setString(2, provider);
            ManualAddStatement.setString(3, location);
            ManualAddStatement.setString(4, vehicle);
            ManualAddStatement.setString(5,String.valueOf(date));
            ManualAddStatement.setInt(6,crew);
            ManualAddStatement.setString(7,payload);
            ManualAddStatement.setDouble(8,tonnage);
            ManualAddStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
    Updates the database when a user deletes a row from the table
    */
    public void MySQLRemove(int ID){
        String MySQLRemove = "DELETE FROM "+tableName+" WHERE Launch_ID=?";
        try{
            PreparedStatement removeStatement = this.MySQLSever.prepareStatement(MySQLRemove);
            removeStatement.setInt(1, ID);
            removeStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Uses the correct MySQL query to gather data from the database.
     * */
    public ResultSet importDatabase(int selection){
        String MySQLImport = " ";

        switch(selection){
            case 1:
                // returns table sorted by ID number
                MySQLImport = "SELECT * FROM "+tableName+ " ORDER BY Launch_ID;";
                break;
            case 2:
                MySQLImport = "SELECT * FROM "+tableName+" ORDER BY Launch_Location ASC;";
                break;
            case 3:
                MySQLImport = "SELECT * FROM "+tableName+" ORDER BY Launch_Location DESC;";
                break;
            case 4:
                MySQLImport = "SELECT * FROM "+tableName+" ORDER BY Launch_Date ASC;";
                break;
            case 5:
                MySQLImport = "SELECT * FROM "+tableName+" ORDER BY Launch_Date DESC;";
                break;
        }

        PreparedStatement importStatement = null;
        try {
            importStatement = this.MySQLSever.prepareStatement(MySQLImport);
            return importStatement.executeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Database not formated to match program. Please format the database.");
            throw new RuntimeException(e);
        }

    }
}
