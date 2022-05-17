package example.commnds.cron;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;

public class CronCommand extends Command {
    private PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out));
    CommandPrinter<CronCommand> commandPrinter = new CronCommandPrettyDisplay();

    public CronCommand() {
    }

    @Override
    public void run(CommandRunConfig config) {
        // TODO handle Feb days
        commandPrinter.print(this, config, printWriter);
    }

    @Override
    public void configure(CommandArgumentParser parser) {
        // 1st argument is minutes
        parser.addPositionalArgument(0).type(new CronArgumentValueType(0, 59));
        // 2nd argument is hours
        parser.addPositionalArgument(1).type(new CronArgumentValueType(0, 23));
        // 3rd argument is days of month
        parser.addPositionalArgument(2).type(new CronArgumentValueType(1, 31));
        // 4th argument is month
        parser.addPositionalArgument(3).type(new CronArgumentValueType(1, 12));
        // 5th argument is day of week
        parser.addPositionalArgument(4).type(new CronArgumentValueType(1, 7));
        parser.addPositionalArgument(5);

    }

    // Only for testing ..
    public void setPrintWriter(Writer writer) {
        this.printWriter = new PrintWriter(writer);
    }
}
