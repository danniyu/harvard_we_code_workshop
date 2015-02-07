package harvardWeCode;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MajorControllerTest {

    @Test
    public void shouldReturnAListOfFiveMajors() {
        MajorController majorController = new MajorController();
        List majors = majorController.list();
        assertThat(majors.size(), is(5));
    }
}