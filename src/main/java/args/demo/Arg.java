package args.demo;

import static java.lang.Boolean.parseBoolean;
import static java.lang.Integer.parseInt;

public class Arg {
    private final String flag;
    private final String value;
    private final String type;

    public Arg(String argPair, Schema schema) {
        String[] flagValue = argPair.split(" ");
        this.flag = flagValue[0];
        this.value = flagValue[1];
        this.type = schema.getTypeOf(this.flag);
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
