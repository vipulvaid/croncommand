package example.commands.cron;

import example.commnds.cron.CommandArgumentParser;
import example.commnds.cron.CommandArgumentParserImpl;
import example.commnds.cron.CommandRunConfig;
import example.commnds.cron.CronCommand;
import org.junit.jupiter.api.Test;

import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CronCommandTest {
    @Test
    public void givenInputArguments_whenCronCommandIsRun_prettyPrint() {
        CronCommand cronCommand = new CronCommand();
        StringWriter writer = new StringWriter();
        cronCommand.setPrintWriter(writer);
        CommandArgumentParser commandArgumentParser = new CommandArgumentParserImpl();
        cronCommand.configure(commandArgumentParser);
        CommandRunConfig config = commandArgumentParser.parse(new String[] {"*/15", "0" ,"1,15",  "*" ,"1-5", "/command"});
        cronCommand.run(config);
        writer.flush();
        String expectedString = "minute         0 15 30 45" + "\n"
                + "hour           0" + "\n"
                + "days of month  1 15" + "\n"
                + "month          1 2 3 4 5 6 7 8 9 10 11 12" + "\n"
                + "day of week    1 2 3 4 5" + "\n"
                + "command        /command";

        assertEquals(expectedString, writer.toString());
    }
}
