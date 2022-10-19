package analyzer.searchImplementation;

public interface SearchStrategy {
    boolean bufferContainsSearchText(byte[] buffer, String searchText);
}
