package example.commnds.cron;

import java.util.*;

public class CommandArgumentParserImpl implements CommandArgumentParser {

    Map<String, ArgumentImpl> positionalArguments = new HashMap<>();

    @Override
    public CommandRunConfig parse(String[] args) {
        Map<String, Object> argumentMap = new HashMap<>();

        // Currently, only positional arguments are supported.
        if (args != null && args.length != positionalArguments.size()) {
            throw new InvalidCronArgumentException();
        }
        for (int i=0;i<args.length; i++) {
            String key = getKey(i);
            if (positionalArguments.get(key) == null) {
                throw new InvalidCronArgumentException();
            } else {
                positionalArguments.get(key).setValue(args[i]);
            }
            argumentMap.put(key,positionalArguments.get(key).getValue());
        }
        return new CommandRunConfigImpl(argumentMap);
    }

    @Override
    public Argument addPositionalArgument(int pos) {
        String key = getKey(pos);
        ArgumentImpl arg = new ArgumentImpl(key);
        positionalArguments.put(key, arg);
        return arg;
    }

    private String getKey(int pos) {
        return "pos" + pos;
    }
}
