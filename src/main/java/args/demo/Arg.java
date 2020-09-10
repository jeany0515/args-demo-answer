package args.demo;

import static java.lang.Boolean.parseBoolean;
import static java.lang.Integer.parseInt;

public class Arg {
    private final String flag;
    private final String value;
    private final String type;

    public Arg(String argPair, Schema schema) {
        String[] flagValues = argPair.trim().split("\\s+", 2);

        this.flag = flagValues[0];
        this.value = flagValues.length == 2 ? flagValues[1] : schema.getDefaultValueOf(this.flag).toString();
        this.type = schema.getTypeOf(this.flag);

        isArgValid();
    }

    private void isArgValid() {
        boolean isFlagValid = flag.length() == 1;
        boolean isValueValid = !value.contains(" ");
        boolean isArgValid = isFlagValid && isValueValid;
        if(!isArgValid) {
            throw new RuntimeException("Invalid arg");
        }
    }

    public Object getValue() {
        switch (type) {
            case "boolean":
                return parseBoolean(value);
            case "integer":
                return parseInt(value);
            default:
                return value;
        }
    }


    public boolean withFlag(String flag) {
        return this.flag.equals(flag);
    }

    public String getFlag() {
        return this.flag;
    }
}
