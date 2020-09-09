package args.demo;

import static java.lang.Integer.parseInt;

public class Arg {
    private final String flag;
    private final String value;
    private final String type;

    public Arg(String command, Schema schema) {
        String[] flagValue = command.split(" ");
        this.flag = flagValue[0];
        this.value = flagValue[1];
        this.type = schema.getTypeOf(this.flag);
    }

    public Object getValue() {
        if(type.equals("integer")) {
            return parseInt(value);
        }
        return value;
    }


    public boolean withFlag(String flag) {
        return this.flag.equals(flag);
    }
}
