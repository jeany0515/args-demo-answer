package args.demo;

import static java.lang.Boolean.parseBoolean;

public class BooleanParser extends TypeParser {

    @Override
    public Object handle(String value) {
        return parseBoolean(value);
    }
}
