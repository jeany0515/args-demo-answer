package args.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Args {
    private final List<Arg> argPairs = new ArrayList<>();
    private final String args;

    public Args(String args, Schema schema) {
        this.args = args.trim();
        isStartWithFlag();
        mapToArgPairs(args, schema);
        isFlagDistinct();
    }

    private void mapToArgPairs(String args, Schema schema) {
        List<String> argPairs = splitToArgs(args);
        argPairs.forEach(arg -> this.argPairs.add(new Arg(arg, schema)));
    }

    private List<String> splitToArgs(String command) {
        String[] list = " ".concat(command).split(" -");
        List<String> args = new ArrayList<>(Arrays.asList(list));
        args.remove(0);
        return args;
    }

    private void isStartWithFlag() {
        if (args.length() == 0 || !args.startsWith("-")) {
            throw new InvalidArgs(args);
        }
    }

    private void isFlagDistinct() {
        List<String> distinctFlags = argPairs.stream().map(Arg::getFlag).distinct().collect(Collectors.toList());
        boolean isFlagDuplicated = distinctFlags.size() != argPairs.size();
        if(isFlagDuplicated) {
            throw new ArgsFlagDuplicated();
        }
    }

    public Object getValueOf(String flag) {
        return argPairs.stream().filter(arg -> arg.withFlag(flag)).findFirst().get().parseValue();
    }
}
