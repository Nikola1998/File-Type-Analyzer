package analyzer.utilities;

import analyzer.pattern.Pattern;
import analyzer.pattern.PriorityOrderPattern;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.concurrent.Executors;

public class ParallelFileAnalyzer {
    private String directoryPath;
    private String directoryPatterns;
    private ArrayList<Pattern> patterns;


    public void startProgram(String[] args) {
        scanCLArguments(args);
        patterns = new PriorityOrderPattern(directoryPatterns).getPatterns();
        var executor = Executors.newFixedThreadPool(10);
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Path.of(directoryPath))) {
            directoryStream.forEach(path -> {
                if (Files.isRegularFile(path)) {
                    executor.submit(() -> new FileTypeAnalyzer(patterns).analyze(path));
                }
            });
            executor.shutdown();
        } catch (IOException exception) {
            System.out.println("Could not read from directory " + directoryPath + "!");
        }
    }


    private void scanCLArguments(String[] args) {
        directoryPath = args[0];
        if (!Files.isDirectory(Path.of(directoryPath))) {
            System.out.println("The directory-path given " + directoryPath + " is not valid!");
            System.exit(1);
        }
        directoryPatterns = args[1];
    }
}
