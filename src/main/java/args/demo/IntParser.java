package args.demo;

import static java.lang.Integer.parseInt;

public class IntParser extends TypeParser {

    @Override
    public Object handle(String value) {
        return parseInt(value);
    }
}
