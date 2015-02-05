package harvardWeCode;

import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StudentControllerTest {

    @Test
    public void shouldReturnAMap() {
        StudentController studentController = new StudentController();
        studentController.studentService = mock(StudentService.class);
        HashMap returnedMap = new HashMap();
        when(studentController.studentService.list()).thenReturn(returnedMap);
        assertThat(studentController.home(), is(returnedMap));
    }
}