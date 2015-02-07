package harvardWeCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class StudentServiceTest {

    @Test
    public void shouldReturnListOfMajors() {
        StudentService studentService = new StudentService();
        Map majorsByEthnicityRaceAndGender = studentService.list();
        assertThat(majorsByEthnicityRaceAndGender.isEmpty(), is(false));
    }

    @Test
    public void shouldIncludeAllRacesAndEthnicities() {
        StudentService studentService = new StudentService();
        Map majorsByEthnicityRaceAndGender = studentService.list();
        assertThat(majorsByEthnicityRaceAndGender.containsKey("All races and ethnicities"), is(true));
        assertThat(majorsByEthnicityRaceAndGender.containsKey("Female"), is(false));
        assertThat(majorsByEthnicityRaceAndGender.containsKey("White"), is(true));
    }

    @Test
    public void shouldCreateHashWithRaceAndEthnicityAsKeysAndGenderAsSubKeys() {
        ArrayList<String[]> exampleData = getExampleCSVData("Asian");

        StudentService studentService = new StudentService();
        Map majorsByEthnicityRaceAndGender = studentService.createListOfMajorsByPercent(exampleData);

        assertThat(majorsByEthnicityRaceAndGender.containsKey("Female"), is(false));

        String asianKey = "Asian";
        assertThat(majorsByEthnicityRaceAndGender.containsKey(asianKey), is(true));
        assertThat(((Map) majorsByEthnicityRaceAndGender.get(asianKey)).containsKey("Female"), is(true));
    }

    @Test
    public void shouldCreateListOfPercentagesByMajorForTotalAndEachGender() {
        ArrayList<String[]> exampleData = getExampleCSVData("Asian");
        StudentService studentService = new StudentService();
        Map majorsByEthnicityRaceAndGender = studentService.createListOfMajorsByPercent(exampleData);

        Map mapOfMajorPercentagesForAsianEthnicity = (Map) majorsByEthnicityRaceAndGender.get("Asian");
        assertThat(((List) mapOfMajorPercentagesForAsianEthnicity.get("Female")).isEmpty(), is(false));
    }

    private ArrayList<String[]> getExampleCSVData(String ethnicityKey) {
        String[] row1 = String.format("%s,52.7,20.3,15.0,5.6,2.8,9.0", ethnicityKey).split(",");
        String[] row2 = "Female,45.4,22.5,7.0,2.9,2.5,10.5".split(",");
        String[] row3 = "Male,60.0,17.8,23.4,8.4,3.2,7.2".split(",");
        ArrayList<String[]> exampleData = new ArrayList<>();
        exampleData.add(row1);
        exampleData.add(row2);
        exampleData.add(row3);
        return exampleData;
    }

}