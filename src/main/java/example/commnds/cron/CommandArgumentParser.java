package example.commnds.cron;

public interface CommandArgumentParser {
    /**
     * Parse the command argument.
     * @param args command arguments.
     * @return A wrapper for map of key and values.
     */
    CommandRunConfig parse(String args[]);

    /**
     * Add a argument to the parser.
     * @param position position of positional argument.
     * @return {@link Argument} so to attach more details.
     */
    Argument addPositionalArgument(int position);
}
