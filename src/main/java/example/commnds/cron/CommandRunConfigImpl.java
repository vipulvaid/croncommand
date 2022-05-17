package example.commnds.cron;

import java.util.HashMap;
import java.util.Map;

public class CommandRunConfigImpl implements CommandRunConfig {
    Map<String, Object> argumentMap = new HashMap<>();
    public CommandRunConfigImpl(Map<String, Object> argumentMap) {
        this.argumentMap = argumentMap;
    }

    @Override
    public Map<String, Object> getArguments() {
        return argumentMap;
    }
}
