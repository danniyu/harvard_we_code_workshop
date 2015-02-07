package harvardWeCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StudentControllerTest {

    @Test
    public void shouldReturnAMap() {
        StudentController studentController = new StudentController();
        studentController.studentService = mock(StudentService.class);

        HashMap freshmenMajorsByRaceEthnicityAndGender = createTestMajorIntendedData();
        when(studentController.studentService.list()).thenReturn(freshmenMajorsByRaceEthnicityAndGender);

        assertThat(studentController.home(), is(freshmenMajorsByRaceEthnicityAndGender));
    }

    @Test
    public void shouldOnlyReturnTotalPercentages() {
        StudentController studentController = new StudentController();
        studentController.studentService = mock(StudentService.class);

        HashMap freshmenMajorsByRaceEthnicityAndGender = createTestMajorIntendedData();
        when(studentController.studentService.list()).thenReturn(freshmenMajorsByRaceEthnicityAndGender);

        assertThat(studentController.home().containsKey("All races and ethnicities"), is(true));
        assertThat(studentController.home().containsKey("Hispanic or Latino"), is(true));
    }

    private HashMap createTestMajorIntendedData() {
        HashMap freshmenMajorsByRaceEthnicityAndGender = new HashMap();
        Map percentagesByMajor = new HashMap<>();
        percentagesByMajor.put("Total", createMajor("Engineering",31.3));
        percentagesByMajor.put("Female", createMajor("Engineering", 1.3));
        percentagesByMajor.put("Male", createMajor("Engineering", 3.9));
        freshmenMajorsByRaceEthnicityAndGender.put("Hispanic or Latino", percentagesByMajor);

        percentagesByMajor.put("Total", createMajor("Engineering",31.3));
        percentagesByMajor.put("Female", createMajor("Engineering", 1.3));
        percentagesByMajor.put("Male", createMajor("Engineering", 3.9));
        freshmenMajorsByRaceEthnicityAndGender.put("All races and ethnicities", percentagesByMajor);
        return freshmenMajorsByRaceEthnicityAndGender;
    }

    private List createMajor(String majorName, Double percentage) {
        List major = new ArrayList<>();
        Map<String, Double> nameToPercentage = new HashMap<>();

        nameToPercentage.put(majorName, percentage);
        major.add(nameToPercentage);

        return major;
    }
}