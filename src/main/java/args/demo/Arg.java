package args.demo;

import static java.lang.Boolean.parseBoolean;
import static java.lang.Integer.parseInt;

public class Arg {
    private final String flag;
    private final String value;
    private final String type;

    public Arg(String argPair, Schema schema) {
        String[] flagValues = argPair.trim().split("\\s+", 2);

        isArgValid(flagValues);

        this.flag = flagValues[0];
        this.value = flagValues[1];
        this.type = schema.getTypeOf(this.flag);
    }

    private void isArgValid(String[] flagValues) {
        boolean isFlagValid = flagValues[0].length() == 1;
        boolean isValueValid = !flagValues[1].contains(" ");
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

    public String geFlag() {
        return this.flag;
    }
}
