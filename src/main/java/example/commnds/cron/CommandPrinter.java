package example.commnds.cron;

import java.io.PrintWriter;

public interface CommandPrinter<T extends Command> {
    public void print(T command, CommandRunConfig config, PrintWriter writer);
}
