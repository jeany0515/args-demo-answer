package args.demo;

public class ValueParserFactory {
    static public TypeParser create(String type) {
        switch (type) {
            case "boolean":
                return new BooleanParser();
            case "integer":
                return new IntParser();
            default:
                return new StringParser();
        }
    }
}
