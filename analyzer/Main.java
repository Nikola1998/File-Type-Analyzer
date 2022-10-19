package analyzer;

import analyzer.utilities.ParallelFileAnalyzer;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2)
            System.out.println("Not enough arguments");
        else {
            new ParallelFileAnalyzer().startProgram(args);
            try {
                Thread.sleep(2000); // This is required because otherwise program will end before finishing the process
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
