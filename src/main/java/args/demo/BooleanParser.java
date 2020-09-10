package args.demo;

import static java.lang.Boolean.parseBoolean;

public class BooleanParser extends TypeParser {

    @Override
    public Object parse(String value) {
        return parseBoolean(value);
    }
}
