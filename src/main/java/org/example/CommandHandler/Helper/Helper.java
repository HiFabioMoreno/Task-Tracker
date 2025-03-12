package org.example.CommandHandler.Helper;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.ParseException;
import org.example.CommandHandler.CommandHandler;
import org.example.Model.Status;
import org.example.Model.Task;
import org.example.Services.TaskManagerImp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Helper {

    public void helpCommands(String [] args) throws ParseException{

        TaskManagerImp taskManagerImp = new TaskManagerImp();

        CommandLine cmd;
        CommandHandler options = new CommandHandler();

        CommandLineParser parser = new DefaultParser();
        cmd = parser.parse(options.getOptions(),args);

            if(cmd.hasOption("add")){
                Task task = new Task(cmd.getOptionValue("add"), Status.TODO.getStatus(), setDateTime(),setDateTime());
                taskManagerImp.Save(task);
            } else if (cmd.hasOption("list")) {
                taskManagerImp.FindAll();

            } else if (cmd.hasOption("delete")) {
                taskManagerImp.Delete(Integer.parseInt(cmd.getOptionValue("delete")));

            } else if (cmd.hasOption("update")) {

                String[] updateArgs = cmd.getOptionValues("update");

                taskManagerImp.UpdateDescription(updateArgs[0],Integer.parseInt(updateArgs[1]));
                taskManagerImp.UpdateDateTime(Integer.parseInt(updateArgs[1]),setDateTime());

            } else if (cmd.hasOption("mark-todo")) {
                taskManagerImp.MarkAs(Status.TODO.getStatus(), Integer.parseInt(cmd.getOptionValue("mark-todo")));
                taskManagerImp.UpdateDateTime(Integer.parseInt(cmd.getOptionValue("mark-todo")),setDateTime());

            } else if (cmd.hasOption("mark-in-progress")) {
                taskManagerImp.MarkAs(Status.INPROGRESS.getStatus(),Integer.parseInt(cmd.getOptionValue("mark-in-progress")));
                taskManagerImp.UpdateDateTime(Integer.parseInt(cmd.getOptionValue("mark-in-progress")),setDateTime());

            } else if (cmd.hasOption("mark-done")) {
                taskManagerImp.MarkAs(Status.DONE.getStatus(), Integer.parseInt(cmd.getOptionValue("mark-done")));
                taskManagerImp.UpdateDateTime(Integer.parseInt(cmd.getOptionValue("mark-done")),setDateTime());

            } else if (cmd.hasOption("list-todo")) {
               taskManagerImp.FindByStatus(Status.TODO.getStatus());

            }else if (cmd.hasOption("list-in-progress")) {
                taskManagerImp.FindByStatus(Status.INPROGRESS.getStatus());

            }else if (cmd.hasOption("list-done")) {
                taskManagerImp.FindByStatus(Status.DONE.getStatus());
            }
    }

    public String setDateTime(){

        // Method for set DateTime in the task.

        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formattedDateTime = ldt.format(formatter);

        return  formattedDateTime;
    }
}
