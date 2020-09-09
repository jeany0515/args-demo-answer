package args.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Args {
    private final List<Arg> arg = new ArrayList<>();

    public Args(String command, Schema schema) {
        List<String> args = splitToArgs(command);
        args.forEach(arg -> this.arg.add(new Arg(arg, schema)));
    }

    private List<String> splitToArgs(String command) {
        String[] list = " ".concat(command).split(" -");
        List<String> args = new ArrayList<>(Arrays.asList(list));
        args.remove(0);
        return args;
    }

    public Object getValueOf(String flag) {
        return arg.stream().filter(arg -> arg.withFlag(flag)).findFirst().get().getValue();
    }
}
