package harvardWeCode;

import au.com.bytecode.opencsv.CSVReader;

import java.io.FileReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentService {
    private final String intentionToMajor = String.format(Paths.get("").toAbsolutePath() + "/" + "intentions_of_freshman_to_major_in_stem.csv");
    private Map something;

    public StudentService() {
        try {
            CSVReader reader = new CSVReader(new FileReader(intentionToMajor));
            List<String[]> strings = reader.readAll();
            String[] majors = strings.get(0);

            for (String[] raceEthnicityGender : strings.subList(1, strings.size() - 1)) {
                something = new HashMap<>();
                List majorsPercentages = new ArrayList<>();

                for(int i = 1; i < raceEthnicityGender.length; i++) {
                    Map majorPercent = new HashMap<>();
                    majorPercent.put(majors[i], raceEthnicityGender[i]);
                    majorsPercentages.add(majorPercent);
                }

                something.put(raceEthnicityGender[0], majorsPercentages);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Map list() {
        return something;
    }
}
