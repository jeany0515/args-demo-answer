package args.demo;

class ArgsException extends RuntimeException {
    ArgsException(String message) {
        super(message);
    }
}

class FlagNotFound extends ArgsException {
    FlagNotFound(String flag) {
        super(flag);
    }
}

class InvalidArgs extends ArgsException {
    InvalidArgs(String args) {
        super(args);
    }
}

class InvalidArg extends ArgsException {
    InvalidArg(String arg) {
        super(arg);
    }
}

class ArgsFlagDuplicated extends RuntimeException {
}

class SchemaFlagDuplicated extends RuntimeException {
}
