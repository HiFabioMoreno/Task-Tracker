package org.example.CommandHandler;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class CommandHandler {

    public Options getOptions() {
        Options options = new Options();

        // commands essentials

        Option add = new Option("add", true, "Create a new Task");
        options.addOption(add);
        Option list = new Option("list", false, "List all task");
        options.addOption(list);
        Option delete = new Option("delete", true, "Delete task by id");
        options.addOption(delete);
        Option update = Option.builder("update")
                            .longOpt("update")
                            .desc("Update the description of a task")
                            .hasArgs()
                            .argName("description> <index")
                            .build();
        options.addOption(update);

        // commands marks

        Option toDo= new Option("mark-todo", true, "Update the status of a task to to-do");
        options.addOption(toDo);
        Option inProgress= new Option("mark-in-progress", true, "Update the status of a task to in-progress");
        options.addOption(inProgress);
        Option done= new Option("mark-done", true, "Update the status of a task to done");
        options.addOption(done);

        // commands list by status

        Option listTodo = new Option("list-todo", false, "List tasks by status to-do");
        options.addOption(listTodo);
        Option listInProgress = new Option("list-in-progress", false, "List tasks by status in-progress");
        options.addOption(listInProgress);
        Option listDone = new Option("list-done", false, "List tasks by status done");
        options.addOption(listDone);

        return options;
    }
}
