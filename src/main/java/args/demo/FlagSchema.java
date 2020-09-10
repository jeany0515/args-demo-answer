package args.demo;

public class FlagSchema {
    private final String flag;
    private final ValueType valueType;

    public FlagSchema(String flag, ValueType valueType) {
        this.flag = flag;
        this.valueType = valueType;
    }

    public String getType() {
        return this.valueType.getType();
    }

    public Object getDefaultValue() {
        return this.valueType.getDefaultValue();
    }

    public String getFlag() {
        return flag;
    }
}
