package example.commnds.cron;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.stream.Collectors;

public class CronCommandPrettyDisplay implements CommandPrinter<CronCommand> {

    @Override
    public void print(CronCommand cronCommand, CommandRunConfig config, PrintWriter printWriter) {
        CronArgumentValue min = (CronArgumentValue) config.getArguments().get("pos0");
        CronArgumentValue hours = (CronArgumentValue) config.getArguments().get("pos1");
        CronArgumentValue dayOfMonth = (CronArgumentValue) config.getArguments().get("pos2");
        CronArgumentValue month = (CronArgumentValue) config.getArguments().get("pos3");
        CronArgumentValue dayOfWeek = (CronArgumentValue) config.getArguments().get("pos4");
        String command = (String) config.getArguments().get("pos5");

        printWriter.printf("%-14s " + getPrint(min), "minute");
        printWriter.printf("%-14s " + getPrint(hours), "hour");
        printWriter.printf("%-14s " + getPrint(dayOfMonth), "days of month");
        printWriter.printf("%-14s " + getPrint(month), "month");
        printWriter.printf("%-14s " + getPrint(dayOfWeek), "day of week");
        printWriter.printf("%-14s " + command, "command");
        printWriter.flush();
        printWriter.close();
    }

    private String getPrint(CronArgumentValue value) {
        return Arrays.stream(value.getValues())
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" ")) + "\n";
    }
}
