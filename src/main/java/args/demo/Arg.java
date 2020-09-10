package args.demo;

public class Arg {
    private final String flag;
    private final String value;
    private final String type;

    public Arg(String argPair, Schema schema) {
        String[] flagValues = argPair.trim().split("\\s+", 2);

        this.flag = flagValues[0];
        this.value = flagValues.length == 2 ? flagValues[1] : schema.getDefaultValueOf(this.flag).toString();
        isArgValid();
        this.type = schema.getTypeOf(this.flag);
    }

    private void isArgValid() {
        boolean isFlagValid = flag.length() == 1;
        boolean isValueValid = !value.contains(" ");
        boolean isArgValid = isFlagValid && isValueValid;
        if(!isArgValid) {
            throw new InvalidArg(flag);
        }
    }

    public Object parseValue() {
        switch (type) {
            case "boolean":
                return new BooleanParser().parse(value);
            case "integer":
                return new IntParser().parse(value);
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
