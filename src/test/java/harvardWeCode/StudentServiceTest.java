package harvardWeCode;

import org.junit.Test;

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
    }
}