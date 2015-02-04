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
    private Map something = new HashMap<>();
    private String[] majors;

    public StudentService() {
        try {
            CSVReader reader = new CSVReader(new FileReader(intentionToMajor));
            List<String[]> strings = reader.readAll();
            majors = strings.get(0);

            int min = 1;
            int max = 4;
            strings = filterOutEmptyRows(strings);
            while(max < strings.size()) {
                List<String[]> raceEthnicityAndGenderStatistics = strings.subList(min, max);
                Map listOfMajorsByPercent = createListOfMajorsByPercent(raceEthnicityAndGenderStatistics);
                something.putAll(listOfMajorsByPercent);
                min = min + 3;
                max = max + 3;
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<String[]> filterOutEmptyRows(List<String[]> strings) {
        ArrayList<String[]> filteredStrings = new ArrayList<>();
        for (String[] string : strings) {
            boolean hasATitle = !string[0].trim().equals("");
            if(hasATitle) {
                filteredStrings.add(string);
            }
        }
        return filteredStrings;
    }

    public Map list() {
        return something;
    }

    public Map createListOfMajorsByPercent(List<String[]> exampleData) {
        Map majorByPercent = new HashMap<>();
        HashMap<Object, Object> genderRaceOrEthnicityAndPercentages = new HashMap<>();

        for (String[] raceEthnicityOrGenderAndPercentOfMajor : exampleData) {
            String title = raceEthnicityOrGenderAndPercentOfMajor[0];
            ArrayList<String> femaleOrMale = new ArrayList<>();
            femaleOrMale.add("Female");
            femaleOrMale.add("Male");

            if(femaleOrMale.contains(title)) {
                genderRaceOrEthnicityAndPercentages.put(title, creatListOfMajorAndPercent(raceEthnicityOrGenderAndPercentOfMajor));
            } else {
                genderRaceOrEthnicityAndPercentages.put("Total", creatListOfMajorAndPercent(raceEthnicityOrGenderAndPercentOfMajor));
            }
        }

        majorByPercent.put(exampleData.get(0)[0], genderRaceOrEthnicityAndPercentages);
        return majorByPercent;
    }

    private List creatListOfMajorAndPercent(String[] raceEthnicityOrGenderAndPercentOfMajor) {
        ArrayList<Object> majorsAndPercentages = new ArrayList<>();

        for(int iterator = 1; iterator < raceEthnicityOrGenderAndPercentOfMajor.length; iterator++) {
            HashMap<String, Double> majorToPercentage = new HashMap<>();
            majorToPercentage.put(majors[iterator], Double.valueOf(raceEthnicityOrGenderAndPercentOfMajor[iterator]));
            majorsAndPercentages.add(majorToPercentage);
        }

        return majorsAndPercentages;
    }
}
