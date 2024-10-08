import java.time.LocalDate;
import java.util.ArrayList;

public class RocketDataObject {
    //fields
    static ArrayList<RocketDataObject> launchList = new ArrayList<>();
    private int Launch_ID;
    private String Launch_Provider;
    private String Launch_Location;
    private String Launch_Vehicle;
    private LocalDate Launch_date;
    private int Number_of_Crew;
    private String Payload;
    private double Tonnage_to_Orbit;

    // Constructor
    public RocketDataObject(int Launch_ID,String Launch_Provider,String Launch_Location,
                             String Launch_Vehicle, LocalDate Launch_date, int Number_of_Crew, String Payload,
                             double Tonnage_to_Orbit){
        this.Launch_ID = Launch_ID;
        this.Launch_Provider = Launch_Provider;
        this.Launch_Location = Launch_Location;
        this.Launch_Vehicle = Launch_Vehicle;
        this.Launch_date = Launch_date;
        this.Number_of_Crew = Number_of_Crew;
        this.Payload = Payload;
        this.Tonnage_to_Orbit = Tonnage_to_Orbit;
    }
    public RocketDataObject(){
        // default constructor
    }
    //getters & setters
    public int getLaunch_ID(){
        return Launch_ID;
    }
    public void setLaunch_ID(int Launch_ID){
        this.Launch_ID = Launch_ID;
    }
    public String getLaunch_Provider(){
        return Launch_Provider;
    }
    public void setLaunch_Provider(String Launch_Provider){
        this.Launch_Provider = Launch_Provider;
    }
    public String getLaunch_Location(){
        return Launch_Location;
    }
    public void setLaunch_Location(String Launch_Location){
        this.Launch_Location = Launch_Location;
    }
    public String getLaunch_Vehicle(){
        return Launch_Vehicle;
    }
    public void setLaunch_Vehicle(String Launch_Vehicle){
        this.Launch_Vehicle = Launch_Vehicle;
    }
    public LocalDate getLaunch_date(){
        return Launch_date;
    }
    public void setLaunch_date(LocalDate Launch_date){
        this.Launch_date = Launch_date;
    }
    public int getNumber_of_Crew(){
        return Number_of_Crew;
    }
    public void setNumber_of_Crew(int Number_of_Crew){
        this.Number_of_Crew = Number_of_Crew;
    }
    public String getPayload(){
        return Payload;
    }
    public void setPayload(String Payload){
        this.Payload = Payload;
    }
    public double getTonnage_to_Orbit(){
        return Tonnage_to_Orbit;
    }
    public void setTonnage_to_Orbit(double Tonnage_to_Orbit){
        this.Tonnage_to_Orbit = Tonnage_to_Orbit;
    }
}
