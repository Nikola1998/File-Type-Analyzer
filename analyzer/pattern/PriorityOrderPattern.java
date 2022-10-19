package analyzer.pattern;

import analyzer.utilities.FileReader;

import java.nio.file.Path;
import java.util.ArrayList;

public class PriorityOrderPattern {
    private ArrayList<Pattern> patterns = new ArrayList<>();

    public ArrayList<Pattern> getPatterns() {
        return patterns;
    }

    public PriorityOrderPattern(String pathToPatternsDB) {
        FileReader fileReader = new FileReader();
        String inputPatterns = new String(fileReader.readFile(Path.of(pathToPatternsDB)));
        addToPatterns(inputPatterns);
    }

    private void addToPatterns(String inputPatterns) {
        StringBuilder typeSubstring = new StringBuilder();
        StringBuilder type = new StringBuilder();
        int controller = 0;

        for (int i = 0; i < inputPatterns.length(); i++) {
            if (controller == 0) {
                if (inputPatterns.charAt(i) == '"') controller = 1;
            }
            else if (controller == 1) {
                if (inputPatterns.charAt(i) == '"') controller = 2;
                else typeSubstring.append(inputPatterns.charAt(i));
            }
            else if (controller == 2) {
                if (inputPatterns.charAt(i) == '"') controller = 3;
            }
            else {
                if (inputPatterns.charAt(i) == '"')  {
                    controller = 0;
                    patterns.add(new Pattern(typeSubstring.toString(), type.toString()));
                    typeSubstring = new StringBuilder();
                    type = new StringBuilder();
                }
                else type.append(inputPatterns.charAt(i));
            }
        }
        ArrayList<Pattern> reversePatterns = new ArrayList<>();
        for (int i = patterns.size() - 1; i >= 0; i--) {
            reversePatterns.add(patterns.get(i));
        }
        patterns = reversePatterns;
    }
}
