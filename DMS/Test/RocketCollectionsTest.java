import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RocketCollectionsTest {
    RocketDataObject rocket;

    RocketCollectionsTest() {
    }

    @BeforeEach
    void setUp() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate inputDateType = LocalDate.parse("2009-12-25", dateFormat);
        this.rocket = new RocketDataObject(1, "NASA", "Florida", "Space Shuttle", inputDateType, 7, "Hubble", 4.5);
    }

    @Test
    void launchIDInput() {
        System.out.println("Enter this value to test method:" + this.rocket.getLaunch_ID());
        RocketCollections.launchIDInput();
        Assertions.assertEquals(this.rocket.getLaunch_ID(), RocketCollections.launchIDInput(), "Error with launchDataInput");
        // this will not finish since the launchIDInput() method expects user input
    }

}
