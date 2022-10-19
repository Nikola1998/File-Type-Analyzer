package analyzer.pattern;

public class Pattern {
    private final String typeSubstring;
    private final String type;

    public Pattern(String typeSubstring, String type) {
        this.typeSubstring = typeSubstring;
        this.type = type;
    }

    public String getTypeSubstring() {
        return typeSubstring;
    }

    public String getType() {
        return type;
    }
}
