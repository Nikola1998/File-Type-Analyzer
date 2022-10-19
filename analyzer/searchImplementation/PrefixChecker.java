package analyzer.searchImplementation;

import java.util.Arrays;

class PrefixChecker {
    private final String text;
    private final int[] prefixArray;

    public int[] getPrefixArray() {
        return prefixArray;
    }

    public PrefixChecker(String text) {
        this.text = text;
        prefixArray = new int[text.length()];
        Arrays.setAll(prefixArray, this::checkIndividualPrefix);
    }

    private int checkIndividualPrefix(int index) {
        int j = index;
        while (j > 0) {
            j = prefixArray[j - 1];
            if (text.charAt(index) == text.charAt(j)) {
                return j + 1;
            }
        }
        return 0;
    }
}
