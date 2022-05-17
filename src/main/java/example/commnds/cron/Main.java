package example.commnds.cron;

public class Main {

    public static void main(String args[]) {
        // Create a cron command instance
        CronCommand cronCommand = new CronCommand();
        // next create argument parser that knows how to parse the command arguments
        CommandArgumentParser commandArgumentParser = new CommandArgumentParserImpl();
        // configure command to create arguments, this will give command to set all required argument
        // their validation, value type, default value etc.
        cronCommand.configure(commandArgumentParser);
        // next parse the arguments passed to command.
        CommandRunConfig config = commandArgumentParser.parse(args);
        // run the command
        cronCommand.run(config);
    }
}
