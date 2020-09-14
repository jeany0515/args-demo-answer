package args.demo;

public class StringParser extends TypeParser {
    @Override
    public Object handle(String value) {
        return value;
    }
}
