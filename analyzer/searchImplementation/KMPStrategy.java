package analyzer.searchImplementation;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class KMPStrategy implements SearchStrategy{
    public static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

    private int[] prefix;
    private byte[] searchBytes;
    private int searchLength;

    @Override
    public boolean bufferContainsSearchText(byte[] textBuffer, String searchText) {
        initializePrefixAndSearchBytes(searchText);
        int bufferLength = textBuffer.length;
        int position = 0;
        while (position + searchLength <= bufferLength) {
            int matchLength = getMatchLengthAtPosition(textBuffer, position);
            if (matchLength == searchLength) {
                return true;
            }
            position += matchLength == 0 ? 1 : matchLength - prefix[matchLength - 1];
        }
        return false;
    }

    private int getMatchLengthAtPosition(byte[] buffer, int position) {
        int index = 0;
        while (index < searchLength && buffer[position + index] == searchBytes[index]) {
            index++;
        }
        return index;
    }

    private void initializePrefixAndSearchBytes(String searchText) {
        prefix = new PrefixChecker(searchText).getPrefixArray();
        searchLength = searchText.length();
        searchBytes = DEFAULT_CHARSET.encode(searchText).array();
    }
}
