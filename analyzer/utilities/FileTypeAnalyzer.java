package analyzer.utilities;

import analyzer.pattern.Pattern;
import analyzer.searchImplementation.KMPStrategy;
import analyzer.searchImplementation.SearchStrategy;

import java.nio.file.Path;
import java.util.ArrayList;

class FileTypeAnalyzer {
    private final FileReader fileReader = new FileReader();
    private final SearchStrategy searchStrategy = new KMPStrategy();
    private final ArrayList<Pattern> patterns;

    public FileTypeAnalyzer(ArrayList<Pattern> patterns) {
        this.patterns = patterns;
    }

    public void analyze(Path filePath) {
        for (Pattern pattern : patterns) {
            byte[] buffer = fileReader.readFile(filePath);
            if (searchStrategy.bufferContainsSearchText(buffer, pattern.getTypeSubstring())) {
                System.out.println(filePath.getFileName().toString() + ": " + pattern.getType());
                return;
            }
        }
        System.out.println(filePath.getFileName().toString() + ": Unknown file type");
    }
}
