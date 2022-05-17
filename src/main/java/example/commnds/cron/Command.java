package example.commnds.cron;

/**
 * A command that can perform some task.
 */
public abstract class Command {

    /**
     * Run the command with a given run config.
     *
     * @param config contains key value pairs of arguments.
     */
    public abstract void run(CommandRunConfig config);

    /**
     * Configure the command arguments.
     *
     * @param parser parser that will be used to parse this command arguments.
     */
    public abstract void configure(CommandArgumentParser parser);
}
