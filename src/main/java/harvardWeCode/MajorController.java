package harvardWeCode;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/major")
public class MajorController {

    @RequestMapping("")
    public List list() {
        ArrayList<String> majors = new ArrayList<>();

        majors.add("Biological and agricultural sciences");
        majors.add("Engineering");
        majors.add("Mathematics,statistics, and computer sciences");
        majors.add("Physical sciences");
        majors.add("Social and behavioral sciences");

        return majors;
    }
}
